package com.aquabarnes.spiritedaway.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockChair extends Block {

	private static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockChair(String name, SoundType sound) {
		
		super(Material.WOOD);
		this.setHardness(1.5F);
		//this.setSoundType(sound);
		this.setUnlocalizedName(name);
	}

}
