package net.silverfishstone.silversnifferupgrade.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SnifferUpgrade.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> LookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        generator.addProvider(event.includeClient(), new ModBlockstateProvider(packOutput,SnifferUpgrade.MODID, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput,SnifferUpgrade.MODID, existingFileHelper));

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput, LookupProvider,  SnifferUpgrade.MODID, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, LookupProvider, blockTagGenerator.contentsGetter(),  SnifferUpgrade.MODID, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModPoiTypeTagsProvider(packOutput, LookupProvider, SnifferUpgrade.MODID, existingFileHelper));

        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, LookupProvider, Collections.singleton(SnifferUpgrade.MODID)));
    }
}
