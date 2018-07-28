package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;

public class TESRDisplayCase extends TESRDisplayCaseBase {

    @Override
    public void doItemRender(int index) {
        GlStateManager.rotate(180f,0, 0, 1);
        GlStateManager.rotate(90f,1, 0, 0);

        double xOffset = 0D;
        double yOffset = -0.475D;
        double zOffset = -0.35D;

        GlStateManager.translate(xOffset, yOffset, zOffset);

        super.doItemRender(index);
    }

    @Override
    public void doItemBlockRender(int index) {
        GlStateManager.scale(0.5D, 0.5D, 0.5D);

        double xOffset = 0.0D;
        double yOffset = -1.025D;
        double zOffset = 0.0D;

        GlStateManager.translate(xOffset, yOffset, zOffset);

        super.doItemBlockRender(index);
    }
}
