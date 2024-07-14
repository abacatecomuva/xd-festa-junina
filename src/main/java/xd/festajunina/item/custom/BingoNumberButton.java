package xd.festajunina.item.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.screen.BingoCardScreen;

import java.awt.*;

@Environment(EnvType.CLIENT)
public class BingoNumberButton extends ButtonWidget {

    private static final Identifier TEXTURE = new Identifier(XDFestaJunina.MOD_ID, "textures/item/bingo_number.png");
    public static final int BUTTON_SIZE = 16;

    private boolean isClicked;
    private final int x;
    private final int y;
    private int index;

    public BingoNumberButton(int x, int y, int number, boolean isClicked, int index) {
        this(x, y, BUTTON_SIZE, BUTTON_SIZE, null, (button) -> {}, ButtonWidget.DEFAULT_NARRATION_SUPPLIER);
        this.setMessage(Text.of(String.valueOf(number)));
        this.isClicked = isClicked;
        this.index = index;
    }

    protected BingoNumberButton(int x, int y, int width, int height, Text message, PressAction onPress, NarrationSupplier narrationSupplier) {
        super(x, y, width, height, message, onPress, narrationSupplier);
        this.isClicked = false;
        this.width = BUTTON_SIZE;
        this.height = BUTTON_SIZE;
        this.x = x;
        this.y = y;
    }

    @Override
    public void onPress() {
        super.onPress();
        this.isClicked = !this.isClicked;

        BingoNumberItem.setMarked(BingoCardScreen.cardItems.get(index), this.isClicked);
    }

    @Override
    protected void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        minecraftClient.getTextureManager().bindTexture(TEXTURE);

        context.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        if (isClicked) {
            context.drawTexture(TEXTURE, x, y, 1, (float) 0, (float) 0, this.getWidth(), this.getHeight(), getWidth(), getHeight());
        }
        context.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int color = this.isClicked ? Color.decode("#EFE0C1").getRGB() : Color.decode("#FF3358").getRGB();
        TextRenderer textRenderer = minecraftClient.textRenderer;
        context.drawCenteredTextWithShadow(textRenderer, this.getMessage(), this.x + this.width / 2, this.y + (this.height - 8) / 2, color | MathHelper.ceil(this.alpha * 255.0F) << 24);
    }

    public boolean isClicked() {
        return isClicked;
    }
}
