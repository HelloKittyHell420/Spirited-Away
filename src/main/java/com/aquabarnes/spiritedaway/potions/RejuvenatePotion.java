package com.aquabarnes.spiritedaway.potions;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class RejuvenatePotion extends Potion {

	public RejuvenatePotion() {
		super(false, 0xFF9D00);
		this.hasStatusIcon();	
	}
	
	public static int getIdFromPotion(Potion id) {
		
		return 28;		
	}
	
    public String setPotionName()
    {
        return "Rejuvenate";
    }
}