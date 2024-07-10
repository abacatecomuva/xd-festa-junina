package xd.festajunina.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.*;

public class ModItems {
    public static final Item RED_T_CHESTPLATE = registerItem("red_tshirt",
            new RedTArmorItem(ModArmorMaterials.CLOTH_RED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BLUE_T_CHESTPLATE = registerItem("blue_tshirt",
            new BlueTArmorItem(ModArmorMaterials.CLOTH_BLUE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item YELLOW_T_CHESTPLATE = registerItem("yellow_tshirt",
            new YellowTArmorItem(ModArmorMaterials.CLOTH_YELLOW, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GREEN_T_CHESTPLATE = registerItem("green_tshirt",
            new GreenTArmorItem(ModArmorMaterials.CLOTH_GREEN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PURPLE_T_CHESTPLATE = registerItem("purple_tshirt",
            new PurpleTArmorItem(ModArmorMaterials.CLOTH_PURPLE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item JEANS_LEGGINGS = registerItem("jeans",
            new JeansArmorItem(ModArmorMaterials.CLOTH_JEANS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item BROWN_T_BOOTS = registerItem("jeans_boots",
            new BrownTArmorItem(ModArmorMaterials.CLOTH_BROWN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item RED_D_CHESTPLATE = registerItem("red_dress",
            new RedDArmorItem(ModArmorMaterials.TISSUE_RED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BLUE_D_CHESTPLATE = registerItem("blue_dress",
            new BlueDArmorItem(ModArmorMaterials.TISSUE_BLUE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item YELLOW_D_CHESTPLATE = registerItem("yellow_dress",
            new YellowDArmorItem(ModArmorMaterials.TISSUE_YELLOW, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GREEN_D_CHESTPLATE = registerItem("green_dress",
            new GreenDArmorItem(ModArmorMaterials.TISSUE_GREEN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PURPLE_D_CHESTPLATE = registerItem("purple_dress",
            new PurpleDArmorItem(ModArmorMaterials.TISSUE_PURPLE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item BROWN_D_BOOTS = registerItem("dress_boots",
            new BrownDArmorItem(ModArmorMaterials.TISSUE_BROWN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item BINGO_CARD = registerItem("bingo_card",
            new BingoCardItem(new FabricItemSettings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(XDFestaJunina.MOD_ID, name), item);

    }

    public static void registerModItems() {
        XDFestaJunina.LOGGER.debug("Registering Mod Items for " + XDFestaJunina.MOD_ID);
    }
}
