package net.silverfishstone.silversnifferupgrade.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.ModFoliagePLacers;

public class TreeFernFoliagePlacer extends FoliagePlacer {
    public static final Codec<TreeFernFoliagePlacer> CODEC = RecordCodecBuilder.create(treeFernFoliagePlacerInstance ->
            foliagePlacerParts(treeFernFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height)).apply(treeFernFoliagePlacerInstance, TreeFernFoliagePlacer::new));

    private final int height;

    public TreeFernFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePLacers.TREE_FERN_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        int min = 0;
        int max = 1;
        int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
        int min2 = 0;
        int max2 = 1;
        int j = (int)Math.floor(Math.random() * (max2 - min2 + 1) + min2);
        int min3 = 0;
        int max3 = 1;
        int k = (int)Math.floor(Math.random() * (max3 - min3 + 1) + min3);
        int min4 = 0;
        int max4 = 1;
        int l = (int)Math.floor(Math.random() * (max4 - min4 + 1) + min4);
        int min5 = 0;
        int max5 = 1;
        int m = (int)Math.floor(Math.random() * (max5 - min5 + 1) + min5);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0), 1, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0).east(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0).west(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0).south(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0).north(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(1), 2, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2), 1, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).north(1).east(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).south(1).east(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).north(2).east(1), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).south(2).east(1), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).north(1).west(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).south(1).west(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).north(2).west(1), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).south(2).west(1), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).north(3), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).south(3), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).east(3), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).west(3), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3).north(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3).south(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3).east(2), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3).west(2), 0, 0, pAttachment.doubleTrunk());

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3), 1, 0, pAttachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
