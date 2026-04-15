package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySuperPrimalGatlingPea;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SuperPrimalPeashooterRender<T extends EntitySuperPrimalGatlingPea> extends MobRenderer<EntitySuperPrimalGatlingPea, PrimalSuperGatlingPeaModel> {
    public SuperPrimalPeashooterRender(EntityRendererProvider.Context pContext) {
        super(pContext, new PrimalSuperGatlingPeaModel(pContext.bakeLayer(PrimalSuperGatlingPeaModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySuperPrimalGatlingPea pEntity) {
        return PrimalSuperGatlingPeaModel.LAYER_LOCATION.getModel();
    }
}
