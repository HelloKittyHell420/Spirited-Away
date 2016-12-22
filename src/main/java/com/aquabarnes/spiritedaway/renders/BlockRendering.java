package com.aquabarnes.spiritedaway.renders;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.init.SABlocks;
import com.aquabarnes.spiritedaway.init.SAItemBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockRendering {

	  public static void initialize()
	  {
		register(SABlocks.shrine, "shrine");
		
	    register(SABlocks.sakura_fence, "sakura_fence");
	    //register(SABlocks.wisteria_fence, "wisteria_fence");
	    //register(SABlocks.acer_palmatum_fence, "acer_palmatum_fence");
	    //register(SABlocks.winter_sweet_fence, "winter_sweet_fence");
	    
		register(SAItemBlocks.sakura_double_slab, "sakura_double_slab");
		register(SAItemBlocks.wisteria_double_slab, "wisteria_double_slab");
		register(SAItemBlocks.acer_palmatum_double_slab, "acer_palmatum_double_slab");
		register(SAItemBlocks.winter_sweet_double_slab, "winter_sweet_double_slab");

		register(SAItemBlocks.sakura_slab, "sakura_slab");
		register(SAItemBlocks.wisteria_slab, "wisteria_slab");
		register(SAItemBlocks.acer_palmatum_slab, "acer_palmatum_slab");
		register(SAItemBlocks.winter_sweet_slab, "winter_sweet_slab");
	    
	    //registerMetadata(SAItemBlocks.PLANKS, new ResourceLocation[] { SpiritedAway.getResource("leaves"), SpiritedAway.getResource("leaves") });
	    //registerMetadata(SAItemBlocks.LEAVES, new ResourceLocation[] { SpiritedAway.getResource("leaves"), SpiritedAway.getResource("leaves") });
	  }
	  
	  public static void register(Block block, String model)
	  {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(SpiritedAway.modAddress() + model, "inventory"));
	  }
	  
	  public static void register(Block block, ItemMeshDefinition definition)
	  {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), definition);
	  }
	  
	  public static void register(Block block, int meta, String model)
	  {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(SpiritedAway.modAddress() + model, "inventory"));
	  }
	  
	  public static void registerMetadata(Block block, ResourceLocation... model)
	  {
	    ModelBakery.registerItemVariants(Item.getItemFromBlock(block), model);
	  }
}