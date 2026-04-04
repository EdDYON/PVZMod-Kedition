package keletu.pvzmod.entities;

import keletu.pvzmod.init.PVZItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class EntityWalnut extends EntityPlantBase implements GeoEntity {
    private final double protectRadio;
    private static final int RETARGET_INTERVAL = 10;
    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("animation");

    public EntityWalnut(EntityType<? extends EntityPlantBase> type, Level par1World, float protectRadio) {
        super(type, par1World, new ItemStack(PVZItems.WALNUT_CARD.get(), 1));
        this.protectRadio = protectRadio;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return EntityPlantBase.createAttributes().add(Attributes.MAX_HEALTH, 20.0D * 16);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide || this.tickCount % RETARGET_INTERVAL != 0) {
            return;
        }

        AABB searchBox = new AABB(
                this.getX() - protectRadio, this.getY(), this.getZ() - protectRadio,
                this.getX() + protectRadio, this.getY() + 1.0D, this.getZ() + protectRadio
        );

        List<Mob> nearbyMobs = this.level().getEntitiesOfClass(Mob.class, searchBox);

        for (Mob mob : nearbyMobs) {
            LivingEntity target = mob.getTarget();
            if (target instanceof EntityPlantBase plant && !(plant instanceof EntityWalnut)) {
                mob.setTarget(this);
            }
        }
    }

    @Override
    protected void doPush(Entity entity) {
        if (entity instanceof Mob) {
            entity.push(this);
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Generic", 5, state -> state.setAndContinue(STAND)));
    }
}