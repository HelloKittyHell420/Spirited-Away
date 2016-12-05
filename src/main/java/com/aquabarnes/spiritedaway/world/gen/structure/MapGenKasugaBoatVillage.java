package com.aquabarnes.spiritedaway.world.gen.structure;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenKasugaBoatVillage extends MapGenStructure {

	public static List<BiomeGenBase> SpawnBiomes = Arrays.<BiomeGenBase>asList(new BiomeGenBase[] {Biomes.plains, Biomes.desert, Biomes.savanna});
	
	private int field_82665_g;
	private int field_82666_h;
	
	@Override
	public String getStructureName() {

		return "Kasuga Boat Village";
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
		
		int i = chunkX;
        int j = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= this.field_82665_g - 1;
        }

        if (chunkZ < 0)
        {
            chunkZ -= this.field_82665_g - 1;
        }

        int k = chunkX / this.field_82665_g;
        int l = chunkZ / this.field_82665_g;
        Random random = this.worldObj.setRandomSeed(k, l, 10387312);
        k = k * this.field_82665_g;
        l = l * this.field_82665_g;
        k = k + random.nextInt(this.field_82665_g - this.field_82666_h);
        l = l + random.nextInt(this.field_82665_g - this.field_82666_h);

        if (i == k && j == l)
        {
            boolean flag = this.worldObj.getBiomeProvider().areBiomesViable(i * 16 + 8, j * 16 + 8, 0, SpawnBiomes);

            if (flag)
            {
                return true;
            }
        }

        return false;
    }

	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		
		return null; //new MapGenVillage.Start(this.worldObj, this.rand, chunkX, chunkZ, this.terrainType);
	}

}
