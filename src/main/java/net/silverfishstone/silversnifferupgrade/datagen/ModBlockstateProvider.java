package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.block.custom.BiomiteCropBlock;
import net.silverfishstone.silversnifferupgrade.block.custom.HorsetailCropBlock;
import net.silverfishstone.silversnifferupgrade.block.custom.StranipCropBlock;
import org.objectweb.asm.tree.ModuleNode;

import java.util.function.Function;

public class ModBlockstateProvider extends BlockStateProvider {
    public ModBlockstateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, SnifferUpgrade.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BOULDERSTONE);
        blockWithItem(ModBlocks.BOULDERSTONE_BRICKS);
        blockWithItem(ModBlocks.CHISELED_BOULDERSTONE_BRICKS);
        blockWithItem(ModBlocks.POWDERSTONE);
        blockWithItem(ModBlocks.POLISHED_POWDERSTONE);
        blockWithItem(ModBlocks.BIOMITE_ORE);
        blockWithItem(ModBlocks.BIOMITE_BLOCK);
        blockWithItem(ModBlocks.ANCIENT_SOIL);
        blockWithItem(ModBlocks.MUDDY_SOIL);

        blockWithItem(ModBlocks.PETRIFIED_PLANKS);
        blockWithItem(ModBlocks.SMOOTH_PETRIFIED_LOG);
        logBlock(((RotatedPillarBlock) ModBlocks.PETRIFIED_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.PETRIFIED_WOOD.get()), blockTexture(ModBlocks.PETRIFIED_LOG.get()),
                blockTexture(ModBlocks.PETRIFIED_LOG.get()));
        makeBiomiteCrop((CropBlock) ModBlocks.BIOMITE_CROP.get(), "biomite_crop_stage", "biomite_crop_stage");
        makeStranipCrop((CropBlock) ModBlocks.STRANIP_CROP.get(), "stranip_crop_stage", "stranip_crop_stage");
        makeHorsetailCrop((CropBlock) ModBlocks.HORSETAIL_CROP.get(), "horsetail_crop_stage_", "horsetail_crop_stage_");



        logBlock(((RotatedPillarBlock) ModBlocks.GINKGO_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.GINKGO_WOOD.get()), blockTexture(ModBlocks.GINKGO_LOG.get()), blockTexture(ModBlocks.GINKGO_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GINKGO_LOG.get()), blockTexture(ModBlocks.STRIPPED_GINKGO_LOG.get()),
                new ResourceLocation(SnifferUpgrade.MODID, "block/stripped_ginkgo_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GINKGO_WOOD.get()), blockTexture(ModBlocks.STRIPPED_GINKGO_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_GINKGO_LOG.get()));
        blockItem(ModBlocks.GINKGO_LOG);
        blockItem(ModBlocks.STRIPPED_GINKGO_LOG);
        blockItem(ModBlocks.GINKGO_WOOD);
        blockItem(ModBlocks.STRIPPED_GINKGO_WOOD);
        blockWithItem(ModBlocks.GINKGO_PLANKS);
        leavesBlock(ModBlocks.GINKGO_LEAVES);
        signBlock(((StandingSignBlock) ModBlocks.GINKGO_SIGN.get()), ((WallSignBlock) ModBlocks.GINKGO_WALL_SIGN.get()),
                blockTexture(ModBlocks.GINKGO_PLANKS.get()));
        hangingSignBlock(ModBlocks.GINKGO_HANGING_SIGN.get(), ModBlocks.GINKGO_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.STRIPPED_GINKGO_LOG.get()));
        stairsBlock(((StairBlock) ModBlocks.GINKGO_STAIRS.get()), blockTexture(ModBlocks.GINKGO_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.GINKGO_SLAB.get()), blockTexture(ModBlocks.GINKGO_PLANKS.get()), blockTexture(ModBlocks.GINKGO_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.GINKGO_BUTTON.get()), blockTexture(ModBlocks.GINKGO_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GINKGO_PRESSURE_PLATE.get()), blockTexture(ModBlocks.GINKGO_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.GINKGO_FENCE.get()), blockTexture(ModBlocks.GINKGO_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GINKGO_FENCE_GATE.get()), blockTexture(ModBlocks.GINKGO_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.GINKGO_DOOR.get()), modLoc("block/ginkgo_door_bottom"), modLoc("block/ginkgo_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.GINKGO_TRAPDOOR.get()), modLoc("block/ginkgo_trapdoor"), true, "cutout");

        logBlock(((RotatedPillarBlock) ModBlocks.SPIKETIP_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.SPIKETIP_WOOD.get()), blockTexture(ModBlocks.SPIKETIP_LOG.get()), blockTexture(ModBlocks.SPIKETIP_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SPIKETIP_LOG.get()), blockTexture(ModBlocks.STRIPPED_SPIKETIP_LOG.get()),
                new ResourceLocation(SnifferUpgrade.MODID, "block/stripped_spiketip_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_SPIKETIP_WOOD.get()), blockTexture(ModBlocks.STRIPPED_SPIKETIP_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_SPIKETIP_LOG.get()));
        blockItem(ModBlocks.SPIKETIP_LOG);
        blockItem(ModBlocks.STRIPPED_SPIKETIP_LOG);
        blockItem(ModBlocks.SPIKETIP_WOOD);
        blockItem(ModBlocks.STRIPPED_SPIKETIP_WOOD);
        blockWithItem(ModBlocks.SPIKETIP_PLANKS);
        leavesBlock(ModBlocks.SPIKETIP_LEAVES);
        signBlock(((StandingSignBlock) ModBlocks.SPIKETIP_SIGN.get()), ((WallSignBlock) ModBlocks.SPIKETIP_WALL_SIGN.get()),
                blockTexture(ModBlocks.SPIKETIP_PLANKS.get()));
        hangingSignBlock(ModBlocks.SPIKETIP_HANGING_SIGN.get(), ModBlocks.SPIKETIP_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.STRIPPED_SPIKETIP_LOG.get()));
        stairsBlock(((StairBlock) ModBlocks.SPIKETIP_STAIRS.get()), blockTexture(ModBlocks.SPIKETIP_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.SPIKETIP_SLAB.get()), blockTexture(ModBlocks.SPIKETIP_PLANKS.get()), blockTexture(ModBlocks.SPIKETIP_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.SPIKETIP_BUTTON.get()), blockTexture(ModBlocks.SPIKETIP_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.SPIKETIP_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SPIKETIP_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.SPIKETIP_FENCE.get()), blockTexture(ModBlocks.SPIKETIP_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.SPIKETIP_FENCE_GATE.get()), blockTexture(ModBlocks.SPIKETIP_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.SPIKETIP_DOOR.get()), modLoc("block/spiketip_door_bottom"), modLoc("block/spiketip_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SPIKETIP_TRAPDOOR.get()), modLoc("block/spiketip_trapdoor"), true, "cutout");

        logBlock(((RotatedPillarBlock) ModBlocks.TREE_FERN_STEM.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.TREE_FERN_WOOD.get()), blockTexture(ModBlocks.TREE_FERN_STEM.get()), blockTexture(ModBlocks.TREE_FERN_STEM.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_TREE_FERN_LOG.get()), blockTexture(ModBlocks.STRIPPED_TREE_FERN_LOG.get()),
                new ResourceLocation(SnifferUpgrade.MODID, "block/stripped_tree_fern_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_TREE_FERN_WOOD.get()), blockTexture(ModBlocks.STRIPPED_TREE_FERN_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_TREE_FERN_LOG.get()));
        blockItem(ModBlocks.TREE_FERN_STEM);
        blockItem(ModBlocks.STRIPPED_TREE_FERN_LOG);
        blockItem(ModBlocks.TREE_FERN_WOOD);
        blockItem(ModBlocks.STRIPPED_TREE_FERN_WOOD);
        blockWithItem(ModBlocks.TREE_FERN_PLANKS);
        leavesBlock(ModBlocks.TREE_FERN_LEAVES);
        signBlock(((StandingSignBlock) ModBlocks.TREE_FERN_SIGN.get()), ((WallSignBlock) ModBlocks.TREE_FERN_WALL_SIGN.get()),
                blockTexture(ModBlocks.TREE_FERN_PLANKS.get()));
        hangingSignBlock(ModBlocks.TREE_FERN_HANGING_SIGN.get(), ModBlocks.TREE_FERN_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.STRIPPED_TREE_FERN_LOG.get()));
        stairsBlock(((StairBlock) ModBlocks.TREE_FERN_STAIRS.get()), blockTexture(ModBlocks.TREE_FERN_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.TREE_FERN_SLAB.get()), blockTexture(ModBlocks.TREE_FERN_PLANKS.get()), blockTexture(ModBlocks.TREE_FERN_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.TREE_FERN_BUTTON.get()), blockTexture(ModBlocks.TREE_FERN_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.TREE_FERN_PRESSURE_PLATE.get()), blockTexture(ModBlocks.TREE_FERN_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.TREE_FERN_FENCE.get()), blockTexture(ModBlocks.TREE_FERN_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.TREE_FERN_FENCE_GATE.get()), blockTexture(ModBlocks.TREE_FERN_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.TREE_FERN_DOOR.get()), modLoc("block/tree_fern_door_bottom"), modLoc("block/tree_fern_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.TREE_FERN_TRAPDOOR.get()), modLoc("block/tree_fern_trapdoor"), true, "cutout");


        logBlock(((RotatedPillarBlock) ModBlocks.GREAT_CANE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.GREAT_CANE_WOOD.get()), blockTexture(ModBlocks.GREAT_CANE_LOG.get()), blockTexture(ModBlocks.GREAT_CANE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GREAT_CANE_LOG.get()), blockTexture(ModBlocks.STRIPPED_GREAT_CANE_LOG.get()),
                new ResourceLocation(SnifferUpgrade.MODID, "block/stripped_great_cane_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_GREAT_CANE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_GREAT_CANE_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_GREAT_CANE_LOG.get()));
        blockItem(ModBlocks.GREAT_CANE_LOG);
        blockItem(ModBlocks.STRIPPED_GREAT_CANE_LOG);
        blockItem(ModBlocks.GREAT_CANE_WOOD);
        blockItem(ModBlocks.STRIPPED_GREAT_CANE_WOOD);
        leavesBlock(ModBlocks.GREAT_CANE_LEAVES);

        stairsBlock(((StairBlock) ModBlocks.BOULDERSTONE_STAIRS.get()), blockTexture(ModBlocks.BOULDERSTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.BOULDERSTONE_SLAB.get()), blockTexture(ModBlocks.BOULDERSTONE.get()), blockTexture(ModBlocks.BOULDERSTONE.get()));
        wallBlock(((WallBlock) ModBlocks.BOULDERSTONE_WALL.get()), blockTexture(ModBlocks.BOULDERSTONE.get()));
        stairsBlock(((StairBlock) ModBlocks.BOULDERSTONE_BRICK_STAIRS.get()), blockTexture(ModBlocks.BOULDERSTONE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.BOULDERSTONE_BRICK_SLAB.get()), blockTexture(ModBlocks.BOULDERSTONE_BRICKS.get()), blockTexture(ModBlocks.BOULDERSTONE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.BOULDERSTONE_BRICK_WALL.get()), blockTexture(ModBlocks.BOULDERSTONE_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocks.POLISHED_POWDERSTONE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_POWDERSTONE.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_POWDERSTONE_SLAB.get()), blockTexture(ModBlocks.POLISHED_POWDERSTONE.get()), blockTexture(ModBlocks.POLISHED_POWDERSTONE.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_POWDERSTONE_WALL.get()), blockTexture(ModBlocks.POLISHED_POWDERSTONE.get()));
        slabBlock(((SlabBlock) Blocks.PETRIFIED_OAK_SLAB), blockTexture(ModBlocks.PETRIFIED_PLANKS.get()), blockTexture(ModBlocks.PETRIFIED_PLANKS.get()));

        saplingBlock(ModBlocks.GINKGO_SAPLING);
        saplingBlock(ModBlocks.TREE_FERN_SAPLING);
        saplingBlock(ModBlocks.SPIKETIP_SAPLING);

        blockWithItem(ModBlocks.POLISHED_CHLORITE_BRICKS);
        blockWithItem(ModBlocks.CHLORITE);
        blockWithItem(ModBlocks.POLISHED_CHLORITE);
        stairsBlock(((StairBlock) ModBlocks.CHLORITE_STAIRS.get()), blockTexture(ModBlocks.CHLORITE.get()));
        slabBlock(((SlabBlock) ModBlocks.CHLORITE_SLAB.get()), blockTexture(ModBlocks.CHLORITE.get()), blockTexture(ModBlocks.CHLORITE.get()));
        wallBlock(((WallBlock) ModBlocks.CHLORITE_WALL.get()), blockTexture(ModBlocks.CHLORITE.get()));
        stairsBlock(((StairBlock) ModBlocks.POLISHED_CHLORITE_BRICK_STAIRS.get()), blockTexture(ModBlocks.POLISHED_CHLORITE_BRICKS.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_CHLORITE_BRICK_SLAB.get()), blockTexture(ModBlocks.POLISHED_CHLORITE_BRICKS.get()), blockTexture(ModBlocks.POLISHED_CHLORITE_BRICKS.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_CHLORITE_BRICK_WALL.get()), blockTexture(ModBlocks.POLISHED_CHLORITE_BRICKS.get()));
        stairsBlock(((StairBlock) ModBlocks.POLISHED_CHLORITE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_CHLORITE.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_CHLORITE_SLAB.get()), blockTexture(ModBlocks.POLISHED_CHLORITE.get()), blockTexture(ModBlocks.POLISHED_CHLORITE.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_CHLORITE_WALL.get()), blockTexture(ModBlocks.POLISHED_CHLORITE.get()));

        blockWithItem(ModBlocks.SNIFFER_WOOL);
        blockWithItem(ModBlocks.PUMICE);
        blockWithItem(ModBlocks.LATITE);
        blockWithItem(ModBlocks.LATITE_BRICKS);
        blockWithItem(ModBlocks.COBBLED_LATITE);

        simpleBlockWithItem(ModBlocks.CRATERWEED.get(), models().cross(blockTexture(ModBlocks.CRATERWEED.get()).getPath(),
                blockTexture(ModBlocks.CRATERWEED.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_CRATERWEED.get(), models().singleTexture("potted_crater_weed", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CRATERWEED.get())).renderType("cutout"));
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private String name(Block block) {
        return key(block).getPath();
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(SnifferUpgrade.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeBiomiteCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> biomiteStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] biomiteStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BiomiteCropBlock) block).getAgeProperty()),
                new ResourceLocation(SnifferUpgrade.MODID, "block/" + textureName + state.getValue(((BiomiteCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeHorsetailCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> horsetailStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] horsetailStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((HorsetailCropBlock) block).getAgeProperty()),
                new ResourceLocation(SnifferUpgrade.MODID, "block/" + textureName + state.getValue(((HorsetailCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeStranipCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> StranipStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] StranipStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StranipCropBlock) block).getAgeProperty()),
                new ResourceLocation(SnifferUpgrade.MODID, "block/" + textureName + state.getValue(((StranipCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
