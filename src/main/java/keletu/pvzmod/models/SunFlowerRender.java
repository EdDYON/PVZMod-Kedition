package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySunFlower;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SunFlowerRender<T extends EntitySunFlower> extends MobRenderer<EntitySunFlower, SunFlowerModel> {
    public SunFlowerRender(EntityRendererProvider.Context pContext) {
        super(pContext, new SunFlowerModel(pContext.bakeLayer(SunFlowerModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySunFlower pEntity) {
        return SunFlowerModel.LAYER_LOCATION.getModel();
    }
}
