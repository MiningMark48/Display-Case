package com.miningmark48.displaycase.client;

import com.miningmark48.displaycase.container.ContainerDCSingleSlotArmor;
import com.miningmark48.displaycase.reference.Reference;
import com.miningmark48.displaycase.tile.base.TileEntityDisplayCaseBase;
import com.miningmark48.mininglib.utility.GuiUtil;
import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GuiDCSingleSlotArmor extends GuiContainer {

    private IInventory playerInv;
    private EntityPlayer player;
    private TileEntityDisplayCaseBase te;

    private static String texture = Reference.MOD_ID + ":textures/gui/display_case.png";

    public GuiDCSingleSlotArmor(IInventory playerInv, TileEntityDisplayCaseBase te, EntityPlayer player) {
        super(new ContainerDCSingleSlotArmor(playerInv, te));

        this.xSize = 176;
        this.ySize = 113;

        this.playerInv = playerInv;
        this.player = player;
        this.te = te;

    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(texture));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        this.drawTexturedModalRect(getGuiLeft() + 150, getGuiTop() + 6, 177, 1, 15, 15);
    }

    @Override
    protected  void drawGuiContainerForegroundLayer(int mouseX, int mouseY){

        DecimalFormat df = new DecimalFormat("##.##");
        String s = this.te.getDisplayName().getUnformattedComponentText();
        //this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        int x = GuiUtil.getXCenter(s, this.fontRenderer, xSize);
        this.fontRenderer.drawString(s, x, 5, 0x404040);

        renderTooltips(mouseX, mouseY);

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    private void renderTooltips(int mouseX, int mouseY){
        Minecraft mc = Minecraft.getMinecraft();
        if (this.isMouseOver(mouseX, mouseY, 150, 6, 165, 21)) {
            List<String> text = new ArrayList<>();
            text.add(TextFormatting.BOLD + "" + TextFormatting.UNDERLINE + ModTranslate.toLocal("gui.display_case.armor.info.title"));
            text.add(ModTranslate.toLocal("gui.display_case.armor.info.line1"));
            net.minecraftforge.fml.client.config.GuiUtils.drawHoveringText(text, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }
    }

    private boolean isMouseOver(int mouseX, int mouseY, int minX, int minY, int maxX, int maxY){
        int actualX = mouseX - ((this.width - this.xSize) / 2);
        int actualY = mouseY - ((this.height - this.ySize) / 2);
        return (actualX >= minX) && (actualX <= maxX) && (actualY >= minY) && (actualY <= maxY);
    }

}
