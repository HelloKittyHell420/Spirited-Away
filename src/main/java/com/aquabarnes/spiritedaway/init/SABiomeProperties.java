package com.aquabarnes.spiritedaway.init;

import net.minecraft.world.biome.Biome.BiomeProperties;

public class SABiomeProperties extends BiomeProperties 
{

	public SABiomeProperties()
	{
		super("Spirited Away");
		this.setRainDisabled();
		this.setBaseBiome("sa");
	}

}