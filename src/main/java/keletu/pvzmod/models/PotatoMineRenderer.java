package keletu.pvzmod.models;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.EntityPotatoMine;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PotatoMineRenderer<T extends EntityPotatoMine> extends MobRenderer<EntityPotatoMine, PotatoMineModel> {
    public PotatoMineRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PotatoMineModel(pContext.bakeLayer(PotatoMineModel.LAYER_LOCATION)), 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPotatoMine pEntity) {
        return new ResourceLocation(PVZMod.MODID, "textures/entity/plant/potato_mine_new.png");
    }
}
