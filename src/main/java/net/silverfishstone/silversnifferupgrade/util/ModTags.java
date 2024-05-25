package net.silverfishstone.silversnifferupgrade.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Biomes {

        public static final TagKey<Biome> ANCIENT = tag("ancient");

        private static TagKey<Biome> tag(String name) {
            return ModTags.create(String.valueOf(new ResourceLocation(SnifferUpgrade.MODID, name)));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> GREATER_DODO_EGG_HATCH_BOOST = tag("greater_dodo_egg_hatch_boost");
        public static final TagKey<Block> BOULDERSTONE_ORE_REPLACEABLES = tag("boulderstone_ore_replaceables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SnifferUpgrade.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> GINKGO_LOGS = tag("ginkgo_logs");
        public static final TagKey<Item> SPIKETIP_LOGS = tag("spiketip_logs");
        public static final TagKey<Item> TREE_FERN_LOGS = tag("tree_fern_logs");
        public static final TagKey<Item> FEATHERS = tag("feathers");
        public static final TagKey<Item> GREAT_CANE_LOGS = tag("great_can_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SnifferUpgrade.MODID, name));
        }
    }
    public static TagKey<Biome> create(String pName) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(pName));
    }
}
