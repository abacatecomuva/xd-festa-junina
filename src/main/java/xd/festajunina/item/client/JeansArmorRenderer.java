package xd.festajunina.item.client;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.JeansArmorItem;

public class JeansArmorRenderer extends GeoArmorRenderer<JeansArmorItem> {
    public JeansArmorRenderer() {
        super(new DefaultedItemGeoModel<>(new Identifier(XDFestaJunina.MOD_ID,"armor/jeans_cloth")));
    }

    @Override
    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        super.applyBoneVisibilityBySlot(currentSlot);

        switch (currentSlot) {
            case LEGS -> {
                setBoneVisible(this.body, true);
                setBoneVisible(this.rightLeg, true);
                setBoneVisible(this.leftLeg, true);
                }

            default -> {}
        }
    }
}
