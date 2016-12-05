package com.aquabarnes.spiritedaway.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks.EnumType;

public class BlockGates extends BlockFenceGate {
	
public BlockGates(String name, EnumType type)
{
  super(type);
  
  setUnlocalizedName(name);
  setSoundType(SoundType.WOOD);
}
}
