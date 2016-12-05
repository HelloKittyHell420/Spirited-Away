package com.aquabarnes.spiritedaway.itemblock;

import java.util.List;

import java.util.Random;

import com.aquabarnes.spiritedaway.enums.EnumPlankTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSapling extends BlockBush implements IGrowable, IMetaBlockName {
	
	  public static final PropertyEnum<EnumPlankTypes> TYPE = PropertyEnum.<EnumPlankTypes>create("type", EnumPlankTypes.class);
	  public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	 
	  protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	  
	  public BlockSapling(String name)
	  //Object treeGen
	  {
	    setUnlocalizedName(name);
	    setRegistryName(name);
	    this.setHardness(0.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumPlankTypes.SAKURA).withProperty(STAGE, Integer.valueOf(0)));
        this.setCreativeTab(CreativeTabs.tabDecorations);
        
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlockMeta(this), getRegistryName());
	  }
	  
	@Override
	public String getSpecialName(ItemStack stack) 
	{
	      if(stack.getItemDamage() == 0)
	    	  return "sakura";
	      if(stack.getItemDamage() == 1)
    		  return "wisteria";
	      if(stack.getItemDamage() == 2)
    		  return "acerpalmatum";
	      if(stack.getItemDamage() == 3)
    		  return "wintersweet";
	      
		return "sakura";
	}
  
	 
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return SAPLING_AABB;
	}
	
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumPlankTypes blockplanks$enumtype : EnumPlankTypes.values())
        {
            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
        }
    }
    
    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }
    
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	//TODO:        
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        WorldGenerator worldgenerator = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true));
        int i = 0;
        int j = 0;
        boolean flag = false;

        switch ((EnumPlankTypes)state.getValue(TYPE))
        {
            case SAKURA:
                worldgenerator = new WorldGenBirchTree(true, false);
                break;
                
            case WISTERIA:
                worldgenerator = new WorldGenBirchTree(true, false);
                break;
                
            case ACERPALMATUM:
                worldgenerator = new WorldGenSavannaTree(true);
                break;
                
            case WINTERSWEET:
                worldgenerator = new WorldGenSavannaTree(true);
                break;
            }
        }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, EnumPlankTypes.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumPlankTypes)state.getValue(TYPE)).getMetadata();
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE, STAGE});
    }
}



