package com.miningmark48.displaycase.handler;

import com.miningmark48.displaycase.client.GuiDCSingleSlot;
import com.miningmark48.displaycase.client.GuiDCSingleSlotArmor;
import com.miningmark48.displaycase.container.ContainerDCSingleSlot;
import com.miningmark48.displaycase.container.ContainerDCSingleSlotArmor;
import com.miningmark48.displaycase.tile.base.TileEntityDisplayCaseBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static int gui_id_dc_single_slot = 0;
    public static int gui_id_dc_single_slot_armor = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);


        if (ID == gui_id_dc_single_slot){
            return new ContainerDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te);
        } else if (ID == gui_id_dc_single_slot_armor) {
            return new ContainerDCSingleSlotArmor(player.inventory, (TileEntityDisplayCaseBase) te);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (ID == gui_id_dc_single_slot){
            return new GuiDCSingleSlot(player.inventory, (TileEntityDisplayCaseBase) te, player);
        } else if (ID == gui_id_dc_single_slot_armor) {
            return new GuiDCSingleSlotArmor(player.inventory, (TileEntityDisplayCaseBase) te, player);
        }

        return null;
    }

}
