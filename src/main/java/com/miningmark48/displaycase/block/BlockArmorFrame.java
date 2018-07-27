package com.miningmark48.displaycase.block;

import com.miningmark48.displaycase.block.base.BlockDisplayCaseBase;
import com.miningmark48.displaycase.handler.GuiHandler;
import com.miningmark48.displaycase.reference.Reference;
import com.miningmark48.displaycase.tile.TileEntityArmorFrame;
import com.miningmark48.displaycase.tile.TileEntityDisplayCase;
import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemDye;
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

public class BlockArmorFrame extends BlockDisplayCaseBase {

    private static AxisAlignedBB BOUNDING_BOX_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.890625D, 1D, 1D, 1D);
    private static AxisAlignedBB BOUNDING_BOX_EAST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.109375D, 1D, 1D);
    private static AxisAlignedBB BOUNDING_BOX_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1D, 1D, 0.109375D);
    private static AxisAlignedBB BOUNDING_BOX_WEST = new AxisAlignedBB(0.890625D, 0.0D, 0.0D, 1D, 1D, 1D);

    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    public static final PropertyInteger COLOR = PropertyInteger.create("color", 0, 15);

    public BlockArmorFrame() {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(COLOR, 0));
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        int color = ((TileEntityArmorFrame) worldIn.getTileEntity(pos)).getColor();
        state = state.withProperty(COLOR, color);

        return state;
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState state = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        state = state.withProperty(COLOR, 0);
        return state;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING, COLOR);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return BOUNDING_BOX_NORTH;
            case EAST:
                return BOUNDING_BOX_EAST;
            case SOUTH:
                return BOUNDING_BOX_SOUTH;
            case WEST:
                return BOUNDING_BOX_WEST;
        }
        return BOUNDING_BOX_NORTH;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        switch (state.getValue(FACING)) {
            case NORTH:
                super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX_NORTH);
                break;
            case EAST:
                super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX_EAST);
                break;
            case SOUTH:
                super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX_SOUTH);
                break;
            case WEST:
                super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX_WEST);
                break;
        }
        super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, entityIn, p_185477_7_);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityArmorFrame();
    }

    //Custom Tooltip
    @Override
    public void addInformation(ItemStack par1ItemStack, @Nullable World world, List par3List, ITooltipFlag par4) {
        par3List.add(TextFormatting.AQUA + ModTranslate.toLocal("tooltip.block.armor_frame.line1"));
    }

    @SuppressWarnings("Duplicates")
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (player != null) {
            if (!player.isSneaking()) {

                ItemStack heldItem = player.getHeldItem(hand);
                TileEntity te = world.getTileEntity(pos);
                if (te instanceof TileEntityArmorFrame) {
                    TileEntityArmorFrame teAF = (TileEntityArmorFrame) te;
                    if (!heldItem.isEmpty()) {
                        if (heldItem.getItem() instanceof ItemDye) {
                            teAF.setColor(heldItem.getItemDamage());
                            heldItem.shrink(1);
                            teAF.markDirty();
                        }
                    } else {
                        player.openGui(Reference.MOD_ID, GuiHandler.gui_id_dc_single_slot_armor, world, pos.getX(), pos.getY(), pos.getZ());
                    }
                }

                return true;
            }
            return false;
        }
        return false;
    }

}
