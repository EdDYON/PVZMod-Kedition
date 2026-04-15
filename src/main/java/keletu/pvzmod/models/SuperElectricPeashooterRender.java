package keletu.pvzmod.models;

import keletu.pvzmod.entities.EntitySuperElectricGatlingPea;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SuperElectricPeashooterRender<T extends EntitySuperElectricGatlingPea> extends MobRenderer<EntitySuperElectricGatlingPea, SuperElectricGatlingPeaModel> {
    public SuperElectricPeashooterRender(EntityRendererProvider.Context pContext) {
        super(pContext, new SuperElectricGatlingPeaModel(pContext.bakeLayer(SuperElectricGatlingPeaModel.LAYER_LOCATION)), 0.5F);
        this.addLayer(new SuperElectricPeashooterLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySuperElectricGatlingPea pEntity) {
        return SuperElectricGatlingPeaModel.LAYER_LOCATION.getModel();
    }

    @Override
    protected RenderType getRenderType(EntitySuperElectricGatlingPea entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.itemEntityTranslucentCull(getTextureLocation(entity));
    }
}
