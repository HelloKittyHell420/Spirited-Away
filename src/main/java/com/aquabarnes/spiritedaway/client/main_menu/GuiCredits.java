package com.aquabarnes.spiritedaway.client.main_menu;

import static net.minecraft.util.text.TextFormatting.RED;

import static net.minecraft.util.text.TextFormatting.WHITE;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.Level;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.google.common.base.Strings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.ForgeVersion.CheckResult;
import net.minecraftforge.common.ForgeVersion.Status;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.GuiModList;
import net.minecraftforge.fml.client.GuiScrollingList;
import net.minecraftforge.fml.client.GuiSlotModList;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.ModContainer.Disableable;
import net.minecraftforge.fml.common.versioning.ComparableVersion;

public class GuiCredits extends GuiScreen
{	   
private static final ResourceLocation MOJANG_LOGO  = new ResourceLocation("sa:textures/gui/mainmenu/logo");	
private static final ResourceLocation STUDIOGIBIL_LOGO  = new ResourceLocation("sa:textures/gui/mainmenu/logo");		
private static final ResourceLocation FORGE_LOGO = new ResourceLocation("sa:textures/gui/mainmenu/logo");	
private static final ResourceLocation MCP_LOGO  = new ResourceLocation("sa:textures/gui/mainmenu/logo");	

private GuiScrollingList modInfo;
private GuiScreen mainMenu;

private int selected = -1;
private int listWidth;
private static String supportersURL = "http://pastebin.com/raw.php?i=VF4pMfZQ";
private static List<String> supportersList = new ArrayList();
private static ArrayList<ModContainer> supporters;
private int page;
private EntityPlayer player;
private GuiTextField nameTextField;
private GuiButtonExt button1;
//TODO: says Thank you to Mojang/Studio Gibil/PatreonSupporters/MinecraftForgeTeam/MinecraftCoderPack :D


    /**
     * @param mainMenu
     */
    public GuiCredits(GuiScreen mainMenu)
    {

    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    @Override
    public void initGui()
    {
    	button1 = GuiButtonExt(0, width / 2, height / 2 + 100, width, height, "Exit"); 
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    @Override
    protected void mouseClicked(int x, int y, int button) throws IOException
    {
     
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    @Override
    protected void keyTyped(char c, int keyCode) throws IOException
    {
        super.keyTyped(c, keyCode);
   
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen()
    {
        super.updateScreen();
    }

    private void reloadMods()
    {
       
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);
    }

    public int drawLine(String line, int offset, int shifty)
    {
        this.fontRendererObj.drawString(line, offset, shifty, 0xd7edea);
        return shifty + 10;
    }

    /**
     * Draws the screen and all the components in it.
     *  
     * @param mouseX Mouse x coordinate
     * @param mouseY Mouse y coordinate
     * @param partialTicks How far into the current tick (1/20th of a second) the game is
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
   
    }

    /**
     * Handles mouse input.
     */
    @Override
    public void handleMouseInput() throws IOException
    {
    
    }

    Minecraft getMinecraftInstance()
    {
     
    }

    FontRenderer getFontRenderer()
    {
       
    }

    public void selectModIndex(int index)
    {      
        updateCache();
    }

    public boolean modIndexSelected(int index)
    {
        return index == selected;
    }

    private void updateCache()
    {
        modInfo = null;
    }
}