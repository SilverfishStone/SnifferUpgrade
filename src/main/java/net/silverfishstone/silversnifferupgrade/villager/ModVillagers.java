package net.silverfishstone.silversnifferupgrade.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SnifferUpgrade.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SnifferUpgrade.MODID);

    public static final RegistryObject<PoiType> INCUBATOR_POI = POI_TYPES.register("incubation_bench_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.INCUBATION_BENCH.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> CREATURE_CARETAKER =
            VILLAGER_PROFESSIONS.register("creature_caretaker", () -> new VillagerProfession("creature_caretaker",
                    holder -> holder.get() == INCUBATOR_POI.get(), holder -> holder.get() == INCUBATOR_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
