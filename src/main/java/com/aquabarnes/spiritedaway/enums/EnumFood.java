package com.aquabarnes.spiritedaway.enums;

import java.util.Map;

import com.aquabarnes.spiritedaway.itemblock.BlockBowl;
import com.google.common.collect.Maps;

import net.minecraft.block.BlockStairs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;

public enum EnumFood implements IStringSerializable {

	EMPTY,
	MUSHROOMSOUP,
	BEETROOTSOUP, 
	RABBITSTEW;
	//SUSHI,
	//RICE;

    public String toString()
    {
        return this.getName();
    }
	
    public String getName()
    {
    	switch (this)
    {
        case EMPTY:
            return "empty";
        case MUSHROOMSOUP:
            return "mushroom_stew";
        case BEETROOTSOUP:
            return "beetroot_soup";
        case RABBITSTEW:
            return "rabbit_stew";
        default:
            return "empty";
    }
    }
}