package net.silverfishstone.silversnifferupgrade.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.silverfishstone.silversnifferupgrade.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class PetrifiedLogrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.PETRIFIED_LOG_KEY;
    }
}
