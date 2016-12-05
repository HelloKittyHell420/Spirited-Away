package com.aquabarnes.spiritedaway.client.renderer.entity;

import java.util.Date;

import org.lwjgl.opengl.GL11;

import com.ibm.icu.text.SimpleDateFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent.TileEntity;

public class RenderClock extends TileEntitySpecialRenderer
{


public RenderClock()
{

}

public void renderAModelAt(TileEntity tileentity1, double d, double d1, double d2, float f)
{
  int metadata = tileentity1.func_145832_p();
  
  float f1 = 0.6666667F;
  
  float rotationAngle = 0.0F;
  if (metadata % 4 == 0) {
    rotationAngle = 0.0F;
  }
  if (metadata % 4 == 1) {
    rotationAngle = 270.0F;
  }
  if (metadata % 4 == 2) {
    rotationAngle = 180.0F;
  }
  if (metadata % 4 == 3) {
    rotationAngle = 90.0F;
  }
  FontRenderer fontrenderer = Minecraft.func_71410_x().field_71466_p;
  
  GL11.glPushMatrix();
  GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.75F, (float)d2 + 0.5F);
  
  GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
  
  GL11.glScalef(0.5F, 0.5F, 0.5F);
  GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
  Minecraft.func_71410_x().field_71446_o.func_110577_a(new ResourceLocation("thedalekmod:textures/tileentities/AlarmClock.png"));
  GL11.glPushMatrix();
  this.renderModel(0.0625F);
  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
  String str = sdf.format(new Date());
  
  rotationAngle = 0.016666668F * f1;
  GL11.glTranslatef(0.02F, 1.075F, -0.533F);
  GL11.glScalef(0.015F, 0.015F, 0.015F);
  GL11.glNormal3f(0.0F, 0.0F, -1.0F);
  GL11.glDepthMask(false);
  if ((str.startsWith("00")) || (str.startsWith("01")) || (str.startsWith("02")) || (str.startsWith("03")) || (str.startsWith("04")) || (str.startsWith("05")) || (str.startsWith("06")) || (str.startsWith("07")) || (str.startsWith("08")) || (str.startsWith("09")) || (str.startsWith("10")) || (str.startsWith("10"))) {
    fontrenderer.getStringWidth(str + " am", -fontrenderer.getStringWidth(str + " am") / 2, 8, 6663424);
  } else {
    fontrenderer.func_78276_b(str + " pm", -fontrenderer.func_78256_a(str + " pm") / 2, 8, 6663424);
  }
  GL11.glDepthMask(true);
  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
  GL11.glPopMatrix();
  
  Minecraft.func_71410_x().field_71446_o.func_110577_a(new ResourceLocation("thedalekmod:textures/tileentities/60sDalek.png"));
  GL11.glPushMatrix();
  GL11.glScalef(0.75F, 0.75F, 0.75F);
  GL11.glTranslatef(0.1F, -0.3F, 0.0F);
  this.renderModel(0.0625F);
  GL11.glPopMatrix();
  GL11.glPopMatrix();
}

public void func_147500_a(TileEntity tileentity, double d, double d1, double d2, float f)
{
  renderAModelAt((TileEntity)tileentity, d, d1, d2, f);
}

@Override
public void renderTileEntityAt(net.minecraft.tileentity.TileEntity te, double x, double y, double z, float partialTicks,
		int destroyStage) {
	// TODO Auto-generated method stub
	
}
}
