package keletu.pvzmod.entities;

import keletu.pvzmod.entities.projectile.PrimalPeaProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class EntitySuperPrimalGatlingPea extends EntitySuperGatlingPea {
    public EntitySuperPrimalGatlingPea(EntityType<? extends EntitySuperPrimalGatlingPea> type, Level level) {
        super(type, level);
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        PrimalPeaProjectile ent = new PrimalPeaProjectile(world, this, 3, 1);
        return ent;
    }
}