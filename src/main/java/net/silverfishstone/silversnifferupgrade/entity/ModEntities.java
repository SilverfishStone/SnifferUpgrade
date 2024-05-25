package net.silverfishstone.silversnifferupgrade.entity;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.silversnifferupgrade.entity.custom.AncientZombieEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.entity.custom.*;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.entity.custom.GreaterDodoEntity;

@Mod.EventBusSubscriber(modid = SnifferUpgrade.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SnifferUpgrade.MODID);

    public static final RegistryObject<EntityType<GreaterDodoEntity>> GREATERDODO = ENTITY_TYPES.register("greater_dodo", () -> EntityType.Builder.of(GreaterDodoEntity::new, MobCategory.CREATURE).sized(0.55f, 0.9f).build("greater_dodo"));
    public static final RegistryObject<EntityType<AncientZombieEntity>> ANCIENTZOMBIE = ENTITY_TYPES.register("ancient_zombie", () -> EntityType.Builder.of(AncientZombieEntity::new, MobCategory.MONSTER).sized(0.9f, 2f).build("ancient_zombie"));
    public static final RegistryObject<EntityType<NautilusEntity>> NAUTILUS = ENTITY_TYPES.register("nautilus", () -> EntityType.Builder.of(NautilusEntity::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f).build("nautilus"));
    public static final RegistryObject<EntityType<AmphibimusEntity>> AMPHIBIMUS = ENTITY_TYPES.register("amphibimus", () -> EntityType.Builder.of(AmphibimusEntity::new, MobCategory.MONSTER).sized(0.6f, 0.6f).build("amphibimus"));
    public static final RegistryObject<EntityType<ConeshellEntity>> CONESHELL = ENTITY_TYPES.register("coneshell", () -> EntityType.Builder.of(ConeshellEntity::new, MobCategory.WATER_CREATURE).sized(1f, 0.2f).build("coneshell"));
    public static final RegistryObject<EntityType<ArmisorEntity>> ARMISOR = ENTITY_TYPES.register("armisor", () -> EntityType.Builder.of(ArmisorEntity::new, MobCategory.WATER_CREATURE).sized(4f, 1.5f).build("armisor"));
    public static final RegistryObject<EntityType<EurypterusEntity>> EURYPTERUS = ENTITY_TYPES.register("eurypterus", () -> EntityType.Builder.of(EurypterusEntity::new, MobCategory.WATER_CREATURE).sized(4f, 0.5f).build("eurypterus"));
    public static final RegistryObject<EntityType<FlamipedeEntity>> FLAMIPEDE = ENTITY_TYPES.register("flamipede", () -> EntityType.Builder.of(FlamipedeEntity::new, MobCategory.MONSTER).sized(3f, 1f).build("flamipede"));
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT = ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT = ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_chest_boat"));
    public static final RegistryObject<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = ENTITY_TYPES.register("floating_block", () -> EntityType.Builder.<FloatingBlockEntity>of(FloatingBlockEntity::new, MobCategory.MISC).sized(0.98F, 0.98F).build("floating_block"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
    //Built from Alex's Mobs Entity Spawning rules because I was an idiot and couldn't figure it out on my own.
    @SubscribeEvent
    public static void initializeAttributes(EntityAttributeCreationEvent event) {
        SpawnPlacements.register(ModEntities.NAUTILUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NautilusEntity::canNautilusSpawn);
        SpawnPlacements.register(ModEntities.CONESHELL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NautilusEntity::canConeshellSpawn);
        SpawnPlacements.register(ModEntities.GREATERDODO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GreaterDodoEntity::checkSpawnRules);
        SpawnPlacements.register(ModEntities.FLAMIPEDE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FlamipedeEntity::checkSpawnRules);
        SpawnPlacements.register(ModEntities.EURYPTERUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NautilusEntity::canEurypterusSpawn);
    }
}
