package com.aquabarnes.spiritedaway.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class SATileEntites {

	public static void initialization()
	{
		GameRegistry.registerTileEntityWithAlternatives(Tile.class, "tile", new String[] { "sa_tile" });
	}
}
