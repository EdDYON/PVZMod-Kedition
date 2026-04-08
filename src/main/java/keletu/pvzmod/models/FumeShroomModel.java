package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.FumeShroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import java.util.Optional;

public class FumeShroomModel extends GeoModel<FumeShroomEntity> {
    @Override
    public ResourceLocation getModelResource(FumeShroomEntity t) {
        return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/fume_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FumeShroomEntity t) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/fume_shroom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FumeShroomEntity t) {
        return new ResourceLocation(PVZMod.MODID, "animations/fume_shroom.animation.json");
    }

    @Override
    public void handleAnimations(FumeShroomEntity entity, long uniqueID, AnimationState<FumeShroomEntity> customPredicate) {
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
