package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityGatlingPea;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GatlingPeaRender<T extends EntityGatlingPea> extends MobRenderer<EntityGatlingPea, GatlingPeaModel> {
    public GatlingPeaRender(EntityRendererProvider.Context pContext) {
        super(pContext, new GatlingPeaModel(pContext.bakeLayer(GatlingPeaModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGatlingPea pEntity) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/gatling_pea_new.png");
    }

    @Override
    protected RenderType getRenderType(EntityGatlingPea entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }
}
