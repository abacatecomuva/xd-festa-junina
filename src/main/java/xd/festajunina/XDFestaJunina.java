package xd.festajunina;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xd.festajunina.item.ModItemGroups;
import xd.festajunina.item.ModItems;
import xd.festajunina.screen.ModScreenHandlerTypes;

public class XDFestaJunina implements ModInitializer {
	public static final String MOD_ID = "festajunina";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModScreenHandlerTypes.registerScreenHandlers();
	}
}