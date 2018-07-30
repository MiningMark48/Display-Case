package com.miningmark48.displaycase.item;

import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFake extends Item {

    public ItemFake() {
        setMaxDamage(1);
        setMaxDamage(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add(TextFormatting.DARK_RED + ModTranslate.toLocal("tooltip.info.fake_item.line1"));
    }
}
