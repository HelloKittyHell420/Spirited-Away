package com.aquabarnes.spiritedaway.world.gen.structure;

import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenZenbiasCottage extends MapGenStructure {

	@Override
	public String getStructureName() {
	
		return "Zenbia's Cottage";
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected StructureStart getStructureStart(int chunkX, int chunkZ) {
		// TODO Auto-generated method stub
		return null;
	}

}
