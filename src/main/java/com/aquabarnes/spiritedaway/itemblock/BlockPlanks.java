package com.aquabarnes.spiritedaway.itemblock;

import java.util.List;




import com.aquabarnes.spiritedaway.enums.EnumPlankTypes;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPlanks extends Block implements IMetaBlockName
{
	 public static final PropertyEnum<EnumPlankTypes> VARIANT = PropertyEnum.<EnumPlankTypes>create("variant", EnumPlankTypes.class);

	 public BlockPlanks(String name) {
	       
	    super(Material.WOOD);
        setUnlocalizedName(name);
        setRegistryName(name);
	    this.setHardness(2.0F);
	    this.setHarvestLevel("axe", 0);
	    this.setCreativeTab(SACreativeTabs.BUILDING_BLOCKS);
	    this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumPlankTypes.SAKURA));  
	    
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlockMeta(this), getRegistryName());
	  }
	 
	  public int damageDropped(IBlockState state)
	  {
	    return ((EnumPlankTypes)state.getValue(VARIANT)).getMetadata();
	  }
	  
	  public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, Block block, BlockPos pos, EntityPlayer player)
	  {
		  return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	  }

	  @SideOnly(Side.CLIENT)
	  public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
	    {
	        for (EnumPlankTypes blockplanks$enumtype : EnumPlankTypes.values())
	        {
	            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
	        }
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
  
	  public IBlockState getStateFromMeta(int meta)
	  {
	     return this.getDefaultState().withProperty(VARIANT, EnumPlankTypes.byMetadata(meta));
	  }
	  
	  public int getMetaFromState(IBlockState state)
	  {
	     return ((EnumPlankTypes)state.getValue(VARIANT)).getMetadata();
	  }

	  protected BlockStateContainer createBlockState()
	  {
	     return new BlockStateContainer(this, new IProperty[] {VARIANT});
	  }
	    
	    
}
