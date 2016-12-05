package com.aquabarnes.spiritedaway.block;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;

public class BlockSakuraGate extends BlockFenceGate {
	
public BlockSakuraGate()
{
  super(BlockPlanks.EnumType.OAK);
  
  func_149711_c(2.0F);
  func_149752_b(5.0F);
  func_149672_a(SoundType.WOOD);
}
}
