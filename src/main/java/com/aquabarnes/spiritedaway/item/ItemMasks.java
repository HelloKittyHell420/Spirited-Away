package com.aquabarnes.spiritedaway.item;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMasks {
	
public static final ResourceLocation MASK = new ResourceLocation ("sa:textures/items/mask_band.png");

@SideOnly(Side.CLIENT)
public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY)
{
  int i = resolution.getScaledHeight();
  int j = resolution.getScaledWidth();
  GL11.glDisable(2929);
  
  GL11.glDepthMask(false);
  GL11.glBlendFunc(770, 771);
  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
  GL11.glDisable(3008);
  
  this.bindTexture("maskblur");
  Tessellator tessellator = Tessellator.getInstance();
  tessellator.func_78382_b();
  tessellator.func_78374_a(0.0D, j, -90.0D, 0.0D, 1.0D);
  tessellator.func_78374_a(i, j, -90.0D, 1.0D, 1.0D);
  tessellator.func_78374_a(i, 0.0D, -90.0D, 1.0D, 0.0D);
  tessellator.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
  tessellator.func_78381_a();
  GL11.glDepthMask(true);
  GL11.glEnable(2929);
  
  GL11.glEnable(3008);
  
  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
}
}