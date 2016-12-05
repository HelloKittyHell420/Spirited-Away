package com.aquabarnes.spiritedaway.enums;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum TrainType
{
    NORMAL(0, "Train"),
    WITHWORKBENCH(0, "TrainShrine"),
    WITHCOOKINGPOT(0, "TrainShrine"),
	WITHSHRINE(1, "TrainShrine");

	private final int meta;
	private final String typeName;

	private TrainType(int s, String n)
	{
		this.meta = s;
		this.typeName = n;
	}

}
