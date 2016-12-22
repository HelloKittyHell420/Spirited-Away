package com.aquabarnes.spiritedaway.init;

import java.util.ArrayList;
import java.util.Random;

import com.aquabarnes.spiritedaway.proxy.ClientProxy;

import com.aquabarnes.spiritedaway.world.biome.BiomeGenPlains;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SABiomes extends Biome
{

	public SABiomes()
	{
		super(new SABiomeProperties());
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		ArrayList<SpawnListEntry> list = new ArrayList<SpawnListEntry>();

		this.spawnableCaveCreatureList.addAll(list);

        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SAND.getDefaultState();
	}

    public boolean canRain()
    {
    	return false;
    }

    public Biome.TempCategory getTempCategory()
    {
    	return TempCategory.COLD;
    }

    public BiomeDecorator createBiomeDecorator()
    {
		return theBiomeDecorator;
    	//return new AetherBiomeDecorator();
    }

    public WorldGenAbstractTree genBigTreeChance(Random rand)
    {
		return null;
       // return (WorldGenAbstractTree)(rand.nextInt(20) == 0 ? new AetherGenOakTree() : new AetherGenSkyrootTree());
    }

}