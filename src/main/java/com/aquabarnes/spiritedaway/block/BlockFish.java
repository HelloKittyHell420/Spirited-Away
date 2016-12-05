package com.aquabarnes.spiritedaway.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFish extends BlockRotatedPillar {

	  public BlockFish(String name) 
	  {
	    super(Material.gourd, MapColor.grayColor);
	    this.setHardness(1);
	    setUnlocalizedName(name);
	    setRegistryName(name);
	  }

	  /**
	   * Get the Item that this Block should drop when harvested.
	   */
	  public Item getItemDropped(IBlockState state, Random rand, int fortune)
	  {
		  return Items.fish;
	  }

	  /**
	   * Returns the quantity of items to drop on block destruction.
	   */
	  public int quantityDropped(Random random)
	  {
		  return 3 + random.nextInt(7);
	  }

	  /**
	   * Get the quantity dropped based on the given fortune level
	   */
	  public int quantityDroppedWithBonus(int fortune, Random random)
	  {
		  return Math.min(9, this.quantityDropped(random) + random.nextInt(1 + fortune));
	  }

	  @Override
	  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4)
	  {
		  list.add("Fishy, Fishy, Fishy");
	  }
}
