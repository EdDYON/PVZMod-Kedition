package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.PuffShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import java.util.Optional;

public class PuffShroomModel extends GeoModel<PuffShroomEntity> {
    @Override
    public ResourceLocation getModelResource(PuffShroomEntity t) {
        return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/puff_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PuffShroomEntity t) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/puff_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PuffShroomEntity t) {
        return new ResourceLocation(PVZMod.MODID, "animations/puff_shroom.animation.json");
    }

    @Override
    public void handleAnimations(PuffShroomEntity entity, long uniqueID, AnimationState<PuffShroomEntity> customPredicate) {
        super.handleAnimations(entity, uniqueID, customPredicate);
        CoreGeoBone head = this.getAnimationProcessor().getBone("all");
        EntityModelData extraData = customPredicate.getData(DataTickets.ENTITY_MODEL_DATA);
        head.setRotY(extraData.netHeadYaw() * ((float) Math.PI / 180F));
    }

    @Override
    public Optional<GeoBone> getBone(String boneName) {
        return super.getBone(boneName);
    }
}
