package xd.festajunina.item.client;

import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import xd.festajunina.item.custom.GreenWoolArmorItem;

public class GreenWoolArmorRenderer extends GeoArmorRenderer<GreenWoolArmorItem> {
    public GreenWoolArmorRenderer() {
        super(new GreenWoolArmorModel());
    }
}
