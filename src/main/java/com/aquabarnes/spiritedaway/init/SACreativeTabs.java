package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.creativetab.SABlocksTab;
import com.aquabarnes.spiritedaway.creativetab.SACombatTab;
import com.aquabarnes.spiritedaway.creativetab.SADecorationsTab;
import com.aquabarnes.spiritedaway.creativetab.SAFoodTab;
import com.aquabarnes.spiritedaway.creativetab.SAMaterialsTab;
import com.aquabarnes.spiritedaway.creativetab.SAToolsTab;
import com.aquabarnes.spiritedaway.creativetab.SATransportationTab;
import com.aquabarnes.spiritedaway.handler.SAConfiguration;

import net.minecraft.creativetab.CreativeTabs;

public class SACreativeTabs {
	
	public static CreativeTabs BUILDING_BLOCKS;
	public static CreativeTabs DECORATIONS; 
	public static CreativeTabs TRANSPORTATION;
	public static CreativeTabs FOOD;
	public static CreativeTabs TOOLS;
	public static CreativeTabs COMBAT;
	public static CreativeTabs MATERIALS;

	public static void initialization() {
		
		registerCreativeTabs();
	}
	
	private static void registerCreativeTabs() {
		
		if (SAConfiguration.enableCreativeTab) {
			
			BUILDING_BLOCKS = new SABlocksTab(CreativeTabs.CREATIVE_TAB_ARRAY.length, "SABlocksTab");
			DECORATIONS = new SADecorationsTab(CreativeTabs.CREATIVE_TAB_ARRAY.length, "SADecorationsTab");
			TRANSPORTATION = new SATransportationTab(CreativeTabs.CREATIVE_TAB_ARRAY.length, "SATransportationTab");
			FOOD = new SAFoodTab(CreativeTabs.CREATIVE_TAB_ARRAY.length, "SAFoodTab");
			TOOLS = new SAToolsTab(CreativeTabs.CREATIVE_TAB_ARRAY.length, "SAToolsTab");
	        COMBAT = new SACombatTab(CreativeTabs.CREATIVE_TAB_ARRAY.length, "SACombatTab");
	        MATERIALS = new SAMaterialsTab(CreativeTabs.CREATIVE_TAB_ARRAY.length, "SAMaterialsTab");
		}

	}
} 
