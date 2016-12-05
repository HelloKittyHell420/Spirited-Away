package com.aquabarnes.spiritedaway.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketCombatEvent.Event;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BucketEventHandler
{
  @SubscribeEvent
  public void onBucketFill(FillBucketEvent event)
  {
      }
    
  
}