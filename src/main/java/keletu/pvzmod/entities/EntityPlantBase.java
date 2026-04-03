package keletu.pvzmod.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.JumpControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public abstract class EntityPlantBase extends AbstractGolem implements OwnableEntity {
    protected static final EntityDataAccessor<Optional<UUID>> DATA_OWNERUUID_ID = SynchedEntityData.defineId(EntityPlantBase.class, EntityDataSerializers.OPTIONAL_UUID);
    private String texture;
    private String livingSound;
    private String hurtSound;
    private String deathSound;
    public int baseHealth;
    public ItemStack spawnStack;
    public float range = 10.0F;

    public EntityPlantBase(EntityType<? extends EntityPlantBase> entityType, Level level) {
        super(entityType, level);
    }

    public EntityPlantBase(EntityType<? extends EntityPlantBase> entityType, Level level, ItemStack spawnStack) {
        this(entityType, level);
        this.spawnStack = spawnStack;
    }

    @Override
    public float maxUpStep() {
        return 0.0F;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_OWNERUUID_ID, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.getOwnerUUID() != null) {
            pCompound.putUUID("Owner", this.getOwnerUUID());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        UUID uuid;
        if (pCompound.hasUUID("Owner")) {
            uuid = pCompound.getUUID("Owner");
        } else {
            String s = pCompound.getString("Owner");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), s);
        }

        if (uuid != null) {
            this.setOwnerUUID(uuid);
        }
    }

    public UUID getOwnerUUID() {
        return this.entityData.get(DATA_OWNERUUID_ID).orElse(null);
    }

    public void setOwnerUUID(@Nullable UUID pUuid) {
        this.entityData.set(DATA_OWNERUUID_ID, Optional.ofNullable(pUuid));
    }

    public boolean isOwnedBy(LivingEntity pEntity) {
        return pEntity == this.getOwner();
    }

    @Override
    public JumpControl getJumpControl() {
        //Cannot Jump.
        return new JumpControlNoJumping(this);
    }

    @Override
    protected void registerGoals() {
        this.getNavigation().setCanFloat(false); // setAvoidsWater
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 24.0F);
    }

    protected void jump() {
    }

    @Override
    protected void playStepSound(net.minecraft.core.BlockPos pos, net.minecraft.world.level.block.state.BlockState state) {
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getTexture() {
        return this.texture;
    }

    @Override
    public MobType getMobType() {
        return /*PvZ.PLANT_TYPE*/ MobType.UNDEFINED;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public void tick() {
        this.zza = 0.0F;
        this.xxa = 0.0F;
        this.setSpeed(0.0F);

        super.tick();
    }

    @Override
    public void knockback(double strength, double x, double z) {
    }

    @Override
    protected void doPush(net.minecraft.world.entity.Entity entity) {
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target) && !this.isOwnedBy(target) && !(target instanceof Creeper) && !(target instanceof Ghast);
    }

    @Override
    public boolean isNoAi() {
        return false;
    }

    public boolean wantsToAttack(LivingEntity pTarget, LivingEntity pOwner) {
        if (!(pTarget instanceof Creeper) && !(pTarget instanceof Ghast)) {
            if (pTarget instanceof EntityPlantBase) {
                return false;
            } else if (pTarget instanceof Player && pOwner instanceof Player && !((Player) pOwner).canHarmPlayer((Player) pTarget)) {
                return false;
            } else if (pTarget instanceof AbstractHorse && ((AbstractHorse) pTarget).isTamed()) {
                return false;
            } else {
                return !(pTarget instanceof TamableAnimal) || !((TamableAnimal) pTarget).isTame();
            }
        } else {
            return false;
        }
    }
}