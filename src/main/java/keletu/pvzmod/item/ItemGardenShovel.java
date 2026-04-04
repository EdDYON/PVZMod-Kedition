package keletu.pvzmod.item;

import keletu.pvzmod.entities.EntityPlantBase;
import keletu.pvzmod.models.GardenShovelRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class ItemGardenShovel extends ShovelItem implements GeoItem {

    public ItemGardenShovel(Properties properties) {
        super(Tiers.IRON, 3.0F, -2.4F, properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof EntityPlantBase target) {
            if (entity.level().isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                BlockPos pos = BlockPos.containing(entity.position());
                if (target.getOwnerUUID() == null || target.getOwnerUUID().equals(playerIn.getUUID())) {
                    target.remove(Entity.RemovalReason.DISCARDED);
                    playerIn.level().playSound(null, pos, SoundEvents.GRASS_BREAK, SoundSource.PLAYERS);
                    ((ServerLevel) playerIn.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DIRT.defaultBlockState()),
                            pos.getX() + 0.5,
                            pos.getY(),
                            pos.getZ() + 0.5,
                            20,
                            0.25D,
                            0.25D,
                            0.25D,
                            0.15D);

                    if (!playerIn.isCreative())
                        stack.hurtAndBreak(1, playerIn, (p_43122_) -> {
                            p_43122_.broadcastBreakEvent(hand);
                        });
                }
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public void initializeClient(@Nonnull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GardenShovelRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null) {
                    this.renderer = new GardenShovelRenderer();
                }
                return renderer;
            }

            @Override
            public HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
                return HumanoidModel.ArmPose.ITEM;
            }
        });
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
