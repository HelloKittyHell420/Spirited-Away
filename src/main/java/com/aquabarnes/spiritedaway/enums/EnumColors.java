package com.aquabarnes.spiritedaway.enums;

import net.minecraft.block.material.MapColor;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;

public enum EnumColors implements IStringSerializable {
	
	WHITE(0, "white"),
	ORANGE(1, "orange"),
	MAGENTA(2, "magenta"),
	LIGHT_BLUE(3, "light_blue"),
	YELLOW(4, "yellow"),
	LIME(5, "lime"),
	PINK(6, "pink"),
	GRAY(7, "gray"),
	SILVER(8, "silver"),
    CYAN(9, "cyan"),
    PURPLE(10, "purple"),
    BLUE(11, "blue"),
    BROWN(12, "brown"),
    GREEN(13, "green"),
    RED(14, "red"),
    BLACK(15, "black");
	
	private final int meta;
    private final String name;
    private static final EnumColors[] META_LOOKUP;
    
    private EnumColors(int meta, String name)
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

    public static EnumColors byMetadata(int meta)
    {
      if ((meta < 0) || (meta >= META_LOOKUP.length)) {
        meta = 0;
      }
      return META_LOOKUP[meta];
    }
    
    static
    {
      META_LOOKUP = new EnumColors[values().length];
      
      EnumColors[] var0 = values();
      int var1 = var0.length;
      for (int var2 = 0; var2 < var1; var2++)
      {
    	EnumColors var3 = var0[var2];
        META_LOOKUP[var3.getMetadata()] = var3;
      }
    }


}

