package keletu.pvzmod.entities;

import keletu.pvzmod.init.PVZItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityTallnut extends EntityWalnut {
    private static final float PROTECT_RADIUS = 16.0F;

    public EntityTallnut(EntityType<? extends EntityWalnut> type, Level par1World) {
        super(type, par1World, PROTECT_RADIUS);
        this.spawnStack = new ItemStack(PVZItems.TALL_NUT_CARD.get(), 1);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return EntityPlantBase.createAttributes().add(Attributes.MAX_HEALTH, 20.0D * 21);
    }
}