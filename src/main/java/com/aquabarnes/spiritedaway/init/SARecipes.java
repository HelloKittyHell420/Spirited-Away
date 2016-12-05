package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.recipes.RecipesDyeableArmor;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.ItemFishFood.FishType;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;

public class SARecipes {

public static void init() {
	register();
}

public static void register() {

CraftingManager.getInstance().getRecipeList().add(new RecipesDyeableArmor());
RecipeSorter.register("sa:armordyes", RecipesDyeableArmor.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");	


GameRegistry.addShapelessRecipe(new ItemStack(SAItems.AQUABARNES), new Object[] {Items.REDSTONE, new ItemStack(Items.DYE, 1, 4)});



GameRegistry.addShapedRecipe(new ItemStack(SABlocks.FISH_BLOCK), new Object[] {"XXX", "XXX", "XXX", 'X', new ItemStack(Items.FISH)});	
	
	
GameRegistry.addRecipe(new ItemStack(SABlocks.BASIN, 1), new Object[] {"   ", "X X", "#X#", '#', Items.STICK, 'X', Blocks.PLANKS});	

//LEATHER --> WORKERS CLOTHES
GameRegistry.addShapelessRecipe(new ItemStack(SAItems.LEGGINGS_DYEABLE_CLOTHES), new Object[] {new ItemStack(Items.LEATHER_LEGGINGS, 1)});
GameRegistry.addShapelessRecipe(new ItemStack(SAItems.CHESTPLATE_DYEABLE_CLOTHES), new Object[] {new ItemStack(Items.LEATHER_CHESTPLATE, 1)});

//Bowls
//GameRegistry.addShapedRecipe(new ItemStack(SABlocks.rice_bowl, 1), new Object[] {new ItemStack(SABlocks.flower_rose, 1)});
	
//Dyes --> Beds
//GameRegistry.addRecipe(new ItemStack(SABlocks.bedBlockBlack, 1), new Object[] {"###", "XXX", '#', Blocks.wool, 'X', Blocks.planks});
//GameRegistry.addRecipe(new ItemStack(SA.bedOrange, 1), new Object[] {"###", "XXX", '#', Blocks.wool, 'X', Blocks.planks});

//Dyes --> Flower Pots 

//GameRegistry.addRecipe(new ItemStack(SABlocks.SPRUCE_PRESSURE_PLATE, 1), new Object[] {"##", '#', new ItemStack (Blocks.PLANKS, 1, BlockPlanks.EnumType.SPRUCE.getMetadata())});
//GameRegistry.addRecipe(new ItemStack(SABlocks.BIRCH_PRESSURE_PLATE, 1), new Object[] {"##", '#', new ItemStack (Blocks.PLANKS, 1, BlockPlanks.EnumType.BIRCH.getMetadata())});
//GameRegistry.addRecipe(new ItemStack(SABlocks.JUNGLE_PRESSURE_PLATE, 1), new Object[] {"##", '#', new ItemStack (Blocks.PLANKS, 1, BlockPlanks.EnumType.JUNGLE.getMetadata())});
//GameRegistry.addRecipe(new ItemStack(SABlocks.ACACIA_PRESSURE_PLATE, 1), new Object[] {"##", '#', new ItemStack (Blocks.PLANKS, 1, BlockPlanks.EnumType.ACACIA.getMetadata())});
//GameRegistry.addRecipe(new ItemStack(SABlocks.DARK_OAK_PRESSURE_PLATE, 1), new Object[] {"##", '#', new ItemStack (Blocks.PLANKS, 1, BlockPlanks.EnumType.DARK_OAK.getMetadata())});

//Flower --> Dyes
//GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new Object[] {new ItemStack(SABlocks.FLOWER_ROSE, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.PURPLE.getDyeDamage()), new Object[] {new ItemStack(SABlocks.FLOWER_KONJAC, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(SABlocks.FLOWER_KIUSIANUS, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(SABlocks.flower_kiusianus, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(SABlocks.flower_kiusianus, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(SABlocks.flower_kiusianus, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(SABlocks.flower_kiusianus, 1)});


//GameRegistry.addShapelessRecipe(new ItemStack(SABlocks.CLASSIC_BRICK, 1), new Object[] {new ItemStack(Blocks.brick_block, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(SABlocks.classic_gravel, 1), new Object[] {new ItemStack(Blocks.gravel, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(SABlocks.classic_cobblestone, 1), new Object[] {new ItemStack(Blocks.cobblestone, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(SABlocks.classic_mossy_cobblestone, 1), new Object[] {new ItemStack(Blocks.mossy_cobblestone, 1)});

//GameRegistry.addShapelessRecipe(new ItemStack(Blocks.brick_block, 1), new Object[] {new ItemStack(SABlocks.classic_brick, 1)});
///GameRegistry.addShapelessRecipe(new ItemStack(Blocks.gravel, 1), new Object[] {new ItemStack(SABlocks.classic_gravel, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[] {new ItemStack(SABlocks.classic_cobblestone, 1)});
//GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone, 1), new Object[] {new ItemStack(SABlocks.classic_mossy_cobblestone, 1)});

//FISH
//GameRegistry.addRecipe(new ItemStack(SABlocks.FISH_BLOCK, 1), new Object[] {"XXX", "XXX", "XXX", 'X', new ItemStack(Items.fish, 1, FishType.COD.getMetadata())});
//GameRegistry.addRecipe(new ItemStack(SABlocks.FISH_BLOCK, 1), new Object[] {"XXX", "XXX", "XXX", 'X', new ItemStack(Items.fish, 1, FishType.SALMON.getMetadata())});
//GameRegistry.addRecipe(new ItemStack(SABlocks.FISH_BLOCK, 1), new Object[] {"XXX", "XXX", "XXX", 'X', new ItemStack(Items.fish, 1, FishType.CLOWNFISH.getMetadata())});

}
}

