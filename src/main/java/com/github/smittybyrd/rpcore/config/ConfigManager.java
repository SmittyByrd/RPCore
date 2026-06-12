package com.github.smittybyrd.rpcore.config;

import com.github.smittybyrd.rpcore.RPCore;


public class ConfigManager {

    public static double conInput;
    public static double modInput;


    public static double getModInput() {
        return modInput = (10.0 - conInput) / 100.0 - 0.1;
    }

    private final RPCore plugin;

    public ConfigManager(RPCore plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        loadConfig();
    }

    public void loadConfig() {

        conInput = plugin.getConfig().getDouble("walking-speed");

    }

}



