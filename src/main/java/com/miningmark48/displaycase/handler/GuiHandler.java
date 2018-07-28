package com.miningmark48.displaycase.handler;

import com.miningmark48.displaycase.client.GuiDCSingleSlot;
import com.miningmark48.displaycase.container.ContainerDCSingleSlot;
import com.miningmark48.displaycase.container.slot.SlotType;
import com.miningmark48.displaycase.tile.base.TileEntityDisplayCaseBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static int gui_id_dc = 0;
    public static int gui_id_dc_armor = 1;
    public static int gui_id_dc_item = 2;
    public static int gui_id_dc_block = 3;
    public static int gui_id_dc_tool = 4;
    public static int gui_id_dc_weapon = 5;
    public static int gui_id_dc_fishing_rod = 6;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        assert te != null;

        if (ID == gui_id_dc){
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, SlotType.ALL);
        } else if (ID == gui_id_dc_armor) {
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, SlotType.ARMOR);
        } else if (ID == gui_id_dc_item) {
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, SlotType.ITEM);
        } else if (ID == gui_id_dc_block) {
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, SlotType.BLOCK);
        } else if (ID == gui_id_dc_tool) {
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, SlotType.TOOL);
        } else if (ID == gui_id_dc_weapon) {
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, SlotType.WEAPON);
        } else if (ID == gui_id_dc_fishing_rod) {
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, SlotType.FISHING_ROD);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (ID == gui_id_dc){
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player, SlotType.ALL);
        } else if (ID == gui_id_dc_armor) {
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player, SlotType.ARMOR);
        } else if (ID == gui_id_dc_item) {
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player, SlotType.ITEM);
        } else if (ID == gui_id_dc_block) {
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player, SlotType.BLOCK);
        } else if (ID == gui_id_dc_tool) {
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player, SlotType.TOOL);
        } else if (ID == gui_id_dc_weapon) {
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player, SlotType.WEAPON);
        } else if (ID == gui_id_dc_fishing_rod) {
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player, SlotType.FISHING_ROD);
        }

        return null;
    }

}
