package com.aquabarnes.spiritedaway.utils;

import java.util.HashMap;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FootprintRegistry 
{
  private ExternalTextureManager externalTextureManager;
  public static HashMap<String, ExternalTexture> trailMap = new HashMap();
  
  public FootprintRegistry()
  {
    this.externalTextureManager = ExternalTextureManager.getInstance();
    
    TrailsVersionChecker trailsVersionChecker = TrailsVersionChecker.getInstance();
    
    trailMap.put("dev_trail", this.externalTextureManager.retrieveExternalTexture("https://raw.githubusercontent.com/Glitchfiend/BiomesOPlenty/master/trails/dev_trail.png", "trails", trailsVersionChecker));
    trailMap.put("donator_trail", this.externalTextureManager.retrieveExternalTexture("https://raw.githubusercontent.com/Glitchfiend/BiomesOPlenty/master/trails/donator_trail.png", "trails", trailsVersionChecker));
    trailMap.put("helper_trail", this.externalTextureManager.retrieveExternalTexture("https://raw.githubusercontent.com/Glitchfiend/BiomesOPlenty/master/trails/helper_trail.png", "trails", trailsVersionChecker));
  }
  
  @SubscribeEvent
  public void onTextureStitch(TextureStitchEvent event)
  {
    if (event.map.func_130086_a() == 1)
    {
      event.map.setTextureEntry("biomesoplenty:dev_trail", (TextureAtlasSprite)trailMap.get("dev_trail"));
      event.map.setTextureEntry("biomesoplenty:donator_trail", (TextureAtlasSprite)trailMap.get("donator_trail"));
      event.map.setTextureEntry("biomesoplenty:helper_trail", (TextureAtlasSprite)trailMap.get("helper_trail"));
    }
  }
}
