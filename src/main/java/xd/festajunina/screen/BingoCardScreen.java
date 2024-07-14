package xd.festajunina.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.BingoNumberButton;
import xd.festajunina.item.custom.BingoNumberItem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BingoCardScreen extends HandledScreen<BingoCardScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(XDFestaJunina.MOD_ID, "textures/gui/bingo_card_gui_v2.png");
    private static final int GRID_ROWS = 5;
    private static final int GRID_COLS = 5;

    public static final Map<Integer, ItemStack> cardItems = new ConcurrentHashMap<>();

    public BingoCardScreen(BingoCardScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = 222;
        this.playerInventoryTitleX = 8;
        this.playerInventoryTitleY = 130;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, (float) 0.0, (float) 0.0, this.backgroundWidth, this.backgroundHeight, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(this.textRenderer, this.playerInventoryTitle, this.playerInventoryTitleX, this.playerInventoryTitleY, 4210752, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        generateButtons();
    }

    private void generateButtons() {
        int startX = (2 + this.width - this.backgroundWidth) / 2;
        int startY = (1 + this.height - this.backgroundHeight) / 2;
        int counter = 0;

        Map<Integer, ItemStack> items = getItems();
        for (int col = 0; col < GRID_COLS; col++) {
            for (int row = 0; row < GRID_ROWS; row++) {
                if (row == 2 && col == 2) {
                    continue;
                }
                ItemStack item = items.get(counter);
                int number = BingoNumberItem.getNumber(item);
                boolean isMarked = BingoNumberItem.isMarked(item);

                int x = startX + col * (BingoNumberButton.BUTTON_SIZE + 2);
                int y = startY + row * (BingoNumberButton.BUTTON_SIZE + 2);

                BingoNumberButton button = createButton(43 + x, 31 + y, number, isMarked, counter);
                cardItems.put(counter, item);
                this.addDrawableChild(button);
                counter++;
            }
        }
    }

    private Map<Integer, ItemStack> getItems() {
        Map<Integer, ItemStack> items = new ConcurrentHashMap<>();
        SimpleInventory inventory = this.handler.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack item = inventory.getStack(i);
            items.put(i, item);
        }
        return items;
    }

    private BingoNumberButton createButton(int x, int y, int number, boolean isMarked, int index) {
        return new BingoNumberButton(x, y, number, isMarked, index);
    }
}
