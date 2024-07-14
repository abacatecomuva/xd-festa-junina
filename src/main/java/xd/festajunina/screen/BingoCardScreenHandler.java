package xd.festajunina.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.BingoCardItem;

import java.util.List;

public class BingoCardScreenHandler extends ScreenHandler {
    private final SimpleInventory inventory;
    private final ItemStack stack;
    private final PlayerInventory playerInventory;

    public BingoCardScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, buf.readItemStack());
    }

    public BingoCardScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack stack) {
        super(XDFestaJunina.BINGO_CARD_SCREEN_HANDLER, syncId);
        this.inventory = BingoCardItem.getInventory(stack);
        this.playerInventory = playerInventory;
        this.stack = stack;
        generateSlots();
    }

    public SimpleInventory getInventory() {
        return inventory;
    }

    @Override
        public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        for (int i = 0; i < inventory.size(); i++) {
            inventory.setStack(i, BingoCardScreen.cardItems.get(i));
        }
        BingoCardItem.saveInventory(stack, inventory);
    }

    void generateSlots() {
        // Player Inventory Slots
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 140 + y * 18));
            }
        }

        // Hotbar Slots
        for (int x = 0; x < 9; x++) {
            this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 198));
        }
    }
}
