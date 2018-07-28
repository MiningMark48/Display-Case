package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;

public class TESRFishingRodHolder extends TESRDisplayCaseBase {

    @SuppressWarnings("Duplicates")
    @Override
    public void doItemRender(int index) {

        GlStateManager.scale(1D, 1D, 1D);
        double yOffset = 0D;

        if (index == 0) {
            double xOffset = 0D;
            double zOffset = 0D;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 1) {
            double xOffset = 0D;
            double zOffset = 0D;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 2) {
            double xOffset = 0D;
            double zOffset = 0D;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        }

        super.doItemRender(index);
    }

    @Override
    public int getSlotAmount() {
        return 3;
    }
}
