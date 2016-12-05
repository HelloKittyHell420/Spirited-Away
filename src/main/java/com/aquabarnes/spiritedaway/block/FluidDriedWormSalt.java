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

public final class FluidDriedWormSalt extends Fluid {

	public static final String name = "driedwormsalt";
	public static final FluidDriedWormSalt instance = new FluidDriedWormSalt();
	
	public FluidDriedWormSalt() {
		super(name, new ResourceLocation("sa:" + "textures/blocks/" + name + "_still"), new ResourceLocation("sa:" + "textures/blocks/" + name + "_flowing"));
		this.setViscosity(1000);
	}

	public final static class BlockDriedWormSalt extends BlockFluidClassic {

	public static final String name = "driedwormsalt";
	public static final BlockDriedWormSalt instance = new BlockDriedWormSalt();
	
	public BlockDriedWormSalt() {
		super(FluidDriedWormSalt.instance, Material.WATER);
		this.setUnlocalizedName(name);
	
		
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		
		return EnumBlockRenderType.MODEL; 
	}
	}
}	