package net.silverfishstone.silversnifferupgrade.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import net.silverfishstone.silversnifferupgrade.potions.ModMobEffects;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VialItem extends Item {
    public VialItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        if (!pLevel.isClientSide) {
            pEntityLiving.addEffect(new MobEffectInstance(ModMobEffects.MYSTERY.get(), 600, 3));
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                pStack.shrink(1);
            }
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (pStack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }

            if (player != null) {
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
            }
        }

        pEntityLiving.gameEvent(GameEvent.DRINK);
        return pStack;
    }
    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        ItemStack stack = ModItems.BIOMIC_SLUDGE_VIAL.get().getDefaultInstance();
        pTooltip.add(Component.translatable("item.silversnifferupgrade.biomic_sludge_vial.vial_brew").withStyle(ChatFormatting.BLUE));
        super.appendHoverText(stack, pLevel, pTooltip, pFlag);
    }
}
