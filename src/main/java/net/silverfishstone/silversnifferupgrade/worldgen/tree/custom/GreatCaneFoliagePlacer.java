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

public class GreatCaneFoliagePlacer extends FoliagePlacer {
    public static final Codec<GreatCaneFoliagePlacer> CODEC = RecordCodecBuilder.create(treeFernFoliagePlacerInstance ->
            foliagePlacerParts(treeFernFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height)).apply(treeFernFoliagePlacerInstance, GreatCaneFoliagePlacer::new));

    private final int height;

    public GreatCaneFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePLacers.GREAT_CANE_FOLIAGE_PLACER.get();
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
        int mint = 0;
        int maxt = 2;
        int two = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int three = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int four = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int five = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int two2 = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int three2 = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int four2 = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int five2 = (int)Math.floor(Math.random() * (maxt - mint + 1) + mint) - 1;
        int minh = 0;
        int maxh = 4;
        int h = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        int h2 = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        int h3 = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        int h4 = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        int h5 = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        int h6 = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        int h7 = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        int h8 = (int)Math.floor(Math.random() * (maxh - minh + 1) + minh);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0).east(two*(-1)).west(three*(-1)).north(four*(-1)).south(five*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(1).east(two*(-three)).west(three*(-two)).north(four*(-three)).south(five*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).east(-two).west(three*two).north(four*(-three)).south(five*three), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2).east(two).west(two*(-four)).north(four*two).south(five*(-three)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-1).east(two2*(-1)).west(three2*(-1)).north(four2*(-1)).south(five2*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-2).east(two2*(-three2)).west(three2*(-two2)).north(four2*(-three2)).south(five2*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-3).east(-two2).west(three2*two2).north(four2*(-three2)).south(five2*three2), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-4).east(two2).west(two2*(-four2)).north(four2*two2).south(five2*(-three2)), 0, -4, pAttachment.doubleTrunk());

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h).east(two*(-1)).west(three*(-1)).north(four*(-1)).south(five*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h2).east(two*(-three)).west(three*(-two)).north(four*(-three)).south(five*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h3).east(-two).west(three*two).north(four*(-three)).south(five*three), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h4).east(two).west(two*(-four)).north(four*two).south(five*(-three)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h5).east(two2*(-1)).west(three2*(-1)).north(four2*(-1)).south(five2*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h6).east(two2*(-three2)).west(three2*(-two2)).north(four2*(-three2)).south(five2*(-1)), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h7).east(-two2).west(three2*two2).north(four2*(-three2)).south(five2*three2), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-h8).east(two2).west(two2*(-four2)).north(four2*two2).south(five2*(-three2)), 0, -4, pAttachment.doubleTrunk());

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(3), 1, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).east(1), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).west(1), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).north(1), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).south(1), 0, -4, pAttachment.doubleTrunk());
        if (i == 1) {
        }else {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).east(1).south(1), 0, -4, pAttachment.doubleTrunk());
        }
        if (j == 1) {
        }else {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).west(1).south(1), 0, -4, pAttachment.doubleTrunk());
        }
        if (k == 1) {
        }else {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).north(1).east(1), 0, -4, pAttachment.doubleTrunk());
        }
        if (l == 1) {
        }else {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(4).south(1).west(1), 0, -4, pAttachment.doubleTrunk());
        }
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(5).east(1), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(5).west(1), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(5).north(1), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(5).south(1), 0, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(5), 0, -4, pAttachment.doubleTrunk());

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(6), 0, -4, pAttachment.doubleTrunk());
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
