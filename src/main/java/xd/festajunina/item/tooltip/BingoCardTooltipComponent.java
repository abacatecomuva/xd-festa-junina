package xd.festajunina.item.tooltip;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;

import java.util.List;

@Environment(EnvType.CLIENT)
public class BingoCardTooltipComponent implements TooltipComponent {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier(XDFestaJunina.MOD_ID, "textures/gui/bingo_card_tooltip_background.png");
    private static final int WIDTH_PER_COLUMN = 18;
    private static final int HEIGHT_PER_ROW = 18;
    private final List<ItemStack> inventory;
    private static final int BACKGROUND_WIDTH = 122;
    private static final int BACKGROUND_HEIGHT = 137;

    public BingoCardTooltipComponent(BingoCardTooltipData backpackContents) {
        this.inventory = backpackContents.inventory();
    }

    @Override
    public int getHeight() {
        return BACKGROUND_HEIGHT + 4;
    }

    @Override
    public int getWidth(TextRenderer textRenderer) {
        return BACKGROUND_WIDTH;
    }

    @Override
    public void drawItems(TextRenderer textRenderer, int x, int y, DrawContext context) {
        context.drawTexture(BACKGROUND_TEXTURE, x, y, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        int slotIndex = 0;

        for (int rowIndex = 0; rowIndex < 5; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 5; columnIndex++) {
                int slotX = x + columnIndex * WIDTH_PER_COLUMN + 16;
                int slotY = y + rowIndex * HEIGHT_PER_ROW + 31;
                this.drawSlot(slotX, slotY, slotIndex++, context, textRenderer);
            }
        }
    }

    private void drawSlot(int x, int y, int index, DrawContext context, TextRenderer textRenderer) {
        ItemStack itemStack = this.inventory.get(index);
        context.drawItem(itemStack, x + 1, y + 1, index);
        context.drawItemInSlot(textRenderer, itemStack, x + 1, y + 1);
    }
}