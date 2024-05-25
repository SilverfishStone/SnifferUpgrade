package net.silverfishstone.silversnifferupgrade.structure;

import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class MountainCastle extends Structure {
    protected MountainCastle(StructureSettings pSettings) {
        super(pSettings);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext pContext) {
        return Optional.empty();
    }

    @Override
    public StructureType<?> type() {
        return null;
    }
}
