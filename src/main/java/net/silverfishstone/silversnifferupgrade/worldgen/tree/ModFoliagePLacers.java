package net.silverfishstone.silversnifferupgrade.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.GreatCaneFoliagePlacer;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.SpiketipFoliagePlacer;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.TreeFernFoliagePlacer;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.TreeFernTrunkPlacer;

public class ModFoliagePLacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, SnifferUpgrade.MODID);

    public static final RegistryObject<FoliagePlacerType<SpiketipFoliagePlacer>> SPIKETIP_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("spiketip_foliage_placer", () -> new FoliagePlacerType<>(SpiketipFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<TreeFernFoliagePlacer>> TREE_FERN_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("tree_fern_foliage_placer", () -> new FoliagePlacerType<>(TreeFernFoliagePlacer.CODEC));
    public static final RegistryObject<FoliagePlacerType<GreatCaneFoliagePlacer>> GREAT_CANE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("great_cane_foliage_placer", () -> new FoliagePlacerType<>(GreatCaneFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
