package com.aquabarnes.spiritedaway.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SABlocks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiBook extends GuiScreen {

    final ResourceLocation texture = new ResourceLocation("sa:textures/gui/book.png");
    int guiWidth = 175;
    int guiHeight = 228;

    GuiButton button1;
    GuiButtonTutorial arrow;
    GuiTextField textBox;

    final int BUTTON1 = 0, ARROW = 1;
    String title = "Guide Book";
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        //drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        //drawString(fontRendererObj, "Tutorial", centerX, centerY, 0x6028ff);
        GlStateManager.pushMatrix();
        {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate((width / 2) - fontRendererObj.getStringWidth(title), centerY + 10, 0);
            GlStateManager.scale(2, 2, 2);
            fontRendererObj.drawString(title, 0, 0, 0xc00e0e);
        }
        GlStateManager.popMatrix();
        //super.drawScreen(mouseX, mouseY, partialTicks);
        button1.drawButton(mc, mouseX, mouseY);
        arrow.drawButton(mc, mouseX, mouseY);
        ItemStack icon = new ItemStack(SABlocks.shrine);
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(centerX, centerY, 0);
            GlStateManager.scale(2, 2, 2);
            mc.getRenderItem().renderItemAndEffectIntoGUI(icon, 0, 0);
        }
        GlStateManager.popMatrix();
        textBox.drawTextBox();
        List<String> text = new ArrayList<String>();
        text.add(I18n.format("gui.tooltip"));
        text.add(I18n.format("gui.tooltip2", mc.theWorld.provider.getDimension()));
        text.add(icon.getDisplayName());
        drawTooltip(text, mouseX, mouseY, centerX, centerY, 16 * 2, 16 * 2);
    }

    public void drawTooltip(List<String> lines, int mouseX, int mouseY, int posX, int posY, int width, int height) {
        if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
            drawHoveringText(lines, mouseX, mouseY);
        }
    }

    @Override
    public void initGui() {
        buttonList.clear();
        buttonList.add(button1 = new GuiButton(BUTTON1, (width / 2) - 100 / 2, height - 40, 100, 20, "Close"));
        buttonList.add(arrow = new GuiButtonTutorial(ARROW, 100, 100));
        textBox = new GuiTextField(0, fontRendererObj, 0, 0, 100, 20);
        updateButtons();
        super.initGui();
    }

    public void updateButtons() {
        if (title.equals("Close"))  {
            button1.enabled = true;
        } else {
            button1.enabled = false;
        }
    }

    public void updateTextBoxes() {
        if (!textBox.getText().isEmpty()) {
            if (!textBox.isFocused()) {
                title = textBox.getText();
            }
        }
        updateButtons();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case BUTTON1:
                mc.displayGuiScreen(null);
                break;
            case ARROW:
                mc.displayGuiScreen(new GuiInventory(mc.thePlayer));
                break;
        }
        updateButtons();
        super.actionPerformed(button);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        textBox.textboxKeyTyped(typedChar, keyCode);
        updateTextBoxes();
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        textBox.mouseClicked(mouseX, mouseY, mouseButton);
        updateTextBoxes();
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

}
