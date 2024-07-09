package xd.festajunina.item.client;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.PurpleDArmorItem;

public class PurpleDArmorRenderer extends GeoArmorRenderer<PurpleDArmorItem> {
    public PurpleDArmorRenderer() {
        super(new DefaultedItemGeoModel<>(new Identifier(XDFestaJunina.MOD_ID,"armor/purple_tissue")));
    }
}
