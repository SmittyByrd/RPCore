package com.github.smittybyrd.rpcore;
import com.github.smittybyrd.rpcore.commands.Walk;
import com.github.smittybyrd.rpcore.commands.rpCommands;
import com.github.smittybyrd.rpcore.commands.rpTabComplete;
import com.github.smittybyrd.rpcore.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class RPCore extends JavaPlugin {

    private static RPCore plugin;


    @Override
    public void onEnable() {
        plugin = this;
        new ConfigManager(this);

        //getCommand("walk").setExecutor(new Walk());
        Objects.requireNonNull(getCommand("rpcore")).setExecutor(new rpCommands());
        Objects.requireNonNull(getCommand("rpcore")).setTabCompleter(new rpTabComplete());
        boolean enableWalk = this.plugin.getConfig().getBoolean("features.enable-walk");
        if (enableWalk) {
            getCommand("walk").setExecutor(new Walk());
        }

        Bukkit.getLogger().info("[RPCore] Enabled!");

    }

    public static RPCore pluginGet() {
        return plugin;
    }
}
