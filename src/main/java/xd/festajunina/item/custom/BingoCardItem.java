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
import xd.festajunina.item.ModItems;
import xd.festajunina.screen.BingoCardScreenHandler;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
        SimpleInventory inventory = new SimpleInventory(24);
        NbtCompound nbt = stack.getOrCreateNbt();
        Inventories.readNbt(nbt, inventory.stacks);
        handleEmptyInventory(inventory);
        return inventory;
    }

    public static void saveInventory(ItemStack stack, SimpleInventory inventory) {
        NbtCompound nbt = stack.getOrCreateNbt();
        Inventories.writeNbt(nbt, inventory.stacks);
    }

    static void handleEmptyInventory(SimpleInventory inventory) {
        boolean isEmpty = inventory.stacks.stream().allMatch(ItemStack::isEmpty);
        if (isEmpty) {
            fillBingoCard(inventory);
        }
    }

    static void fillBingoCard(SimpleInventory inventory) {
        Set<Integer> numbers = new HashSet<>();
        int slot = 0;
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                if (slot == 24) continue;
                int number = 0;
                while (number == 0 || numbers.contains(number)) {
                    number = getRandomNumberByRow(row);
                }
                numbers.add(number);
                inventory.setStack(slot, ModItems.BINGO_NUMBER.getDefaultStack());
                BingoNumberItem.setNumber(inventory.getStack(slot), number);
                slot++;
            }
        }
    }

    static Integer getRandomNumberByRow(int column) {
        int min = column * 15 + 1;
        int max = (column + 1) * 15;
        return getRandomNumber(min, max);
    }

    static Integer getRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
