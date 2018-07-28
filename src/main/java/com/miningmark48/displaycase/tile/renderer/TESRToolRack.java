package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;

public class TESRToolRack extends TESRDisplayCaseBase {

    @SuppressWarnings("Duplicates")
    @Override
    public void doItemRender(int index) {

        GlStateManager.scale(1.65D, 1.65D, 1.65D);


        double indexOffset = -0.417D;
        double xOffset = -0.105D + (index == 1 ? indexOffset : 0D);
        double yOffset = -0.635D;
        double zOffset = 0.25D;

        GlStateManager.translate(xOffset, yOffset, zOffset);

        GlStateManager.translate(0D, 1D, 0D);

        GlStateManager.rotate(225f, 0, 0, 1);

        super.doItemRender(index);
    }

    @Override
    public int getSlotAmount() {
        return 2;
    }
}
