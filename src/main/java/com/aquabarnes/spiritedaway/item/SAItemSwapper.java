package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SA;

import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAItemSwapper extends Item
{
	  public SAItemSwapper() {}
	  
	  public SAItemSwapper(String name)
	  {
	    this(name, 0);
	  }
	  
	  public SAItemSwapper(String name, int meta)
	  {
	    GameRegistry.registerItem(this, name);
	    //this.setCreativeTab(SA.tabSA);
	    this.setUnlocalizedName(name);
	    if (!SA.isServer()) {
	      Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, meta, new ModelResourceLocation("sa:" + name, "inventory"));
	    }
	  }
	}
