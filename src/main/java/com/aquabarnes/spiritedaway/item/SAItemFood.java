package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SA;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAItemFood extends ItemFood {

	public final int itemUseDuration;
	
	public SAItemFood(String name, int amount, float f, boolean isWolfFood)
	  {
	    super(amount, 0.6F, false);
		//this.setCreativeTab(SA.tabSA);
        this.setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        this.itemUseDuration = 32;

        if (!SA.isServer()) {
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("sa:" + name, "inventory"));
  }

}
}
