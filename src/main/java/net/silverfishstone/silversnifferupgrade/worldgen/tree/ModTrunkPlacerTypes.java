package net.silverfishstone.silversnifferupgrade.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.PetrifiedLogPlacer;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.PetrifiedTrunkPlacer;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.custom.TreeFernTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, SnifferUpgrade.MODID);

    public static final RegistryObject<TrunkPlacerType<TreeFernTrunkPlacer>> TREE_FERN_TRUNK_PLACER =
            TRUNK_PLACER.register("tree_fern_trunk_placer", () -> new TrunkPlacerType<>(TreeFernTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<PetrifiedTrunkPlacer>> PETRIFIED_TREE_TRUNK_PLACER =
            TRUNK_PLACER.register("petrified_tree_trunk_placer", () -> new TrunkPlacerType<>(PetrifiedTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<PetrifiedLogPlacer>> PETRIFIED_LOG_PLACER =
            TRUNK_PLACER.register("petrified_log_placer", () -> new TrunkPlacerType<>(PetrifiedLogPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
