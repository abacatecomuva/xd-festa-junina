package xd.festajunina.item.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

import java.util.logging.Logger;

public class BingoNumberItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    private final static Logger LOGGER = Logger.getLogger(BingoNumberItemRenderer.class.getName());

    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        LOGGER.info("Rendering item: " + stack.getItem().getTranslationKey()); // not being called
    }
}
