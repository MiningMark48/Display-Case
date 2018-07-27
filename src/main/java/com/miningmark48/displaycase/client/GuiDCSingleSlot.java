package com.miningmark48.displaycase.client;

import com.miningmark48.displaycase.container.ContainerDCSingleSlot;
import com.miningmark48.displaycase.container.slot.SlotType;
import com.miningmark48.displaycase.reference.Reference;
import com.miningmark48.displaycase.reference.TextureReference;
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
import java.util.Objects;

public class GuiDCSingleSlot extends GuiContainer {

    private IInventory playerInv;
    private EntityPlayer player;
    private IInventory te;
    private SlotType slotType;

    public GuiDCSingleSlot(IInventory playerInv, IInventory te, EntityPlayer player, SlotType slotType) {
        super(new ContainerDCSingleSlot(playerInv, te, slotType));

        this.xSize = 176;
        this.ySize = 144;

        this.playerInv = playerInv;
        this.player = player;
        this.te = te;
        this.slotType = slotType;

    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(TextureReference.SINGLE_SLOT_RESOURCE);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if (te.getSizeInventory() == 1) {
            this.drawTexturedModalRect(getGuiLeft() + 79, getGuiTop() + 30, 177, 18, 18, 18);
        } else if (te.getSizeInventory() == 2) {
            this.drawTexturedModalRect(getGuiLeft() + 52, getGuiTop() + 30, 177, 18, 18, 18);
            this.drawTexturedModalRect(getGuiLeft() + 106, getGuiTop() + 30, 177, 18, 18, 18);
        } else if (te.getSizeInventory() == 3) {
            this.drawTexturedModalRect(getGuiLeft() + 52, getGuiTop() + 30, 177, 18, 18, 18);
            this.drawTexturedModalRect(getGuiLeft() + 79, getGuiTop() + 30, 177, 18, 18, 18);
            this.drawTexturedModalRect(getGuiLeft() + 106, getGuiTop() + 30, 177, 18, 18, 18);
        }

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
            List<String> text = new ArrayList<String>();
            text.add(TextFormatting.BOLD + "" + TextFormatting.UNDERLINE + ModTranslate.toLocal("gui.display_case.info.title"));

            switch (slotType) {
                default:
                case ALL:
                    text.add(ModTranslate.toLocal("gui.display_case.info.all.line1"));
                    break;
                case ARMOR:
                    text.add(ModTranslate.toLocal("gui.display_case.info.armor.line1"));
                    break;
                case BLOCK:
                    text.add(ModTranslate.toLocal("gui.display_case.info.block.line1"));
                    break;
                case ITEM:
                    text.add(ModTranslate.toLocal("gui.display_case.info.item.line1"));
                    break;
                case TOOL:
                    text.add(ModTranslate.toLocal("gui.display_case.info.tool.line1"));
                    break;
                case WEAPON:
                    text.add(ModTranslate.toLocal("gui.display_case.info.weapon.line1"));
                    break;
            }


            net.minecraftforge.fml.client.config.GuiUtils.drawHoveringText(text, mouseX - ((this.width - this.xSize) / 2), mouseY - ((this.height - this.ySize) / 2), mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
        }
    }

    private boolean isMouseOver(int mouseX, int mouseY, int minX, int minY, int maxX, int maxY){
        int actualX = mouseX - ((this.width - this.xSize) / 2);
        int actualY = mouseY - ((this.height - this.ySize) / 2);
        return (actualX >= minX) && (actualX <= maxX) && (actualY >= minY) && (actualY <= maxY);
    }

}
