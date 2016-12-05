package com.aquabarnes.spiritedaway.handler;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyHandler {
	
	public static KeyBinding ASCEND_KEY;
	public static KeyBinding DESCEND_KEY;
	public static KeyBinding FLUSH_KEY;
	
    public static void init() {
    	register();
    }

	public static void register() {
	
	ASCEND_KEY = new KeyBinding("key.ascend", Keyboard.KEY_C,"category.spiritedaway");
	DESCEND_KEY = new KeyBinding("key.descend", Keyboard.KEY_Z,"category.spiritedaway");
	FLUSH_KEY = new KeyBinding("key.flush", Keyboard.KEY_F,"category.spiritedaway");

	ClientRegistry.registerKeyBinding(ASCEND_KEY); //TODO Key Binds need to think of..
	ClientRegistry.registerKeyBinding(DESCEND_KEY);
}
}