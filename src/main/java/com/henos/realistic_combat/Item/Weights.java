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
//                RealisticCombatMain.LOGGER.info("Created the weight config folder");
                Files.createFile(WEIGHTS);
//                RealisticCombatMain.LOGGER.info("Created the weight config file");
            } catch (IOException e) {
                RealisticCombatMain.LOGGER.error("Couldn't create weights file");
            }
            add_weights();
//            RealisticCombatMain.LOGGER.info("Added all the items to the json file");
            try {
                Files.write(WEIGHTS, RealisticCombatMain.json.toJson(RealisticCombatMain.weights_json).getBytes());
            } catch(IOException e) {
                RealisticCombatMain.LOGGER.error("Couldn't create the weight config");
                return;
            }
        }
    }

    public static void load_weights_config() {
        try {
            RealisticCombatMain.weights_json = json.fromJson(Files.newBufferedReader(WEIGHTS), JsonObject.class);
//            RealisticCombatMain.LOGGER.info("Loading the weight config into JsonObject");
        } catch(IOException e) {
            RealisticCombatMain.LOGGER.error("Couldn't read the weights");
        }
    }

//    public static ImmutableMultimap<String, Double> multimapbuilder() {
//        ImmutableMultimap.Builder<String, Double> multimap = ImmutableMultimap.builder();
////        for (JsonElement id : RealisticCombatMain.weights_json.getAsJsonArray()) {
////            multimap.put(id.getAsString(), RealisticCombatMain.weights_json.get(id.getAsString()).getAsFloat());
////        }
//        for (String key : RealisticCombatMain.weights_json.keySet()) {
//            if (RealisticCombatMain.weights_json.get(key) instanceof JsonObject) {
//                multimap.put(key, RealisticCombatMain.weights_json.get(key).getAsDouble());
//            }
//            RealisticCombatMain.LOGGER.info("Added " + key + " to the Multimap");
//        }
//        RealisticCombatMain.LOGGER.info("Created the multimap");
//        return multimap.build();
//    }

    public static Double getWeight(Item item) {
//        RealisticCombatMain.LOGGER.info("Retrieved the weight of " + Registry.ITEM.getId(item));
        return RealisticCombatMain.weights_json.get(Registry.ITEM.getId(item).toString()).getAsDouble();
    }

    public static Boolean check_id(Item item) {
//        RealisticCombatMain.LOGGER.info("Retrieved the id of " + Registry.ITEM.getId(item).toString());
        RealisticCombatMain.LOGGER.info(String.valueOf(RealisticCombatMain.weights_json.has(Registry.ITEM.getId(item).toString())));
        return RealisticCombatMain.weights_json.has(Registry.ITEM.getId(item).toString());
    }

    public static void add_weights() {
        RealisticCombatMain.weights_json.addProperty("minecraft:bucket", 2);
        RealisticCombatMain.weights_json.addProperty("minecraft:lava_bucket", 3);
        RealisticCombatMain.weights_json.addProperty("minecraft:water_bucket", 3);
        RealisticCombatMain.weights_json.addProperty("minecraft:milk_bucket", 3);
        RealisticCombatMain.weights_json.addProperty("minecraft:cod_bucket", 4);
        RealisticCombatMain.weights_json.addProperty("minecraft:salmon_bucket", 4);
        RealisticCombatMain.weights_json.addProperty("minecraft:axolotl_bucket", 4);
        RealisticCombatMain.weights_json.addProperty("minecraft:power_snow_bucket", 3);
        RealisticCombatMain.weights_json.addProperty("minecraft:pufferfish_bucket", 4);
        RealisticCombatMain.weights_json.addProperty("minecraft:tropical_fish_bucket", 4);
        RealisticCombatMain.weights_json.addProperty("minecraft:stone");
        RealisticCombatMain.weights_json.addProperty("minecraft:granite");
        RealisticCombatMain.weights_json.addProperty("minecraft:polished_granite");
        RealisticCombatMain.weights_json.addProperty("minecraft:diorite");
        RealisticCombatMain.weights_json.addProperty("minecraft:polished_diorite");
        RealisticCombatMain.weights_json.addProperty("minecraft:andesite");
        RealisticCombatMain.weights_json.addProperty("minecraft:polished_andesite");
        RealisticCombatMain.weights_json.addProperty("minecraft:cobblestone");
        RealisticCombatMain.weights_json.addProperty("minecraft:bedrock");
        RealisticCombatMain.weights_json.addProperty("minecraft:gold_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:iron_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:coal_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:lapis_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:lapis_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:dispenser");
        RealisticCombatMain.weights_json.addProperty("minecraft:sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:chiseled_sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:cut_sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:sticky_piston");
        RealisticCombatMain.weights_json.addProperty("minecraft:piston");
        RealisticCombatMain.weights_json.addProperty("minecraft:gold_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:iron_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:stone_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:cobblestone_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:brick_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:stone_brick_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:nether_brick_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:red_sandstone_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:quartz_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:red_sandstone_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:purpur_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:prismarine_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:prismarine_brick_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:dark_prismarine_slab");
        RealisticCombatMain.weights_json.addProperty("minecraft:smooth_quartz");
        RealisticCombatMain.weights_json.addProperty("minecraft:smooth_quartz");
        RealisticCombatMain.weights_json.addProperty("minecraft:smooth_red_sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:smooth_sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:smooth_stone");
        RealisticCombatMain.weights_json.addProperty("minecraft:bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:mossy_cobblestone");
        RealisticCombatMain.weights_json.addProperty("minecraft:obsidian");
        RealisticCombatMain.weights_json.addProperty("minecraft:purpur_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:diamond_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:diamond_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:furnace");
        RealisticCombatMain.weights_json.addProperty("minecraft:cobblestone_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:redstone_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:ice");
        RealisticCombatMain.weights_json.addProperty("minecraft:netherrack");
        RealisticCombatMain.weights_json.addProperty("minecraft:glowstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:stone_bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:mossy_stone_bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:cracked_stone_bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:chiseled_stone_bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:iron_bars");
        RealisticCombatMain.weights_json.addProperty("minecraft:brick_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:stone_brick_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:end_stone");
        RealisticCombatMain.weights_json.addProperty("minecraft:enchanting_table");
        RealisticCombatMain.weights_json.addProperty("minecraft:end_portal_frame");
        RealisticCombatMain.weights_json.addProperty("minecraft:end_stone_bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:redstone_lamp");
        RealisticCombatMain.weights_json.addProperty("minecraft:sandstone_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:emerald_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:ender_chest");
        RealisticCombatMain.weights_json.addProperty("minecraft:emerald_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:beacon");
        RealisticCombatMain.weights_json.addProperty("minecraft:cobblestone_wall");
        RealisticCombatMain.weights_json.addProperty("minecraft:mossy_cobblestone_wall");
        RealisticCombatMain.weights_json.addProperty("minecraft:anvil");
        RealisticCombatMain.weights_json.addProperty("minecraft:chipped_anvil");
        RealisticCombatMain.weights_json.addProperty("minecraft:damaged_anvil");
        RealisticCombatMain.weights_json.addProperty("minecraft:light_weighted_pressure_plate");
        RealisticCombatMain.weights_json.addProperty("minecraft:heavy_weighted_pressure_plate");
        RealisticCombatMain.weights_json.addProperty("minecraft:nether_quartz_ore");
        RealisticCombatMain.weights_json.addProperty("minecraft:hopper");
        RealisticCombatMain.weights_json.addProperty("minecraft:chiseled_quartz_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:quartz_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:quartz_pillar");
        RealisticCombatMain.weights_json.addProperty("minecraft:quartz_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:dropper");
        RealisticCombatMain.weights_json.addProperty("minecraft:white_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:orange_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:magenta_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:light_blue_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:yellow_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:lime_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:pink_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:gray_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:light_gray_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:cyan_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:purple_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:blue_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:brown_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:green_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:red_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:black_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:iron_trapdoor");
        RealisticCombatMain.weights_json.addProperty("minecraft:coal_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:packed_ice");
        RealisticCombatMain.weights_json.addProperty("minecraft:prismarine");
        RealisticCombatMain.weights_json.addProperty("minecraft:prismarine_bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:dark_prismarine");
        RealisticCombatMain.weights_json.addProperty("minecraft:prismarine_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:prismarine_brick_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:dark_prismarine_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:red_sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:chiseled_red_sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:cut_red_sandstone");
        RealisticCombatMain.weights_json.addProperty("minecraft:red_sandstone_stairs");
        RealisticCombatMain.weights_json.addProperty("minecraft:magma_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:red_nether_bricks");
        RealisticCombatMain.weights_json.addProperty("minecraft:bone_block");
        RealisticCombatMain.weights_json.addProperty("minecraft:white_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:orange_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:magenta_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:light_blue_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:yellow_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:lime_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:pink_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:gray_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:light_gray_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:cyan_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:purple_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:blue_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:brown_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:green_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:red_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("minecraft:black_glazed_terracotta");
        RealisticCombatMain.weights_json.addProperty("");
}
