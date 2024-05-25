package net.silverfishstone.silversnifferupgrade.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.sound.SoundEvent;

import java.util.Objects;


    public class MagiciansBook extends Item{
        public MagiciansBook(Item.Properties pProperties) {
            super(pProperties);
        }

        public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
            int mine = 0;
            int maxe = 34;
            int e = (int)Math.floor(Math.random() * (maxe - mine + 1) + mine);
            int minl5 = 3;
            int maxl5 = 5;
            int l5 = (int)Math.floor(Math.random() * (maxl5 - minl5 + 1) + minl5);
            int minl4 = 3;
            int maxl4 = 4;
            int l4 = (int)Math.floor(Math.random() * (maxl4 - minl4 + 1) + minl4);
            int minl3 = 2;
            int maxl3 = 3;
            int l3 = (int)Math.floor(Math.random() * (maxl3 - minl3 + 1) + minl3);
            int minl2 = 1;
            int maxl2 = 2;
            int l2 = (int)Math.floor(Math.random() * (maxl2 - minl2 + 1) + minl2);
            ItemStack itemstack = pPlayer.getItemInHand(pHand);
            if (pPlayer.experienceLevel >= 2 || pPlayer.isCreative()) {
                itemstack = Items.ENCHANTED_BOOK.getDefaultInstance();
            if (e == 1) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.KNOCKBACK, l3));
            } else if (e == 2) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.AQUA_AFFINITY, l3));
            } else if (e == 3) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.ALL_DAMAGE_PROTECTION, l4));
            } else if (e == 4) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.UNBREAKING, l3));
            } else if (e == 5) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.BANE_OF_ARTHROPODS, l5));
            } else if (e == 6) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.BLAST_PROTECTION, l4));
            } else if (e == 7) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.BLOCK_EFFICIENCY, l5));
            } else if (e == 8) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.BLOCK_FORTUNE, l3));
            } else if (e == 9) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.CHANNELING, 1));
            } else if (e == 10) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.DEPTH_STRIDER, l3));
            } else if (e == 11) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.FALL_PROTECTION, l4));
            } else if (e == 12) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.FIRE_ASPECT, l2));
            }else if (e == 13) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.FIRE_PROTECTION, l4));
            }else if (e == 14) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.FISHING_LUCK, l3));
            }else if (e == 15) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.FISHING_SPEED, l3));
            }else if (e == 16) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.FLAMING_ARROWS, 1));
            }else if (e == 17) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.FROST_WALKER, l2));
            }else if (e == 18) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.IMPALING, l5));
            }else if (e == 19) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.INFINITY_ARROWS, 1));
            }else if (e == 20) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.LOYALTY, l3));
            }else if (e == 21) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.MOB_LOOTING, l3));
            }else if (e == 22) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.MULTISHOT, 1));
            }else if (e == 23) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.PIERCING, l4));
            }else if (e == 24) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.POWER_ARROWS, l5));
            }else if (e == 25) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.PROJECTILE_PROTECTION, l4));
            }else if (e == 26) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.PUNCH_ARROWS, l2));
            }else if (e == 27) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.QUICK_CHARGE, l3));
            }else if (e == 28) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.RESPIRATION, l3));
            }else if (e == 29) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.RIPTIDE, l3));
            }else if (e == 30) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.SHARPNESS, l5));
            }else if (e == 31) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.SILK_TOUCH, 1));
            }else if (e == 32) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.SMITE, l5));
            }else if (e == 33) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.SWEEPING_EDGE, l3));
            }else if (e == 34) {
                EnchantedBookItem.addEnchantment(itemstack, new EnchantmentInstance(Enchantments.THORNS, l3));
            }
            pPlayer.playSound(SoundEvents.ENCHANTMENT_TABLE_USE);
            pPlayer.giveExperienceLevels(-3);
            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            }
            return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
        }
    }