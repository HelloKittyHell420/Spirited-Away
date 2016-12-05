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

	private static final Map<SoundEvent, ItemRecord> RECORDS = Maps.<SoundEvent, ItemRecord>newHashMap();
	private static SoundEvent sound;
	
	public static ResourceLocation RECORD_1_RESOURCE = new ResourceLocation("sa", "shuffling");
	
	  public SAItemRecord(String name)
	  {
		super(name, sound);
		this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.tabMisc);
        if (!SpiritedAway.isServer()) {
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("sa:" + name, "inventory"));
          }
        }
	
	  public ResourceLocation getRecordResource(String name)
	  {
	    return RECORD_1_RESOURCE;
	  }
	}

