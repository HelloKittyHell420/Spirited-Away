package com.aquabarnes.spiritedaway.init;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAWorldGenerator implements IWorldGenerator
{
private WorldGenerator GEN_COPPER_ORE;

public static void init() {
	  
	registerWorldGenerator();
}

public SAWorldGenerator()
{
  this.GEN_COPPER_ORE = new WorldGenMinable(SABlocks.BASIN.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.iron_ore));
}

public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
{
  switch (world.provider.getDimension())
  {
  case 0: 
    runGenerator(this.GEN_COPPER_ORE, world, random, chunkX, chunkZ, 16, 12, 64);
    break;
  case -1: 
    break;
  }
}

private void runGenerator(WorldGenerator generator, World world, Random random, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
{
  if ((minHeight < 0) || (maxHeight > 256) || (minHeight > maxHeight)) {
    throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
  }
  int heightDiff = maxHeight - minHeight + 1;
  for (int i = 0; i < chancesToSpawn; i++)
  {
    int x = chunk_X * 16 + random.nextInt(16);
    int y = minHeight + random.nextInt(heightDiff);
    int z = chunk_Z * 16 + random.nextInt(16);
    generator.generate(world, random, new BlockPos(x, y, z));
  }
  }
  
 private static void registerWorldGenerator() {
	
	 GameRegistry.registerWorldGenerator(new SAWorldGenerator(), 0);
	
}
}
