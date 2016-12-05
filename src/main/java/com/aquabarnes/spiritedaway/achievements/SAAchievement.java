package com.aquabarnes.spiritedaway.achievements;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

public class SAAchievement extends Achievement {

	 public SAAchievement(String name, String desc, int length, int width, ItemStack stack, Achievement parentAchievement)
	 {
	    super(name, desc, length, width, stack, parentAchievement);
	 }
	
	public SAAchievement(String statIdIn, String unlocalizedName, int column, int row, Item itemIn, Achievement parent)
    {
        this(statIdIn, unlocalizedName, column, row, new ItemStack(itemIn), parent);
    }

    public SAAchievement(String statIdIn, String unlocalizedName, int column, int row, Block blockIn, Achievement parent)
    {
        this(statIdIn, unlocalizedName, column, row, new ItemStack(blockIn), parent);
    }

    public ITextComponent getStatName()
    {
    ITextComponent itextcomponent = super.getStatName();
    itextcomponent.getStyle().setColor(this.getSpecial() ? TextFormatting.DARK_RED : TextFormatting.RED);
    return itextcomponent;
    }
}
