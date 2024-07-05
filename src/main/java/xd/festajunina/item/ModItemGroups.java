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
                    .icon(() -> new ItemStack(ModItems.GREEN_WOOL_CHESTPLATE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GREEN_WOOL_CHESTPLATE);

                    }).build());

    public static void registerItemGroups() {
        XDFestaJunina.LOGGER.info("Regestering Item Groups for " +XDFestaJunina.MOD_ID) ;
    }
}
