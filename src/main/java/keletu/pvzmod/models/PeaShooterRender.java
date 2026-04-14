package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityPeaShooter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PeaShooterRender<T extends EntityPeaShooter> extends MobRenderer<EntityPeaShooter, PeaShooterModel> {
    public PeaShooterRender(EntityRendererProvider.Context pContext) {
        super(pContext, new PeaShooterModel(pContext.bakeLayer(PeaShooterModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPeaShooter pEntity) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/peashooter_new.png");
    }
}
