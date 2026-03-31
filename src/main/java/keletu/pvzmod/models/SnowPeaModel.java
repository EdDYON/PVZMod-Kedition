package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntitySnowPea;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import java.util.Optional;

public class SnowPeaModel extends GeoModel<EntitySnowPea> {
    @Override
    public ResourceLocation getModelResource(EntitySnowPea t) {
        return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/snow_pea.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySnowPea t) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/snow_pea.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySnowPea t) {
        return new ResourceLocation(PVZMod.MODID, "animations/snow_pea.animation.json");
    }

    @Override
    public void handleAnimations(EntitySnowPea entity, long uniqueID, AnimationState<EntitySnowPea> customPredicate) {
        super.handleAnimations(entity, uniqueID, customPredicate);
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);
        head.setRotY(extraData.netHeadYaw() * ((float) Math.PI / 180F));
    }

    @Override
    public Optional<GeoBone> getBone(String boneName) {
        return super.getBone(boneName);
    }
}
