package xd.festajunina.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;

public class ModScreenHandlerTypes {
    public static final ScreenHandlerType<BingoCardScreenHandler> BINGO_CARD =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(XDFestaJunina.MOD_ID, "bingo_card"),
                    new ExtendedScreenHandlerType<>(BingoCardScreenHandler::new));

    public static void registerScreenHandlers() {
        XDFestaJunina.LOGGER.info("Registering Screen Handlers for " + XDFestaJunina.MOD_ID);
    }
}
