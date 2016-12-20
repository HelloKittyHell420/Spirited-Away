package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.SpiritedAway;

import com.aquabarnes.spiritedaway.client.model.ModelShikigami;
import com.aquabarnes.spiritedaway.client.renderer.entity.RenderShikigami;
import com.aquabarnes.spiritedaway.entity.EntityAkiichiro;
import com.aquabarnes.spiritedaway.entity.EntityBoh;
import com.aquabarnes.spiritedaway.entity.EntityChihiro;
import com.aquabarnes.spiritedaway.entity.EntityFrogman;
import com.aquabarnes.spiritedaway.entity.EntityHakuDragon;
import com.aquabarnes.spiritedaway.entity.EntityHakuHuman;
import com.aquabarnes.spiritedaway.entity.EntityKamaji;
import com.aquabarnes.spiritedaway.entity.EntityKashira;
import com.aquabarnes.spiritedaway.entity.EntityKasuga;
import com.aquabarnes.spiritedaway.entity.EntityLin;
import com.aquabarnes.spiritedaway.entity.EntityNoFace;
import com.aquabarnes.spiritedaway.entity.EntityOotori;
import com.aquabarnes.spiritedaway.entity.EntityPigMumDad;
import com.aquabarnes.spiritedaway.entity.EntityRadish;
import com.aquabarnes.spiritedaway.entity.EntityShikigami;
import com.aquabarnes.spiritedaway.entity.EntitySootball;
import com.aquabarnes.spiritedaway.entity.EntityTrain;
import com.aquabarnes.spiritedaway.entity.EntityUUIDSkin;
import com.aquabarnes.spiritedaway.entity.EntityUshi;
import com.aquabarnes.spiritedaway.entity.EntityYubaba;
import com.aquabarnes.spiritedaway.entity.EntityYuko;
import com.aquabarnes.spiritedaway.entity.EntityZenbia;
import com.aquabarnes.spiritedaway.handler.SAConfiguration;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class SAEntities {

public static void initialization() {

	registerMobs(); 
	registerProjectiles();
}

	//TODO: Pig Versions of Akiichiro and Yuko. Akiichiro and Yuko will be able to pickup/given food at night time only this will course them to change to pig form.
	//TODO: Hopping Lamp Achievement if you name him Garry OMG :D
	
	private static void registerProjectiles() {
	
		//TODO: Mud??
		//EntityRegistry.registerModEntity(EntityDart.class, "Dart", SAConfigurationIDs.entityDartID, SpiritedAway.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityTrain.class, "Train", 29, SpiritedAway.instance, 80, 3, true);

	}

	private static void registerMobs() {

		if (SAConfiguration.spawnUUID)	
		    {
		     //EntityRegistry.registerModEntity(EntityUUIDSkin.class, "UUID", 20, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
		     //EntityRegistry.addSpawn(EntityUUIDSkin.class, 5, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
		    }
		if (SAConfiguration.spawnAkiichiro)
			{
			 EntityRegistry.registerModEntity(EntityAkiichiro.class, "Akiichiro", 0, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 EntityRegistry.addSpawn(EntityAkiichiro.class, (int)SAConfiguration.maxperchunkAkiichiro, (int)SAConfiguration.rateminAkiichiro, (int)SAConfiguration.rateminAkiichiro, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
			}
		if (SAConfiguration.spawnBoh)
			{
			 EntityRegistry.registerModEntity(EntityBoh.class, "Boh", 1, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 EntityRegistry.addSpawn(EntityBoh.class, 5, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
			}
		if (SAConfiguration.spawnChihiro)
			{
			 //EntityRegistry.registerModEntity(EntityChihiro.class, "Chihiro", 2, SpiritedAway.instance, 64, 1, true, 8306542, 15771042);
			 //EntityRegistry.addSpawn(EntityChihiro.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
	    if (SAConfiguration.spawnFrogman)
			{
			 //EntityRegistry.registerModEntity(EntityFrogman.class, "Frogman", 3, SpiritedAway.instance, 64, 1, true, 15198183, 7375001);
			 //EntityRegistry.addSpawn(EntityFrogman.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnHakuHuman)
			{
			 //EntityRegistry.registerModEntity(EntityHakuHuman.class, "HakuHuman", 4, SpiritedAway.instance, 64, 1, true, 15198183, 7375001);
			 //EntityRegistry.addSpawn(EntityHakuHuman.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnKamaji)
			{
			 //EntityRegistry.registerModEntity(EntityKamaji.class, "Kamaji", 5, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 //EntityRegistry.addSpawn(EntityKamaji.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnKashira)
			{
			 //EntityRegistry.registerModEntity(EntityKashira.class, "Kashira", 6, SpiritedAway.instance, 64, 1, true, 8306542, 5651507);
			 //EntityRegistry.addSpawn(EntityKashira.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
	    if (SAConfiguration.spawnKasuga)
			{
			 //EntityRegistry.registerModEntity(EntityKasuga.class, "Kasuga", 7, SpiritedAway.instance, 64, 1, true, 10489616, 16777215);
			 //EntityRegistry.addSpawn(EntityKasuga.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnLin)
			{
			 //EntityRegistry.registerModEntity(EntityLin.class, "Lin", 8, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 //EntityRegistry.addSpawn(EntityLin.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnNoFace)
			{
			 //EntityRegistry.registerModEntity(EntityNoFace.class, "NoFace", 9, SpiritedAway.instance, 64, 1, true, 0, 16777215);
			 //EntityRegistry.addSpawn(EntityNoFace.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnOotori)
			{
			 //EntityRegistry.registerModEntity(EntityOotori.class, "Ootori", 10, SpiritedAway.instance, 64, 1, true, 15720061, 15826224);
			 //EntityRegistry.addSpawn(EntityOotori.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnRadish)
			{
			 //EntityRegistry.registerModEntity(EntityRadish.class, "Radish", 11, SpiritedAway.instance, 64, 1, true, 15198183, 16711680);
			 //EntityRegistry.addSpawn(EntityRadish.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnShikigami)
		    {
			 EntityRegistry.registerModEntity(EntityShikigami.class, "Shikigami", 12, SpiritedAway.instance, 64, 1, true, 16777215, 15198183);
			 EntityRegistry.addSpawn(EntityShikigami.class, 50, 4, 4, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
		    }
		if (SAConfiguration.spawnSootball)
			{
			 EntityRegistry.registerModEntity(EntitySootball.class, "Sootball", 13, SpiritedAway.instance, 64, 1, true, 5651507, 12623485);
			 EntityRegistry.addSpawn(EntitySootball.class, 52, 6, 7, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnUshi)
			{
			 //EntityRegistry.registerModEntity(EntityUshi.class, "Ushi", 14, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 //EntityRegistry.addSpawn(EntityUshi.class, 52, 6, 7, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnYubaba)
			{
			 //EntityRegistry.registerModEntity(EntityYubaba.class, "Yubaba", 15, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 //EntityRegistry.addSpawn(EntityYubaba.class, 52, 6, 7, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnYuko)
			{
			 //EntityRegistry.registerModEntity(EntityYuko.class, "Yuko", 16, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 //EntityRegistry.addSpawn(EntityYuko.class, 52, 6, 7, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
		if (SAConfiguration.spawnZenbia)
			{
			 //EntityRegistry.registerModEntity(EntityZenbia.class, "Zenbia", 17, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 //EntityRegistry.addSpawn(EntityZenbia.class, 52, 6, 7, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			}
			
			
			if (SAConfiguration.spawnDragon)
			{
			 //EntityRegistry.registerModEntity(EntityHakuDragon.class, "HakuDragon", 18, SpiritedAway.instance, 64, 1, true, 0, 0);
			 //EntityRegistry.addSpawn(EntityDragon.class, 52, 6, 7, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			{
			if (SAConfiguration.spawnDragon)
			{
			 //EntityRegistry.registerModEntity(EntityPigMumDad.class, "PigMumDad", 19, SpiritedAway.instance, 64, 1, true, 10489616, 10489616);
			 //EntityRegistry.addSpawn(EntityPigMumDad.class, 52, 6, 7, EnumCreatureType.AMBIENT, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
			
			}
	

} 
}
}
}
	

