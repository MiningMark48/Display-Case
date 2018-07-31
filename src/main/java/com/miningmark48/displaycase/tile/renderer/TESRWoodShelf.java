package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;

public class TESRWoodShelf extends TESRDisplayCaseBase {

    @SuppressWarnings("Duplicates")
    @Override
    public void doItemRender(int index) {

        GlStateManager.scale(0.5D, 0.5D, 0.5D);

        double xOffset = 0D;
        double yOffset = -0.2D;
        double zOffset = 0.75D;

        double xOffsetSpacing = 0.5D;

        if (index == 0) {
            xOffset += xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
            GlStateManager.rotate(30f, 0, 1, 0);
        } else if (index == 1) {
            xOffset -= 0;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 2) {
            xOffset -= xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
            GlStateManager.rotate(-30f, 0, 1, 0);
        }

        GlStateManager.rotate(180f, 0, 1, 0);

        super.doItemRender(index);
    }

    @Override
    public void doItemBlockRender(int index) {
        GlStateManager.scale(0.65D, 0.65D, 0.65D);

        double xOffset = 0D;
        double yOffset = -0.18D;
        double zOffset = 0.575D;

        double xOffsetSpacing = 0.4D;

        if (index == 0) {
            xOffset += xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 1) {
            xOffset -= 0;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 2) {
            xOffset -= xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        }


//        GlStateManager.rotate(180f, 0, 1, 0);
        GlStateManager.rotate(45f, 0, 1, 0);

        super.doItemRender(index);
    }

    @Override
    public int getSlotAmount() {
        return 3;
    }
}
