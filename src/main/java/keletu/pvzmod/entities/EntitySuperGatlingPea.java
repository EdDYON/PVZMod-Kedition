package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.TrueSuperRangedAttackGoal;
import keletu.pvzmod.entities.projectile.PeaProjectile;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntitySuperGatlingPea extends EntityPlantShooterBase implements GeoEntity {
    public static final int SUPER_RAPID_FIRE_DURATION = 200;
    public static final int SUPER_RAPID_FIRE_COOLDOWN = 300;
    public static final float SUPER_RAPID_FIRE_CHANCE = 0.1F;
    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("stand");
    public static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("shoot");

    private static final EntityDataAccessor<Integer> SUPER_TICK =
            SynchedEntityData.defineId(EntitySuperGatlingPea.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SUPER_COOLDOWN =
            SynchedEntityData.defineId(EntitySuperGatlingPea.class, EntityDataSerializers.INT);

    public EntitySuperGatlingPea(EntityType<? extends EntitySuperGatlingPea> type, Level level) {
        super(type, level, new ItemStack(PVZItems.SUPER_GATLING_PEA_CARD.get()));
    }


    @Override
    protected TrueSuperRangedAttackGoal createRangedAttackGoal() {
        return new TrueSuperRangedAttackGoal(this, 0.0D, 30, 30, 15.0F, 4, 2);
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        PeaProjectile ent = new PeaProjectile(world, this, 3);
        return ent;
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
        return this.getSuperTick() <= 0 && this.getSuperCooldown() <= 0;
    }

    public void triggerSuperRapidFire() {
        this.setSuperTick(SUPER_RAPID_FIRE_DURATION);
        this.setSuperCooldown(SUPER_RAPID_FIRE_COOLDOWN);
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
    public void tick() {
        super.tick();

        this.setXRot(0.0F);
        this.xRotO = 0.0F;

        if (!this.level().isClientSide) {
            if (this.getSuperCooldown() > 0) {
                this.setSuperCooldown(this.getSuperCooldown() - 1);
            }

            if (this.getSuperTick() > 0) {
                LivingEntity target = this.getTarget();

                if (target != null && target.isAlive() && this.canAttack(target)) {
                    //this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    this.performRangedAttack(target, 1.0F);
                } else {
                    this.fireSuperShotForward();
                }

                this.setSuperTick(this.getSuperTick() - 1);
            }
        }
    }

    private void fireSuperShot(LivingEntity target) {
        if (this.level().isClientSide || target == null) {
            return;
        }

        ThrowableProjectile pea = this.entitySelect(this.level());

        pea.setPos(
                this.getX(),
                this.getEyeY() - 0.1D,
                this.getZ()
        );

        double dx = target.getX() - pea.getX();
        double dy = target.getEyeY() - pea.getY();
        double dz = target.getZ() - pea.getZ();

        Vec3 direction = new Vec3(dx, dy, dz).normalize();

        float spreadYaw = (this.random.nextFloat() * 15.0F) - 7.5F;
        float spreadPitch = (this.random.nextFloat() * 15.0F) - 7.5F;

        Vec3 spreadDirection = direction
                .yRot((float) Math.toRadians(spreadYaw))
                .xRot((float) Math.toRadians(spreadPitch))
                .normalize();

        pea.shoot(spreadDirection.x, 0, spreadDirection.z, 1.2F, 0.0F);
        this.level().addFreshEntity(pea);
    }

    private void fireSuperShotForward() {
        if (this.level().isClientSide) {
            return;
        }

        ThrowableProjectile pea = this.entitySelect(this.level());

        float yawOffset = (this.random.nextFloat() * 15.0F) - 7.5F;
        float pitchOffset = (this.random.nextFloat() * 15.0F) - 7.5F;

        float shootYaw = this.getYRot() + yawOffset;
        float shootPitch = this.getXRot() + pitchOffset;

        Vec3 look = Vec3.directionFromRotation(shootPitch, shootYaw);

        pea.setPos(this.getX(), this.getEyeY() - 0.1D, this.getZ());
        pea.shoot(look.x, look.y, look.z, 1.2F, 0.0F);
        this.level().addFreshEntity(pea);
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Found/NotFound", 5, state -> state.setAndContinue((this.isShooting() || this.isSuperFiring()) ? SHOOT : STAND)));
    }
}