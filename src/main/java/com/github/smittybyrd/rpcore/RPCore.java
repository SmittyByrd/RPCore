package com.github.smittybyrd.rpcore;

import com.github.smittybyrd.rpcore.commands.Walk;
// import com.github.smittybyrd.rpcore.config.ConfigFile;
import com.github.smittybyrd.rpcore.config.ConfigManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import static com.github.smittybyrd.rpcore.config.ConfigManager.*;

public final class RPCore extends JavaPlugin {

    private static RPCore plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        new ConfigManager(this);

        System.out.println(getModInput());

        //saveResource("config.yml", false);

        getCommand("walk").setExecutor(new Walk());

    }


    public void onLoad() {


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static RPCore pluginGet() {
        return plugin;
    }
}
