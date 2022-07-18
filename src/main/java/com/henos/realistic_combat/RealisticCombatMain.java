package com.henos.realistic_combat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class RealisticCombatMain implements ModInitializer {
	public static final String MODID = "realistic_combat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final Path CONFIG_FOLDER = FabricLoader.getInstance().getConfigDir().resolve(MODID);
	public static final Path CONFIG = CONFIG_FOLDER.resolve("config.json");
//	private static final KeyBinding kb_enable = registerKeyBinding("enable", GLFW.GLFW_KEY_UNKNOWN);
//	private static final KeyBinding kb_cycleProfiles = registerKeyBinding("cycle_profiles", GLFW.GLFW_KEY_UNKNOWN);
//	private static final KeyBinding kb_swapToProfile1 = registerKeyBinding("swap_to_profile1", GLFW.GLFW_KEY_UNKNOWN);
//	private static final KeyBinding kb_swapToProfile2 = registerKeyBinding("swap_to_profile2", GLFW.GLFW_KEY_UNKNOWN);
//	private static final KeyBinding kb_swapToProfile3 = registerKeyBinding("swap_to_profile3", GLFW.GLFW_KEY_UNKNOWN);

//	private static KeyBinding registerKeyBinding(String binding, int key) {
//		return KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + MODID + "." + binding, InputUtil.Type.KEYSYM, key, "category." + MODID));
//	}

	@Override
	public void onInitialize() {
		LOGGER.info(MODID + " initializing");
	}
}
