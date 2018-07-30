package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.init.ModItems;
import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import com.miningmark48.displaycase.tile.base.TileEntityDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TESRFishingRodHolder extends TESRDisplayCaseBase {

    @SuppressWarnings("Duplicates")
    @Override
    public void doItemRender(int index) {

        GlStateManager.scale(1.75D, 1.75D, 1.75D);

        double xOffset = -0.35D;
        double yOffset = -0.17D;
        double zOffset = 0.2D;

        double yOffsetSpacing = 0.18D;

        if (index == 0) {
            yOffset -= 0;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 1) {
            yOffset -= yOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 2) {
            yOffset -= (yOffsetSpacing * 2);

            GlStateManager.translate(xOffset, yOffset, zOffset);
        }

        GlStateManager.rotate(-45f, 0, 0, 1);

        super.doItemRender(index);
    }

    @Override
    public ItemStack getItemToRender(TileEntityDisplayCaseBase te, int index) {
        if (te.getStackInSlot(index).getItem() != Items.FISHING_ROD) {
            return ItemStack.EMPTY;
        } else {
            return new ItemStack(ModItems.fake_fishing_rod);
        }
    }

    @Override
    public int getSlotAmount() {
        return 3;
    }

}
