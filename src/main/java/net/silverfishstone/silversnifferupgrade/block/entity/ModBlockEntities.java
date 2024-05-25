package net.silverfishstone.silversnifferupgrade.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SnifferUpgrade.MODID);



    public static final RegistryObject<BlockEntityType<GinkgoSignBlockEntity>> GINKGO_SIGN =
            BLOCK_ENTITIES.register("ginkgo_sign", () ->
                    BlockEntityType.Builder.of(GinkgoSignBlockEntity::new,
                            ModBlocks.GINKGO_SIGN.get(), ModBlocks.GINKGO_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<GinkgoHangingSignBlockEntity>> GINKGO_HANGING_SIGN =
            BLOCK_ENTITIES.register("ginkgo_hanging_sign", () ->
                    BlockEntityType.Builder.of(GinkgoHangingSignBlockEntity::new,
                            ModBlocks.GINKGO_HANGING_SIGN.get(),ModBlocks.GINKGO_WALL_HANGING_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<SpiketipSignBlockEntity>> SPIKETIP_SIGN =
            BLOCK_ENTITIES.register("spiketip_sign", () ->
                    BlockEntityType.Builder.of(SpiketipSignBlockEntity::new,
                            ModBlocks.SPIKETIP_SIGN.get(), ModBlocks.SPIKETIP_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<SpiketipHangingSignBlockEntity>> SPIKETIP_HANGING_SIGN =
            BLOCK_ENTITIES.register("spiketip_hanging_sign", () ->
                    BlockEntityType.Builder.of(SpiketipHangingSignBlockEntity::new,
                            ModBlocks.SPIKETIP_HANGING_SIGN.get(), ModBlocks.SPIKETIP_WALL_HANGING_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<TreeFernSignBlockEntity>> TREE_FERN_SIGN =
            BLOCK_ENTITIES.register("tree_fern_sign", () ->
                    BlockEntityType.Builder.of(TreeFernSignBlockEntity::new,
                             ModBlocks.TREE_FERN_SIGN.get(), ModBlocks.TREE_FERN_WALL_SIGN.get()).build(null));
    public static final RegistryObject<BlockEntityType<TreeFernHangingSignBlockEntity>> TREE_FERN_HANGING_SIGN =
            BLOCK_ENTITIES.register("tree_fern_hanging_sign", () ->
                    BlockEntityType.Builder.of(TreeFernHangingSignBlockEntity::new,
                            ModBlocks.TREE_FERN_HANGING_SIGN.get(), ModBlocks.TREE_FERN_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
