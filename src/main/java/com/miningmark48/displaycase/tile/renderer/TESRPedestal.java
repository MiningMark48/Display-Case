package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;

public class TESRPedestal extends TESRDisplayCaseBase {

    @SuppressWarnings("Duplicates")
    @Override
    public void doItemRender(int index) {

        GlStateManager.scale(0.5D, 0.5D, 0.5D);

        double xOffset = 0D;
        double yOffset = 0.625D;
        double zOffset = 0D;

        GlStateManager.translate(xOffset, yOffset, zOffset);

        GlStateManager.rotate(180f, 0, 1, 0);

        super.doItemRender(index);
    }

    @Override
    public void doItemBlockRender(int index) {
        GlStateManager.scale(0.65D, 0.65D, 0.65D);

        double xOffset = 0D;
        double yOffset = 0.475D;
        double zOffset = 0D;

        GlStateManager.translate(xOffset, yOffset, zOffset);

        GlStateManager.rotate(45f, 0, 1, 0);

        super.doItemRender(index);
    }

    @Override
    public boolean getDoesRotation() {
        return true;
    }

    @Override
    public boolean getDoesFloat() {
        return true;
    }

    @Override
    public int getSlotAmount() {
        return 1;
    }
}
