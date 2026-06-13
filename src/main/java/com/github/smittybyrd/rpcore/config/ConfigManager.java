package com.github.smittybyrd.rpcore.config;

import com.github.smittybyrd.rpcore.RPCore;
import org.bukkit.Bukkit;


public class ConfigManager {

    public static double conInput;
    public static double modInput;


    public static double getModInput() {
        return modInput = ((10.0 - conInput) / 100.0) * -1;
    }

    private static RPCore plugin;

    public ConfigManager(RPCore plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        loadConfig();
        reloadConfig();
    }

    public static void loadConfig() {

        conInput = plugin.getConfig().getDouble("walking-speed");

    }

    public static void reloadConfig() {
        Bukkit.getLogger().info("[RPCore] is reloading config...");
        plugin.reloadConfig();
        ConfigManager.loadConfig();

    }

}



