package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SA;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAItemSword extends ItemSword {

public SAItemSword(String name, Item.ToolMaterial material)
{
  this(name, 0, material);
}

public SAItemSword(String name, int meta, Item.ToolMaterial material)
{
  super(material);
  GameRegistry.registerItem(this, name);
  this.setCreativeTab(CreativeTabs.tabTransport);
  this.setUnlocalizedName(name);
  if (!SA.isServer()) {
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, meta, new ModelResourceLocation("sa:" + name, "inventory"));
  }
  
}
}