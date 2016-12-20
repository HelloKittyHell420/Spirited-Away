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
import com.aquabarnes.spiritedaway.block.BlockStair;
import com.aquabarnes.spiritedaway.block.BlockSushiPlate;
import com.aquabarnes.spiritedaway.block.BlockTable;
import com.aquabarnes.spiritedaway.block.BlockToliet;
import com.aquabarnes.spiritedaway.block.BlockTorch;
import com.aquabarnes.spiritedaway.block.BlockWisteriaFence;
import com.aquabarnes.spiritedaway.block.BlockWorkbench;

import com.aquabarnes.spiritedaway.block.SABlockDoor;
import com.aquabarnes.spiritedaway.block.SABlockFlower;
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
	
	public static Block basin;
	public static Block shrine;
	
	//FENCE'S/GATE'S
	public static Block sakura_fence;
	public static Block wisteria_fence;
	public static Block acer_palmatum_fence;
	public static Block winter_sweet_fence;
	
	public static Block sakura_fence_gates;
	public static Block wisteria_fence_gates;
	public static Block acer_palmatum_fence_gates;
	public static Block winter_sweet_fence_gates;

    public static Block sakura_pressure_plate;
    public static Block wisteria_pressure_plate;
    public static Block acer_palmatum_pressure_plate;
    public static Block winter_sweet_pressure_plate;

    public static Block sakura_stairs;
    public static Block wisteria_stairs;
    public static Block acer_palmatum_stairs;
    public static Block winter_sweet_stairs;
    
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
    
    public static Block dungeon_block;
    	
    public static void initialization()
    {
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
		basin = register("basin", new BlockBasin("basin", Material.WOOD, MapColor.WOOD));	
		
    	//SEE TODO: LIST - TILE ENTITY SPECIAL RENDERER
		//SUSHI_PLATE = new BlockSushiPlate("sushi_plate", Material.wood);	
		
    	//SEE TODO: LIST
		//PUMP = new BlockPump("pump", Material.iron, MapColor.ironColor);
		
    	//SEE TODO: LIST
		shrine = register("shrine", new BlockShrine("shrine"));
		
    	//SEE TODO: LIST
		//HAKU_EGG = new BlockEgg("haku_egg", Material.wood);	
		//CHIHIRO_EGG = new BlockEgg("chihiro_egg", Material.dragonEgg);	
			
		//FISH_BLOCK = new BlockFish("fish_block");	
		
		sakura_fence = register("sakura_fence", new BlockFences("sakura_fence"));
		wisteria_fence = register("wisteria_fence", new BlockFences("wisteria_fence"));
		acer_palmatum_fence = register("acer_palmatum_fence", new BlockFences("acer_palmatum_fence"));
		winter_sweet_fence = register("winter_sweet_fence", new BlockFences("winter_sweet_fence"));
		
		//sakura_fence_gate = new BlockGates("sakura_fence_gate", EnumType.OAK);
		//wisteria_fence_gate = new BlockGates("wisteria_fence_gate", EnumType.OAK);
		//acer_palmatum_fence_gate = new BlockGates("acer_palmatum_fence_gate", EnumType.OAK);
		//winter_sweet_fence_gate = new BlockGates("winter_sweet_fence_gate", EnumType.OAK);
		
		//sakura_pressure_plate = new BlockPressurePlate("sakura_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
		//wisteria_pressure_plate = new BlockPressurePlate("wisteria_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
    	//acer_palmatum_pressure_plate = new BlockPressurePlate("acer_palmatum_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
    	//winter_sweet_pressure_plateT = new BlockPressurePlate("winter_sweet_pressure_plate", Material.WOOD, Sensitivity.EVERYTHING);
    	
    	//sakura_stairs = register("sakura_stairs", new BlockStair(SAItemBlocks.planks.getDefaultState()));
    	//wisteria_stairs = register("sakura_stairs", new BlockStair(null));
    	//acer_palmatum_stairs = register("sakura_stairs", new BlockStair(null));
    	//winter_sweet_stairs = register("sakura_stairs", new BlockStair(null));
    	
    	
		//GameRegistry.registerTileEntity(TileEntityWorkbench.class, "sa.crafting_table");
		GameRegistry.registerTileEntity(TileEntityFurnace.class, "sa.furnace");
		GameRegistry.registerTileEntity(TileEntitySkull.class, "sa.skull");
				
		}
     
    public static Block register(String name, Block block)
    {
      block.setUnlocalizedName(name);
      
      GameRegistry.register(block.setRegistryName(SpiritedAway.getResource(name)));
      GameRegistry.register(new ItemBlock(block).setRegistryName(SpiritedAway.getResource(name)));
      
      return block;
     
    }
    
}
