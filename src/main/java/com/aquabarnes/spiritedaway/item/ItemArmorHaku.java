package com.aquabarnes.spiritedaway.item;

import java.util.List;


import java.util.UUID;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;
import com.aquabarnes.spiritedaway.init.SAItems;
import com.aquabarnes.spiritedaway.proxy.ClientProxy;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorHaku extends ItemArmor  
{
	
public String armorName;
	
public ItemArmorHaku(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {

  super(SAItems.HAKU, renderIndexIn, equipmentSlotIn);
  this.setCreativeTab(SACreativeTabs.tabSACombat);
  this.setUnlocalizedName(name);
  GameRegistry.registerItem(this, name);
  if (!SpiritedAway.isServer()) {
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("sa:" + name, "inventory"));
  }
}

//TODO:
public Multimap<String, AttributeModifier> getAttributeModifier(EntityEquipmentSlot slot, ItemStack stack) {

	Multimap mods = HashMultimap.create();
	
	if(this == SAItems.CHESTPLATE_HAKU);
		//mods.put(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString(name)))
}
}
