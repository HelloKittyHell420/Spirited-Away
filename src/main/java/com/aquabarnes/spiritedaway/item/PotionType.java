package com.aquabarnes.spiritedaway.item;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;

public class PotionType {

public static void registerPotionTypes()
{
    registerPotionType("empty", new PotionType(new PotionEffect[0]));
    registerPotionType("water", new PotionType(new PotionEffect[0]));
    registerPotionType("mundane", new PotionType(new PotionEffect[0]));
}