package xd.festajunina;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import xd.festajunina.item.ModItems;
import xd.festajunina.item.renderer.BingoNumberItemRenderer;
import xd.festajunina.screen.BingoCardScreen;

@Environment(EnvType.CLIENT)
public class XDFestaJuninaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(XDFestaJunina.BINGO_CARD_SCREEN_HANDLER, BingoCardScreen::new);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.BINGO_NUMBER, new BingoNumberItemRenderer());
    }
}
