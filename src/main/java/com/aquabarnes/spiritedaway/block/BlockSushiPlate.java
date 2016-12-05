package com.aquabarnes.spiritedaway.block;

import java.util.List;

import com.aquabarnes.spiritedaway.tileenitity.TileEntitySushi;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSushiPlate extends Block implements ITileEntityProvider
{
	 public static final PropertyInteger SUSHI_COUNT = PropertyInteger.create("sushi_count", 0, 6); 
	 protected static final AxisAlignedBB BASIN_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.53D, 0.9375D);
	 protected static final AxisAlignedBB BASIN_AABB_LEGS = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.53D, 0.3125D, 0.53D);
	 protected static final AxisAlignedBB BASIN_AABB_WALL_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.53D, 0.125D);
	 protected static final AxisAlignedBB BASIN_AABB_WALL_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.875D, 1.0D, 0.53D, 1.0D);
	 protected static final AxisAlignedBB BASIN_AABB_WALL_EAST = new AxisAlignedBB(0.875D, 0.0D, 0.0D, 1.0D, 0.53D, 1.0D);
	 protected static final AxisAlignedBB BASIN_AABB_WALL_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.125D, 0.53D, 1.0D);
	
	  public BlockSushiPlate(String name, Material material)
	  {
	    super(material);
	    this.setUnlocalizedName(name);
	    GameRegistry.registerBlock(this, name);
	    //this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, Integer.valueOf(0)));
    }
	  
	    @SideOnly(Side.CLIENT)
	    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	    {
	        return true;
	    }
	    
	    
	  
	  public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
			return enableStats;
	
	    }
	    
	    /**
	     * Returns a new instance of a block's tile entity class. Called on placing the block.
	     */
	    public TileEntity createNewTileEntity(World worldIn, int meta)
	    {
	        return new TileEntitySushi();
	    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BASIN_AABB;
  }
    
    public boolean isOpaqueCube(IBlockState state)
    {
    	return false;
    }

    public boolean isFullCube(IBlockState state)
    {
    	return true;
    }
}