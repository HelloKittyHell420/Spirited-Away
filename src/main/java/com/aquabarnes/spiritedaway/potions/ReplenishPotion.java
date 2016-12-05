package com.aquabarnes.spiritedaway.potions;

import net.minecraft.potion.Potion;

public class ReplenishPotion extends Potion {

public ReplenishPotion(boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		this.registerPotions();
		
	}
}