package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.SpiritedAway;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SASoundEvents {

public static SoundEvent entity_sootball_death;
public static SoundEvent entity_sootball_hurt;
public static SoundEvent entity_sootball_loop;

//public static final SoundEvent record_ = new SoundEvent(AetherCore.getResource("records."));
//public static final SoundEvent record_ = new SoundEvent(AetherCore.getResource("records."));
//public static final SoundEvent record_ = new SoundEvent(AetherCore.getResource("records."));
//public static final SoundEvent record_ = new SoundEvent(AetherCore.getResource("records."));

public static final SoundEvent entity_sootball_ambient = new SoundEvent(SpiritedAway.getResource("mob.generic.wings.flap"));

public static void init()
{
	registerSound("entity.sootball.ambient", entity_sootball_ambient);
//entity_sootball_death = registerSound("entity.sootball.death");
//entity_sootball_hurt = registerSound("entity.sootball.hurt");
//entity_sootball_loop = registerSound("entity.sootball.loop");

}

private static void registerSound(String resource, SoundEvent event)
{
  GameRegistry.register(event, SpiritedAway.getResource(resource));
}
}
