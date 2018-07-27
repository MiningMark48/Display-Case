package com.miningmark48.displaycase.proxy;

import com.miningmark48.displaycase.init.ModRegistry;
import com.miningmark48.displaycase.init.ModTileEntities;
import com.miningmark48.displaycase.tile.TileEntityDisplayCase;
import com.miningmark48.displaycase.tile.renderer.TESRDisplayCase;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event){

    }

    @Override
    public void registerRenders(){
        ModRegistry.registerRenderItems();
        ModRegistry.registerRenderBlocks();
        ModTileEntities.bindTileRenders();
    }

}
