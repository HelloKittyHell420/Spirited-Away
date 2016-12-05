package com.aquabarnes.spiritedaway.achievements;

import com.aquabarnes.spiritedaway.init.SABlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public final class SAAchievementPage
{
  public static AchievementPage page;
  public static Achievement installmod;
  public static Achievement travelSpiritedAway;

  
  public static void init()
  {
    installmod = new SAAchievement("achievement.installMod", "installMod", 0, 0, new ItemStack(Items.SLIME_BALL), installmod).setSpecial();
    travelSpiritedAway = new SAAchievement("achievement.enterSpiritedAway", "enterSpiritedAway", 1, 4, SABlocks.SHRINE, null);

    page = new AchievementPage("§4Spirited Away", new Achievement[] { installmod, travelSpiritedAway});
    AchievementPage.registerAchievementPage(page);
    
    
  }
}