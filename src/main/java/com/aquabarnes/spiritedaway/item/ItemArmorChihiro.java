package com.aquabarnes.spiritedaway.item;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SACreativeTabs;
import com.aquabarnes.spiritedaway.init.SAItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemArmorChihiro extends ItemArmor  
{
	
public String armorName;
	
public ItemArmorChihiro(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {

  super(SAItems.CHIHIRO, renderIndexIn, equipmentSlotIn);
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
	
	if(this == SAItems.CHESTPLATE_CHIHIRO);
		//mods.put(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString(name)))
}
}
