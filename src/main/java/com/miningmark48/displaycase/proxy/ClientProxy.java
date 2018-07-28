package com.miningmark48.displaycase.proxy;

import com.miningmark48.displaycase.init.ModBlocks;
import com.miningmark48.displaycase.init.ModRegistry;
import com.miningmark48.displaycase.init.ModTileEntities;
import com.miningmark48.displaycase.reference.Reference;
import com.miningmark48.displaycase.tile.TileEntityDisplayCase;
import com.miningmark48.displaycase.tile.renderer.TESRDisplayCase;
import com.miningmark48.mininglib.utility.ModLogger;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);
    }

    @Override
    public void init(FMLInitializationEvent event){
        registerOBJRenders();
    }

    @Override
    public void registerRenders(){
        ModRegistry.registerRenderItems();
        ModRegistry.registerRenderBlocks();
        ModTileEntities.bindTileRenders();
    }

    private void registerOBJRenders() {
        ModLogger.info("MODEL LOADER " + Reference.MOD_ID + ":" + ModBlocks.fishing_rod_holder.getUnlocalizedName().substring(5));
        ModLogger.info(new ModelResourceLocation(Reference.MOD_ID + ":" + ModBlocks.fishing_rod_holder.getUnlocalizedName().substring(5), "inventory").toString());
        Item item = ItemBlock.getItemFromBlock(ModBlocks.fishing_rod_holder);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ModBlocks.fishing_rod_holder.getUnlocalizedName().substring(5), "inventory"));
    }

}
