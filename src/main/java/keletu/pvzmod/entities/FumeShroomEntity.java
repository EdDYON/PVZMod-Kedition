package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.TrueRangedAttackGoal;
import keletu.pvzmod.init.PVZItems;
import keletu.pvzmod.init.PVZParticles;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class FumeShroomEntity extends EntityPlantShooterBase implements GeoEntity {

    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("animation");
    public static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("shoot");

    // 可调参数
    private static final float BEAM_LENGTH = 7.0F;
    private static final float BEAM_RADIUS = 1.25F;
    private static final float BEAM_DAMAGE = 6.0F;

    public FumeShroomEntity(EntityType<? extends EntityPlantShooterBase> entityType, Level par1World) {
        super(entityType, par1World, new ItemStack(PVZItems.FUME_SHROOM_CARD.get()));
    }

    @Override
    public InteractionResult mobInteract(Player par1EntityPlayer, InteractionHand hand) {
        return InteractionResult.PASS;
    }

    @Override
    protected TrueRangedAttackGoal createRangedAttackGoal() {
        return new TrueRangedAttackGoal(this, 0.0F, this.range, 1, 0, 50, 40);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (this.level().isClientSide) return;

        this.faceTarget(target);

        Vec3 start = new Vec3(this.getX(), this.getEyeY() - 0.2D, this.getZ());
        Vec3 dir = new Vec3(
                target.getX() - this.getX(),
                0.0D,
                target.getZ() - this.getZ()
        ).normalize();

        if (dir.lengthSqr() < 1.0E-6D) {
            dir = this.getLookAngle().multiply(1.0D, 0.0D, 1.0D).normalize();
        }

        Vec3 end = start.add(dir.scale(BEAM_LENGTH));

        spawnBeamParticles((ServerLevel) this.level(), start, end);

        damageEntitiesAlongBeam(start, end, BEAM_RADIUS, BEAM_DAMAGE);

        this.playSound(
                PVZSounds.FUME_SHROOM_SHOOT.get(),
                1.0F,
                1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F)
        );

        List<LivingEntity> hits = getEntitiesAlongBeam(start, end, BEAM_RADIUS);
        for (LivingEntity hit : hits) {
            if (hit instanceof PathfinderMob mob) {
                if (mob.getTarget() == null || !mob.getTarget().isAlive()) {
                    mob.setTarget(this);
                }
            }
        }
    }

    private void damageEntitiesAlongBeam(Vec3 start, Vec3 end, float radius, float damage) {
        List<LivingEntity> entities = getEntitiesAlongBeam(start, end, radius);

        for (LivingEntity entity : entities) {
            if (entity == this) continue;
            entity.hurt(this.damageSources().mobAttack(this), damage);
            entity.invulnerableTime = 0;
        }
    }

    private List<LivingEntity> getEntitiesAlongBeam(Vec3 start, Vec3 end, float radius) {
        AABB box = new AABB(start, end).inflate(radius + 0.5D);

        return this.level().getEntitiesOfClass(LivingEntity.class, box, entity -> {
            if (entity == this) return false;
            if (!entity.isAlive()) return false;

            if (entity instanceof EntityPlantBase || entity == this.getOwner()) return false;

            double dist = distanceToSegment(entity.position().add(0, entity.getBbHeight() * 0.5D, 0), start, end);
            return dist <= radius;
        });
    }

    private double distanceToSegment(Vec3 point, Vec3 segStart, Vec3 segEnd) {
        Vec3 seg = segEnd.subtract(segStart);
        Vec3 toPoint = point.subtract(segStart);

        double segLenSqr = seg.lengthSqr();
        if (segLenSqr < 1.0E-6D) {
            return point.distanceTo(segStart);
        }

        double t = toPoint.dot(seg) / segLenSqr;
        t = Math.max(0.0D, Math.min(1.0D, t));

        Vec3 projection = segStart.add(seg.scale(t));
        return point.distanceTo(projection);
    }

    private void spawnBeamParticles(ServerLevel level, Vec3 start, Vec3 end) {
        Vec3 delta = end.subtract(start);
        int steps = 18;

        for (int i = 0; i <= steps; i++) {
            float progress = i / (float) steps;
            Vec3 pos = start.add(delta.scale(progress));

            level.sendParticles(
                    PVZParticles.SPORE.get(),
                    pos.x, pos.y, pos.z,
                    4,
                    0.12D, 0.12D, 0.12D,
                    0.01D
            );
        }
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target) && target.distanceTo(this) <= BEAM_LENGTH + 2.0F;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    @Override
    public void tick() {
        super.tick();

        this.setXRot(0.0F);
        this.xRotO = 0.0F;
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Found/NotFound", 5,
                state -> state.setAndContinue(this.isShooting() ? SHOOT : STAND)));
    }
}