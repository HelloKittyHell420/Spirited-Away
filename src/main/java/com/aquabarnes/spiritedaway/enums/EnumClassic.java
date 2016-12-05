package com.aquabarnes.spiritedaway.enums;

import net.minecraft.util.IStringSerializable;

public enum EnumClassic implements IStringSerializable {
	
	WHITE(0, "white"),
	ORANGE(1, "orange"),
	MAGENTA(2, "magenta"),
	LIGHT_BLUE(3, "light_blue"),
	YELLOW(4, "yellow"),
	LIME(5, "lime"),
	PINK(6, "pink");
	
	private final int meta;
    private final String name;
    private static final EnumClassic[] META_LOOKUP;
    
    private EnumClassic(int meta, String name)
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

    public static EnumClassic byMetadata(int meta)
    {
      if ((meta < 0) || (meta >= META_LOOKUP.length)) {
        meta = 0;
      }
      return META_LOOKUP[meta];
    }
    
    static
    {
      META_LOOKUP = new EnumClassic[values().length];
      
      EnumClassic[] var0 = values();
      int var1 = var0.length;
      for (int var2 = 0; var2 < var1; var2++)
      {
    	EnumClassic var3 = var0[var2];
        META_LOOKUP[var3.getMetadata()] = var3;
      }
    }


}

