package com.aquabarnes.spiritedaway.world;

import com.aquabarnes.spiritedaway.block.biomes.SABiomes;
import com.aquabarnes.spiritedaway.init.SADimension;
import com.aquabarnes.spiritedaway.world.gen.ChunkProvider;

import net.minecraft.init.Biomes;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SAWorldProvider extends WorldProvider
{ 
	
	public DimensionType getDimensionType()
    {
        return SADimension.SpiritedAway;
	}
	
	public void createBiomeProvider()
	{
		this.worldChunkMgr = new BiomeProviderSingle(Biomes.beach);
	}
	
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkProviderEnd(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
    }
    
    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return false;
    }
    
    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.5F;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
    	//TODO:
        return true;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return false;
    }

    public String getDepartMessage()
    {
      return "Leaving the Spirit Realm";
    }
    
    public String getWelcomeMessage()
    {
      return "Entering the Spirit Realm";
    }
    
    public String getSunTexture()
    {
      return "/sa.twinsuns.png";
    }
    
    public String name()
    {
      return "The Spirit Realm";
    }
    
    public String getSaveFolder()
    {
      return "DIM-SpiritedAway";
	}
    
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z) 
    {
    	return false;
    }
    
}