package com.miningmark48.displaycase.init;

import com.miningmark48.displaycase.block.BlockArmorFrame;
import com.miningmark48.displaycase.block.BlockDisplayCase;
import net.minecraft.block.Block;

public class ModBlocks {

    public static Block display_case;
    public static Block armor_frame;

    public static void init() {
        display_case = new BlockDisplayCase().setUnlocalizedName("display_case").setRegistryName("display_case").setCreativeTab(ModCreativeTab.DisplayCase_Tab);
        armor_frame = new BlockArmorFrame().setUnlocalizedName("armor_frame").setRegistryName("armor_frame").setCreativeTab(ModCreativeTab.DisplayCase_Tab);
    }

}