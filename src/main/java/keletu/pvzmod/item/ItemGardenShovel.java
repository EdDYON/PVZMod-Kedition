package keletu.pvzmod.item;

import keletu.pvzmod.entities.EntityPlantBase;
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

public class ItemGardenShovel extends ShovelItem {

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
                if ((target.getOwner() != null && target.getOwner() == playerIn) || target.getOwner() == null) {
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
}
