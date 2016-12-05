package com.aquabarnes.spiritedaway.block;

import com.aquabarnes.spiritedaway.SpiritedAway;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class FluidSulfer extends Fluid {

	public static final String name = "sulfer";
	public static final FluidSulfer instance = new FluidSulfer();
	
	public FluidSulfer() {
		super(name, new ResourceLocation("sa:" + "blocks/" + name + "_still"), new ResourceLocation("sa:" + "blocks/" + name + "_flowing"));
		this.setViscosity(1000);
	}

	public final static class BlockSulfer extends BlockFluidClassic {

	public static final String name = "sulfer";
	public static final BlockSulfer instance = new BlockSulfer();
	
	public BlockSulfer() {
		super(FluidSulfer.instance, Material.WATER);
		this.setUnlocalizedName(name);
	
		
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		
		return EnumBlockRenderType.MODEL; 
	}
	}
}	