package com.aquabarnes.spiritedaway.tileenitity.renderer;

import com.aquabarnes.spiritedaway.init.SAItems;
import com.aquabarnes.spiritedaway.tileenitity.TileEntitySushi;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySushiRenderer extends TileEntitySpecialRenderer<TileEntitySushi> {

	private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, new ItemStack(Items.fish)); 
	private static final EntityItem ITEM1 = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, new ItemStack(SAItems.LEGGINGS_HAKU));  
	private static final EntityItem ITEM2 = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, new ItemStack(SAItems.BOOTS_HAKU));  
	
	@Override
	public void renderTileEntityAt(TileEntitySushi te, double x, double y, double z, float partialTicks, int destroyStage) {
		
		ITEM.hoverStart = 0F;
		
		GlStateManager.pushMatrix();
		{	
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(90F, 1, 0, 0);
			GlStateManager.translate(0.5, 0, -1.0);
			for(int i = 0; i < te.sushiCount; i++)
		{
			Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0F, 0F, false);
		}
		GlStateManager.popMatrix();	
	}
 }
}

