package xd.festajunina.item.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xd.festajunina.item.tooltip.BingoCardTooltipData;
import xd.festajunina.screen.BingoCardScreenHandler;

import java.util.Arrays;
import java.util.Optional;

public class BingoCardItem extends Item {
    public static final String STACKS = "stacks";

    public BingoCardItem(Settings settings) {
        super(settings);
    }

    private static ExtendedScreenHandlerFactory createExtendedScreenHandlerFactory(ItemStack bingoCardStack) {
        return new ExtendedScreenHandlerFactory() {
            @Override
            public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
                buf.writeItemStack(bingoCardStack);
            }

            @Override
            public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                return new BingoCardScreenHandler(syncId, playerInventory, bingoCardStack);
            }

            @Override
            public Text getDisplayName() {
                return Text.empty();
            }
        };
    }

    public static void writeStacksToNbt(ItemStack bingoCardStack, Iterable<ItemStack> stacks) {
        NbtList nbtList = new NbtList();
        stacks.forEach(stack -> nbtList.add(stack.writeNbt(new NbtCompound())));
        bingoCardStack.getOrCreateNbt().put(STACKS, nbtList);
    }

    @Nullable
    public static ItemStack[] readStacksFromNbt(ItemStack bingoCardStack) {
        if (bingoCardStack.getNbt() == null || !bingoCardStack.getNbt().contains(STACKS, NbtElement.LIST_TYPE)) return null;
        NbtList nbtList = bingoCardStack.getNbt().getList(STACKS, NbtElement.COMPOUND_TYPE);
        ItemStack[] stacks = new ItemStack[nbtList.size()];
        for (int i = 0; i < nbtList.size(); i++) {
            NbtCompound stackCompound = nbtList.getCompound(i);
            ItemStack itemStack = ItemStack.fromNbt(stackCompound);
            stacks[i] = itemStack;
        }
        return stacks;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stackInHand = user.getStackInHand(hand);
        user.openHandledScreen(createExtendedScreenHandlerFactory(stackInHand));
        return TypedActionResult.success(stackInHand);
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (player.currentScreenHandler instanceof BingoCardScreenHandler bingoCardScreenHandler &&
                bingoCardScreenHandler.bingoCardStack == stack) return true;
        if (clickType != ClickType.RIGHT) return false;
        if (!player.getWorld().isClient()) {
            player.currentScreenHandler.setCursorStack(ItemStack.EMPTY);
            player.openHandledScreen(createExtendedScreenHandlerFactory(stack));
            player.currentScreenHandler.setCursorStack(otherStack);
            player.currentScreenHandler.syncState();
        }
        return true;
    }

    @Override
    public boolean canBeNested() {
        return false;
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        return Optional.ofNullable(BingoCardItem.readStacksFromNbt(stack)).map(stacks -> new BingoCardTooltipData(Arrays.asList(stacks)));
    }
}