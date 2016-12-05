package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.enums.TrainType;

import com.aquabarnes.spiritedaway.item.ItemArmorChihiro;
import com.aquabarnes.spiritedaway.item.ItemArmorDyeable;
import com.aquabarnes.spiritedaway.item.ItemArmorHaku;
import com.aquabarnes.spiritedaway.item.ItemBook;
import com.aquabarnes.spiritedaway.item.ItemBucket;
import com.aquabarnes.spiritedaway.item.ItemElytra;
import com.aquabarnes.spiritedaway.item.ItemHat;
import com.aquabarnes.spiritedaway.item.ItemMasks;
import com.aquabarnes.spiritedaway.item.ItemMudball;
import com.aquabarnes.spiritedaway.item.ItemPotion;
import com.aquabarnes.spiritedaway.item.ItemStaff;
import com.aquabarnes.spiritedaway.item.ItemTrain;
import com.aquabarnes.spiritedaway.item.SAItemSwapper;
import com.aquabarnes.spiritedaway.itemblock.BlockSkull;
import com.aquabarnes.spiritedaway.proxy.CommonProxy;

import java.lang.reflect.Field;
import net.minecraft.item.ItemLeaves;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemColored;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SAItems { 
		
	public static ItemArmor.ArmorMaterial DYEABLE = EnumHelper.addArmorMaterial("DYEABLE", "sa:dyeable", 29, new int[] { 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	public static ItemArmor.ArmorMaterial NONE = EnumHelper.addArmorMaterial("NONE", "sa:", 29, new int[] { 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	public static ItemArmor.ArmorMaterial HAKU = EnumHelper.addArmorMaterial("HAKU", "sa:haku", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	public static ItemArmor.ArmorMaterial CHIHIRO = EnumHelper.addArmorMaterial("CHIHIRO", "sa:chihiro", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	public static ItemArmor.ArmorMaterial NOFACE = EnumHelper.addArmorMaterial("NOFACE", "sa:noface", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	
	public static Item.ToolMaterial ToolMaterial = EnumHelper.addToolMaterial("ToolMaterial", 2, 2000, 10.0F, 4.0F, 0);
	
	public static Item AQUABARNES;
  
	public static Item MUDBALL;
	//public static Item MUDBALL;
	
	//RECORDS
	public static Item RECORD_1;
	public static Item RECORD_2;
	public static Item RECORD_3;
	
    public static Item RICE_SEEDS;
    public static Item RICE;
	//TODO: Some type of soup
	
	//TODO Work out ItemBlock???
	public static BlockSkull SKULL2;
	
	//TODO: POTIONS AND BREWING RECIPES FOR THEM??
	public static ItemPotion POTION;
	public static ItemPotion SPLASH_POTION;
	public static ItemPotion LINGERING_POTION;
	
	//BUCKETS MAY NOT NEED IF NO WOOD BUCKET ADDED
	public static Item BUCKET;
	public static Item BUCKET_WATER;
	public static Item BUCKET_LAVA;
	public static Item BUCKET_MILK;
	//TODO: Custom Buckets (Water Types)
	public static Item BUCKET_MUGWORT;
	public static Item BUCKET_SULFER;
	public static Item BUCKET_WORM_SALTS;
	
	//ARMOR/CLOTHES
	public static Item CHESTPLATE_HAKU;
	public static Item LEGGINGS_HAKU;
	public static Item BOOTS_HAKU;
	
	public static Item CHESTPLATE_CHIHIRO;
	public static Item LEGGINGS_CHIHIRO;
	public static Item BOOTS_CHIHIRO;
	
	public static Item CHESTPLATE_FEMALE_WORKER;
	public static Item LEGGINGS_FEMALE_WORKER;
	
	public static Item CHESTPLATE_DYEABLE_CLOTHES;
	public static Item LEGGINGS_DYEABLE_CLOTHES;
	
	//HATS/MASK'S
	public static Item HAT_DYEABLE;
	public static Item HAT_RADISH;
	public static Item HAT_FROGMAN;
	public static Item MASK_NOFACE;
	public static Item MASK_RADISH;
	public static Item MASK_OOTORI;
	public static Item MASK_RIVERSPIRIT;
	
	//TODO Add to RenderPlayer
	public static Item ELYTRA_RADISH;
	public static Item ELYTRA_KASHIRA;
	public static Item ELYTRA_SOOTBALL;
	
    public static Item TRAIN;
    
    //TODO:Skin Changer
    public static Item BOOK;
    
    public static SAItemSwapper Transport;
    
    //TODO: Records
	public static Item RECORD_;
   
      
    public static void init() {
    	
    	register();
    	registerItems();
    }

	public static void register() {
		
		//AQUABARNES = new ItemStaff(0);
		
		//MUDBALL = new ItemMudball("mudball");
		
		//POTION = new ItemPotion("potion");

	   //TRANSPORT = new SAItemSwapper("transport_swapper");
	   //ARMOR = new SAItemSwapper("armor_swapper");
	   //FOOD = new SAItemSwapper("food_swapper");
			  
       //HAT_RADISH = new ItemHat("hatradish", NONE, CommonProxy.addArmor("Radish Hat"), EntityEquipmentSlot.HEAD).setMaxStackSize(1);
       //TODO:FrogmanHat - Make Dyeable???
       //HAT_DYEABLE = new ItemHat("hatradish", NONE, CommonProxy.addArmor("Radish Hat"), EntityEquipmentSlot.HEAD).setMaxStackSize(1); 
       //HAT_RADISH = new ItemFrogmanHat(0, NONE, proxy.addArmor("Frogman Hat"), 0).func_77625_d(1); 
       //MASK_NOFACE = new ItemFrogmanHat(0, NONE, proxy.addArmor("No-Face Mask"), 0).func_77625_d(1);
       //MASKS = new ItemMasks("masks");
       
       //TODO:Item Texture Dye Fix, LOOKUP:
       CHESTPLATE_DYEABLE_CLOTHES = new ItemArmorDyeable("dyeable_chestplate", 1, EntityEquipmentSlot.CHEST);
       LEGGINGS_DYEABLE_CLOTHES = new ItemArmorDyeable("dyeable_leggings", 2, EntityEquipmentSlot.LEGS);

       //CHESTPLATE_HAKU = new ItemArmorHaku("haku_chestplate", 1, EntityEquipmentSlot.CHEST);
       //LEGGINGS_HAKU = new ItemArmorHaku("haku_leggings", 2, EntityEquipmentSlot.LEGS);
       //BOOTS_HAKU = new ItemArmorHaku("haku_boots", 1, EntityEquipmentSlot.FEET);
       
       //CHESTPLATE_CHIHIRO = new ItemArmorChihiro("chihiro_chestplate", 1, EntityEquipmentSlot.CHEST);
       //LEGGINGS_CHIHIRO = new ItemArmorChihiro("chihiro_leggings", 2, EntityEquipmentSlot.LEGS);
       //BOOTS_CHIHIRO = new ItemArmorChihiro("chihiro_boots", 1, EntityEquipmentSlot.FEET);
       
       //TODO: Custom Liquids/Bath Waters
       //BUCKET = new ItemBucket("bucket", Blocks.air);
       //BUCKET_WATER = new ItemBucket("water_bucket", Blocks.flowing_water);
       //BUCKET_LAVA = new ItemBucket("lava_bucket", Blocks.flowing_lava);
       //BUCKET_MILK = new ItemBucket("milk_bucket", null);
       
       //ELYTRA_RADISH = new ItemElytra("elytra_radish");
       //ELYTRA_KASHIRA = new ItemElytra("elytra_kashira");
       //ELYTRA_SOOTBALL = new ItemElytra("elytra_sootball"); 
       
       //RECORD_ = new ItemElytra("elytra_radish");
       
       //TRAIN = new ItemTrain("train", 0, TrainType.NORMAL);
       
       //BOOK = new ItemBook("book");
       
	}
	
	public static void registerItems() {
		
		registerItem(CHESTPLATE_DYEABLE_CLOTHES);
		registerItem(LEGGINGS_DYEABLE_CLOTHES);
		
	}
    	
	
	public static void registerItem(Item item) {
    	
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		System.out.println("Registered Spirirted Away Item: " + item.getUnlocalizedName().substring(5));	
	  
	}
	
	@SideOnly(Side.CLIENT)
    public static void registerRenders() {
	  {
	    ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
	    for (Field f : SAItems.class.getFields()) {
	      try
	      {
	        Item item = (Item)f.get(null);
	        String name = item.getUnlocalizedName().substring(5);
	        mesher.register(item, 0, new ModelResourceLocation("sa:" + name, "inventory"));
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	    }
	  }
	}
}
