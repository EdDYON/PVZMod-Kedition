package keletu.pvzmod.entities;

import keletu.pvzmod.init.PVZItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EntityWalnut extends EntityPlantBase implements IProtectPlant {

    private static final EntityDataAccessor<String> DATA_STUCK_ARROW_RECORDS = SynchedEntityData.defineId(EntityWalnut.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<ItemStack> HELMET_ARMOR = SynchedEntityData.defineId(EntityWalnut.class, EntityDataSerializers.ITEM_STACK);
    private static final int MAX_STUCK_ARROW_RECORDS = 12;
    public final AnimationState idleAnimation0 = new AnimationState();
    public final AnimationState idleAnimation1 = new AnimationState();
    public final AnimationState idleAnimation2 = new AnimationState();
    private final double protectRadio;
    private static final int RETARGET_INTERVAL = 10;

    public EntityWalnut(EntityType<? extends EntityPlantBase> type, Level par1World, float protectRadio) {
        super(type, par1World, new ItemStack(PVZItems.WALNUT_CARD.get(), 1));
        this.protectRadio = protectRadio;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_STUCK_ARROW_RECORDS, "");
        this.entityData.define(HELMET_ARMOR, ItemStack.EMPTY);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return EntityPlantBase.createAttributes().add(Attributes.MAX_HEALTH, 10.0D * 16);
    }

    @Override
    protected void registerGoals() {
        this.getNavigation().setCanFloat(false);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        } else {
            trimStuckArrowRecords();
        }

        if (this.level().isClientSide || this.tickCount % RETARGET_INTERVAL != 0) {
            return;
        }

        AABB searchBox = new AABB(
                this.getX() - protectRadio, this.getY(), this.getZ() - protectRadio,
                this.getX() + protectRadio, this.getY() + 1.0D, this.getZ() + protectRadio
        );

        List<Mob> nearbyMobs = this.level().getEntitiesOfClass(Mob.class, searchBox);

        for (Mob mob : nearbyMobs) {
            LivingEntity target = mob.getTarget();
            if (target instanceof EntityPlantBase plant && !(plant instanceof IProtectPlant)) {
                mob.setTarget(this);
            }
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean hurt = super.hurt(source, amount);
        if (hurt && !this.level().isClientSide && source.getDirectEntity() instanceof AbstractArrow arrow) {
            recordStuckArrow(arrow);
        }
        return hurt;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("StuckArrowRecords", this.entityData.get(DATA_STUCK_ARROW_RECORDS));
    }

    @Override
    public void remove(RemovalReason reason) {
        if (reason.shouldDestroy()) {
            if (!this.level().isClientSide) {
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
                if (!itemstack.isEmpty()) {
                    this.spawnAtLocation(itemstack);
                    this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                }
            }
        }
        super.remove(reason);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(DATA_STUCK_ARROW_RECORDS, pCompound.getString("StuckArrowRecords"));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (tryPlaceHelmet(player, hand, heldItem)) {
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        if (tryRemoveHelmet(player, hand, heldItem)) {
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }

        return super.mobInteract(player, hand);
    }

    private boolean tryPlaceHelmet(Player player, InteractionHand hand, ItemStack heldItem) {
        if (heldItem.isEmpty()) {
            return false;
        }

        if (!(heldItem.getItem() instanceof ArmorItem armor) || armor.getType() != ArmorItem.Type.HELMET) {
            return false;
        }

        if (this.hasHelmet()) {
            return false;
        }

        if (!this.level().isClientSide) {
            ItemStack placed = heldItem.copy();
            placed.setCount(1);
            this.setItemSlot(EquipmentSlot.HEAD, placed);

            if (!player.getAbilities().instabuild) {
                heldItem.shrink(1);
            }

            this.level().playSound(null, this.blockPosition(), SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.PLAYERS, 1.0F, 1.0F);
        }

        return true;
    }

    private boolean tryRemoveHelmet(Player player, InteractionHand hand, ItemStack heldItem) {
        if (!heldItem.isEmpty()) {
            return false;
        }

        if (!this.hasHelmet()) {
            return false;
        }

        if (!this.level().isClientSide) {
            ItemStack removed = this.removeHelmetItem();

            if (!player.addItem(removed)) {
                player.drop(removed, false);
            }

            this.level().playSound(null, this.blockPosition(), SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.PLAYERS, 1.0F, 0.8F);
        }

        return true;
    }

    public boolean hasHelmet() {
        return !this.getItemBySlot(EquipmentSlot.HEAD).isEmpty();
    }

    public ItemStack removeHelmetItem() {
        ItemStack stack = this.getItemBySlot(EquipmentSlot.HEAD);
        this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
        return stack;
    }

    @Override
    protected void doPush(Entity entity) {
        if (entity instanceof Mob) {
            entity.push(this);
        }
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    public void setupAnimationStates() {
        if (this.getHealth() > this.getMaxHealth() * 2 / 3) {
            this.idleAnimation1.stop();
            this.idleAnimation2.stop();
            this.idleAnimation0.startIfStopped(this.tickCount);
        } else if (this.getHealth() > this.getMaxHealth() * 1 / 3 && this.getHealth() <= this.getMaxHealth() * 2 / 3) {
            this.idleAnimation0.stop();
            this.idleAnimation2.stop();
            this.idleAnimation1.startIfStopped(this.tickCount);
        } else {
            this.idleAnimation0.stop();
            this.idleAnimation1.stop();
            this.idleAnimation2.startIfStopped(this.tickCount);
        }
    }

    public List<StuckArrowRecord> getStuckArrowRecords() {
        String records = this.entityData.get(DATA_STUCK_ARROW_RECORDS);
        if (records.isEmpty()) {
            return List.of();
        }

        List<StuckArrowRecord> result = new ArrayList<>();
        for (String record : records.split(";")) {
            String[] parts = record.split(",");
            if (parts.length != 6) {
                continue;
            }

            try {
                result.add(new StuckArrowRecord(
                        Float.parseFloat(parts[0]),
                        Float.parseFloat(parts[1]),
                        Float.parseFloat(parts[2]),
                        Float.parseFloat(parts[3]),
                        Float.parseFloat(parts[4]),
                        Float.parseFloat(parts[5])
                ));
            } catch (NumberFormatException ignored) {
            }
        }

        return result;
    }

    protected float getStuckArrowModelHeight() {
        return 20.0F;
    }

    protected float getStuckArrowModelHalfWidth() {
        return 7.0F;
    }

    protected float getStuckArrowModelHalfDepth() {
        return 6.0F;
    }

    private void recordStuckArrow(AbstractArrow arrow) {
        List<StuckArrowRecord> records = new ArrayList<>(getStuckArrowRecords());
        records.add(createStuckArrowRecord(arrow));

        while (records.size() > MAX_STUCK_ARROW_RECORDS) {
            records.remove(0);
        }

        setStuckArrowRecords(records);
    }

    private StuckArrowRecord createStuckArrowRecord(AbstractArrow arrow) {
        Vec3 localHit = worldToLocal(arrow.position().subtract(this.position()));
        Vec3 motion = arrow.getDeltaMovement();
        Vec3 localMotion = motion.lengthSqr() > 1.0E-6D ? worldToLocalDirection(motion.normalize()) : localHit.normalize();

        float x = (float) Mth.clamp(localHit.x / (this.getBbWidth() * 0.5D) * getStuckArrowModelHalfWidth(), -getStuckArrowModelHalfWidth(), getStuckArrowModelHalfWidth());
        float y = (float) Mth.clamp(-(localHit.y / this.getBbHeight()) * getStuckArrowModelHeight(), -getStuckArrowModelHeight(), 0.0D);
        float z = (float) Mth.clamp(localHit.z / (this.getBbWidth() * 0.5D) * getStuckArrowModelHalfDepth(), -getStuckArrowModelHalfDepth(), getStuckArrowModelHalfDepth());

        return new StuckArrowRecord(
                x,
                y,
                z,
                (float) localMotion.x,
                (float) -localMotion.y,
                (float) localMotion.z
        );
    }

    private Vec3 worldToLocal(Vec3 vector) {
        return worldToLocalDirection(vector);
    }

    private Vec3 worldToLocalDirection(Vec3 vector) {
        float yaw = (this.getYRot() - 180.0F) * Mth.DEG_TO_RAD;
        double cos = Mth.cos(yaw);
        double sin = Mth.sin(yaw);
        double x = vector.x * cos - vector.z * sin;
        double z = vector.x * sin + vector.z * cos;
        return new Vec3(x, vector.y, z);
    }

    private void trimStuckArrowRecords() {
        List<StuckArrowRecord> records = new ArrayList<>(getStuckArrowRecords());
        int arrowCount = this.getArrowCount();
        if (records.size() <= arrowCount) {
            return;
        }

        while (records.size() > arrowCount) {
            records.remove(0);
        }

        setStuckArrowRecords(records);
    }

    private void setStuckArrowRecords(List<StuckArrowRecord> records) {
        StringBuilder builder = new StringBuilder();
        for (StuckArrowRecord record : records) {
            if (!builder.isEmpty()) {
                builder.append(';');
            }

            builder.append(format(record.x)).append(',')
                    .append(format(record.y)).append(',')
                    .append(format(record.z)).append(',')
                    .append(format(record.dirX)).append(',')
                    .append(format(record.dirY)).append(',')
                    .append(format(record.dirZ));
        }

        this.entityData.set(DATA_STUCK_ARROW_RECORDS, builder.toString());
    }

    private static String format(float value) {
        return String.format(Locale.ROOT, "%.3f", value);
    }

    public static class StuckArrowRecord {
        public final float x;
        public final float y;
        public final float z;
        public final float dirX;
        public final float dirY;
        public final float dirZ;

        public StuckArrowRecord(float x, float y, float z, float dirX, float dirY, float dirZ) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dirX = dirX;
            this.dirY = dirY;
            this.dirZ = dirZ;
        }
    }
}
