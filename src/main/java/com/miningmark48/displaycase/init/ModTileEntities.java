package com.miningmark48.displaycase.init;

import com.miningmark48.displaycase.tile.*;
import com.miningmark48.displaycase.tile.renderer.*;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityDisplayCase.class, "display_case");
        GameRegistry.registerTileEntity(TileEntityArmorFrame.class, "armor_frame");
        GameRegistry.registerTileEntity(TileEntityToolRack.class, "tool_rack");
    }

    public static void bindTileRenders() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplayCase.class, new TESRDisplayCase());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArmorFrame.class, new TESRArmorFrame());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityToolRack.class, new TESRToolRack());
    }

}
