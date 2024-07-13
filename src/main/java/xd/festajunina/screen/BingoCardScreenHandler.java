package xd.festajunina.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import xd.festajunina.item.custom.BingoCardItem;

public class BingoCardScreenHandler extends ScreenHandler {

    private final SimpleInventory inventory;
    public final ItemStack bingoCardStack;

    public BingoCardScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, buf.readItemStack());
    }

    public BingoCardScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack bingoCardStack) {
        super(ModScreenHandlerTypes.BINGO_CARD, syncId);
        this.bingoCardStack = bingoCardStack;
        ItemStack[] stacks = BingoCardItem.readStacksFromNbt(bingoCardStack);
        if (stacks != null) {
            this.inventory = new SimpleInventory(stacks);
        } else {
            this.inventory = new SimpleInventory(25);
        }

        // Bingo Card Slots
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (x == 2 && y == 2) {
                    continue;
                }
                this.addSlot(new Slot(this.inventory, x + y * 5, 44 + x * 18, 32 + y * 18));
            }
        }

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

        this.inventory.onOpen(playerInventory.player);
        this.inventory.addListener(sender -> {
            if (this.inventory.isEmpty()) {
                this.bingoCardStack.removeSubNbt(BingoCardItem.STACKS);
            } else {
                BingoCardItem.writeStacksToNbt(this.bingoCardStack, this.inventory.stacks);
            }
            playerInventory.markDirty();
            this.syncState();
        });
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack originalStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if (slot.hasStack()) {
            ItemStack stackInSlot = slot.getStack();
            originalStack = stackInSlot.copy();
            if (slotIndex >= 0 && slotIndex < this.inventory.size()) {
                if (!this.insertItem(stackInSlot, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(stackInSlot, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

        }

        return originalStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player) &&
                player.getInventory().containsAny(stack -> stack == this.bingoCardStack);
    }
}