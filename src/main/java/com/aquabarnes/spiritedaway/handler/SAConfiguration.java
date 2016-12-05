package com.aquabarnes.spiritedaway.handler;

import java.io.File;

import java.io.IOException;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SAConfiguration
{
  private static final String CATEGORY_GENERAL = "general";
  private static final String CATEGORY_DIMENSIONS = "dimensions";
  private static final String CATEGORY_BLOCKS = "blocks";
  private static final String CATEGORY_ITEMS = "items";
  private static final String CATEGORY_ENTITES = "mobs";

  public static final int SpiritedAwayID = 2;
  public static File SALocation;
  private static Configuration SAConfig;
  
  //TODO:Needs to be in another Config file /Spirited Away/Settings
  public static boolean welcomeMessage = true;
  public static boolean autoUpdate = false; //TODO: 
  public static boolean showTitleScreen = false; //TODO: 
  public static boolean enableCreativeTab = true;
 
  //Entities //TODO:Spawn Rates
  public static boolean spawnAkiichiro;
  public static boolean spawnBoh;
  public static boolean spawnChihiro;
  public static boolean spawnFrogman;
  public static boolean spawnHakuHuman;
  public static boolean spawnKamaji;
  public static boolean spawnKashira;
  public static boolean spawnKasuga;
  public static boolean spawnLin;
  public static boolean spawnNoFace;
  public static boolean spawnOotori;
  public static boolean spawnRadish;
  public static boolean spawnShikigami;
  public static boolean spawnSootball;
  public static boolean spawnUshi;
  public static boolean spawnYubaba;
  public static boolean spawnYuko;
  public static boolean spawnZenbia;
  
  public static int rateminAkiichiro;
  public static int ratemaxAkiichiro;
  public static int maxperchunkAkiichiro;
  
  public static int rateminBoh;
  public static int ratemaxBoh;
  public static int maxperchunkBoh;
  
  public static boolean spawnDragon = true;
  public static boolean spawnUUID = true;
  public static boolean isDonator;
  public static DimensionType getDimensionID;
  public static boolean dungeonLoot;

  
  public static void init(File location)
  {
	    File newFile = new File(location + "/Spirited Away" + "/Entites.cfg");
	    try
	    {
	      if ((!newFile.exists()) && (!newFile.createNewFile())) {
	        throw new IOException("Couldn't create the file...");
	      }
	    }
	    catch (IOException e)
	    {
	      System.out.println("Could not create the configuration file for Spirited Away. Reason: ");
	      
	      e.printStackTrace();
	    } 
	  
	Configuration SAConfig = new Configuration(newFile);
	SALocation = location;
	SAConfig.load();
	    
	
    //SAConfig.addCustomCategoryComment("Blocks Configuration", "Spirited Away Blocks. Change value to false to disable selected block.");
    //SAConfig.addCustomCategoryComment("Items Configuration", "Spirited Away Items. Change value to false to disable selected item.");
    
	SAConfig.addCustomCategoryComment("Mobs Configuration", "Here you can Enable or Disable any Spirited Away mob entity. Change value to either true or false.");
    	
	spawnAkiichiro = SAConfig.get("~Akiichiro Ogino~", "~canspawn~", true).getBoolean(true);
    maxperchunkAkiichiro = SAConfig.get("~Akiichiro Ogino~", "~maxperchunk~", 3).getInt();
    rateminAkiichiro = SAConfig.get("~Akiichiro Ogino~", "~maxspawn~", 3).getInt();
    ratemaxAkiichiro = SAConfig.get("~Akiichiro Ogino~", "~minspawn~", 3).getInt();
    
    spawnBoh = SAConfig.get("Mobs Configuration", "~Boh~", true).getBoolean(true);
    spawnChihiro = SAConfig.get("Mobs Configuration", "~Chihiro Ogino~", true).getBoolean(true);
    spawnFrogman = SAConfig.get("Mobs Configuration", "~Frogman~", true).getBoolean(true);
    //TODO: Change
    spawnHakuHuman = SAConfig.get("Mobs Configuration", "~Haku Human~", true).getBoolean(true);
    
    spawnKamaji = SAConfig.get("Mobs Configuration", "~Kamaji~", true).getBoolean(true);
    spawnKashira = SAConfig.get("Mobs Configuration", "~Kashira~", true).getBoolean(true);
    spawnKasuga = SAConfig.get("Mobs Configuration", "~Kasuga~", true).getBoolean(true);    
    spawnLin = SAConfig.get("Mobs Configuration", "~Lin~", true).getBoolean(true);
    spawnNoFace = SAConfig.get("Mobs Configuration", "~No-Face~", true).getBoolean(true);
    spawnOotori = SAConfig.get("Mobs Configuration", "~Ootori-Sami~", true).getBoolean(true);
    spawnRadish = SAConfig.get("Mobs Configuration", "~Radish~", true).getBoolean(true);
    spawnShikigami = SAConfig.get("Mobs Configuration", "~Shikigami~", true).getBoolean(true); 
    spawnSootball = SAConfig.get("Mobs Configuration", "~Sootball~", true).getBoolean(true);
    spawnUshi = SAConfig.get("Mobs Configuration", "~Ushi~", true).getBoolean(true);
    spawnYubaba = SAConfig.get("Mobs Configuration", "~Yubaba~", true).getBoolean(true);
    spawnYuko = SAConfig.get("Mobs Configuration", "~Yuko Ogino~", true).getBoolean(true);
    spawnZenbia = SAConfig.get("Mobs Configuration", "~Zenbia~", true).getBoolean(true);
    
    //showTitleScreen = SAConfig.get("General", "Show Spirited Away Title Screen", true).getBoolean(true);
  
    SAConfig.save();
  }
  
  public static class MobConfig
  {
    public final String configName;
    private boolean enableSpawn;
    private int minGroupSize;
    private int maxGroupSize;
    private int maxGroupsPerChunk;
    
  
  public MobConfig(String configName, boolean enableSpawn, int minGroupSize, int maxGroupSize, int maxGroupsPerChunk)
  {
    this.configName = configName;
    this.enableSpawn = enableSpawn;
    this.minGroupSize = minGroupSize;
    this.maxGroupSize = maxGroupSize;
    this.maxGroupsPerChunk = maxGroupsPerChunk;
  }
  
  protected void readConfig(Configuration config)
  {
	this.enableSpawn = SAConfig.get(this.configName, "Enable Spawn", true).getBoolean(true);
    this.minGroupSize = SAConfig.get(this.configName, "Minimum Group Size", this.minGroupSize).getInt(this.minGroupSize);
    this.maxGroupSize = SAConfig.get(this.configName, "Maximum Group Size", this.maxGroupSize).getInt(this.maxGroupSize);
    this.maxGroupsPerChunk = SAConfig.get(this.configName, "Average Amount of groups in Area",this.maxGroupsPerChunk).getInt(this.maxGroupsPerChunk);
  }
  
  public int minGroupSize()
  {
    return this.minGroupSize;
  }
  
  public int maxGroupSize()
  {
    return this.maxGroupSize;
  }
  
  public float maxGroupsPerChunk()
  {
    return this.maxGroupsPerChunk;
  }

}
}
