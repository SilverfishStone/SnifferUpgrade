package net.silverfishstone.silversnifferupgrade.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.util.ModTags;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_BIOMITE_ORE = registerKey("add_biomite_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_BIOMITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Biomes.ANCIENT),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ANCIENT_FIELDS_BIOMITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(SnifferUpgrade.MODID, name));
    }
}
