package com.miningmark48.displaycase.tile.base;

import com.miningmark48.displaycase.block.base.BlockDisplayCaseBase;
import com.miningmark48.displaycase.tile.TileEntityDisplayCase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public abstract class TESRDisplayCaseBase extends TileEntitySpecialRenderer<TileEntityDisplayCaseBase> {

    private EntityItem entityItem = new EntityItem(Minecraft.getMinecraft().world, 0D, 0D, 0D);

    @Override
    public void func_192841_a(TileEntityDisplayCaseBase te, double x, double y, double z, float partialTicks, int destroyStage, float partial) {
        if (te != null){
            for (int i = 1; i <= getSlotAmount(); i++) {
                int index = i - 1;
                ItemStack stack = getItemToRender(te, index);
                if (!stack.isEmpty()) {
                    stack.setCount(1);
                    entityItem.setItem(stack);
                    entityItem.hoverStart = 0;
                    GlStateManager.pushMatrix();

                    GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.5D);

                    //For rotating the item based on the block's direction it's facing
                    int facingIndex = getDirection(te.getWorld().getBlockState(te.getPos()).getValue(BlockDisplayCaseBase.FACING));
                    GlStateManager.rotate(90f * facingIndex, 0, 1, 0);

                    //For rendering based on if block or item
                    if (!(stack.getItem() instanceof ItemBlock)) {
                        doItemRender(index);
                    } else {
                        doItemBlockRender(index);
                    }
                    Minecraft.getMinecraft().getRenderManager().doRenderEntity(entityItem, 0D, 0D, 0D, 0.0F, 0.0F, false);

                    GlStateManager.popMatrix();

                }
            }

        }
    }

    public ItemStack getItemToRender(TileEntityDisplayCaseBase te, int index) {
        return te.getStackInSlot(index).copy();
    }

    public void doItemRender(int index) {

    }

    public void doItemBlockRender(int index) {

    }

    public int getSlotAmount() {
        return 1;
    }

    private static int getDirection(EnumFacing facing) {

        if (facing.equals(EnumFacing.NORTH)) {
            return 0;
        } else if (facing.equals(EnumFacing.WEST)) {
            return 1;
        } else if (facing.equals(EnumFacing.SOUTH)) {
            return 2;
        } else if (facing.equals(EnumFacing.EAST)) {
            return 3;
        }

        return 0;
    }

}
