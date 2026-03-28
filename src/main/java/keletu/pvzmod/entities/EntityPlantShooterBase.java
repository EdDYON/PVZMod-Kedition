package keletu.pvzmod.entities;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityPlantShooterBase extends EntityPlantBase implements RangedAttackMob {

    public EntityPlantShooterBase(EntityType<? extends EntityPlantBase> entityType, Level level) {
        super(entityType, level);
    }

    public EntityPlantShooterBase(EntityType<? extends EntityPlantBase> entityType, Level level, ItemStack spawnStack) {
        super(entityType, level, spawnStack);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 0.0F, 35, this.range));

        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Monster.class, true));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ThrowableProjectile projectile = entitySelect(this.level());
        projectile.setPos(this.getX(), this.getEyeY() - 0.1D, this.getZ());

        double toX = target.getX() - this.getX();
        float percentToMouth = 0.5F;
        double toY = target.getY() + target.getEyeHeight() * percentToMouth - 1.0D - projectile.getY();
        double toZ = target.getZ() - this.getZ();

        float horizontalDistance = Mth.sqrt((float) (toX * toX + toZ * toZ)) * 0.2F;

        projectile.shoot(toX, toY + horizontalDistance, toZ, 1.6F, 12.0F);

        this.playSound(SoundEvents.ARROW_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));

        this.level().addFreshEntity(projectile);

        if (target instanceof PathfinderMob) {
            ((PathfinderMob) target).setTarget(this);
        }
    }

    public ThrowableProjectile entitySelect(Level level) {
        return new Snowball(level, this);
    }
}