package com.aquabarnes.spiritedaway.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockStep extends BlockSlab {

	public BlockStep(String name, boolean par2, Material par5, int par6)
	  {
	    super(par5);
	    this.setUnlocalizedName(name);
	    GameRegistry.registerBlock(this, name);
	}

	@Override
	public String getUnlocalizedName(int meta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDouble() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		// TODO Auto-generated method stub
		return null;
	}

}
