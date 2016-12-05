package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.SpiritedAway;




import com.aquabarnes.spiritedaway.block.BlockBasin;
import com.aquabarnes.spiritedaway.block.BlockChair;
import com.aquabarnes.spiritedaway.block.BlockChopstick;
import com.aquabarnes.spiritedaway.block.BlockEgg;
import com.aquabarnes.spiritedaway.block.BlockFences;
import com.aquabarnes.spiritedaway.block.BlockFish;
import com.aquabarnes.spiritedaway.block.BlockFurnace;
import com.aquabarnes.spiritedaway.block.BlockGates;
import com.aquabarnes.spiritedaway.block.BlockLamp;
import com.aquabarnes.spiritedaway.block.BlockPressurePlate;
import com.aquabarnes.spiritedaway.block.BlockPressurePlate.Sensitivity;
import com.aquabarnes.spiritedaway.itemblock.BlockSkull;
import com.aquabarnes.spiritedaway.itemblock.BlockWool;
import com.aquabarnes.spiritedaway.block.BlockPump;
import com.aquabarnes.spiritedaway.block.BlockShrine;
import com.aquabarnes.spiritedaway.block.BlockSink;
import com.aquabarnes.spiritedaway.block.BlockSushiPlate;
import com.aquabarnes.spiritedaway.block.BlockTable;
import com.aquabarnes.spiritedaway.block.BlockToliet;
import com.aquabarnes.spiritedaway.block.BlockTorch;
import com.aquabarnes.spiritedaway.block.BlockWisteriaFence;
import com.aquabarnes.spiritedaway.block.BlockWorkbench;

