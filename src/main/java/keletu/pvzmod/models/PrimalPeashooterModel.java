package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityPrimalPeashooter;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import java.util.Optional;

public class PrimalPeashooterModel extends GeoModel<EntityPrimalPeashooter> {
    @Override
    public ResourceLocation getModelResource(EntityPrimalPeashooter t) {
        return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/primal_peashooter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPrimalPeashooter t) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/primal_peashooter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPrimalPeashooter t) {
        return new ResourceLocation(PVZMod.MODID, "animations/primal_peashooter.animation.json");
    }

    @Override
    public void handleAnimations(EntityPrimalPeashooter entity, long uniqueID, AnimationState<EntityPrimalPeashooter> customPredicate) {
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
