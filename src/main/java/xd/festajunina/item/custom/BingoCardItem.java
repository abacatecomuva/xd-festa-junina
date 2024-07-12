package xd.festajunina.item.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xd.festajunina.screen.BingoCardScreenHandler;

public class BingoCardItem extends Item {

    public BingoCardItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            user.openHandledScreen(createScreenHandlerFactory(stack));
        }
        return TypedActionResult.success(stack);
    }

    private NamedScreenHandlerFactory createScreenHandlerFactory(ItemStack stack) {
        return new ExtendedScreenHandlerFactory() {
            @Override
            public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
                buf.writeItemStack(stack);
            }

            @Override
            public Text getDisplayName() {
                return Text.translatable(getTranslationKey());
            }

            @Override
            public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                return new BingoCardScreenHandler(syncId, inv, stack);
            }
        };
    }

    public static SimpleInventory getInventory(ItemStack stack) {
        SimpleInventory inventory = new SimpleInventory(54);
        NbtCompound nbt = stack.getOrCreateNbt();
        Inventories.readNbt(nbt, inventory.stacks);
        return inventory;
    }

    public static void saveInventory(ItemStack stack, SimpleInventory inventory) {
        NbtCompound nbt = stack.getOrCreateNbt();
        Inventories.writeNbt(nbt, inventory.stacks);
    }

}
