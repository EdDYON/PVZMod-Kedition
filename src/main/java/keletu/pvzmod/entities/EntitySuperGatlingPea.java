package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.TrueSuperRangedAttackGoal;
import keletu.pvzmod.entities.projectile.PeaProjectile;
import keletu.pvzmod.init.PVZItems;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntitySuperGatlingPea extends EntityPlantShooterBase {
    public static final int SUPER_RAPID_FIRE_DURATION = 40;
    public static final int SUPER_RAPID_FIRE_COOLDOWN = 300;
    public static final float SUPER_RAPID_FIRE_CHANCE = 0.02F;
    private static final int SUPER_STARTUP_TICKS = 4;
    private static final int SUPER_MAIN_PROJECTILE_COUNT_MIN = 4;
    private static final int SUPER_MAIN_PROJECTILE_COUNT_MAX = 5;
    private static final int SUPER_LAYER_PROJECTILE_COUNT_MIN = 2;
    private static final int SUPER_LAYER_PROJECTILE_COUNT_MAX = 3;
    private static final float SUPER_TARGET_MAIN_HALF_SPREAD = 18.0F;
    private static final float SUPER_TARGET_LAYER_HALF_SPREAD = 10.0F;
    private static final float SUPER_FORWARD_MAIN_HALF_SPREAD = 24.0F;
    private static final float SUPER_FORWARD_LAYER_HALF_SPREAD = 14.0F;
    private static final float SUPER_MAIN_YAW_JITTER = 4.0F;
    private static final float SUPER_LAYER_YAW_JITTER = 3.0F;
    private static final float SUPER_MAIN_PITCH_JITTER = 1.5F;
    private static final float SUPER_LAYER_PITCH_JITTER = 1.8F;
    private static final float SUPER_UPPER_LAYER_PITCH = -6.5F;
    private static final float SUPER_LOWER_LAYER_PITCH = 5.5F;
    private static final float SUPER_VOLLEY_YAW_BIAS = 5.0F;
    private static final float SUPER_VOLLEY_PITCH_BIAS = 1.5F;
    private static final float SUPER_SPREAD_CHAOS_FACTOR = 0.35F;
    private static final double SUPER_MOUTH_FORWARD_OFFSET = 0.82D;
    private static final double SUPER_MOUTH_VERTICAL_OFFSET = -0.18D;
    private static final double SUPER_SPAWN_SIDE_OFFSET = 0.12D;
    private static final double SUPER_SPAWN_Y_OFFSET = 0.10D;
    private static final float SUPER_PROJECTILE_SPEED = 1.2F;
    private static final float SUPER_PROJECTILE_SPEED_JITTER = 0.12F;
    public final AnimationState idleAnimation = new AnimationState();
    public final AnimationState shootAnimation = new AnimationState();
    public final AnimationState superAnimation = new AnimationState();
    private static final EntityDataAccessor<Integer> SUPER_TICK =
            SynchedEntityData.defineId(EntitySuperGatlingPea.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SUPER_COOLDOWN =
            SynchedEntityData.defineId(EntitySuperGatlingPea.class, EntityDataSerializers.INT);
    private boolean queuedSuperRapidFire;
    private int superStartupTicks;

    public EntitySuperGatlingPea(EntityType<? extends EntitySuperGatlingPea> type, Level level) {
        super(type, level, new ItemStack(PVZItems.SUPER_GATLING_PEA_CARD.get()));
    }

    @Override
    protected TrueSuperRangedAttackGoal createRangedAttackGoal() {
        if (this.isSuperFiring()) {
            return new TrueSuperRangedAttackGoal(this, 0.0D, 15.0F, 4, 2, 60, 0);
        }
        return new TrueSuperRangedAttackGoal(this, 0.0D, 15.0F, 4, 2, 30, 25);
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        return new PeaProjectile(world, this, 3);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SUPER_TICK, 0);
        this.entityData.define(SUPER_COOLDOWN, 0);
    }

    public int getSuperTick() {
        return this.entityData.get(SUPER_TICK);
    }

    public void setSuperTick(int tick) {
        this.entityData.set(SUPER_TICK, tick);
    }

    public int getSuperCooldown() {
        return this.entityData.get(SUPER_COOLDOWN);
    }

    public void setSuperCooldown(int tick) {
        this.entityData.set(SUPER_COOLDOWN, tick);
    }

    public boolean isSuperFiring() {
        return this.getSuperTick() > 0;
    }

    public boolean canTriggerSuperRapidFire() {
        return this.getSuperTick() <= 0 && this.getSuperCooldown() <= 0 && !this.queuedSuperRapidFire;
    }

    public void triggerSuperRapidFire() {
        if (this.isShootAnimationInProgress()) {
            this.queuedSuperRapidFire = true;
            return;
        }

        this.startSuperRapidFire();
    }

    private void startSuperRapidFire() {
        this.setSuperTick(SUPER_RAPID_FIRE_DURATION);
        this.setSuperCooldown(SUPER_RAPID_FIRE_COOLDOWN);
        this.superStartupTicks = SUPER_STARTUP_TICKS;
        this.queuedSuperRapidFire = false;
        this.setShooting(false);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float power) {
        if (this.isSuperFiring()) {
            this.fireSuperShot(target);
        } else {
            super.performRangedAttack(target, power);
        }
    }

    @Override
    public SoundEvent getShootSound() {
        return PVZSounds.SUPERGATLINGPEA_SHOOT.get();
    }

    @Override
    public void tick() {
        super.tick();

        this.setXRot(0.0F);
        this.xRotO = 0.0F;

        if (!this.level().isClientSide) {
            if (this.getSuperCooldown() > 0) {
                this.setSuperCooldown(this.getSuperCooldown() - 1);
            }

            if (!this.isSuperFiring() && this.queuedSuperRapidFire && !this.isShootAnimationInProgress()) {
                this.startSuperRapidFire();
            }

            if (this.getSuperTick() > 0) {
                if (this.superStartupTicks > 0) {
                    --this.superStartupTicks;
                } else {
                    LivingEntity target = this.getTarget();

                    if (target != null && target.isAlive() && this.canAttack(target)) {
                        this.performRangedAttack(target, 1.0F);
                    } else {
                        this.fireSuperShotForward();
                    }
                }

                this.setSuperTick(this.getSuperTick() - 1);
            } else {
                this.superStartupTicks = 0;
            }
        }

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void fireSuperShot(LivingEntity target) {
        if (this.level().isClientSide || target == null) {
            return;
        }

        this.faceTarget(target);
        Vec3 baseDirection = new Vec3(target.getX() - this.getX(), 0.0D, target.getZ() - this.getZ());
        this.fireSuperVolley(baseDirection, SUPER_TARGET_MAIN_HALF_SPREAD, SUPER_TARGET_LAYER_HALF_SPREAD);
    }

    private void fireSuperShotForward() {
        if (this.level().isClientSide) {
            return;
        }

        Vec3 look = Vec3.directionFromRotation(0.0F, this.yHeadRot);
        this.fireSuperVolley(look, SUPER_FORWARD_MAIN_HALF_SPREAD, SUPER_FORWARD_LAYER_HALF_SPREAD);
    }

    private void fireSuperVolley(Vec3 baseDirection, float mainHalfSpread, float layerHalfSpread) {
        Vec3 flattenedDirection = new Vec3(baseDirection.x, 0.0D, baseDirection.z);
        if (flattenedDirection.lengthSqr() < 1.0E-6D) {
            Vec3 look = this.getLookAngle();
            flattenedDirection = new Vec3(look.x, 0.0D, look.z);
        }

        if (flattenedDirection.lengthSqr() < 1.0E-6D) {
            flattenedDirection = Vec3.directionFromRotation(0.0F, this.yHeadRot);
        }

        Vec3 normalizedDirection = flattenedDirection.normalize();

        float volleyYawBias = randomCentered(SUPER_VOLLEY_YAW_BIAS);
        float volleyPitchBias = randomCentered(SUPER_VOLLEY_PITCH_BIAS);

        this.fireSuperBand(
                normalizedDirection,
                randomCount(SUPER_MAIN_PROJECTILE_COUNT_MIN, SUPER_MAIN_PROJECTILE_COUNT_MAX),
                mainHalfSpread,
                volleyYawBias,
                volleyPitchBias,
                SUPER_MAIN_YAW_JITTER,
                SUPER_MAIN_PITCH_JITTER
        );
        this.fireSuperBand(
                normalizedDirection,
                randomCount(SUPER_LAYER_PROJECTILE_COUNT_MIN, SUPER_LAYER_PROJECTILE_COUNT_MAX),
                layerHalfSpread,
                volleyYawBias + randomCentered(2.5F),
                volleyPitchBias + SUPER_UPPER_LAYER_PITCH + randomCentered(1.0F),
                SUPER_LAYER_YAW_JITTER,
                SUPER_LAYER_PITCH_JITTER
        );
        this.fireSuperBand(
                normalizedDirection,
                randomCount(SUPER_LAYER_PROJECTILE_COUNT_MIN, SUPER_LAYER_PROJECTILE_COUNT_MAX),
                layerHalfSpread,
                volleyYawBias + randomCentered(2.5F),
                volleyPitchBias + SUPER_LOWER_LAYER_PITCH + randomCentered(1.0F),
                SUPER_LAYER_YAW_JITTER,
                SUPER_LAYER_PITCH_JITTER
        );
    }

    private void fireSuperBand(Vec3 baseDirection, int projectileCount, float halfSpread, float baseYaw, float basePitch, float yawJitter, float pitchJitter) {
        for (int i = 0; i < projectileCount; ++i) {
            float step = projectileCount == 1 ? 0.5F : (float) i / (projectileCount - 1);
            float fanOffset = Mth.lerp(step, -halfSpread, halfSpread) + randomCentered(halfSpread * SUPER_SPREAD_CHAOS_FACTOR);
            float yawOffset = baseYaw + fanOffset + randomCentered(yawJitter);
            float pitchOffset = basePitch + randomCentered(pitchJitter);

            Vec3 shotDirection = baseDirection
                    .yRot((float) Math.toRadians(yawOffset))
                    .xRot((float) Math.toRadians(pitchOffset))
                    .normalize();

            this.spawnSuperProjectile(shotDirection);
        }
    }

    private int randomCount(int min, int max) {
        return this.random.nextInt(max - min + 1) + min;
    }

    private float randomCentered(float range) {
        return (this.random.nextFloat() * 2.0F - 1.0F) * range;
    }

    private void spawnSuperProjectile(Vec3 direction) {
        ThrowableProjectile projectile = this.entitySelect(this.level());
        Vec3 forward = direction.normalize();
        Vec3 flattenedDirection = new Vec3(forward.x, 0.0D, forward.z);
        if (flattenedDirection.lengthSqr() < 1.0E-6D) {
            flattenedDirection = Vec3.directionFromRotation(0.0F, this.yHeadRot);
        }

        Vec3 horizontalForward = flattenedDirection.normalize();
        Vec3 lateral = new Vec3(-horizontalForward.z, 0.0D, horizontalForward.x).normalize();

        double sideOffset = randomCentered((float) SUPER_SPAWN_SIDE_OFFSET);
        double yOffset = randomCentered((float) SUPER_SPAWN_Y_OFFSET);
        Vec3 spawnPos = new Vec3(this.getX(), this.getEyeY() + SUPER_MOUTH_VERTICAL_OFFSET, this.getZ())
                .add(horizontalForward.scale(SUPER_MOUTH_FORWARD_OFFSET))
                .add(lateral.scale(sideOffset))
                .add(0.0D, yOffset, 0.0D);

        projectile.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
        projectile.shoot(direction.x, direction.y, direction.z, SUPER_PROJECTILE_SPEED + randomCentered(SUPER_PROJECTILE_SPEED_JITTER), 0.0F);
        this.level().addFreshEntity(projectile);
    }

    public void setupAnimationStates() {
        if (this.isSuperFiring()) {
            this.shootAnimation.stop();
            this.idleAnimation.stop();
            this.superAnimation.startIfStopped(this.tickCount);
        } else if (this.isShooting()) {
            this.superAnimation.stop();
            this.idleAnimation.stop();
            this.shootAnimation.startIfStopped(this.tickCount);
        } else {
            this.shootAnimation.stop();
            this.superAnimation.stop();
            this.idleAnimation.startIfStopped(this.tickCount);
        }
    }
}
