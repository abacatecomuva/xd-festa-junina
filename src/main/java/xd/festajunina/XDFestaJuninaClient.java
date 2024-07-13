package xd.festajunina;

import net.fabricmc.api.ClientModInitializer;
import xd.festajunina.screen.BingoCardScreen;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import xd.festajunina.item.tooltip.BingoCardTooltipComponent;
import xd.festajunina.item.tooltip.BingoCardTooltipData;
import xd.festajunina.screen.ModScreenHandlerTypes;
import xd.festajunina.item.ModItems;
import xd.festajunina.item.renderer.BingoNumberItemRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;

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
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.BINGO_NUMBER, new BingoNumberItemRenderer());
    }
}
