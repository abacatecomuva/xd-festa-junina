package xd.festajunina;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import xd.festajunina.item.tooltip.BingoCardTooltipComponent;
import xd.festajunina.item.tooltip.BingoCardTooltipData;
import xd.festajunina.screen.BingoCardScreen;
import xd.festajunina.screen.ModScreenHandlerTypes;

public class XDFestaJuninaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlerTypes.BINGO_CARD, BingoCardScreen::new);
        TooltipComponentCallback.EVENT.register(data -> {
            if (data instanceof BingoCardTooltipData bingoCardTooltipData) {
                return new BingoCardTooltipComponent(bingoCardTooltipData);
            }
            return null;
        });
    }
}
