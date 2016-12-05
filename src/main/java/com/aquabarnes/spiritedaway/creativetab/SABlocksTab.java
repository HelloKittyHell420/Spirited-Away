package com.aquabarnes.spiritedaway.creativetab;

import com.aquabarnes.spiritedaway.init.SABlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class SABlocksTab extends CreativeTabs
{
  public SABlocksTab(int i, String label)
  {
    super(label);
  }
  
  @Override
	public Item getTabIconItem() {
  {
    return Item.getItemFromBlock(Blocks.BRICK_BLOCK);
	}
}
}
