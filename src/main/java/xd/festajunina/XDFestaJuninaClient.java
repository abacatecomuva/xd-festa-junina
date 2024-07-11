package xd.festajunina;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import xd.festajunina.screen.BingoCardScreen;

public class XDFestaJuninaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(XDFestaJunina.BINGO_CARD_SCREEN_HANDLER, BingoCardScreen::new);

    }
}
