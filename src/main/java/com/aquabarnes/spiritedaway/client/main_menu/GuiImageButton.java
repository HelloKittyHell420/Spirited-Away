package com.aquabarnes.spiritedaway.client.main_menu;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

public class GuiImageButton extends GuiButton 
{
	
public boolean isActive;
public boolean isFocused; 
public boolean isHovered;
public boolean isClicked;	
	
private ResourceLocation tex_1 = new ResourceLocation("sa:gui/mainmenu/button_back.png");
private ResourceLocation tex_2 = new ResourceLocation("sa:gui/mainmenu/button_back_hover.png");

public GuiImageButton(int id, int x, int y)
{
  super(id, x, y, 107, 27, "");
}

public void func_146112_a(Minecraft mc, int posX, int posY)
{
  if (this.field_146125_m)
  {
    mc.getTextureManager().bindTexture(tex_1);
    
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.field_146123_n = ((posX >= this.field_146128_h) && (posY >= this.field_146129_i) && (posX < this.field_146128_h + this.field_146120_f) && (posY < this.field_146129_i + this.field_146121_g));
    int hoverState = func_146114_a(this.field_146123_n);
    
    GL11.glEnable(3042);
    OpenGlHelper.func_148821_a(770, 771, 1, 0);
    GL11.glBlendFunc(770, 771);
    
    int v = hoverState == 1 ? 0 : 28;
    func_73729_b(this.field_146128_h, this.field_146129_i, 0, v, this.field_146120_f, this.field_146121_g);
    
    func_146119_b(mc, posX, posY);
  }
}
}
