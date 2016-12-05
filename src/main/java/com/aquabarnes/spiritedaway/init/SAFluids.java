package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.SpiritedAway;
import com.aquabarnes.spiritedaway.block.FluidDriedWormSalt;
import com.aquabarnes.spiritedaway.block.FluidDriedWormSalt.BlockDriedWormSalt;
import com.aquabarnes.spiritedaway.block.FluidMugwort;
import com.aquabarnes.spiritedaway.block.FluidSulfer;
import com.aquabarnes.spiritedaway.block.FluidMugwort.BlockMugwort;
import com.aquabarnes.spiritedaway.block.FluidSulfer.BlockSulfer;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAFluids {
	
  private static ModelResourceLocation MUGWORT = new ModelResourceLocation("sa:" + "mugwort", "fluid");
  private static ModelResourceLocation SULFERSOAKS = new ModelResourceLocation("sa:" + "sulfer", "fluid"); 
  private static ModelResourceLocation DRIEDWORMSALTS = new ModelResourceLocation("sa:" + "driedwormsalt", "fluid");
  
  public static void init() {
  	registerFluids();
  }
  
  private static void registerFluids() {
  
  FluidRegistry.registerFluid(FluidSulfer.instance);
  FluidRegistry.registerFluid(FluidMugwort.instance);
  FluidRegistry.registerFluid(FluidDriedWormSalt.instance);
  
  GameRegistry.registerBlock(BlockSulfer.instance, BlockSulfer.name);
  GameRegistry.registerBlock(BlockMugwort.instance, BlockMugwort.name);
  GameRegistry.registerBlock(BlockDriedWormSalt.instance, BlockDriedWormSalt.name);
   
  Item sulfer = Item.getItemFromBlock(BlockSulfer.instance);
  Item mugwort = Item.getItemFromBlock(BlockMugwort.instance);
  Item driedwormsalt = Item.getItemFromBlock(BlockDriedWormSalt.instance);
  
  ModelLoader.setCustomMeshDefinition(sulfer, new ItemMeshDefinition()
  {
      public ModelResourceLocation getModelLocation(ItemStack stack)
      {
          return SULFERSOAKS;
      }
  });
  
  ModelLoader.setCustomMeshDefinition(mugwort, new ItemMeshDefinition()
  {
      public ModelResourceLocation getModelLocation(ItemStack stack)
      {
          return MUGWORT;
      }
  });
  
  ModelLoader.setCustomMeshDefinition(mugwort, new ItemMeshDefinition()
  {
      public ModelResourceLocation getModelLocation(ItemStack stack)
      {
          return DRIEDWORMSALTS;
      }
  });

  ModelLoader.setCustomStateMapper(BlockSulfer.instance, new StateMapperBase()
  {
      protected ModelResourceLocation getModelResourceLocation(IBlockState state)
      {
          return SULFERSOAKS;
      }

  });
  
  ModelLoader.setCustomStateMapper(BlockMugwort.instance, new StateMapperBase()
  {
      protected ModelResourceLocation getModelResourceLocation(IBlockState state)
      {
          return MUGWORT;
      }

  });
  
  ModelLoader.setCustomStateMapper(BlockDriedWormSalt.instance, new StateMapperBase()
  {
      protected ModelResourceLocation getModelResourceLocation(IBlockState state)
      {
          return DRIEDWORMSALTS;
      }

  });
  }
  
}

