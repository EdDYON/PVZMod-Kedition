package keletu.pvzmod.init;

import keletu.pvzmod.PVZMod;
import keletu.pvzmod.item.ItemPlantCard;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PVZItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PVZMod.MODID);
    public static final RegistryObject<Item> PEA = ITEMS.register("pea", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.25F)
                    .fast()
                    .build())
            .stacksTo(64)));
    public static final RegistryObject<Item> ICE_PEA = ITEMS.register("ice_pea", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.25F)
                    .fast()
                    .effect(() -> new MobEffectInstance(PVZEffects.SNOW.get(), 100, 0), 1.0F)
                    .build())
            .stacksTo(64)));

    public static final RegistryObject<Item> PRIMAL_PEA = ITEMS.register("primal_pea", () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(1.0F)
                    .fast()
                    .build())
            .stacksTo(16)));

    public static final RegistryObject<Item> SMALL_STONE = ITEMS.register("small_stone", () -> new Item(new Item.Properties()
            .stacksTo(64)));

    public static final RegistryObject<Item> PEASHOOTER_CARD = ITEMS.register("peashooter_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.PEA_SHOOTER));
    public static final RegistryObject<Item> SNOWPEA_CARD = ITEMS.register("snowpea_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.SNOW_PEA));
    public static final RegistryObject<Item> REPEATER_CARD = ITEMS.register("repeater_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.REPEATER));
    public static final RegistryObject<Item> GATLING_PEA_CARD = ITEMS.register("gatling_pea_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.GATLING_PEA));
    public static final RegistryObject<Item> PRIMAL_PEASHOOTER_CARD = ITEMS.register("primal_peashooter_card",
            () -> new ItemPlantCard(new Item.Properties(), PVZEntities.PRIMAL_PEASHOOTER));
}
