package com.miningmark48.displaycase.block;

import com.miningmark48.displaycase.block.base.BlockDisplayCaseBase;
import com.miningmark48.displaycase.handler.GuiHandler;
import com.miningmark48.displaycase.reference.Reference;
import com.miningmark48.displaycase.tile.TileEntityPedestal;
import com.miningmark48.displaycase.tile.TileEntityWoodShelf;
import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

@SuppressWarnings("Duplicates")
public class BlockPedestal extends BlockDisplayCaseBase {

    private static AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.109375D, 0.0D, 0.109375D, 0.890625D, 0.90625, 0.890625D);

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockPedestal() {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState state = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        return state;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
        super.addCollisionBoxToList(state, worldIn, pos, entityBox, collidingBoxes, entityIn, p_185477_7_);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPedestal();
    }

    //Custom Tooltip
    @Override
    public void addInformation(ItemStack par1ItemStack, @Nullable World world, List par3List, ITooltipFlag par4) {
        par3List.add(TextFormatting.LIGHT_PURPLE + ModTranslate.toLocal("tooltip.block.pedestal.line1"));
        par3List.add(TextFormatting.YELLOW + ModTranslate.toLocal("gui.display_case.info.all.line1"));
    }

    @SuppressWarnings("Duplicates")
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if (player != null) {
            if (!player.isSneaking()) {
                    player.openGui(Reference.MOD_ID, GuiHandler.gui_id_dc, world, pos.getX(), pos.getY(), pos.getZ());
                return true;
            }
        }
        return false;
    }

}
