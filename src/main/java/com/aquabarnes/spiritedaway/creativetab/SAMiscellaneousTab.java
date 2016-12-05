package com.aquabarnes.spiritedaway.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class SAMiscellaneousTab extends CreativeTabs
{
  public SAMiscellaneousTab(int i, String label)
  {
    super(label);
  }
  
  @Override
	public Item getTabIconItem() {
  {
    return Items.lava_bucket;
	}
}
}
