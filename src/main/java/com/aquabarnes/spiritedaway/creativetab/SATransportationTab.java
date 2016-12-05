package com.aquabarnes.spiritedaway.creativetab;

import com.aquabarnes.spiritedaway.init.SAItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SATransportationTab extends CreativeTabs {
	
public SATransportationTab(int par1, String par2Str)
{
  super(par1, par2Str);
}

@Override
@SideOnly(Side.CLIENT)
public Item getTabIconItem() {
  
	return Items.ACACIA_BOAT;
}

}