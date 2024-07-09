package xd.festajunina.item.client;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.GreenDArmorItem;

public class GreenDArmorRenderer extends GeoArmorRenderer<GreenDArmorItem> {
    public GreenDArmorRenderer() {
        super(new DefaultedItemGeoModel<>(new Identifier(XDFestaJunina.MOD_ID,"armor/green_tissue")));
    }
}
