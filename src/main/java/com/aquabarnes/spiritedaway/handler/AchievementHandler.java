package com.aquabarnes.spiritedaway.handler;

import com.aquabarnes.spiritedaway.achievements.SAAchievementPage;
import com.aquabarnes.spiritedaway.init.SAItems;

import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class AchievementHandler {

	 @SubscribeEvent
	  public void onPickupItem(EntityItemPickupEvent event)
	  {
	    Item item = event.getEntityPlayer().getHeldItemMainhand();
	    if ((item == SAItems.SKULL) && (event.getItem().getEntityItem().getMetadata() == 0)) {
	      event.getEntityPlayer().hasAchievement(SAAchievementPage.installmod);
	    }
	  }
	      
	  @SubscribeEvent
	   public void onCrafting(PlayerEvent.ItemCraftedEvent event)
	   {
	    
	   }
  }