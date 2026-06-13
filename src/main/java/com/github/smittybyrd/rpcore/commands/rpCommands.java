package com.github.smittybyrd.rpcore.commands;
import com.github.smittybyrd.rpcore.RPCore;
import com.github.smittybyrd.rpcore.config.ConfigManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class rpCommands implements CommandExecutor {

    private static final RPCore plugin = RPCore.pluginGet();

    String version = plugin.getPluginMeta().getVersion();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                sender.sendMessage("Incomplete command!");
            } else if (sender instanceof Player && sender.hasPermission("rpcore.admin")) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (args.length == 1) {
                        ConfigManager.reloadConfig();
                        sender.sendMessage(Component.text("Config reloaded!", NamedTextColor.GOLD));
                    } else {
                        sender.sendMessage("Too many arguments!");
                    }
                } else if (args[0].equalsIgnoreCase("version")) {
                    if (args.length == 1) {
                        sender.sendMessage(Component.text("Version:" + version, NamedTextColor.GOLD));
                    } else {
                        sender.sendMessage("Too many arguments!");
                    }
                }
            }
        }
        return true;

    }
}
