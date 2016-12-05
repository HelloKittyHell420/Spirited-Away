package com.aquabarnes.spiritedaway.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SARecipesWool {

public static void init() {
	register();
}

public static void register() {

GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 1, EnumDyeColor.RED.getDyeDamage()), new Object[] {new ItemStack(Blocks.diamond_block, 1)});

}
}