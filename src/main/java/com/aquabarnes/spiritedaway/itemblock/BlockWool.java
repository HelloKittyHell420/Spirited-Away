package com.aquabarnes.spiritedaway.itemblock;

import java.util.List;


import com.aquabarnes.spiritedaway.enums.EnumColors;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWool extends Block implements IMetaBlockName {

	public static final PropertyEnum<EnumColors> COLOR = PropertyEnum.<EnumColors>create("color", EnumColors.class);

    public BlockWool(String name)
    {
        super(Material.cloth);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumColors.WHITE));
        this.setCreativeTab(CreativeTabs.tabBlock);
        
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlockMeta(this), getRegistryName());
    }
    
	  public String getSpecialName(ItemStack stack) 
	  {
	      if(stack.getItemDamage() == 0)
	    	  return "white";
	      if(stack.getItemDamage() == 1)
	    	  return "orange";
	      if(stack.getItemDamage() == 2)
	    	  return "magenta";
	      if(stack.getItemDamage() == 3)
	    	  return "light_blue";
	      if(stack.getItemDamage() == 4)
	    	  return "yellow";
	      if(stack.getItemDamage() == 5)
	    	  return "lime";
	      if(stack.getItemDamage() == 6)
	    	  return "pink";
	      if(stack.getItemDamage() == 7)
	    	  return "gray";
	      if(stack.getItemDamage() == 8)
	    	  return "silver";
	      if(stack.getItemDamage() == 9)
	    	  return "cyan";
	      if(stack.getItemDamage() == 10)
	    	  return "purple";
	      if(stack.getItemDamage() == 11)
	    	  return "blue";
	      if(stack.getItemDamage() == 12)
	    	  return "brown";
	      if(stack.getItemDamage() == 13)
	    	  return "green";
	      if(stack.getItemDamage() == 14)
	    	  return "red";
	      if(stack.getItemDamage() == 15)
	    	  return "black";

		return "white";
	  }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((EnumColors)state.getValue(COLOR)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumColors enumdyecolor : EnumColors.values())
        {
            list.add(new ItemStack(itemIn, 1, enumdyecolor.getMetadata()));
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(COLOR, EnumColors.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumColors)state.getValue(COLOR)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {COLOR});
    }
}