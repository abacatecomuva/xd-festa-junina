package xd.festajunina.item.client;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import xd.festajunina.XDFestaJunina;
import xd.festajunina.item.custom.GreenWoolArmorItem;

public class GreenWoolArmorModel extends GeoModel<GreenWoolArmorItem> {
    @Override
    public Identifier getModelResource(GreenWoolArmorItem animatable) {
        return new Identifier(XDFestaJunina.MOD_ID, "geo/green_twool.geo.json");

    }

    @Override
    public Identifier getTextureResource(GreenWoolArmorItem animatable) {
        return new Identifier(XDFestaJunina.MOD_ID, "textures/armor/green_twool.png");
    }

    @Override
    public Identifier getAnimationResource(GreenWoolArmorItem animatable) {
        return new Identifier(XDFestaJunina.MOD_ID, "animations/green_twool.animation.json");
    }
}
