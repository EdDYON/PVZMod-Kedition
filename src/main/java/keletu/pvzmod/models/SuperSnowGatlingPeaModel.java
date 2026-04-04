package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntitySuperSnowGatlingPea;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

import java.util.Optional;

public class SuperSnowGatlingPeaModel extends GeoModel<EntitySuperSnowGatlingPea> {
    @Override
    public ResourceLocation getModelResource(EntitySuperSnowGatlingPea t) {
        return new ResourceLocation(PVZMod.MODID, "geo/entity/plant/super_snow_gatling_pea.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySuperSnowGatlingPea t) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/super_snow_gatling_pea.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySuperSnowGatlingPea t) {
        return new ResourceLocation(PVZMod.MODID, "animations/super_snow_gatling_pea.animation.json");
    }

    @Override
    public void handleAnimations(EntitySuperSnowGatlingPea entity, long uniqueID, AnimationState<EntitySuperSnowGatlingPea> customPredicate) {
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
