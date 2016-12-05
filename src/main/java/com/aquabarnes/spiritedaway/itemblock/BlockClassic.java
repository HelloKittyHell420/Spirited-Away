package com.aquabarnes.spiritedaway.itemblock;

import java.util.List;


import com.aquabarnes.spiritedaway.enums.EnumClassic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockClassic extends Block {

	public static final PropertyEnum<EnumClassic> CLASSIC = PropertyEnum.<EnumClassic>create("variant", EnumClassic.class);

    public BlockClassic(String name)
    {
        super(Material.CLOTH);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CLASSIC, EnumClassic.WHITE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        
    }
    
	  public String getSpecialName(ItemStack stack) 
	  {
	      if(stack.getItemDamage() == 0)
	    	  return "cobblestone";
	      if(stack.getItemDamage() == 1)
	    	  return "mossy_cobblestone";
	      if(stack.getItemDamage() == 2)
	    	  return "gravel";
	      if(stack.getItemDamage() == 3)
	    	  return "leaves";
	      if(stack.getItemDamage() == 4)
	    	  return "brick";
	      if(stack.getItemDamage() == 5)
	    	  return "iron";
	      if(stack.getItemDamage() == 6)
	    	  return "gold";

	      return "cobblestone";
	  }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((EnumClassic)state.getValue(CLASSIC)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumClassic EnumClassic : EnumClassic.values())
        {
            list.add(new ItemStack(itemIn, 1, EnumClassic.getMetadata()));
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(CLASSIC, EnumClassic.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumClassic)state.getValue(CLASSIC)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CLASSIC});
    }
}