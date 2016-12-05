package com.aquabarnes.spiritedaway.potions;

import com.aquabarnes.spiritedaway.SpiritedAway;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameData;

public class SAPotions {
	 
	public static Potion REJUVENATE;
	public static Potion REPLENISH;
	public static Potion RAINBOW;
	
    public static void init() {
    	registerPotions();
    	register();
    }

    private static void register() {
		// TODO Auto-generated method stub
		
	}

	public static void registerPotions()
    {
		REJUVENATE = new RejuvenatePotion().setPotionName("Rejuvenate").setRegistryName("Rejuvenate");
		//GameData.getPotionRegistry(28, new ResourceLocation("speed"), (new Potion(false, 8171462)).setPotionName("effect.moveSpeed").registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2).func_188413_j());
		//REPLENISH = new ReplenishPotion(false, 14393875).setPotionName("Replenish");
		//RAINBOW = new RainbowPotion(false, 14393875).setPotionName("Rainbow"); //TODO:Makes screen go funny /OP based Effect 
	}
}
