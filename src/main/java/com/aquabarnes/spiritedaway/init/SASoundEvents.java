package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.SpiritedAway;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SASoundEvents {

public static SoundEvent record_;
public static SoundEvent dragon_boy;
public static SoundEvent one_summers_day;
public static SoundEvent always_with_me;

public static SoundEvent sootball_living;
public static SoundEvent sootball_hurt;

public static void initialization()
{
  record_ = register(SpiritedAway.getResource("records.sa"));
  dragon_boy = register(SpiritedAway.getResource("records.dragon_boy"));
  one_summers_day = register(SpiritedAway.getResource("records.one_summers_day"));
  always_with_me = register(SpiritedAway.getResource("records.always_with_me"));
  
  sootball_living = register(SpiritedAway.getResource("mob.sootball_living"));
  sootball_hurt = register(SpiritedAway.getResource("mob.sootball_hurt"));
}

public static SoundEvent register(ResourceLocation location)
{
  SoundEvent sound = new SoundEvent(location);
  
  return (SoundEvent)GameRegistry.register(sound, location);
}
}