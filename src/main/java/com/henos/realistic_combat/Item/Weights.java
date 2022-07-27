package com.henos.realistic_combat.Item;

import com.google.common.collect.ImmutableMultimap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.henos.realistic_combat.RealisticCombatMain;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;

import static com.henos.realistic_combat.RealisticCombatMain.CONFIG_FOLDER;
import static com.henos.realistic_combat.RealisticCombatMain.WEIGHTS;

public class Weights {
    static Gson json = RealisticCombatMain.json;

    public static void create_weights_config() {
        if (!Files.exists(WEIGHTS)) {
            RealisticCombatMain.LOGGER.info("First Run:");
            try {
                Files.createDirectory(CONFIG_FOLDER);
                RealisticCombatMain.LOGGER.info("Created the weight config folder");
                Files.createFile(WEIGHTS);
                RealisticCombatMain.LOGGER.info("Created the weight config file");
            } catch (IOException e) {
                RealisticCombatMain.LOGGER.error("Couldn't create weights file");
            }
            add_weights();
            RealisticCombatMain.LOGGER.info("Added all the items to the json file");
            try {
                Files.write(WEIGHTS, RealisticCombatMain.json.toJson(RealisticCombatMain.weights_json).getBytes());
            } catch(IOException e) {
                RealisticCombatMain.LOGGER.error("Couldn't create the weight config");
                return;
            }
        }
    }

    public static ImmutableMultimap<String, Float> load_weights_config() {
        try {
            RealisticCombatMain.weights_json = json.fromJson(Files.newBufferedReader(WEIGHTS), JsonObject.class);
            RealisticCombatMain.LOGGER.info("Loading the weight config into JsonObject");
        } catch(IOException e) {
            RealisticCombatMain.LOGGER.error("Couldn't read the weights");
        }
        return multimapbuilder();
    }

    public static ImmutableMultimap<String, Float> multimapbuilder() {
        ImmutableMultimap.Builder<String, Float> multimap = ImmutableMultimap.builder();
//        for (JsonElement id : RealisticCombatMain.weights_json.getAsJsonArray()) {
//            multimap.put(id.getAsString(), RealisticCombatMain.weights_json.get(id.getAsString()).getAsFloat());
//        }
        for (String key : RealisticCombatMain.weights_json.keySet()) {
            if (RealisticCombatMain.weights_json.get(key) instanceof JsonObject) {
                multimap.put(key, RealisticCombatMain.weights_json.get(key).getAsFloat());
            }
            RealisticCombatMain.LOGGER.info("Added " + key + " to the Multimap");
        }
        RealisticCombatMain.LOGGER.info("Created the multimap");
        return multimap.build();
    }

    public static Object getWeight(Item item) {
        RealisticCombatMain.LOGGER.info("Retrieved the weight of " + Registry.ITEM.getId(item));
        return RealisticCombatMain.weightmap.get(Registry.ITEM.getId(item).toString()).toArray()[0];
    }

    public static Boolean check_id(Item item) {
        RealisticCombatMain.LOGGER.info("Retrieved the id of " + Registry.ITEM.getId(item));
        return RealisticCombatMain.weightmap.containsKey(Registry.ITEM.getId(item).toString() );
    }

    public static void add_weights() {
        RealisticCombatMain.weights_json.addProperty("minecraft:bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:lava_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:water_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:milk_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:cod_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:salmon_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:axolotl_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:power_snow_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:pufferfish_bucket", 1.5F);
        RealisticCombatMain.weights_json.addProperty("minecraft:tropical_fish_bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
//        weights.addProperty("minecraft:bucket", 1.5F);
    }
}
