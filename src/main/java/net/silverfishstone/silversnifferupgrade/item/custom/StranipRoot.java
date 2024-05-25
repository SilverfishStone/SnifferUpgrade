package net.silverfishstone.silversnifferupgrade.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.silverfishstone.silversnifferupgrade.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class StranipRoot extends ItemNameBlockItem {


    public StranipRoot(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        ItemStack stack = ModItems.STRANIP_ROOT.get().getDefaultInstance();
        pTooltip.add(Component.translatable("item.silversnifferupgrade.stranip_root.clean_use").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        super.appendHoverText(stack, pLevel, pTooltip, pFlag);
    }
}
