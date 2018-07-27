package com.miningmark48.displaycase.block;

import com.miningmark48.displaycase.block.base.BlockDisplayCaseBase;
import com.miningmark48.displaycase.handler.GuiHandler;
import com.miningmark48.displaycase.reference.Reference;
import com.miningmark48.displaycase.tile.TileEntityDisplayCase;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockDisplayCase extends BlockDisplayCaseBase {

    private static AxisAlignedBB BOUNDING_BOX_NORTH = new AxisAlignedBB(0.125D, 0.0D, 0.0D, 0.875D, 0.28125D, 1.0D);
    private static AxisAlignedBB BOUNDING_BOX_EAST = new AxisAlignedBB(0.0D, 0.0D, 0.125D, 1.0D, 0.28125D, 0.875D);

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockDisplayCase() {
        super();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(FACING).equals(EnumFacing.NORTH) || state.getValue(FACING).equals(EnumFacing.SOUTH)) {
            return BOUNDING_BOX_NORTH;
        } else {
            return BOUNDING_BOX_EAST;
        }
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        if (state.getValue(FACING).equals(EnumFacing.NORTH) || state.getValue(FACING).equals(EnumFacing.SOUTH)) {
            super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX_NORTH);
        } else {
            super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX_EAST);
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityDisplayCase();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (player != null) {
            if (!player.isSneaking()) {
                player.openGui(Reference.MOD_ID, GuiHandler.gui_id_dc_single_slot, world, pos.getX(), pos.getY(), pos.getZ());
                return true;
            }
            return false;
        }
        return false;
    }

    //Custom Tooltip
    @Override
    public void addInformation(ItemStack par1ItemStack, @Nullable World world, List par3List, ITooltipFlag par4) {
        par3List.add(TextFormatting.AQUA + "Boop");
    }

}
