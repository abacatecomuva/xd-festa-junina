package xd.festajunina.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import xd.festajunina.XDFestaJunina;

public class BingoCardScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public BingoCardScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(54));
    }

    public BingoCardScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(XDFestaJunina.BINGO_CARD_SCREEN_HANDLER, syncId);
        checkSize(inventory, 9);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        generateSlots();
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

    void generateSlots() {
        int i = 0;

        // Bingo Card Slots
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (i == 12) {
                    i++;
                    continue;
                }
                this.addSlot(new Slot(inventory, i++, 8 + x * 18, 24 + y * 18));
            }
        }

        // Additional Slots
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 4; x++) {
                this.addSlot(new Slot(inventory, i++, 98 + x * 18, 6 + y * 18));
            }
        }
    }
}
