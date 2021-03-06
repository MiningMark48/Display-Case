package com.miningmark48.displaycase.tile.renderer;

import com.miningmark48.displaycase.tile.base.TESRDisplayCaseBase;
import net.minecraft.client.renderer.GlStateManager;

public class TESRArmorFrame extends TESRDisplayCaseBase {

    @SuppressWarnings("Duplicates")
    @Override
    public void doItemRender(int index) {

        GlStateManager.scale(1.65D, 1.65D, 1.65D);

        double xOffset = 0D;
        double yOffset = -0.5D;
        double zOffset = 0.275D;

        GlStateManager.translate(xOffset, yOffset, zOffset);

        super.doItemRender(index);
    }

}
