package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.handler.SAConfiguration;

import com.aquabarnes.spiritedaway.world.SAWorldProvider;
import com.aquabarnes.spiritedaway.world.Teleporter;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.player.EntityPlayerMP;



import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;

public class SAWorld {
	 
	  public static Biome spiritedaway_biome;
	  public static DimensionType spiritedaway_dimension_type;
	  
	  public static void initialization()
	  {
		spiritedaway_biome = new SABiomes();
	    
	    Biome.registerBiome((Integer) SAConfiguration.getSpiritedAwayBiomeID(), "sa:highlands", spiritedaway_biome);
	    
	    spiritedaway_dimension_type = DimensionType.register("SpiritedAway", "_spiritedaway", SAConfiguration.getSpiritedAwayDimensionID(), SAWorldProvider.class, true);
	    
	    DimensionManager.registerDimension(SAConfiguration.getSpiritedAwayDimensionID(), spiritedaway_dimension_type);
	  }
	}
