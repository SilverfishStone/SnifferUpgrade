package net.silverfishstone.silversnifferupgrade;

import com.mojang.datafixers.kinds.Monoid;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.block.entity.ModBlockEntities;
import net.silverfishstone.silversnifferupgrade.enchantments.SnifferEnchantments;
import net.silverfishstone.silversnifferupgrade.entity.ModEntities;
import net.silverfishstone.silversnifferupgrade.entity.client.*;
import net.silverfishstone.silversnifferupgrade.entity.custom.FlamipedeEntity;
import net.silverfishstone.silversnifferupgrade.item.ModCreativeModeTabs;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.loot.ModLootModifiers;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;
import net.silverfishstone.silversnifferupgrade.potions.PotionBrewingClass;
import net.silverfishstone.silversnifferupgrade.potions.SilverPotionsA;
import net.silverfishstone.silversnifferupgrade.sounds.SnifferSounds;
import net.silverfishstone.silversnifferupgrade.util.ModWoodTypes;
import net.silverfishstone.silversnifferupgrade.util.SUGUI;
import net.silverfishstone.silversnifferupgrade.villager.ModVillagers;
import net.silverfishstone.silversnifferupgrade.worldgen.biome.ModTerrablender;
import net.silverfishstone.silversnifferupgrade.worldgen.biome.surface.GinkgoSurfaceRules;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.ModFoliagePLacers;
import net.silverfishstone.silversnifferupgrade.worldgen.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;


//Thanks to Kaupenjoe for comprehensive guides to Forge modding. https://www.youtube.com/@ModdingByKaupenjoe
@Mod(net.silverfishstone.silversnifferupgrade.SnifferUpgrade.MODID)
public class SnifferUpgrade {
    public static final String MODID = "silversnifferupgrade";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Monoid<PotionBrewing.Mix> POTION_MIXES = null;

    public SnifferUpgrade() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModeTabs.register(modEventBus);
        ModMobEffects.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePLacers.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);
        SilverPotionsA.register(modEventBus);
        SnifferEnchantments.register(modEventBus);
        ModEntities.register(modEventBus);
        ModTerrablender.registerBiomes();
        SnifferSounds.register(modEventBus);
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        BrewingRecipeRegistry.addRecipe(new PotionBrewingClass(Potions.AWKWARD, ModItems.BIOMIC_SLUDGE_VIAL.get(), SilverPotionsA.OXYGENATED.get()));
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HORSETAIL.getId(), ModBlocks.POTTED_HORSETAIL);

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, GinkgoSurfaceRules.makeRules());
        });
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BIOMIC_SLUDGE);
            event.accept(ModItems.BIOMITE_GEM);
        }
    }
    private static void addMix(Potion pPotionEntry, Item pPotionIngredient, Potion pPotionResult) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.GINKGO);
            Sheets.addWoodType(ModWoodTypes.TREE_FERN);
            Sheets.addWoodType(ModWoodTypes.SPIKETIP);
            EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
            EntityRenderers.register(ModEntities.CONESHELL.get(), ConeshellRenderer::new);
            EntityRenderers.register(ModEntities.AMPHIBIMUS.get(), AmphibimusRenderer::new);
            EntityRenderers.register(ModEntities.EURYPTERUS.get(), EurypterusRenderer::new);
            EntityRenderers.register(ModEntities.ARMISOR.get(), ArmisorRenderer::new);
            EntityRenderers.register(ModEntities.NAUTILUS.get(), NautilusRenderer::new);
            EntityRenderers.register(ModEntities.GREATERDODO.get(), GreaterDodoRenderer::new);
            EntityRenderers.register(ModEntities.ANCIENTZOMBIE.get(), AncientZombieRenderer::new);
            EntityRenderers.register(ModEntities.FLAMIPEDE.get(), FlamipedeRenderer::new);
            EntityRenderers.register(ModEntities.FLOATING_BLOCK.get(), FloatingBlockRenderer::new);
        }
    }

}
