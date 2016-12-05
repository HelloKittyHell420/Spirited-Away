package com.aquabarnes.spiritedaway.block;

import java.util.List;

import com.aquabarnes.spiritedaway.init.SABlocks;
import com.aquabarnes.spiritedaway.tileenitity.TileEntityFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockShrine extends Block { 

	private static final PropertyDirection FACING = BlockHorizontal.FACING;
	
    protected static final AxisAlignedBB SHRINE_N = new AxisAlignedBB(0.0625D, 0.0D, 0.0D, 0.9375D, 0.8D, 0.9375D);
    protected static final AxisAlignedBB SHRINE_S = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.8D, 1.0D);
    protected static final AxisAlignedBB SHRINE_W = new AxisAlignedBB(0.0D, 0.0D, 0.0625D, 0.9375D, 0.8D, 0.9375D);
    protected static final AxisAlignedBB SHRINE_E = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 1.0D, 0.8D, 0.9375D);
    protected static final AxisAlignedBB SHRINE = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.9375D);

	public BlockShrine(String name) {
		
		super(Material.ANVIL);
	    this.setUnlocalizedName(name);
	    this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return source.getBlockState(pos.north()).getBlock() == this ? SHRINE_N: (source.getBlockState(pos.south()).getBlock() == this ? SHRINE_S : (source.getBlockState(pos.west()).getBlock() == this ? SHRINE_W: (source.getBlockState(pos.east()).getBlock() == this ? SHRINE_E: SHRINE)));
	}
	 
    public boolean isOpaqueCube(IBlockState state)
    {
    	return false;
    }
    
    public boolean isFullCube(IBlockState state)
    {
    	return false;
    }
    
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        this.setDefaultDirection(worldIn, pos, state);
    }
	 
	private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            boolean flag = worldIn.getBlockState(pos.north()).isFullBlock();
            boolean flag1 = worldIn.getBlockState(pos.south()).isFullBlock();

            if (enumfacing == EnumFacing.NORTH && flag && !flag1)
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag)
            {
                enumfacing = EnumFacing.NORTH;
            }
            else
            {
                boolean flag2 = worldIn.getBlockState(pos.west()).isFullBlock();
                boolean flag3 = worldIn.getBlockState(pos.east()).isFullBlock();

                if (enumfacing == EnumFacing.WEST && flag2 && !flag3)
                {
                    enumfacing = EnumFacing.EAST;
                }
                else if (enumfacing == EnumFacing.EAST && flag3 && !flag2)
                {
                    enumfacing = EnumFacing.WEST;
                }
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing));
        }
        } 

			public static void setState(boolean active, World worldIn, BlockPos pos)
			{
				IBlockState iblockstate = worldIn.getBlockState(pos);
			    worldIn.setBlockState(pos, SABlocks.SHRINE.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
				
			    return;
			}

	        /**
	         * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
	         * IBlockstate
	         */
	        public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	        {
	            return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	        }

	        /**
	         * Called by ItemBlocks after a block is set in the world, to allow post-place logic
	         */
	        public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	        {
	        	worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()));

	        }

	        public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	        {
	            return new ItemStack(SABlocks.SHRINE);
	        }

	        /**
	         * Get the facing of a dispenser with the given metadata
	         */
	        public static EnumFacing getFacing(int meta)
	        {
	            return EnumFacing.getFront(meta & 7);
	        }

	        /**
	         * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
	         */
	        public EnumBlockRenderType getRenderType(IBlockState state)
	        {
	            return EnumBlockRenderType.MODEL;
	        }

	        /**
	         * Convert the given metadata into a BlockState for this Block
	         */
	        public IBlockState getStateFromMeta(int meta)
	        {
	            return this.getDefaultState().withProperty(FACING, getFacing(meta));
	        }

	        /**
	         * Convert the BlockState into the correct metadata value
	         */
	        public int getMetaFromState(IBlockState state)
	        {
	            int i = 0;
	            i = i | ((EnumFacing)state.getValue(FACING)).getIndex();
	            return i;
	        }

	        /**
	         * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	         * blockstate.
	         */
	        public IBlockState withRotation(IBlockState state, Rotation rot)
	        {
	            return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	        }

	        /**
	         * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	         * blockstate.
	         */
	        public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	        {
	            return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	        }

	        protected BlockStateContainer createBlockState()
	        {
	            return new BlockStateContainer(this, new IProperty[] {FACING});
	        }
	    }