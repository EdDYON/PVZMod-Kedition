package keletu.pvzmod.entities;

import keletu.pvzmod.init.PVZItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityPotatoMine extends EntityPlantBase implements GeoEntity {
    private static final EntityDataAccessor<Integer> GROW_TIME = SynchedEntityData.defineId(EntityPotatoMine.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BOOM_TIME = SynchedEntityData.defineId(EntityPotatoMine.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> START_BOOM = SynchedEntityData.defineId(EntityPotatoMine.class, EntityDataSerializers.BOOLEAN);

    public static final RawAnimation WAIT = RawAnimation.begin().thenLoop("wait");
    public static final RawAnimation GROW = RawAnimation.begin().thenPlay("chutu");
    public static final RawAnimation WAIT_GROWN = RawAnimation.begin().thenPlay("wait1");
    public static final RawAnimation BOOM = RawAnimation.begin().thenPlay("boom");

    public EntityPotatoMine(EntityType<? extends EntityPotatoMine> entityType, Level par1World) {
        super(entityType, par1World, new ItemStack(PVZItems.POTATO_MINE_CARD.get()));
    }

    // protected Item getDropItem() {
    //     return PvZ.peaPod;
    // }

    @Override
    public InteractionResult mobInteract(Player par1EntityPlayer, InteractionHand hand) {
        return InteractionResult.PASS;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GROW_TIME, 0);
        this.entityData.define(BOOM_TIME, 0);
        this.entityData.define(START_BOOM, false);
    }

    public int getGrowTime() {
        return this.entityData.get(GROW_TIME);
    }

    public void setGrowTime(int time) {
        this.entityData.set(GROW_TIME, time);
    }

    public int getBoomTime() {
        return this.entityData.get(BOOM_TIME);
    }

    public void setBoomTime(int time) {
        this.entityData.set(BOOM_TIME, time);
    }

    public boolean startBoom() {
        return this.entityData.get(START_BOOM);
    }

    public void setStartBoom(boolean isStart) {
        this.entityData.set(START_BOOM, isStart);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("GrowTime", this.getGrowTime());
        pCompound.putInt("BoomTime", this.getBoomTime());
        pCompound.putBoolean("isStart", this.startBoom());
        //this.addPersistentAngerSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setGrowTime(pCompound.getInt("GrowTime"));
        this.setBoomTime(pCompound.getInt("BoomTime"));
        this.setStartBoom(pCompound.getBoolean("isStart"));
        //this.readPersistentAngerSaveData(this.level(), pCompound);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getGrowTime() >= 1000 && !this.startBoom()) {
            double triggerRadius = 1.0D;
            for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(triggerRadius))) {
                if (entity instanceof Mob mob && mob != this.getOwner() && !(mob instanceof EntityPlantBase)) {
                    this.setStartBoom(true);
                    break;
                }
            }
        }

        if (this.getGrowTime() < 1000) {
            this.setGrowTime(this.getGrowTime() + 1);
        }

        if (this.startBoom()) {
            this.setBoomTime(this.getBoomTime() + 1);
        }

        if (this.getBoomTime() == 15) {
            explodeAndDamage();
            this.remove(RemovalReason.DISCARDED);
        }
    }

    private void explodeAndDamage() {
        if (this.level().isClientSide) return;

        double radius = 3.0D;
        float maxDamage = 90.0F;

        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(radius))) {
            if (entity instanceof Mob mob && mob != this.getOwner() && !(mob instanceof EntityPlantBase)) {
                double distance = this.distanceTo(mob);
                if (distance <= radius) {
                    float damage = (float) (maxDamage * (1.0D - distance / radius));
                    damage = Math.max(damage, 1.0F);
                    mob.hurt(this.damageSources().explosion(this, this), damage);
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
    }

    @Override
    protected void doPush(Entity entity) {
        if (entity instanceof Mob && this.getGrowTime() >= 1000) {
            this.setStartBoom(true);
        }
    }

    @Override
    protected void registerGoals() {
        this.getNavigation().setCanFloat(false);
    }

    @Override
    public boolean isInvulnerable() {
        return super.isInvulnerable() || this.startBoom();
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "mine", 5, state -> state.setAndContinue(this.getBoomTime() > 0 ? BOOM : this.getGrowTime() < 990 ? WAIT : this.getGrowTime() >= 990 && this.getGrowTime() < 1000 ? GROW : WAIT_GROWN)));
    }
}