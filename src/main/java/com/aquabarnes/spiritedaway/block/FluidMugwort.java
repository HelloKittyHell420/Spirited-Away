package com.aquabarnes.spiritedaway.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public final class FluidMugwort extends Fluid {

	public static final String name = "mugwort";
	public static final FluidMugwort instance = new FluidMugwort();
	
	public FluidMugwort() {
		super(name, new ResourceLocation("sa:" + "textures/blocks/" + name + "_still"), new ResourceLocation("sa:" + "textures/blocks/" + name + "_flowing"));
		this.setViscosity(1000);
	}

	public final static class BlockMugwort extends BlockFluidClassic {

	public static final String name = "mugwort";
	public static final BlockMugwort instance = new BlockMugwort();
	
	public BlockMugwort() {
		super(FluidMugwort.instance, Material.WATER);
		this.setUnlocalizedName(name);
	
		
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		
		return EnumBlockRenderType.MODEL; 
	}
	}
}	