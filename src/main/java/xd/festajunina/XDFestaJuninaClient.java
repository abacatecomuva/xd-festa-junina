package xd.festajunina;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import xd.festajunina.screen.BingoCardScreen;

@Environment(EnvType.CLIENT)
public class XDFestaJuninaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(XDFestaJunina.BINGO_CARD_SCREEN_HANDLER, BingoCardScreen::new);

    }
}
