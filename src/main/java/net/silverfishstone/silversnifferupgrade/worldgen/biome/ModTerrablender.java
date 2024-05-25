package net.silverfishstone.silversnifferupgrade.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(SnifferUpgrade.MODID, "overworld"), 5));
    }
}
