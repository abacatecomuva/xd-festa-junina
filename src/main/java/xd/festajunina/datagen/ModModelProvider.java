package xd.festajunina.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import xd.festajunina.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RED_T_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_T_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_T_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_T_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURPLE_T_CHESTPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.JEANS_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROWN_T_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.RED_D_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_D_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_D_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_D_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURPLE_D_CHESTPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BROWN_D_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BINGO_CARD, Models.GENERATED);
    }
}
