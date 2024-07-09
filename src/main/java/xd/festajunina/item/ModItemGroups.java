package xd.festajunina.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xd.festajunina.XDFestaJunina;

public class ModItemGroups {
    public static final ItemGroup CLOTHES = Registry.register(Registries.ITEM_GROUP,
            new Identifier(XDFestaJunina.MOD_ID, "clothes"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.clothes"))
                    .icon(() -> new ItemStack(ModItems.RED_D_CHESTPLATE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RED_T_CHESTPLATE);
                        entries.add(ModItems.BLUE_T_CHESTPLATE);
                        entries.add(ModItems.YELLOW_T_CHESTPLATE);
                        entries.add(ModItems.GREEN_T_CHESTPLATE);
                        entries.add(ModItems.PURPLE_T_CHESTPLATE);

                        entries.add(ModItems.JEANS_LEGGINGS);
                        entries.add(ModItems.BROWN_T_BOOTS);

                        entries.add(ModItems.RED_D_CHESTPLATE);
                        entries.add(ModItems.BLUE_D_CHESTPLATE);
                        entries.add(ModItems.YELLOW_D_CHESTPLATE);
                        entries.add(ModItems.GREEN_D_CHESTPLATE);
                        entries.add(ModItems.PURPLE_D_CHESTPLATE);

                        entries.add(ModItems.BROWN_D_BOOTS);

                    }).build());

    public static void registerItemGroups() {
        XDFestaJunina.LOGGER.info("Regestering Item Groups for " +XDFestaJunina.MOD_ID) ;
    }
}
