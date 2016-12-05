package com.aquabarnes.spiritedaway.block;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockFences extends BlockFence {
	
public BlockFences(String name)
{
  super(Material.WOOD, MapColor.PINK);
  
  setUnlocalizedName(name);
  setLightLevel(2.0F);
  setHardness(5.0F);
  setSoundType(SoundType.WOOD);
}
}
