package com.miningmark48.displaycase.init;

import com.miningmark48.displaycase.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ModCreativeTab {

    public static final CreativeTabs DisplayCase_Tab = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.GLASS);
        }
    };

}
