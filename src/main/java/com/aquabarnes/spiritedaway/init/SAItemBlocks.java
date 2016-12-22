package com.aquabarnes.spiritedaway.init;

import java.lang.reflect.Field;





import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.block.BlockSlabs;
import com.aquabarnes.spiritedaway.block.SABlockFlower;
import com.aquabarnes.spiritedaway.item.ItemHat;
import com.aquabarnes.spiritedaway.item.ItemWool;
import com.aquabarnes.spiritedaway.itemblock.BlockBowl;
import com.aquabarnes.spiritedaway.itemblock.BlockClassic;
import com.aquabarnes.spiritedaway.itemblock.BlockPlanks;
import com.aquabarnes.spiritedaway.itemblock.BlockSapling;
import com.aquabarnes.spiritedaway.itemblock.BlockSkull;
import com.aquabarnes.spiritedaway.itemblock.ItemBlockSkull;
import com.aquabarnes.spiritedaway.itemblock.ItemSlabs;
import com.aquabarnes.spiritedaway.proxy.CommonProxy;
import com.aquabarnes.spiritedaway.enums.EnumPlankTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
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
	
    public static Block sakura_double_slab;
    public static Block wisteria_double_slab;
    public static Block acer_palmatum_double_slab;
    public static Block winter_sweet_double_slab;
    
    public static Block sakura_slab;
    public static Block wisteria_slab;
    public static Block acer_palmatum_slab;
    public static Block winter_sweet_slab;
    
	
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

		sakura_double_slab = registerUBlock("sakura_double_slab", new BlockSlabs("sakura_double_slab", true, Material.WOOD).setHardness(2.0F).setResistance(5.0F));
		wisteria_double_slab = registerUBlock("wisteria_double_slab", new BlockSlabs("wisteria_double_slab", true, Material.ROCK).setHardness(2.0F).setResistance(10.0F));
		acer_palmatum_double_slab = registerUBlock("acer_palmatum_double_slab", new BlockSlabs("acer_palmatum_double_slab", true, Material.ROCK).setHardness(2.0F).setResistance(10.0F));
		winter_sweet_double_slab = registerUBlock("winter_sweet_double_slab", new BlockSlabs("winter_sweet_double_slab", true, Material.ROCK).setHardness(2.0F).setResistance(10.0F));
			
		sakura_slab = registerSlab("sakura_slab", new BlockSlabs("sakura_slab", false, Material.WOOD).setHardness(2.0F).setResistance(5.0F), sakura_double_slab);
		wisteria_slab = registerSlab("wisteria_slab", new BlockSlabs("wisteria_slab", false, Material.ROCK).setHardness(2.0F).setResistance(10.0F), wisteria_double_slab);
		acer_palmatum_slab = registerSlab("acer_palmatum_slab", new BlockSlabs("acer_palmatum_slab", false, Material.ROCK).setHardness(2.0F).setResistance(10.0F), acer_palmatum_double_slab);
		winter_sweet_slab = registerSlab("winter_sweet_slab", new BlockSlabs("winter_sweet_slab", false, Material.ROCK).setHardness(2.0F).setResistance(10.0F), winter_sweet_double_slab);
	}


	public static Block registerSlab(String name, Block slab1, Block slab2)
	{
		//slab1.setCreativeTab(SACreativeTabs.blocks);

		GameRegistry.register(slab1.setRegistryName(SpiritedAway.getResource(name)));
		GameRegistry.register(new ItemSlabs(slab1, (BlockSlab) slab1, (BlockSlab) slab2).setRegistryName(SpiritedAway.getResource(name)));

		return slab1;
	}
	
	public static Block registerUBlock(String name, Block block)
	{
		block.setUnlocalizedName(name);

		GameRegistry.register(block.setRegistryName(SpiritedAway.getResource(name)));
		GameRegistry.register(new ItemBlock(block).setRegistryName(SpiritedAway.getResource(name)));

		return block;
	}
 
}

