package com.aquabarnes.spiritedaway.block;

import java.util.Random;

import com.aquabarnes.spiritedaway.init.SABlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSlabs extends BlockSlab 
{

	private String name;

	private boolean double_slab;

	public BlockSlabs(String name, boolean double_slab, Material materialIn) 
	{
		super(materialIn);
		this.name = name;
		this.double_slab = double_slab;

		this.setDefaultState(double_slab ? this.getDefaultState() : this.getDefaultState().withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM));
		this.setSoundType(materialIn == Material.WOOD ? SoundType.WOOD : SoundType.STONE);
	}

	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
    	return new ItemStack(this.getDroppedSlab(), 1, 0);
    }

    public Block getDroppedSlab()
    {
    	if (this == SABlocks.sakura_double_slab) { return SABlocks.sakura_slab; }
    	else if (this == SABlocks.wisteria_double_slab) { return SABlocks.wisteria_slab; }
    	else if (this == SABlocks.acer_palmatum_double_slab) { return SABlocks.acer_palmatum_slab; }
    	else if (this == SABlocks.winter_sweet_double_slab) { return SABlocks.winter_sweet_slab; }
    	else { return this; }
    }

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this.getDroppedSlab());
    }

	@Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

	@Override
	public boolean isDouble() 
	{
		return this.double_slab && this.name.contains("double");
	}

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState iblockstate = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
        return this.isDouble() ? iblockstate : (facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double)hitY <= 0.5D) ? iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM) : iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP));
    }

	@Override
    public IBlockState getStateFromMeta(int meta)
    {
    	if (!this.isDouble())
    	{
    		return this.getDefaultState().withProperty(HALF, meta == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
    	}

    	return this.getDefaultState();
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
		if (!this.isDouble())
		{
			if (state.getValue(HALF) == BlockSlab.EnumBlockHalf.BOTTOM)
			{
				return 0;
			}
			else if (state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
			{
				return 1;
			}
		}

		return 0;
    }

	@Override
    protected BlockStateContainer createBlockState()
    {
    	return this.isDouble() ? new BlockStateContainer(this, new IProperty[0]): new BlockStateContainer(this, new IProperty[] {HALF});
    }

	@Override
	public String getUnlocalizedName(int meta) 
	{
		return this.name;
	}

	@Override
	public IProperty<?> getVariantProperty()
	{
		return null;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack)
	{
		return null;
	}

}
