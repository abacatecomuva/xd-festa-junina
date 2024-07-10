package xd.festajunina.item.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;

public class BingoCardScreen extends HandledScreen<BingoCardScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(XDFestaJunina.MOD_ID, "textures/gui/bingo_card_gui.png");

    public BingoCardScreen(BingoCardScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {

    }
}
