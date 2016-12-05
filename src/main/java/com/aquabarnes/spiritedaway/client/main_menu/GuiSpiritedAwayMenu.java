package com.aquabarnes.spiritedaway.client.main_menu;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiListWorldSelection;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.gui.NotificationModUpdateScreen;
import net.minecraftforge.fml.client.GuiModList;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

import com.aquabarnes.spiritedaway.SAReferances;
import com.google.common.collect.Lists;

public class GuiSpiritedAwayMenu extends GuiScreen
{
  //TODO: Make the Main Menu Design Better :D	
  private static final ResourceLocation MOJANG_LOGO  = new ResourceLocation("sa:textures/gui/mainmenu/Mojang.png");	
  private static final ResourceLocation STUDIO_GHIBLI_LOGO  = new ResourceLocation("sa:textures/gui/mainmenu/Studio_Ghibli.png");		
  private static final ResourceLocation LOGO = new ResourceLocation("sa:textures/gui/mainmenu/minecraft.png");	
  private static final ResourceLocation[] titlePanoramaPaths = new ResourceLocation[] {new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png")};

  public List<GuiButton> buttons = new ArrayList();
  private GuiButtonExt button1;
  private GuiButton modButton;
  private NotificationModUpdateScreen modUpdateNotification;

  private float uiScale = 0.25F;
  private static final Random RANDOM = new Random();
  
  /**
   * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
   * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
   */
  protected void keyTyped(char typedChar, int keyCode) throws IOException
  {
  }

  /**
   * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
   * window resizes, the buttonList is cleared beforehand.
   */
  public void initGui()
  {
      int i = 24;
      int j = this.height / 4 + 48;

	  button1 =  new GuiButtonExt(0, width / 2 - 50, height / 2 + 100, 100, 20, "Main Menu");
	  buttonList.add(button1);	
      
      buttonList.add(new GuiButton(1, this.width / 2 - 100, j, I18n.format("menu.singleplayer", new Object[0])));
      
      buttonList.add(new GuiButton(2, this.width / 2 - 100, j + i * 1, I18n.format("menu.multiplayer", new Object[0])));
      
     // buttonList.add(modButton = new GuiButton(6, this.width / 2 - 100, j + i * 2, 98, 20, I18n.format("fml.menu.mods")));
      
     // buttonList.add(new GuiButton(0, this.width / 2 - 100, j + 72 + 12, 98, 20, I18n.format("menu.options", new Object[0])));
      
     // buttonList.add(new GuiButton(4, this.width / 2 + 2, j + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
      
     // buttonList.add(new GuiButtonLanguage(5, this.width / 2 - 124, j + 72 + 12));
  }

  
 
  protected void actionPerformed(GuiButton button) throws IOException
  {
	  if(button == button1)
	  {
		  mc.displayGuiScreen(new GuiMainMenu());
	  }
	  
      if (button.id == 1)
      {	
    	  this.mc.displayGuiScreen(new GuiWorldSelection(this));
      }
      
      if (button.id == 2)
      {	
    	  this.mc.displayGuiScreen(new GuiMultiplayer(this));
      }
  } 
  
  public void func_73863_a(int par1, int par2, float par3)
  {
    this.mc.getTextureManager().bindTexture(LOGO);
    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
	  
    Tessellator tessellator = Tessellator.getInstance();
    VertexBuffer vertexbuffer = tessellator.getBuffer();
    int i = 274;
    int j = this.width / 2 - i / 2;
    int k = 30;
    this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
    this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);


    {
        this.drawTexturedModalRect(j + 0, k + 0, 0, 0, 99, 44);
        this.drawTexturedModalRect(j + 99, k + 0, 129, 0, 27, 44);
        this.drawTexturedModalRect(j + 99 + 26, k + 0, 126, 0, 3, 44);
        this.drawTexturedModalRect(j + 99 + 26 + 3, k + 0, 99, 0, 26, 44);
        this.drawTexturedModalRect(j + 155, k + 0, 0, 45, 155, 44);
    }
    
    String version = "[Private Early Alpha!] " + SAReferances.mcversion  + "-" + SAReferances.modversion;
    this.drawString(this.fontRendererObj, version, this.width - this.fontRendererObj.getStringWidth(version) - 2, this.height - 20, 1571212);
    
    String studiogibli = "Thank you to Studio Ghibli" + TextFormatting.DARK_RED + " <3";
    this.drawString(this.fontRendererObj, studiogibli, this.width - this.fontRendererObj.getStringWidth(version) - 2, this.height - 10, 16777215);
    
    drawString(this.fontRendererObj, "Minecraft 1.9", this.width - this.fontRendererObj.getStringWidth("Minecraft 1.9") - 8, 8, 16777215);
    drawString(this.fontRendererObj, "Copyright Mojang AB", this.width - this.fontRendererObj.getStringWidth("Copyright Mojang AB") - 8, 18, 16777215);
    drawString(this.fontRendererObj, "Do not distribute!", this.width - this.fontRendererObj.getStringWidth("Do not distribute!") - 8, 28, 16777215);
    
    drawString(this.fontRendererObj, "The Spirited Away Mod", 8, 8, 16777215);
    drawString(this.fontRendererObj, "Property of AquaBarnes", 8, 18, 16777215);
    drawString(this.fontRendererObj, "All rights reserved.", 8, 28, 16777215);
    
    //drawString(this.fontRendererObj, "Spirited Away", 8, 8, 16777215);
    //drawString(this.fontRendererObj, "Property of AquaBarnes", 8, 18, 16777215);
    //drawString(this.fontRendererObj, "All rights reserved.", 8, 28, 16777215);
    
  }
}
