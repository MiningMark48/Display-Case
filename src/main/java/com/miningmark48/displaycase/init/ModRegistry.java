package com.miningmark48.displaycase.init;

import com.miningmark48.mininglib.base.item.ModItemBlock;
import com.miningmark48.displaycase.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.LinkedList;
import java.util.List;

public class ModRegistry {

    private static List<Item> itemsToRegister = new LinkedList<>();
    private static List<Block> blocksToRegister = new LinkedList<>();

    public static void init(){
        registerItems();
        registerBlocks();
    }

    private static void registerItems(){
        //Fake Items
        registerItem(ModItems.fake_fishing_rod);
    }

    private static void registerBlocks(){
        registerBlock(ModBlocks.display_case);
        registerBlock(ModBlocks.armor_frame);
        registerBlock(ModBlocks.tool_rack);
        registerBlock(ModBlocks.fishing_rod_holder);
    }

    public static void registerRenderItems(){
        //Fake Items
        registerItemRender(ModItems.fake_fishing_rod);
    }

    public static void registerRenderBlocks(){
        registerBlockRender(ModBlocks.display_case);
        registerBlockRender(ModBlocks.armor_frame);
        registerBlockRender(ModBlocks.tool_rack);
        registerBlockRender(ModBlocks.fishing_rod_holder);
    }

    //Registry
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> event){
        itemsToRegister.forEach(event.getRegistry()::register);
    }

    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> event){
        blocksToRegister.forEach(event.getRegistry()::register);
    }

    private static void registerBlock(Block block){
        blocksToRegister.add(block);
        registerItem(new ModItemBlock(block));
    }

    private static void registerItem(Item item){
        itemsToRegister.add(item);
    }

    private static void registerBlockRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void registerItemRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void registerItemRender(Item item, int meta, String name){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
    }

}
