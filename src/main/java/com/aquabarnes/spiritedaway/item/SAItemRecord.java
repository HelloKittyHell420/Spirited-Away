package com.aquabarnes.spiritedaway.item;

import java.util.Map;


import com.aquabarnes.spiritedaway.SpiritedAway;
import com.google.common.collect.Maps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SAItemRecord extends ItemRecord {
	
  public String artistName;
  public String songName;
  
  public SAItemRecord(String s, SoundEvent event, String artist, String song)
  {
    super(s, event);
    this.artistName = artist;
    this.songName = song;
  }
  
  public String func_150927_i()
  {
    return this.artistName + " - " + this.songName;
  }
  
  public ResourceLocation getRecordResource(String name)
  {
    return new ResourceLocation("sa", name);
  }
}
