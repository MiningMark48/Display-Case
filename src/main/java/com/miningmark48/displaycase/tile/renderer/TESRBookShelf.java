package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;

public class TESRBookShelf extends TESRDisplayCaseBase {

    @SuppressWarnings("Duplicates")
    @Override
    public void doItemRender(int index) {

        GlStateManager.scale(0.5D, 0.5D, 0.5D);

        double xOffset = 0D;
        double yOffset = -0.15D;
        double zOffset = -0.55D;

        double xOffsetSpacing = 0.5D;

        if (index == 0) {
            xOffset += xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
            GlStateManager.rotate(30f, 0, 1, 0);
        } else if (index == 1) {
            xOffset -= xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
            GlStateManager.rotate(-30f, 0, 1, 0);
        }
        GlStateManager.rotate(180f, 0, 1, 0);

        super.doItemRender(index);
    }

    @Override
    public void doItemBlockRender(int index) {
        GlStateManager.scale(0.75D, 0.75D, 0.75D);

        double xOffset = 0D;
        double yOffset = -0.15D;
        double zOffset = -0.4D;

        double xOffsetSpacing = 0.35D;

        if (index == 0) {
            xOffset += xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        } else if (index == 1) {
            xOffset -= xOffsetSpacing;

            GlStateManager.translate(xOffset, yOffset, zOffset);
        }


//        GlStateManager.rotate(180f, 0, 1, 0);
        GlStateManager.rotate(45f, 0, 1, 0);

        super.doItemRender(index);
    }

    @Override
    public int getSlotAmount() {
        return 2;
    }
}
