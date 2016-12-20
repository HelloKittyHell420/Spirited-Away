package com.aquabarnes.spiritedaway.init;

import java.lang.reflect.Field;




import com.aquabarnes.spiritedaway.SpiritedAway;
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
	
	public static Block bowls;
	public static Block stone;
	public static Block planks;
	public static Block leaves;
	public static Block skulls;
	public static Block saplings;
	
    //public static Block FLOWER_ROSE;
    //public static Block FLOWER_KONJAC;
    //public static Block FLOWER_KIUSIANUS;
	
	//TODO: SKULLS/SLABS/STAIRS/LEAVES/STONE/BEDS/WOOL/CROPS
	
    public static void initialization()
    {
		//TODO:Coloured Bowls - Types of interiors Rice/RiceAndChicken/JapeneseFood 
		
		bowls = new BlockBowl("bowl");
		//SKULL = new BlockSkull(); 	
		//SAPLING = new BlockSapling("sapling");
		planks = new BlockPlanks("planks"); 
		//CLASSIC_WOOL = new BlockWool("classic_wool");	
		//CLASSIC_BLOCKS = new BlockClassic("classic");
	} 
 
}

