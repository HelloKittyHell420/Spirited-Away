package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.proxy.ClientProxy;

import com.aquabarnes.spiritedaway.world.biome.BiomeGenPlains;

import net.minecraft.item.Item;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SABiomes {
	
	public static BiomeGenBase SpiritedAwayBiome;
	public static int SpiritedAwayDimensionID;
	public static int BiomeID;
	
	public static void init() {
	
		registerBiomes();
		register();
		
	}
	
	private static void registerBiomes()
	{
		SpiritedAwayBiome = new BiomeGenPlains(BiomeID);
	}
	
	public static void register() {
	
	 BiomeDictionary.registerBiomeType(SpiritedAwayBiome, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.END });
	 BiomeDictionary.registerAllBiomes();	
		
	}
	
}