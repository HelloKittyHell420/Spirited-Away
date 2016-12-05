package com.aquabarnes.spiritedaway.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChopstick extends Block {

	 protected static final AxisAlignedBB CHOPSTICK_CUP_AABB = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 1.0D, 0.6875D);
	 protected static final AxisAlignedBB CHOPSTICK_CUP_AABB_TOP = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 1.0D, 0.6875D);
	 
	 public BlockChopstick(String name, Material material)
	  {
	    super(Material.anvil);
	    this.setUnlocalizedName(name);
	    GameRegistry.registerBlock(this, name);
	  }
	 
	 	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_)
	    {
	    	addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, CHOPSTICK_CUP_AABB);
	        addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, CHOPSTICK_CUP_AABB_TOP);
	    }
	 	
	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return CHOPSTICK_CUP_AABB;
	    }
	 
	    @SideOnly(Side.CLIENT)
	    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	    {
	        return true;
	    }
	    
	    /**
	     * Used to determine ambient occlusion and culling when rebuilding chunks for render
	     */
	    public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }

	    public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }

}