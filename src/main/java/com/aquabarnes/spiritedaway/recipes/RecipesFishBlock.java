package com.aquabarnes.spiritedaway.recipes;

import com.aquabarnes.spiritedaway.init.SABlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFishFood.FishType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesFishBlock
{
	
private Object[][] recipeItems = new Object[][] {{SABlocks.FISH_BLOCK, new ItemStack(Items.fish, 1, FishType.COD.getMetadata()), SABlocks.FISH_BLOCK, new ItemStack(Items.fish, 1, FishType.SALMON.getMetadata()), SABlocks.FISH_BLOCK, new ItemStack(Items.fish, 1, FishType.CLOWNFISH.getMetadata())}};

/**
 * Adds the ingot recipes to the CraftingManager.
 */
public void addRecipes(CraftingManager p_77590_1_)
{
    for (int i = 0; i < this.recipeItems.length; ++i)
    {
        Block block = (Block)this.recipeItems[i][0];
        ItemStack itemstack = (ItemStack)this.recipeItems[i][1];
        p_77590_1_.addRecipe(new ItemStack(block), new Object[] {"###", "###", "###", '#', itemstack});
        p_77590_1_.addRecipe(itemstack, new Object[] {"#", '#', block});
    }

    p_77590_1_.addRecipe(new ItemStack(Items.gold_ingot), new Object[] {"###", "###", "###", '#', Items.gold_nugget});
    p_77590_1_.addRecipe(new ItemStack(Items.gold_nugget, 9), new Object[] {"#", '#', Items.gold_ingot});
}
}