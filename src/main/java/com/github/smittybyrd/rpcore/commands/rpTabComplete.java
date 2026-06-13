package com.github.smittybyrd.rpcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class rpTabComplete implements TabCompleter {


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (command.getName().equalsIgnoreCase("rpcore")) {
            List<String> completions = new ArrayList<>();

            if (args.length == 1) {
                String[] subArray = {"reload", "version"};
                for (String option : subArray) {
                    if (option.startsWith(args[0].toLowerCase())) {
                        completions.add(option);
                    }
                }
            }
            return completions.isEmpty() ? null : completions;
        }
        return null;
    }
}