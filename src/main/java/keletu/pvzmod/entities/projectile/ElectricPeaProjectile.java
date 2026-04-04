package keletu.pvzmod.entities.projectile;

import keletu.pvzmod.entities.EntityPlantBase;
import keletu.pvzmod.init.PVZDamageTypes;
import keletu.pvzmod.init.PVZEntities;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ElectricPeaProjectile extends ThrowableItemProjectile {
    private float damage = 2.0F;
    private float shockDamage = 1.0F;
    private EntityPlantBase shooter;
    private final Set<UUID> shockedEntities = new HashSet<>();

    public ElectricPeaProjectile(EntityType<? extends ElectricPeaProjectile> type, Level level) {
        super(type, level);
    }

    public ElectricPeaProjectile(Level level, EntityPlantBase shooter, float damage) {
        super(PVZEntities.ELECTRIC_PEA_PROJECTILE.get(), shooter, level);
        this.damage = damage;
        this.shooter = shooter;
        this.setNoGravity(true);
    }

    @Override
    protected Item getDefaultItem() {
        return PVZItems.ELECTRIC_PEA.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (result.getEntity() instanceof EntityPlantBase || (this.shooter != null && result.getEntity() == shooter.getOwner()))
            return;

        if (!this.level().isClientSide) {
            result.getEntity().hurt(PVZDamageTypes.causeElectricPeaProjectileDamage(this, this.getOwner()), damage);
            result.getEntity().invulnerableTime = 0;

            this.shockNearbyEntities();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            this.shockNearbyEntities();
            this.spawnGroundingEffect();

            if (this.tickCount > 40) {
                this.discard();
                ((ServerLevel) this.level()).sendParticles(
                        ParticleTypes.EXPLOSION,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        1,
                        0,
                        0,
                        0,
                        0.15F
                );
            }
        }
    }

    private boolean canShock(LivingEntity entity) {
        if (entity == null || !entity.isAlive()) {
            return false;
        }

        if (entity == this.getOwner()) {
            return false;
        }

        if (entity == this.shooter) {
            return false;
        }

        if (entity instanceof EntityPlantBase) {
            return false;
        }

        if (this.shooter != null && entity == this.shooter.getOwner()) {
            return false;
        }

        return true;
    }

    private void shockNearbyEntities() {
        if (this.level().isClientSide) {
            return;
        }

        AABB range = this.getBoundingBox().inflate(1.0D);

        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, range)) {
            if (!canShock(living)) {
                continue;
            }

            if (shockedEntities.contains(living.getUUID())) {
                continue;
            }

            living.hurt(
                    PVZDamageTypes.causeElectricPeaProjectileDamage(this, this.getOwner()),
                    shockDamage
            );
            living.invulnerableTime = 0;

            this.spawnShockEffect(living);
            shockedEntities.add(living.getUUID());

            if (this.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(
                        ParticleTypes.ELECTRIC_SPARK,
                        living.getX(),
                        living.getY() + living.getBbHeight() * 0.5D,
                        living.getZ(),
                        6,
                        0.2D,
                        0.2D,
                        0.2D,
                        0.02D
                );
            }
        }
    }

    private void spawnGroundingEffect() {
        if (!(this.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        BlockPos projectilePos = this.blockPosition();
        BlockPos groundPos = null;
        int maxDistance = 12;

        for (int i = 1; i <= maxDistance; i++) {
            BlockPos checkPos = projectilePos.below(i);
            if (!this.level().getBlockState(checkPos).isAir()) {
                groundPos = checkPos;
                break;
            }
        }

        if (groundPos == null) {
            return;
        }

        double startX = this.getX();
        double startY = this.getY();
        double startZ = this.getZ();

        double endX = startX;
        double endY = groundPos.getY() + 1.0D;
        double endZ = startZ;

        double distance = startY - endY;
        if (distance <= 0.1D) {
            return;
        }

        int steps = Math.max(5, (int) (distance * 5));

        for (int i = 0; i <= steps; i++) {
            double t = i / (double) steps;

            double px = startX;
            double py = startY + (endY - startY) * t;
            double pz = startZ;

            double offsetX = (this.random.nextDouble() - 0.5D) * 0.12D;
            double offsetZ = (this.random.nextDouble() - 0.5D) * 0.12D;

            serverLevel.sendParticles(
                    ParticleTypes.ELECTRIC_SPARK,
                    px + offsetX,
                    py,
                    pz + offsetZ,
                    1,
                    0.0D,
                    0.0D,
                    0.0D,
                    0.0D
            );
        }

        serverLevel.sendParticles(
                ParticleTypes.ELECTRIC_SPARK,
                endX,
                endY + 0.03D,
                endZ,
                5,
                0.12D,
                0.02D,
                0.12D,
                0.01D
        );
    }

    private void spawnShockEffect(LivingEntity target) {
        if (!(this.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        double x = target.getX();
        double y = target.getY() + target.getBbHeight() * 0.5D;
        double z = target.getZ();

        serverLevel.sendParticles(
                ParticleTypes.ELECTRIC_SPARK,
                x,
                y,
                z,
                10,
                0.25D,
                0.3D,
                0.25D,
                0.04D
        );
        spawnArcParticles(target);
    }

    private void spawnArcParticles(LivingEntity target) {
        if (!(this.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        Vec3 start = this.position().add(0.0D, this.getBbHeight() * 0.5D, 0.0D);
        Vec3 end = target.position().add(0.0D, target.getBbHeight() * 0.5D, 0.0D);
        Vec3 delta = end.subtract(start);

        int steps = 8;
        for (int i = 0; i <= steps; i++) {
            double t = i / (double) steps;
            double px = start.x + delta.x * t;
            double py = start.y + delta.y * t;
            double pz = start.z + delta.z * t;

            serverLevel.sendParticles(
                    ParticleTypes.ELECTRIC_SPARK,
                    px,
                    py,
                    pz,
                    1,
                    0.02D,
                    0.02D,
                    0.02D,
                    0.0D
            );
        }
    }
}