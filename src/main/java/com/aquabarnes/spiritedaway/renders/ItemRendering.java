package com.aquabarnes.spiritedaway.renders;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SAItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemRendering
{
  public static void initialize()
  {
    register(SAItems.pogo_bigger_blue, "record_pogo_bigger_blue");
    register(SAItems.dragon_boy, "record_dragon_boy");
    register(SAItems.dragon_boy, "record_dragon_boy2");
    register(SAItems.one_summers_day, "record_one_summers_day");
    register(SAItems.always_with_me, "record_always_with_me");
  }
  
  public static void register(Item item, int meta, String model)
  {
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(SpiritedAway.modAddress() + model, "inventory"));
  }
  
  public static void register(Item item, String model)
  {
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(SpiritedAway.modAddress() + model, "inventory"));
  }
  
  public static void registerDefinition(Item item, ItemMeshDefinition definition)
  {
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, definition);
  }
  
  public static void registerColor(Item item)
  {
   
  }
  
  public static void registerMeta(Item item, ResourceLocation... model)
  {
    ModelBakery.registerItemVariants(item, model);
  }
}
