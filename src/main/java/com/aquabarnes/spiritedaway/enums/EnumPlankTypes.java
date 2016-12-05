package com.aquabarnes.spiritedaway.enums;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum EnumPlankTypes implements IStringSerializable
{
    SAKURA(0, "sakura"),
	WISTERIA(1, "wisteria"),
	ACERPALMATUM(2, "acer_palmatum"),
	WINTERSWEET(3, "winter_sweet");
	
    private final int meta;
    private final String name;
    private static final EnumPlankTypes[] META_LOOKUP;
    
    private EnumPlankTypes(int meta, String name)
    {
      this.name = name;
      this.meta = meta;
    }
    
    public String getName() 
    {
      return this.name;
    }
    
    public int getMetadata()
    {
      return this.meta; 
    }
    
    @Override
    public String toString()
    {
      return this.name;
    }

    public static EnumPlankTypes byMetadata(int meta)
    {
      if ((meta < 0) || (meta >= META_LOOKUP.length)) {
        meta = 0;
      }
      return META_LOOKUP[meta];
    }
    
    static
    {
      META_LOOKUP = new EnumPlankTypes[values().length];
      
      EnumPlankTypes[] var0 = values();
      int var1 = var0.length;
      for (int var2 = 0; var2 < var1; var2++)
      {
    	EnumPlankTypes var3 = var0[var2];
        META_LOOKUP[var3.getMetadata()] = var3;
      }
    }


}