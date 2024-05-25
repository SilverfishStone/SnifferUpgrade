package net.silverfishstone.silversnifferupgrade.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.StructureTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.silverfishstone.silversnifferupgrade.SnifferUpgrade;
import net.silverfishstone.silversnifferupgrade.block.ModBlocks;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.villager.ModVillagers;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(modid = SnifferUpgrade.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.CREATURE_CARETAKER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.SNIFFER_EGG, 5),
                    new ItemStack(Items.EMERALD, 1),
                    10, 3, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.RAW_DODO_MEAT.get(), 12),
                    new ItemStack(Items.EMERALD, 1),
                    10, 5, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.FEATHER, 27),
                    new ItemStack(Items.EMERALD, 1),
                    10, 5, 0.02f));


            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ModBlocks.GREATER_DODO_EGG.get(), 1),
                    5, 9, 0.035f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(Items.TORCHFLOWER, 1),
                    5, 4, 0.035f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(Items.PITCHER_PLANT, 1),
                    5, 3, 0.035f));


            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.SLIME_BALL, 9),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.OAK_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.ACACIA_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.BAMBOO_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.BIRCH_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.CHERRY_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.DARK_OAK_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.JUNGLE_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.MANGROVE_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.SPRUCE_FENCE, 15),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 13),
                    new ItemStack(Items.LEAD, 2),
                    5, 8, 0.035f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 13),
                    new ItemStack(Items.MAP, 2),
                    5, 8, 0.035f));


            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.SCUTE, 10),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.TURTLE_HELMET, 1),
                    new ItemStack(Items.EMERALD, 1),
                    5, 8, 0.035f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 27),
                    new ItemStack(Items.IRON_HORSE_ARMOR, 1),
                    5, 7, 0.035f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 31),
                    new ItemStack(Items.DIAMOND_HORSE_ARMOR, 1),
                    5, 7, 0.035f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 24),
                    new ItemStack(Items.GOLDEN_HORSE_ARMOR, 1),
                    5, 7, 0.035f));


            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 27),
                    new ItemStack(Blocks.TURTLE_EGG, 2),
                    5, 7, 0.035f));
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 22),
                    new ItemStack(Items.NAME_TAG, 1),
                    5, 7, 0.035f));
        }
    }

    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        growback(event, event.getEntity());
    }

    private static void growback(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("silversnifferupgrade:sniffer")))) {
            entity.getPersistentData().putDouble("sheartimeout", (entity.getPersistentData().getDouble("sheartimeout") - 1));
        }
    }

    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        dropFur(event, event.getLevel(), event.getTarget(), event.getEntity());
    }

    private static void dropFur(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity.getPersistentData().getDouble("sheartimeout") < 21) {
            if ((sourceentity instanceof LivingEntity lEntity ? lEntity.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS) {
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("silversnifferupgrade:sniffer")))) {
                    if (world instanceof ServerLevel pLevel) {
                        ItemEntity entityToSpawn = new ItemEntity(pLevel, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(ModItems.SNIFFER_FUR.get()));
                        entityToSpawn.setPickUpDelay(5);
                        pLevel.addFreshEntity(entityToSpawn);
                    }
                    if (world instanceof Level pLevel) {
                        if (!pLevel.isClientSide()) {
                            pLevel.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), SoundEvents.SHEEP_SHEAR, SoundSource.NEUTRAL, 1, 1);
                        } else {
                            pLevel.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), SoundEvents.SHEEP_SHEAR, SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                    entity.getPersistentData().putDouble("sheartimeout", 100);
                    if (!checkGamemode(entity)) {
                        ItemStack stack = (sourceentity instanceof LivingEntity lEnt ? lEnt.getMainHandItem() : ItemStack.EMPTY);
                        if (stack.hurt(1, RandomSource.create(), null)) {
                            stack.shrink(1);
                            stack.setDamageValue(0);
                        }
                    }
                }
            }
        } else {
            entity.getPersistentData().putDouble("sheartimeout", (entity.getPersistentData().getDouble("sheartimeout") - 1));
        }
    }

    public static boolean checkGamemode(Entity player) {
        if (player instanceof ServerPlayer serverPlayer) {
            return serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
        } else if (player.level().isClientSide() && player instanceof Player thisplayer) {
            return Minecraft.getInstance().getConnection().getPlayerInfo(thisplayer.getGameProfile().getId()) != null
                    && Minecraft.getInstance().getConnection().getPlayerInfo(thisplayer.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
        }
        return player.isInvulnerable();
    }

    @SubscribeEvent
    public static void toCleanStranip(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        cleanStranip(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    private static void cleanStranip(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.STRANIP_ROOT.get()) {
            if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER_CAULDRON) {
                (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                if (entity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(ModItems.STRANIP.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }
            }
        }
    }

    @SubscribeEvent
    public static void pumisize(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        makePumice(event, event.getLevel(), event.getPos(), event.getEntity());
    }

    private static void makePumice(@Nullable Event event, LevelAccessor world, BlockPos pos, Entity entity) {
        ItemStack stack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem().getDefaultInstance();
        if (entity == null)
            return;
        if (stack.getItem() == Items.POTION && PotionUtils.getPotion(stack) == Potions.WATER) {
            if (world.getBlockState(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ())).is(Blocks.MAGMA_BLOCK)) {
                stack.setCount(-1);
                if (entity instanceof Player _player) {
                    ItemStack thisstack = new ItemStack(Items.GLASS_BOTTLE).copy();
                    thisstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, thisstack);
                }
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ());
                    BlockState _bs = ModBlocks.PUMICE.get().defaultBlockState();
                    BlockState _bso = world.getBlockState(_bp);
                    for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                        Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                        if (_property != null && _bs.getValue(_property) != null)
                            try {
                                _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                            } catch (Exception e) {
                            }
                    }
                    world.setBlock(_bp, _bs, 3);
            }
        }
    }
}
