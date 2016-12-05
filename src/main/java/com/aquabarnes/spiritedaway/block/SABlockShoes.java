package com.aquabarnes.spiritedaway.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SABlockShoes extends Block {

public static final PropertyDirection FACING = PropertyDirection.create("facing");
  
	  public SABlockShoes(String name, Material material)
	  {
	    super(material);
	    this.setUnlocalizedName(name);
	    GameRegistry.registerBlock(this, name);
	  }
  
}