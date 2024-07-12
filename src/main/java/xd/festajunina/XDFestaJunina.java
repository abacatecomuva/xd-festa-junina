package xd.festajunina;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xd.festajunina.item.ModItemGroups;
import xd.festajunina.item.ModItems;
import xd.festajunina.screen.BingoCardScreenHandler;
import xd.festajunina.screen.ModScreenHandlers;

public class XDFestaJunina implements ModInitializer {
	public static final String MOD_ID = "festajunina";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ScreenHandlerType<BingoCardScreenHandler> BINGO_CARD_SCREEN_HANDLER;

	static {
		BINGO_CARD_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(
				new Identifier(MOD_ID, "bingo_card"),
				BingoCardScreenHandler::new
		);
	}

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModScreenHandlers.registerScreenHandlers();
	}
}