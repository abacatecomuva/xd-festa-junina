package xd.festajunina.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.BingoCardItem;
import xd.festajunina.item.custom.CustomDyedArmorItem;
import xd.festajunina.item.custom.JeansArmorItem;

public class ModItems {
    public static final Item RED_T_CHESTPLATE = registerItem("red_tshirt",
            new CustomDyedArmorItem("armor/red_cloth", ModArmorMaterials.CLOTH_RED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BLUE_T_CHESTPLATE = registerItem("blue_tshirt",
            new CustomDyedArmorItem("armor/blue_cloth", ModArmorMaterials.CLOTH_BLUE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item YELLOW_T_CHESTPLATE = registerItem("yellow_tshirt",
            new CustomDyedArmorItem("armor/yellow_cloth", ModArmorMaterials.CLOTH_YELLOW, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GREEN_T_CHESTPLATE = registerItem("green_tshirt",
            new CustomDyedArmorItem("armor/green_cloth", ModArmorMaterials.CLOTH_GREEN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PURPLE_T_CHESTPLATE = registerItem("purple_tshirt",
            new CustomDyedArmorItem("armor/purple_cloth", ModArmorMaterials.CLOTH_PURPLE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BROWN_T_BOOTS = registerItem("jeans_boots",
            new CustomDyedArmorItem("armor/brown_cloth", ModArmorMaterials.CLOTH_BROWN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item JEANS_LEGGINGS = registerItem("jeans",
            new JeansArmorItem(ModArmorMaterials.CLOTH_JEANS, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item RED_D_CHESTPLATE = registerItem("red_dress",
            new CustomDyedArmorItem("armor/red_tissue", ModArmorMaterials.TISSUE_RED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BLUE_D_CHESTPLATE = registerItem("blue_dress",
            new CustomDyedArmorItem("armor/blue_tissue", ModArmorMaterials.TISSUE_BLUE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item YELLOW_D_CHESTPLATE = registerItem("yellow_dress",
            new CustomDyedArmorItem("armor/yellow_tissue", ModArmorMaterials.TISSUE_YELLOW, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item GREEN_D_CHESTPLATE = registerItem("green_dress",
            new CustomDyedArmorItem("armor/green_tissue", ModArmorMaterials.TISSUE_GREEN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PURPLE_D_CHESTPLATE = registerItem("purple_dress",
            new CustomDyedArmorItem("armor/purple_tissue", ModArmorMaterials.TISSUE_PURPLE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item BROWN_D_BOOTS = registerItem("dress_boots",
            new CustomDyedArmorItem("armor/brown_tissue", ModArmorMaterials.TISSUE_BROWN, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item BINGO_CARD = registerItem("bingo_card",
            new BingoCardItem(new FabricItemSettings().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(XDFestaJunina.MOD_ID, name), item);
    }

    public static void registerModItems() {
        XDFestaJunina.LOGGER.debug("Registering Mod Items for " + XDFestaJunina.MOD_ID);
    }
}