import com.aquabarnes.spiritedaway.block.SABlockDoor;
import com.aquabarnes.spiritedaway.block.SABlockFlower;
import com.aquabarnes.spiritedaway.block.SABlockRice;
import com.aquabarnes.spiritedaway.block.SABlockShoes;
import com.aquabarnes.spiritedaway.tileenitity.TileEntityFurnace;
import com.aquabarnes.spiritedaway.tileenitity.TileEntitySkull;
import com.aquabarnes.spiritedaway.tileenitity.TileEntityWorkbench;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SABlocks { 
	
	//VANILLA
	public static Block CRAFTING_TABLE;
	public static Block FURNACE;
	public static Block LIT_FURNACE;
	
	public static BlockBasin BASIN;
	public static BlockShrine SHRINE;
	
	//FENCE'S/GATE'S
	public static Block FENCE_SAKURA;
	public static Block FENCE_WISTERIA;
	public static Block FENCE_ACERPALMATUM;
	public static Block FENCE_WINTERSWEET;
	
	public static Block FENCE_GATE_SAKURA;
	public static Block FENCE_GATE_WISTERIA;
	public static Block FENCE_GATE_ACERPALMATUM;
	public static Block FENCE_GATE_WINTERSWEET;

    public static Block PRESSURE_PLATE_SAKURA;
    public static Block PRESSURE_PLATE_WISTERIA;
    public static Block PRESSURE_PLATE_ACERPALMATUM;
    public static Block PRESSURE_PLATE_WINTERSWEET;

    public static Block CLASSIC_BRICK_STEP;
    public static Block CLASSIC_BRICK_HALFSTEP;
    
    public static Block STAIR_SAKURA;
    public static Block STAIR_WISTERIA;
    public static Block STAIR_ACERPALMATUM;
    public static Block STAIR_WINTERSWEET;
    
	//TODO: 
	public static BlockSapling SAPLING;
	public static BlockButton BUTTON;
	
	public static Block RICE_BOWL;
	
	public static Block PORTAL;
	public static Block PORTAL_FRAME; 
	
	public static BlockPump PUMP;
	
	public static Block SUSHI_PLATE;
	
	//Eggs
	public static BlockEgg HAKU_EGG;
	public static BlockEgg CHIHIRO_EGG;
	
    public static Block FISH_BLOCK;   
    //Doors  
    //Sandals/Slippers/Footwear
    //TODO: RenderPlayer Extends to add these footwear as boots and can e placed. No idea the function of them yet!
    public static SABlockShoes FOOTWEAR;
    
    public static Block CHOPSTICK_CUP;
      
    public static Block KAMAJI_KETTLE;
  
    //SLABS
    public static Block CLASSIC_COBBLESTONE_SLAB;
    public static Block CLASSIC_BRICK_SLAB;
    
    
    //STAIRS
    public static Block CLASSIC_COBBLESTONE_STAIR;
    public static Block CLASSIC_BRICK_STAIR;
    public static Block WOOD_STAIR1;
    public static Block WOOD_STAIR2;
    

      
    //WALLS
    public static Block CLASSIC_COBBLESTONE_WALL;
    public static Block CLASSIC_BRICK_WALL;
    
    public static BlockTorch TORCH;
    public static Block TOLIET;
    public static Block SINK;
    
    public static Block COPPER_BLOCK;
    
    public static Block CHAIR;
    public static Block TABLE;
    
    public static Block LIT_LAMP;
    public static Block LAMP;
    	
    public static void init() {
    	register();
    	registerBlocks();
    }

    public static void register() {

    	//LIT_LAMP = new BlockLamp(true, "lit_lamp");
    	//LAMP = new BlockLamp(false, "lamp");
    	
    	CHAIR = new BlockChair("chair", SoundType.WOOD); //TODO: Sit/DifferentWoodTypes
    	//TABLE = new BlockTable("table"); //TODO: ItemPutOnTable/DifferentWoodTypes
    	//TOLIET = new BlockToliet(Material.iron); //TODO: (Sit/Flush Function and SoundEvents)
    	//SINK = new BlockSink(Material.iron); //TODO: (Sink Function and SoundEvents)
    	
    	//TEST = new BlockFence("test_fence", Material.wood, MapColor.brownColor);
    	//TEST1 = new BlockGateFence("test_fence_gate", EnumType.OAK);
    	
    	//TORCH = new BlockTorch("torch");
    	
		//CRAFTING_TABLE = new BlockWorkbench(Material.wood); //TODO: Crafting Table GUI and Keep Inventory
		//UNCRAFTING_TABLE = new BlockWorkbench(Material.wood); //TODO: Uncrafting Table GUI
		
		//TODO: Storage Slots (GUI)/ Keep Inventory / Fix Lit Furnace
		//FURNACE = new BlockFurnace(false, "furnace");
		//LIT_FURNACE = new BlockFurnace(true, "lit_furnace");
		
		//CLASSIC_COBBLESTONE_STAIRS = new SABlockStairs("classic_stone_stairs");
		//CLASSIC_BRICK_STAIRS = new SABlockStairs("classic_brick_stairs");

    	//SEE TODO: LIST
		//kamaji_kettle = new SABlockBase("kamaji_kettle", Material.iron);
		
    	//SEE TODO: LIST
		//CHOPSTICK_CUP = new BlockChopstick("chopstick_cup", Material.rock);
			
		//TODO:Basin - Data Storage whiles picked up, holding water amount..
		BASIN = new BlockBasin("basin", Material.WOOD, MapColor.WOOD);	
		
    	//SEE TODO: LIST - TILE ENTITY SPECIAL RENDERER
		//SUSHI_PLATE = new BlockSushiPlate("sushi_plate", Material.wood);	
		
    	//SEE TODO: LIST
		//PUMP = new BlockPump("pump", Material.iron, MapColor.ironColor);
		
    	//SEE TODO: LIST
		SHRINE = new BlockShrine("shrine");
		
    	//SEE TODO: LIST
		//HAKU_EGG = new BlockEgg("haku_egg", Material.wood);	
		//CHIHIRO_EGG = new BlockEgg("chihiro_egg", Material.dragonEgg);	
			
		//FISH_BLOCK = new BlockFish("fish_block");	
		
		FENCE_SAKURA = new BlockFences("sakura_fence");
		FENCE_WISTERIA = new BlockFences("wisteria_fence");
		FENCE_ACERPALMATUM = new BlockFences("acer_palmatum_fence");
		FENCE_WINTERSWEET = new BlockFences("winter_sweet_fence");
		
		FENCE_GATE_SAKURA = new BlockGates("sakura_fence_gate", EnumType.OAK);
		FENCE_GATE_WISTERIA = new BlockGates("wisteria_fence_gate", EnumType.OAK);
		FENCE_GATE_ACERPALMATUM = new BlockGates("acer_palmatum_fence_gate", EnumType.OAK);
		FENCE_GATE_WINTERSWEET = new BlockGates("winter_sweet_fence_gate", EnumType.OAK);
		
    	PRESSURE_PLATE_SAKURA = new BlockPressurePlate("sakura_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
    	PRESSURE_PLATE_WISTERIA = new BlockPressurePlate("wisteria_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
    	PRESSURE_PLATE_ACERPALMATUM = new BlockPressurePlate("acer_palmatum_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
    	PRESSURE_PLATE_WINTERSWEET = new BlockPressurePlate("winter_sweet_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
    	
		//GameRegistry.registerTileEntity(TileEntityWorkbench.class, "sa.crafting_table");
		GameRegistry.registerTileEntity(TileEntityFurnace.class, "sa.furnace");
		GameRegistry.registerTileEntity(TileEntitySkull.class, "sa.skull");
				
		}
    
    	public static void registerBlocks() {
    		
    		registerBlock(FENCE_SAKURA);
    		registerBlock(FENCE_WISTERIA);
    		registerBlock(FENCE_ACERPALMATUM);
    		registerBlock(FENCE_WINTERSWEET);
    		
    		registerBlock(FENCE_GATE_SAKURA);
    		registerBlock(FENCE_GATE_WISTERIA);
    		registerBlock(FENCE_GATE_ACERPALMATUM);
    		registerBlock(FENCE_GATE_WINTERSWEET);
    		
    		registerBlock(PRESSURE_PLATE_SAKURA);
    		registerBlock(PRESSURE_PLATE_WISTERIA);
    		registerBlock(PRESSURE_PLATE_ACERPALMATUM);
    		registerBlock(PRESSURE_PLATE_WINTERSWEET);
    		
    		registerBlock(CHAIR);
    		registerBlock(SHRINE);
    		registerBlock(BASIN);
    		
    		//registerBlock(FISH_BLOCK);
    		
    		//registerBlock(HAKU_EGG);
    		//registerBlock(CHIHIRO_EGG);
    		
    	}
     
    	public static void registerBlock(Block block) {
        	
    		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    		System.out.println("Registered Spirirted Away Block: " + block.getUnlocalizedName().substring(5));	
    	  
    	}
        
		public static void registerRenders() {
			
			//registerRender(WOODEN_PRESSURE_PLATE);
			//registerRender(SPRUCE_PRESSURE_PLATE);
			//registerRender(BIRCH_PRESSURE_PLATE);
			//registerRender(JUNGLE_PRESSURE_PLATE);
			//registerRender(ACACIA_PRESSURE_PLATE);
			//registerRender(DARK_OAK_PRESSURE_PLATE);
			
			//registerRender(TOLIET);
			//registerRender(SINK);
			
			//registerRender(TEST);
			//registerRender(TEST1);
			
			//registerRender(TORCH);
		
			//registerRender(PUMP); 
			
			//registerRender(CRAFTING_TABLE);
			//registerRender(FURNACE);
			//registerRender(LIT_FURNACE);
			
			//registerRender(LAMP);
			//registerRender(LIT_LAMP);
			
			//registerRender(SUSHI_PLATE);
			registerRender(SHRINE);
			registerRender(BASIN);
			
			registerRender(FENCE_SAKURA);
			registerRender(FENCE_WISTERIA);
			registerRender(FENCE_ACERPALMATUM);
			registerRender(FENCE_WINTERSWEET);
			
    		registerRender(FENCE_GATE_SAKURA);
    		registerRender(FENCE_GATE_WISTERIA);
    		registerRender(FENCE_GATE_ACERPALMATUM);
    		registerRender(FENCE_GATE_WINTERSWEET);
    		
    		registerRender(PRESSURE_PLATE_SAKURA);
    		registerRender(PRESSURE_PLATE_WISTERIA);
    		registerRender(PRESSURE_PLATE_ACERPALMATUM);
    		registerRender(PRESSURE_PLATE_WINTERSWEET);
			
			//registerRender(CHOPSTICK_CUP);
			
			//registerRender(FISH_BLOCK);
			
			//EGGS
			//registerRender(HAKU_EGG);
			//registerRender(CHIHIRO_EGG);
			
	   }

	   @SideOnly(Side.CLIENT)
       public static void registerRender(Block block) {
		   
		   Item item = Item.getItemFromBlock(block);
		   Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
     
    }
    
}
