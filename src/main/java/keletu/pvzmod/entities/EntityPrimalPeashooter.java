package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.TrueRangedAttackGoal;
import keletu.pvzmod.entities.projectile.PrimalPeaProjectile;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityPrimalPeashooter extends EntityPlantShooterBase {
    public final AnimationState idleAnimation = new AnimationState();
    public final AnimationState shootAnimation = new AnimationState();

    public EntityPrimalPeashooter(EntityType<? extends EntityPlantShooterBase> entityType, Level par1World) {
        super(entityType, par1World, new ItemStack(PVZItems.PRIMAL_PEASHOOTER_CARD.get()));
    }

    // protected Item getDropItem() {
    //     return PvZ.peaPod;
    // }

    @Override
    protected TrueRangedAttackGoal createRangedAttackGoal() {
        return new TrueRangedAttackGoal(this, 0.0F, this.range, 1, 2, 55, 25);
    }

    @Override
    public InteractionResult mobInteract(Player par1EntityPlayer, InteractionHand hand) {
        return InteractionResult.PASS;
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        PrimalPeaProjectile ent = new PrimalPeaProjectile(world, this, 3, this.random.nextInt(100) < 15 ? 1 : 0);
        return ent;
    }

    @Override
    public void tick() {
        super.tick();

        this.setXRot(0.0F);
        this.xRotO = 0.0F;

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    public void setupAnimationStates() {
        if (this.isShooting()) {
            this.idleAnimation.stop();
            this.shootAnimation.startIfStopped(this.tickCount);
        } else {
            this.shootAnimation.stop();
            this.idleAnimation.startIfStopped(this.tickCount);
        }
    }
}