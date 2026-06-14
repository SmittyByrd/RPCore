package com.github.smittybyrd.rpcore.config;

import com.github.smittybyrd.rpcore.RPCore;
import org.bukkit.Bukkit;


public class ConfigManager {

    public static double conInput;
    public static double modInput;
    public static boolean enable_walk;

    public static double getModInput() {
        return modInput = ((10.0 - conInput) / 100.0) * -1;
    }

    public static boolean getEnableWalk() {
        return enable_walk;
    }

    private static RPCore plugin;

    public ConfigManager(RPCore plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        loadConfig();
        reloadConfig();
    }
    public static void loadConfig() {

        conInput = plugin.getConfig().getDouble("walking-speed", 6);
        enable_walk = plugin.getConfig().getBoolean("features.enable-walk", true);

    }
    public static void reloadConfig() {
        Bukkit.getLogger().info("[RPCore] is reloading config...");
        plugin.reloadConfig();
        ConfigManager.loadConfig();

    }

}



