package com.aquabarnes.spiritedaway.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraftforge.fml.client.FMLClientHandler;

public class EffectHandler {

	  public static void spawnParticle(String particleID, Vector3 position, Vector3 motion, Object... otherInfo)
	  {
	    Minecraft mc = FMLClientHandler.instance().getClient();
	    if ((mc != null) && (mc.field_71451_h != null) && (mc.field_71452_i != null))
	    {
	      double dX = mc.field_71451_h.field_70165_t - position.x;
	      double dY = mc.field_71451_h.field_70163_u - position.y;
	      double dZ = mc.field_71451_h.field_70161_v - position.z;
	      EntityFX particle = null;
	      double viewDistance = 64.0D;
	      if (particleID.equals("whiteSmokeIdle")) {
	        particle = new EntityFXLaunchSmoke(mc.field_71441_e, position, motion, 1.0F, false);
	      } else if (particleID.equals("whiteSmokeLaunched")) {
	      }
	      if (particle != null)
	      {
	        particle.field_70169_q = particle.field_70165_t;
	        particle.field_70167_r = particle.field_70163_u;
	        particle.field_70166_s = particle.field_70161_v;
	        mc.field_71452_i.func_78873_a(particle);
	      }
	    }
	  }
	}