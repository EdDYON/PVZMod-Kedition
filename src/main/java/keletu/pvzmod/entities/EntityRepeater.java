package keletu.pvzmod.entities;

import keletu.pvzmod.entities.ai.TrueRangedAttackGoal;
import keletu.pvzmod.entities.projectile.PeaProjectile;
import keletu.pvzmod.init.PVZItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityRepeater extends EntityPlantShooterBase implements GeoEntity {

    public static final RawAnimation STAND = RawAnimation.begin().thenLoop("stand");
    public static final RawAnimation SHOOT = RawAnimation.begin().thenLoop("shoot");

    public EntityRepeater(EntityType<? extends EntityPlantShooterBase> entityType, Level par1World) {
        super(entityType, par1World, new ItemStack(PVZItems.REPEATER_CARD.get()));
    }

    // protected Item getDropItem() {
    //     return PvZ.peaPod;
    // }

    @Override
    protected TrueRangedAttackGoal createRangedAttackGoal() {
        return new TrueRangedAttackGoal(this, 0.0F, this.range, 2, 2, 20);
    }

    @Override
    public InteractionResult mobInteract(Player par1EntityPlayer, InteractionHand hand) {
        return InteractionResult.PASS;
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        PeaProjectile ent = new PeaProjectile(world, this, 3);
        return ent;
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
        controllers.add(new AnimationController<>(this, "Found/NotFound", 5, state -> state.setAndContinue(this.isShooting() ? SHOOT : STAND)));
    }
}