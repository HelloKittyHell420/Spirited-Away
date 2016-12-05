package com.aquabarnes.spiritedaway.world;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class SAChunkProvider implements IChunkGenerator {

    private World worldObj;
    private Random random;
    private BiomeGenBase[] biomesForGeneration;
    
	private List<BiomeGenBase.SpawnListEntry> mobs = Lists.newArrayList(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 2, 2));

	@Override
	public Chunk provideChunk(int x, int z) {

		return null;
	}

	@Override
	public void populate(int x, int z) {
	
		
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
	
		return false;
	}

	@Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        // If you want normal creatures appropriate for this biome then uncomment the
        // following two lines:
//        Biome biome = this.worldObj.getBiome(pos);
//        return biome.getSpawnableList(creatureType);

        if (creatureType == EnumCreatureType.MONSTER){
            return mobs;
        }
        return ImmutableList.of();

    }


	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {

		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
	
		
	}

}
