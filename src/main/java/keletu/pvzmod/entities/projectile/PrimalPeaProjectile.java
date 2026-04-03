package keletu.pvzmod.entities.projectile;

import keletu.pvzmod.entities.EntityPlantBase;
import keletu.pvzmod.init.PVZEffects;
import keletu.pvzmod.init.PVZEntities;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.phys.Vec3;

public class PrimalPeaProjectile extends ThrowableItemProjectile {

    private static final EntityDataAccessor<Integer> DATA_TYPE = SynchedEntityData.defineId(PrimalPeaProjectile.class, EntityDataSerializers.INT);
    private float damage = 2.0F;
    private EntityPlantBase shooter;

    public PrimalPeaProjectile(EntityType<? extends PrimalPeaProjectile> type, Level level) {
        super(type, level);
    }

    public PrimalPeaProjectile(Level level, EntityPlantBase shooter, float damage, int type) {
        super(PVZEntities.PRIMAL_PEA_PROJECTILE.get(), shooter, level);
        this.damage = damage;
        this.shooter = shooter;
        this.entityData.set(DATA_TYPE, type);
        this.setNoGravity(true);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TYPE, 0);
    }

    public int getProjectileType() {
        return this.entityData.get(DATA_TYPE);
    }

    @Override
    protected Item getDefaultItem() {
        if (this.getProjectileType() == 1) {
            return PVZItems.SMALL_STONE.get();
        }
        return PVZItems.PRIMAL_PEA.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (result.getEntity() instanceof EntityPlantBase || (this.shooter != null && result.getEntity() == shooter.getOwner()))
            return;

        if (!this.level().isClientSide && result.getEntity() instanceof LivingEntity mob) {
            if (this.random.nextInt(100) < 50) {
                mob.addEffect(new MobEffectInstance(PVZEffects.STUN.get(), 10));
            } else {
                Vec3 motion = this.getDeltaMovement();
                mob.knockback(2.5D, -motion.x, -motion.z);
            }
            result.getEntity().hurt(this.damageSources().mobProjectile(this, (LivingEntity) this.getOwner()), getProjectileType() == 1 ? damage * 2 : damage);
            result.getEntity().invulnerableTime = 0;

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
                    new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(getDefaultItem())),
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