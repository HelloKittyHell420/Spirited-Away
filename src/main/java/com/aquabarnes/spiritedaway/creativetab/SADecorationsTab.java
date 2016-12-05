package com.aquabarnes.spiritedaway.creativetab;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SADecorationsTab extends CreativeTabs {
	
public SADecorationsTab(int par1, String par2Str)
{
  super(par1, par2Str);
}

@Override
@SideOnly(Side.CLIENT)
public Item getTabIconItem() {
  
	return Item.getItemFromBlock(Blocks.DOUBLE_PLANT);
}
@SideOnly(Side.CLIENT)
public int getIconItemDamage()
{
    return BlockDoublePlant.EnumPlantType.PAEONIA.getMeta();
}

}