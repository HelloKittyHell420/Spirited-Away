package com.aquabarnes.spiritedaway.entity;

import net.minecraft.util.text.TextComponentTranslation;

public enum ChihiroType
	{
	    NORMAL("Zombie", false),
	    WORKER("Zombie", true);
	
	    private boolean field_190163_h;
		private final TextComponentTranslation field_190164_i;

		private ChihiroType(String p_i47152_3_, boolean p_i47152_4_)
		{	
			this.field_190163_h = p_i47152_4_;
			this.field_190164_i = new TextComponentTranslation("entity." + p_i47152_3_ + ".name", new Object[0]);
}
	}
