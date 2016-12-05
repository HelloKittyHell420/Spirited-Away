package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.tileenitity.TileEntityFurnace;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SATileEntites {

//PUMP/FURNACE/CRAFTINGTABLE/SHRINE

	  public static final String ALTAR_ID = "aether.altar";
	  public static final String PUMP_ID = "pump";
	  public static final String SHRINE_ID = "shrine";

	  public static void init() {
			register();
		}
	  
	  public static void register()
	  {
	    GameRegistry.registerTileEntity(TileEntityAltar.class, "aether.altar");
	  }
	
	

}
