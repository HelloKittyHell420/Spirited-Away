package com.aquabarnes.spiritedaway.init;

import java.lang.reflect.Field;



import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.block.BlockSlab;
import com.aquabarnes.spiritedaway.block.BlockStairs;
import com.aquabarnes.spiritedaway.block.SABlockFlower;
import com.aquabarnes.spiritedaway.item.ItemHat;
import com.aquabarnes.spiritedaway.item.ItemWool;
import com.aquabarnes.spiritedaway.itemblock.BlockBowl;
import com.aquabarnes.spiritedaway.itemblock.BlockClassic;
import com.aquabarnes.spiritedaway.itemblock.BlockPlanks;
import com.aquabarnes.spiritedaway.itemblock.BlockSapling;
import com.aquabarnes.spiritedaway.itemblock.BlockSkull;
import com.aquabarnes.spiritedaway.itemblock.BlockWool;
import com.aquabarnes.spiritedaway.itemblock.ItemBlockSkull;
import com.aquabarnes.spiritedaway.proxy.CommonProxy;
import com.aquabarnes.spiritedaway.enums.EnumPlankTypes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SAItemBlocks { 
	
	public static Block CROPS;
	
	public static Block STAIRS;
	
	public static Block BOWLS;
	public static Block BEDS; 
	public static Block STONE;
	public static Block PLANKS;
	public static Block LEAVES;
	public static Block CLASSIC_WOOL;
	public static Block CLASSIC_BLOCKS;

	public static BlockSlab SLAB_HALF;
	public static BlockSlab SLAB_DOUBLE;
	
	public static Block SKULL;
	public static Block WOOL;
	public static Block SAPLING;
	
    //public static Block FLOWER_ROSE;
    //public static Block FLOWER_KONJAC;
    //public static Block FLOWER_KIUSIANUS;
	
	//TODO: SKULLS/SLABS/STAIRS/LEAVES/STONE/BEDS/WOOL/CROPS
	
    public static void init() {
    	register(); 
    }

	public static void register() { 
			
		//SLAB_HALF = new BlockSlab("slab", false, Material.rock);
		//SLAB_DOUBLE = new BlockSlab("slab", true, Material.rock);
		
		//TODO:Coloured Bowls - Types of interiors Rice/RiceAndChicken/JapeneseFood 
		
		BOWLS = new BlockBowl("bowl");
		//SKULL = new BlockSkull(); 	
		//SAPLING = new BlockSapling("sapling");
		PLANKS = new BlockPlanks("planks"); 
		//CLASSIC_WOOL = new BlockWool("classic_wool");	
		//CLASSIC_BLOCKS = new BlockClassic("classic");
		
		//STAIRS = new BlockStairs("stairs");
						
	} 
	
	public static void registerRenders() {
	    
		  	registerRender(SAItemBlocks.PLANKS, 0, "planks_sakura");
		  	registerRender(SAItemBlocks.PLANKS, 1, "planks_wisteria");
		  	registerRender(SAItemBlocks.PLANKS, 2, "planks_acer_palmatum");
		  	registerRender(SAItemBlocks.PLANKS, 3, "planks_winter_sweet");
		  	
		  	registerRender(SAItemBlocks.SAPLING, 0, "sapling_sakura");
		  	registerRender(SAItemBlocks.SAPLING, 1, "sapling_wisteria");
		  	registerRender(SAItemBlocks.SAPLING, 2, "sapling_acer_palmatum");
		  	registerRender(SAItemBlocks.SAPLING, 3, "sapling_winter_sweet");
		  	
		  	registerRender(SAItemBlocks.CLASSIC_WOOL, 0, "classic_wool");
		  	
		  	registerRender(SAItemBlocks.BOWLS, 0, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 1, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 2, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 3, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 4, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 5, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 6, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 7, "bowl");
		  	registerRender(SAItemBlocks.BOWLS, 8, "bowl");
		  		
	 }
	
	public static void registerRender(Block block, int meta, String file) {
		    
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation("sa" + ":" + file, "inventory"));
	}
	 
}

