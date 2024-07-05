package xd.festajunina.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.GreenWoolArmorItem;

public class ModItems {
    public static final Item GREEN_WOOL_CHESTPLATE = registerItem("green_tclosed",
            new GreenWoolArmorItem(ModArmorMaterials.WOOL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(XDFestaJunina.MOD_ID, name), item);
    }

    public static void registerModItems() {
        XDFestaJunina.LOGGER.debug("Registering Mod Items for " + XDFestaJunina.MOD_ID);
    }
}
