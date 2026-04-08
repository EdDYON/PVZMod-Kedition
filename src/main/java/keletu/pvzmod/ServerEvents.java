package keletu.pvzmod;

import keletu.pvzmod.entities.EntityPlantBase;
import keletu.pvzmod.entities.EntityTallnut;
import keletu.pvzmod.init.PVZSounds;
import keletu.pvzmod.item.ItemGardenShovel;
import keletu.pvzmod.item.ItemPlantCard;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PVZMod.MODID)
public class ServerEvents {
    private static final String ADDED_PLANT_TARGET_GOAL = "pvz_kedit.added_plant_target_goal";

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        if (!(entity instanceof Monster monster)) {
            return;
        }

        if (monster.getMobType() != MobType.UNDEAD) {
            return;
        }

        CompoundTag persistentData = monster.getPersistentData();
        if (persistentData.getBoolean(ADDED_PLANT_TARGET_GOAL)) {
            return;
        }
        persistentData.putBoolean(ADDED_PLANT_TARGET_GOAL, true);

        monster.targetSelector.addGoal(
                2,
                new NearestAttackableTargetGoal<>(
                        monster,
                        EntityPlantBase.class,
                        true
                )
        );
    }


    @SubscribeEvent
    public static void onPlantKnockBack(LivingKnockBackEvent event) {
        if (event.getEntity() instanceof EntityPlantBase) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onChangeHeldItem(LivingEquipmentChangeEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }

        if (event.getSlot() != EquipmentSlot.MAINHAND) {
            return;
        }

        ItemStack to = event.getTo();

        if (to.getItem() instanceof ItemPlantCard) {
            player.level().playSound(null, player.blockPosition(), PVZSounds.CARD_SELECT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        } else if (to.getItem() instanceof ItemGardenShovel) {
            player.level().playSound(null, player.blockPosition(), PVZSounds.SHOVEL_SELECT.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }

    @SubscribeEvent
    public static void livingHurtEvent(LivingDamageEvent event) {
        if (event.getEntity() instanceof EntityTallnut tallnut && event.getAmount() > tallnut.getMaxHealth() * 1 / 2) {
            event.setAmount(tallnut.getMaxHealth() * 1 / 2);
        }
    }
}
