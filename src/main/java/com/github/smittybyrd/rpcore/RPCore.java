package com.github.smittybyrd.rpcore;

import com.github.smittybyrd.rpcore.commands.Walk;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic



        getCommand("walk").setExecutor(new Walk());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
