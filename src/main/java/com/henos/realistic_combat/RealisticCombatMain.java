package com.henos.realistic_combat;

import com.google.common.collect.ImmutableMultimap;
import com.google.gson.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.henos.realistic_combat.Item.Weights;

public class RealisticCombatMain implements ModInitializer {
	public static final String MODID = "realistic_combat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final Path CONFIG_FOLDER = FabricLoader.getInstance().getConfigDir().resolve(MODID);
	public static final Path CONFIG = CONFIG_FOLDER.resolve("config.json");
	public static final Path WEIGHTS = CONFIG_FOLDER.resolve("weights.json");

	public static Gson json = new GsonBuilder().setPrettyPrinting().create();

	public static JsonObject weights_json = new JsonObject();
	public static ImmutableMultimap<String, Float> weightmap;

	@Override
	public void onInitialize() {
		LOGGER.info(MODID + " initializing");
		Weights.create_weights_config();
		LOGGER.info("Creating Weight Config");
		weightmap = Weights.load_weights_config();
		LOGGER.info("Loading Weight Config");
	}
}
