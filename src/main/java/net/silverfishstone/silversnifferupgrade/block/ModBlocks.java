package net.silverfishstone.silversnifferupgrade.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.custom.*;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;
import net.silverfishstone.silversnifferupgrade.util.ModWoodTypes;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.GinkgoTreeGrower;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.SpiketipTreeGrower;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.TreeFernTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SnifferUpgrade.MODID);

    public static final RegistryObject<Block> BOULDERSTONE = registerBlock("boulderstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> BOULDERSTONE_BRICKS = registerBlock("boulderstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> CHISELED_BOULDERSTONE_BRICKS = registerBlock("chiseled_boulderstone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));
    public static final RegistryObject<Block> BOULDERSTONE_STAIRS = registerBlock("boulderstone_stairs",
            () -> new StairBlock(() -> ModBlocks.BOULDERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS)));
    public static final RegistryObject<Block> BOULDERSTONE_SLAB = registerBlock("boulderstone_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB)));
    public static final RegistryObject<Block> BOULDERSTONE_WALL = registerBlock("boulderstone_wall",
            () -> new WallBlock( BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));
    public static final RegistryObject<Block> BOULDERSTONE_BRICK_STAIRS = registerBlock("boulderstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.BOULDERSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> BOULDERSTONE_BRICK_SLAB = registerBlock("boulderstone_brick_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> BOULDERSTONE_BRICK_WALL = registerBlock("boulderstone_brick_wall",
            () -> new WallBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
    public static final RegistryObject<Block> POLISHED_POWDERSTONE_STAIRS = registerBlock("polished_powderstone_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_POWDERSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> POLISHED_POWDERSTONE_SLAB = registerBlock("polished_powderstone_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> POLISHED_POWDERSTONE_WALL = registerBlock("polished_powderstone_wall",
            () -> new WallBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> POWDERSTONE = registerBlock("powderstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
    public static final RegistryObject<Block> POLISHED_POWDERSTONE = registerBlock("polished_powderstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE)));
    public static final RegistryObject<Block> PETRIFIED_LOG = registerBlock("petrified_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)));
    public static final RegistryObject<Block> PETRIFIED_WOOD = registerBlock("petrified_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)));
    public static final RegistryObject<Block> SMOOTH_PETRIFIED_LOG = registerBlock("smooth_petrified_log",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BASALT)));
    public static final RegistryObject<Block> PETRIFIED_PLANKS = registerBlock("petrified_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> BIOMITE_ORE = registerBlock("biomite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> BIOMITE_BLOCK = registerBlock("biomite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> GREATER_DODO_EGG = registerBlock("greater_dodo_egg",
            () -> new GreaterDodoEgg(BlockBehaviour.Properties.copy(Blocks.SNIFFER_EGG)));

    public static final RegistryObject<Block> ANCIENT_GRASS_BLOCK = registerBlock("ancient_grass_block",
            () -> new AncientGrassBlockBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)) {
                @Override
                public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
                    super.randomTick(pState, pLevel, pPos, pRandom);
                }
            });
    public static final RegistryObject<Block> MOSSY_SOIL = registerBlock("mossy_soil",
            () -> new MossySoilBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)) {
                @Override
                public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
                    super.randomTick(pState, pLevel, pPos, pRandom);
                }
            });
    public static final RegistryObject<Block> GRASSY_BOULDERSTONE = registerBlock("grassy_boulderstone",
            () -> new GrassyBoulderstoneBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)) {
                @Override
                public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
                    super.randomTick(pState, pLevel, pPos, pRandom);
                }
            });

    public static final RegistryObject<Block> ANCIENT_SOIL = registerBlock("ancient_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> MUDDY_SOIL = registerBlock("muddy_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    public static final RegistryObject<Block> BIOMITE_CROP = BLOCKS.register("biomite_crop",
            () -> new BiomiteCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> HORSETAIL_CROP = BLOCKS.register("horsetail_crop",
            () -> new HorsetailCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> HORSETAIL = registerBlock("horsetail",
            () -> new FlowerBlock(ModMobEffects.MYSTERY, 5, BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_HORSETAIL = registerBlock("potted_horsetail",
            () -> new FlowerPotBlock( () -> ((FlowerPotBlock)Blocks.FLOWER_POT), ModBlocks.HORSETAIL, BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH).noOcclusion()));
    public static final RegistryObject<Block> CRATERWEED = registerBlock("crater_weed",
            () -> new DeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_CRATERWEED = registerBlock("potted_crater_weed",
            () -> new FlowerPotBlock( () -> ((FlowerPotBlock)Blocks.FLOWER_POT), ModBlocks.CRATERWEED, BlockBehaviour.Properties.copy(Blocks.POTTED_DEAD_BUSH).noOcclusion()));

    public static final RegistryObject<Block> INCUBATION_BENCH = registerBlock("incubation_bench",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)));

    public static final RegistryObject<Block> GINKGO_SAPLING = registerBlock("ginkgo_sapling",
            () -> new SaplingBlock( new GinkgoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));
    public static final RegistryObject<Block> GINKGO_LOG = registerBlock("ginkgo_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> GINKGO_WOOD = registerBlock("ginkgo_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_GINKGO_WOOD = registerBlock("stripped_ginkgo_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_GINKGO_LOG = registerBlock("stripped_ginkgo_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final RegistryObject<Block> GINKGO_PLANKS = registerBlock("ginkgo_planks",
            () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> GINKGO_LEAVES = registerBlock("ginkgo_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)));
    public static final RegistryObject<Block> GINKGO_SIGN = BLOCKS.register("ginkgo_sign",
            () -> new GinkgoStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.GINKGO));
    public static final RegistryObject<Block> GINKGO_WALL_SIGN = BLOCKS.register("ginkgo_wall_sign",
            () -> new GinkgoWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.GINKGO));
    public static final RegistryObject<Block> GINKGO_HANGING_SIGN = BLOCKS.register("ginkgo_hanging_sign",
            () -> new GinkgoHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.GINKGO));
    public static final RegistryObject<Block> GINKGO_WALL_HANGING_SIGN = BLOCKS.register("ginkgo_wall_hanging_sign",
            () -> new GinkgoWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.GINKGO));
    public static final RegistryObject<Block> GINKGO_STAIRS = registerBlock("ginkgo_stairs",
            () -> new StairBlock(() -> ModBlocks.GINKGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<Block> GINKGO_SLAB = registerBlock("ginkgo_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)));
    public static final RegistryObject<Block> GINKGO_BUTTON = registerBlock("ginkgo_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_BUTTON),
                    BlockSetType.SPRUCE, 10, true));
    public static final RegistryObject<Block> GINKGO_PRESSURE_PLATE = registerBlock("ginkgo_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(Blocks.SPRUCE_PRESSURE_PLATE),
                    BlockSetType.SPRUCE));
    public static final RegistryObject<Block> GINKGO_FENCE = registerBlock("ginkgo_fence",
            () -> new FenceBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)));
    public static final RegistryObject<Block> GINKGO_FENCE_GATE = registerBlock("ginkgo_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> GINKGO_DOOR = registerBlock("ginkgo_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_DOOR), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> GINKGO_TRAPDOOR = registerBlock("ginkgo_trapdoor",
            () -> new TrapDoorBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR), BlockSetType.SPRUCE));


    public static final RegistryObject<Block> TREE_FERN_SAPLING = registerBlock("tree_fern_sapling",
            () -> new SaplingBlock( new TreeFernTreeGrower(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));
    public static final RegistryObject<Block> TREE_FERN_STEM = registerBlock("tree_fern_stem",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> TREE_FERN_WOOD = registerBlock("tree_fern_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TREE_FERN_WOOD = registerBlock("stripped_tree_fern_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_TREE_FERN_LOG = registerBlock("stripped_tree_fern_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final RegistryObject<Block> TREE_FERN_PLANKS = registerBlock("tree_fern_planks",
            () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> TREE_FERN_LEAVES = registerBlock("tree_fern_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)));
    public static final RegistryObject<Block> TREE_FERN_SIGN = BLOCKS.register("tree_fern_sign",
            () -> new TreeFernStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.TREE_FERN));
    public static final RegistryObject<Block> TREE_FERN_WALL_SIGN = BLOCKS.register("tree_fern_wall_sign",
            () -> new TreeFernWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.TREE_FERN));
    public static final RegistryObject<Block> TREE_FERN_HANGING_SIGN = BLOCKS.register("tree_fern_hanging_sign",
            () -> new TreeFernHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.TREE_FERN));
    public static final RegistryObject<Block> TREE_FERN_WALL_HANGING_SIGN = BLOCKS.register("tree_fern_wall_hanging_sign",
            () -> new TreeFernWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.TREE_FERN));
    public static final RegistryObject<Block> TREE_FERN_STAIRS = registerBlock("tree_fern_stairs",
            () -> new StairBlock(() -> ModBlocks.GINKGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<Block> TREE_FERN_SLAB = registerBlock("tree_fern_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)));
    public static final RegistryObject<Block> TREE_FERN_BUTTON = registerBlock("tree_fern_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_BUTTON),
                    BlockSetType.SPRUCE, 10, true));
    public static final RegistryObject<Block> TREE_FERN_PRESSURE_PLATE = registerBlock("tree_fern_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(Blocks.SPRUCE_PRESSURE_PLATE),
                    BlockSetType.SPRUCE));
    public static final RegistryObject<Block> TREE_FERN_FENCE = registerBlock("tree_fern_fence",
            () -> new FenceBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)));
    public static final RegistryObject<Block> TREE_FERN_FENCE_GATE = registerBlock("tree_fern_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> TREE_FERN_DOOR = registerBlock("tree_fern_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_DOOR), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> TREE_FERN_TRAPDOOR = registerBlock("tree_fern_trapdoor",
            () -> new TrapDoorBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR), BlockSetType.SPRUCE));


    public static final RegistryObject<Block> SPIKETIP_SAPLING = registerBlock("spiketip_sapling",
            () -> new SaplingBlock( new SpiketipTreeGrower(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));
    public static final RegistryObject<Block> SPIKETIP_LOG = registerBlock("spiketip_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> SPIKETIP_WOOD = registerBlock("spiketip_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_SPIKETIP_WOOD = registerBlock("stripped_spiketip_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_SPIKETIP_LOG = registerBlock("stripped_spiketip_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final RegistryObject<Block> SPIKETIP_PLANKS = registerBlock("spiketip_planks",
            () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> SPIKETIP_LEAVES = registerBlock("spiketip_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)));
    public static final RegistryObject<Block> SPIKETIP_SIGN = BLOCKS.register("spiketip_sign",
            () -> new SpiketipStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.SPIKETIP));
    public static final RegistryObject<Block> SPIKETIP_WALL_SIGN = BLOCKS.register("spiketip_wall_sign",
            () -> new SpiketipWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.SPIKETIP));
    public static final RegistryObject<Block> SPIKETIP_HANGING_SIGN = BLOCKS.register("spiketip_hanging_sign",
            () -> new SpiketipHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.SPIKETIP));
    public static final RegistryObject<Block> SPIKETIP_WALL_HANGING_SIGN = BLOCKS.register("spiketip_wall_hanging_sign",
            () -> new SpiketipWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.SPIKETIP));
    public static final RegistryObject<Block> SPIKETIP_STAIRS = registerBlock("spiketip_stairs",
            () -> new StairBlock(() -> ModBlocks.GINKGO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<Block> SPIKETIP_SLAB = registerBlock("spiketip_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)));
    public static final RegistryObject<Block> SPIKETIP_BUTTON = registerBlock("spiketip_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_BUTTON),
                    BlockSetType.SPRUCE, 10, true));
    public static final RegistryObject<Block> SPIKETIP_PRESSURE_PLATE = registerBlock("spiketip_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(Blocks.SPRUCE_PRESSURE_PLATE),
                    BlockSetType.SPRUCE));
    public static final RegistryObject<Block> SPIKETIP_FENCE = registerBlock("spiketip_fence",
            () -> new FenceBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)));
    public static final RegistryObject<Block> SPIKETIP_FENCE_GATE = registerBlock("spiketip_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> SPIKETIP_DOOR = registerBlock("spiketip_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_DOOR), BlockSetType.SPRUCE));
    public static final RegistryObject<Block> SPIKETIP_TRAPDOOR = registerBlock("spiketip_trapdoor",
            () -> new TrapDoorBlock( BlockBehaviour.Properties.copy(Blocks.SPRUCE_TRAPDOOR), BlockSetType.SPRUCE));

    public static final RegistryObject<Block> SNIFFER_PEDESTAL = registerBlock("sniffer_pedestal",
            () -> new SnifferPedestalBlock(BlockBehaviour.Properties.copy(Blocks.BEDROCK).sound(SoundType.ANVIL).noOcclusion().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CASTLE_SPIKES = registerBlock("castle_spikes",
            () -> new CastleSpikes(BlockBehaviour.Properties.copy(Blocks.SCAFFOLDING).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CHLORITE = registerBlock("chlorite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final RegistryObject<Block> POLISHED_CHLORITE = registerBlock("polished_chlorite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_GRANITE)));
    public static final RegistryObject<Block> POLISHED_CHLORITE_BRICKS = registerBlock("polished_chlorite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> CHLORITE_STAIRS = registerBlock("chlorite_stairs",
            () -> new StairBlock(() -> ModBlocks.CHLORITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.GRANITE_STAIRS)));
    public static final RegistryObject<Block> CHLORITE_SLAB = registerBlock("chlorite_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.GRANITE_SLAB)));
    public static final RegistryObject<Block> CHLORITE_WALL = registerBlock("chlorite_wall",
            () -> new WallBlock( BlockBehaviour.Properties.copy(Blocks.GRANITE_WALL)));
    public static final RegistryObject<Block> POLISHED_CHLORITE_BRICK_STAIRS = registerBlock("polished_chlorite_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_CHLORITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> POLISHED_CHLORITE_BRICK_SLAB = registerBlock("polished_chlorite_brick_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> POLISHED_CHLORITE_BRICK_WALL = registerBlock("polished_chlorite_brick_wall",
            () -> new WallBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
    public static final RegistryObject<Block> POLISHED_CHLORITE_STAIRS = registerBlock("polished_chlorite_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_CHLORITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> POLISHED_CHLORITE_SLAB = registerBlock("polished_chlorite_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> POLISHED_CHLORITE_WALL = registerBlock("polished_chlorite_wall",
            () -> new WallBlock( BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> BONE_SLAB = registerBlock("bone_slab",
            () -> new SlabBlock( BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK)));
    public static final RegistryObject<Block> BAMBOO_PILLAR_LIGHT = registerBlock("bamboo_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.BAMBOO).noOcclusion().lightLevel((p_187431_) -> {
        return 14;
            })));
    public static final RegistryObject<Block> ACACIA_PILLAR_LIGHT = registerBlock("acacia_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> BIRCH_PILLAR_LIGHT = registerBlock("birch_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> CHERRY_PILLAR_LIGHT = registerBlock("cherry_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.CHERRY_WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> CRIMSON_PILLAR_LIGHT = registerBlock("crimson_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.NETHER_WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> DARK_OAK_PILLAR_LIGHT = registerBlock("dark_oak_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> GINKGO_PILLAR_LIGHT = registerBlock("ginkgo_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> JUNGLE_PILLAR_LIGHT = registerBlock("jungle_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> MANGROVE_PILLAR_LIGHT = registerBlock("mangrove_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> OAK_PILLAR_LIGHT = registerBlock("oak_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> SPIKETIP_PILLAR_LIGHT = registerBlock("spiketip_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> SPRUCE_PILLAR_LIGHT = registerBlock("spruce_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> TREE_FERN_PILLAR_LIGHT = registerBlock("tree_fern_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));
    public static final RegistryObject<Block> WARPED_PILLAR_LIGHT = registerBlock("warped_pillar_light",
            () -> new PillarLight(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.NETHER_WOOD).noOcclusion().lightLevel((p_187431_) -> {
                return 14;
            })));

    public static final RegistryObject<Block> SNIFFER_CARPET = registerBlock("sniffer_carpet",
            () -> new PaintedCarpetBlock(BlockBehaviour.Properties.copy(Blocks.RED_CARPET)));
    public static final RegistryObject<Block> SNIFFER_WOOL = registerBlock("sniffer_wool",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));

    public static final RegistryObject<Block> STRANIP_CROP = BLOCKS.register("stranip_crop",
            () -> new StranipCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> STRANIP_FLOWER = registerBlock("stranip_flower",
            () -> new FlowerBlock(ModMobEffects.DIRTY, 5, BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_STRANIP_FLOWER = registerBlock("potted_stranip_flower",
            () -> new FlowerPotBlock( () -> ((FlowerPotBlock)Blocks.FLOWER_POT), ModBlocks.STRANIP_FLOWER, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> ANCIENT_FARMLAND = registerBlock("ancient_farmland",
            () -> new AncientFarmBlock(BlockBehaviour.Properties.copy(Blocks.FARMLAND)));

    public static final RegistryObject<Block> GREAT_CANE_LOG = registerBlock("great_cane_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_BLOCK)));
    public static final RegistryObject<Block> GREAT_CANE_WOOD = registerBlock("great_cane_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_BLOCK)));
    public static final RegistryObject<Block> STRIPPED_GREAT_CANE_WOOD = registerBlock("stripped_great_cane_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BAMBOO_BLOCK)));
    public static final RegistryObject<Block> STRIPPED_GREAT_CANE_LOG = registerBlock("stripped_great_cane_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BAMBOO_BLOCK)));
    public static final RegistryObject<Block> GREAT_CANE_LEAVES = registerBlock("great_cane_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_LEAVES)));

    public static final RegistryObject<Block> PUMICE = registerBlock("pumice",
            () -> new FloatingBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).sound(SoundType.GILDED_BLACKSTONE)));
    public static final RegistryObject<Block> LATITE = registerBlock("latite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> COBBLED_LATITE = registerBlock("cobbled_latite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> LATITE_BRICKS = registerBlock("latite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BASALT)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
