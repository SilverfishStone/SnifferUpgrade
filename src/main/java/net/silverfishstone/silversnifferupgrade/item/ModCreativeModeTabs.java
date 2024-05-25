package net.silverfishstone.silversnifferupgrade.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SnifferUpgrade.MODID);

    public static final RegistryObject<CreativeModeTab> SNIFFER_UPGRADE = CREATIVE_MODE_TABS.register("silversnifferupgrade_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BIOMITE_GEM.get()))
                    .title(Component.translatable("creativetab.silversnifferupgrade_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.SNIFFER_EGG);
                        pOutput.accept(ModItems.BIOMITE_GEM.get());
                        pOutput.accept(ModItems.GREATER_DODO_SPAWN_EGG.get());
                        pOutput.accept(ModItems.ANCIENT_ZOMBIE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.NAUTILUS_SPAWN_EGG.get());
                        pOutput.accept(ModItems.AMPHIBIMUS_SPAWN_EGG.get());
                        pOutput.accept(ModItems.ARMISOR_SPAWN_EGG.get());
                        pOutput.accept(ModItems.CONESHELL_SPAWN_EGG.get());
                        pOutput.accept(ModItems.EURYPTERUS_SPAWN_EGG.get());
                        pOutput.accept(ModItems.FLAMIPEDE_SPAWN_EGG.get());
                        pOutput.accept(ModItems.CONESHELL_BUCKET.get());
                        pOutput.accept(ModItems.NAUTILUS_BUCKET.get());
                        pOutput.accept(ModItems.CONESHELL_BUCKET.get());
                        pOutput.accept(ModItems.BIOMITE_FRUIT.get());
                        pOutput.accept(ModItems.BIOMIC_SLUDGE.get());
                        pOutput.accept(ModItems.BIOMIC_CAPSULE.get());
                        pOutput.accept(ModItems.HORSETAIL_SPORES.get());
                        pOutput.accept(ModItems.BIOMIC_SLUDGE_VIAL.get());
                        pOutput.accept(ModItems.BIOMITE_CRYSTAL.get());
                        pOutput.accept(ModItems.DODO_FEATHER.get());
                        pOutput.accept(ModItems.MAGIGIANS_BOOK.get());


                        pOutput.accept(ModItems.BIOMIC_PICKAXE.get());
                        pOutput.accept(ModItems.BIOMIC_AXE.get());
                        pOutput.accept(ModItems.BIOMIC_SHOVEL.get());
                        pOutput.accept(ModItems.BIOMIC_SWORD.get());
                        pOutput.accept(ModItems.BIOMIC_HOE.get());

                        pOutput.accept(ModItems.RAW_DODO_MEAT.get());
                        pOutput.accept(ModItems.ROASTED_DODO_MEAT.get());
                        pOutput.accept(ModItems.ANCIENT_APPLE.get());
                        pOutput.accept(ModItems.ROTTEN_APPLE.get());

                        pOutput.accept(ModBlocks.GRASSY_BOULDERSTONE.get());
                        pOutput.accept(ModBlocks.MUDDY_SOIL.get());
                        pOutput.accept(ModBlocks.MOSSY_SOIL.get());
                        pOutput.accept(ModBlocks.BOULDERSTONE.get());
                        pOutput.accept(ModBlocks.POWDERSTONE.get());
                        pOutput.accept(ModBlocks.POLISHED_POWDERSTONE.get());
                        pOutput.accept(ModBlocks.BOULDERSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.CHISELED_BOULDERSTONE_BRICKS.get());
                        pOutput.accept(ModBlocks.PETRIFIED_LOG.get());
                        pOutput.accept(ModBlocks.PETRIFIED_WOOD.get());
                        pOutput.accept(ModBlocks.SMOOTH_PETRIFIED_LOG.get());

                        pOutput.accept(ModBlocks.BOULDERSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.BOULDERSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.BOULDERSTONE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.BOULDERSTONE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.BOULDERSTONE_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.BOULDERSTONE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_POWDERSTONE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_POWDERSTONE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_POWDERSTONE_STAIRS.get());
                        pOutput.accept(ModBlocks.CHLORITE.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE_BRICKS.get());
                        pOutput.accept(ModBlocks.CHLORITE_STAIRS.get());
                        pOutput.accept(ModBlocks.CHLORITE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE_BRICK_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE_BRICK_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE_BRICK_WALL.get());
                        pOutput.accept(ModBlocks.CHLORITE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE_WALL.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_CHLORITE_STAIRS.get());

                        pOutput.accept(ModBlocks.BIOMITE_ORE.get());
                        pOutput.accept(ModBlocks.BIOMITE_BLOCK.get());

                        pOutput.accept(ModBlocks.GREATER_DODO_EGG.get());
                        pOutput.accept(ModBlocks.HORSETAIL.get());
                        pOutput.accept(ModBlocks.INCUBATION_BENCH.get());
                        pOutput.accept(ModBlocks.ANCIENT_SOIL.get());
                        pOutput.accept(ModBlocks.ANCIENT_GRASS_BLOCK.get());

                        pOutput.accept(ModBlocks.GREAT_CANE_WOOD.get());
                        pOutput.accept(ModBlocks.GREAT_CANE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_GREAT_CANE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_GREAT_CANE_LOG.get());
                        pOutput.accept(ModBlocks.GREAT_CANE_LEAVES.get());
                        pOutput.accept(ModBlocks.GINKGO_WOOD.get());
                        pOutput.accept(ModBlocks.GINKGO_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_GINKGO_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_GINKGO_WOOD.get());
                        pOutput.accept(ModBlocks.GINKGO_PLANKS.get());
                        pOutput.accept(ModBlocks.GINKGO_LEAVES.get());
                        pOutput.accept(ModBlocks.GINKGO_STAIRS.get());
                        pOutput.accept(ModBlocks.GINKGO_SLAB.get());
                        pOutput.accept(ModBlocks.GINKGO_DOOR.get());
                        pOutput.accept(ModBlocks.GINKGO_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.GINKGO_FENCE.get());
                        pOutput.accept(ModBlocks.GINKGO_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.GINKGO_BUTTON.get());
                        pOutput.accept(ModBlocks.GINKGO_PRESSURE_PLATE.get());
                        pOutput.accept(ModItems.GINKGO_SIGN.get());
                        pOutput.accept(ModItems.GINKGO_HANGING_SIGN.get());
                        pOutput.accept(ModItems.GINKGO_CHEST_BOAT.get());
                        pOutput.accept(ModItems.GINKGO_BOAT.get());
                        pOutput.accept(ModBlocks.GINKGO_SAPLING.get());

                        pOutput.accept(ModBlocks.SPIKETIP_WOOD.get());
                        pOutput.accept(ModBlocks.SPIKETIP_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_SPIKETIP_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_SPIKETIP_WOOD.get());
                        pOutput.accept(ModBlocks.SPIKETIP_STAIRS.get());
                        pOutput.accept(ModBlocks.SPIKETIP_SLAB.get());
                        pOutput.accept(ModBlocks.SPIKETIP_LEAVES.get());
                        pOutput.accept(ModBlocks.SPIKETIP_PLANKS.get());
                        pOutput.accept(ModBlocks.SPIKETIP_DOOR.get());
                        pOutput.accept(ModBlocks.SPIKETIP_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.SPIKETIP_FENCE.get());
                        pOutput.accept(ModBlocks.SPIKETIP_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.SPIKETIP_BUTTON.get());
                        pOutput.accept(ModBlocks.SPIKETIP_PRESSURE_PLATE.get());
                        pOutput.accept(ModItems.SPIKETIP_SIGN.get());
                        pOutput.accept(ModItems.SPIKETIP_HANGING_SIGN.get());
                        pOutput.accept(ModItems.SPIKETIP_CHEST_BOAT.get());
                        pOutput.accept(ModItems.SPIKETIP_BOAT.get());
                        pOutput.accept(ModBlocks.SPIKETIP_SAPLING.get());

                        pOutput.accept(ModBlocks.TREE_FERN_WOOD.get());
                        pOutput.accept(ModBlocks.TREE_FERN_STEM.get());
                        pOutput.accept(ModBlocks.STRIPPED_TREE_FERN_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_TREE_FERN_WOOD.get());
                        pOutput.accept(ModBlocks.TREE_FERN_STAIRS.get());
                        pOutput.accept(ModBlocks.TREE_FERN_SLAB.get());
                        pOutput.accept(ModBlocks.TREE_FERN_LEAVES.get());
                        pOutput.accept(ModBlocks.TREE_FERN_PLANKS.get());
                        pOutput.accept(ModBlocks.TREE_FERN_DOOR.get());
                        pOutput.accept(ModBlocks.TREE_FERN_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.TREE_FERN_FENCE.get());
                        pOutput.accept(ModBlocks.TREE_FERN_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.TREE_FERN_BUTTON.get());
                        pOutput.accept(ModBlocks.TREE_FERN_PRESSURE_PLATE.get());
                        pOutput.accept(ModItems.TREE_FERN_SIGN.get());
                        pOutput.accept(ModItems.TREE_FERN_HANGING_SIGN.get());
                        pOutput.accept(ModItems.TREE_FERN_CHEST_BOAT.get());
                        pOutput.accept(ModItems.TREE_FERN_BOAT.get());
                        pOutput.accept(ModBlocks.TREE_FERN_SAPLING.get());

                        pOutput.accept(ModBlocks.SNIFFER_PEDESTAL.get());
                        pOutput.accept(ModItems.TROPICAL_CRAB_CLAW.get());
                        pOutput.accept(ModItems.ROASTED_TROPICAL_CRAB_CLAW.get());
                        pOutput.accept(ModItems.BROKEN_TRIDENT.get());
                        pOutput.accept(ModBlocks.CASTLE_SPIKES.get());
                        pOutput.accept(ModBlocks.BONE_SLAB.get());
                        pOutput.accept(ModItems.ARTHROPOD_ARMOR.get());
                        pOutput.accept(ModItems.CHITIN_LEGGINGS.get());
                        pOutput.accept(ModItems.CHITIN_HELMET.get());
                        pOutput.accept(ModItems.CHITIN_CHESTPLATE.get());
                        pOutput.accept(ModItems.CHITIN_BOOTS.get());
                        pOutput.accept(ModItems.SNIFFER_FUR.get());
                        pOutput.accept(ModItems.STRANIP.get());
                        pOutput.accept(ModItems.STRANIP_LEAVES.get());
                        pOutput.accept(ModItems.STRANIP_ROOT.get());
                        pOutput.accept(ModItems.BORSCH.get());
                        pOutput.accept(ModItems.SNIFFER_BAG.get());
                        pOutput.accept(ModItems.CHITIN_SEGMENT.get());

                        pOutput.accept(ModBlocks.ACACIA_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.BAMBOO_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.BIRCH_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.CHERRY_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.CRIMSON_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.DARK_OAK_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.GINKGO_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.JUNGLE_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.MANGROVE_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.OAK_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.SPIKETIP_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.SPRUCE_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.TREE_FERN_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.WARPED_PILLAR_LIGHT.get());
                        pOutput.accept(ModBlocks.SNIFFER_CARPET.get());
                        pOutput.accept(ModBlocks.SNIFFER_WOOL.get());
                        pOutput.accept(ModBlocks.STRANIP_FLOWER.get());
                        pOutput.accept(ModBlocks.ANCIENT_FARMLAND.get());
                        pOutput.accept(ModBlocks.ANCIENT_FARMLAND.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
