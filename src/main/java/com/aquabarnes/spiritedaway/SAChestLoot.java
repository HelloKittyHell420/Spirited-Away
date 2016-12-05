package com.aquabarnes.spiritedaway;

import java.util.Random;


import com.aquabarnes.spiritedaway.handler.SAConfiguration;
import com.aquabarnes.spiritedaway.init.SAItems;

import net.minecraft.block.BlockDispenser;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.ForgeHooks;

public class SAChestLoot
{
  private static Random random = new Random();
  
  public static void init()
  {
    registerDispenserBehaviours();
    addDungeonLoot();
    addDungeonMobs();
  }
  
  private static void addDungeonMobs() {
	
	  float noface = DungeonHooks.addDungeonMob("NoFace", 100);
	  float sootball = DungeonHooks.addDungeonMob("Sootball", 100);
	
}

private static void registerDispenserBehaviours()
  {
    //BlockDispenser.dispenseBehaviorRegistry.iterator(SAItems.MUDBALL, new DispenserBehaviourMudball());
  }
  
  private static void addDungeonLoot()
  {
	//ChestGenHooks mineshaft = ForgeHooks.getInfo("mineshaftCorridor");  
	  
    if (SAConfiguration.dungeonLoot == true)
    {
     //mineshaft.addItem();
    }
  }

}