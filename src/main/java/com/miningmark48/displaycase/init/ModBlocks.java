package com.miningmark48.displaycase.init;

import com.miningmark48.displaycase.block.*;
import net.minecraft.block.Block;

public class ModBlocks {

    public static Block display_case;
    public static Block armor_frame;
    public static Block tool_rack;
    public static Block fishing_rod_holder;
    public static Block wood_shelf;

    public static void init() {
        display_case = new BlockDisplayCase().setUnlocalizedName("display_case").setRegistryName("display_case").setCreativeTab(ModCreativeTab.DisplayCase_Tab);
        armor_frame = new BlockArmorFrame().setUnlocalizedName("armor_frame").setRegistryName("armor_frame").setCreativeTab(ModCreativeTab.DisplayCase_Tab);
        tool_rack = new BlockToolRack().setUnlocalizedName("tool_rack").setRegistryName("tool_rack").setCreativeTab(ModCreativeTab.DisplayCase_Tab);
        fishing_rod_holder = new BlockFishingRodHolder().setUnlocalizedName("fishing_rod_holder").setRegistryName("fishing_rod_holder").setCreativeTab(ModCreativeTab.DisplayCase_Tab);
        wood_shelf = new BlockWoodShelf().setUnlocalizedName("wood_shelf").setRegistryName("wood_shelf").setCreativeTab(ModCreativeTab.DisplayCase_Tab);
    }

}
