package keletu.pvzmod.entities.projectile;

import keletu.pvzmod.entities.EntityPlantBase;
import keletu.pvzmod.init.PVZEffects;
import keletu.pvzmod.init.PVZEntities;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class SnowPeaProjectile extends ThrowableItemProjectile {
    private float damage = 2.0F;
    private EntityPlantBase shooter;

    public SnowPeaProjectile(EntityType<? extends SnowPeaProjectile> type, Level level) {
        super(type, level);
    }

    public SnowPeaProjectile(Level level, EntityPlantBase shooter, float damage) {
        super(PVZEntities.ICE_PEA_PROJECTILE.get(), shooter, level);
        this.damage = damage;
        this.shooter = shooter;
        this.setNoGravity(true);
    }

    @Override
    protected Item getDefaultItem() {
        return PVZItems.ICE_PEA.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (result.getEntity() instanceof EntityPlantBase || (this.shooter != null && this.shooter.getOwner() != null && result.getEntity() == shooter.getOwner()))
            return;

        if (!this.level().isClientSide && result.getEntity() instanceof LivingEntity mob) {
            mob.addEffect(new MobEffectInstance(PVZEffects.SNOW.get(), 100, 0));
            mob.hurt(this.damageSources().mobProjectile(this, this.shooter), damage);
            mob.invulnerableTime = 0;

            this.spawnBreakParticles();
            this.playSound(SoundEvents.GRASS_BREAK, 0.8F, 1.2F);
            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.tickCount > 60) {
            this.setDeltaMovement(this.getDeltaMovement().add(0, -0.01F, 0));
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if (!this.level().isClientSide) {
            this.spawnBreakParticles();
            this.playSound(SoundEvents.GRASS_BREAK, 0.8F, 1.2F);
            this.discard();
        }
    }

    private void spawnBreakParticles() {
        if (this.level() instanceof ServerLevel serverLevel) {
            int particleCount = 10 + this.random.nextInt(10);

            serverLevel.sendParticles(
                    new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(PVZItems.ICE_PEA.get())),
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    particleCount,
                    0.25D,
                    0.25D,
                    0.25D,
                    0.15D
            );
        }
    }
}