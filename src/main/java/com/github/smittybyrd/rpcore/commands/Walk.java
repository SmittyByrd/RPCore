package com.github.smittybyrd.rpcore.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Walk implements CommandExecutor {

    boolean toggle = false;

    @Override
    public boolean  onCommand(CommandSender sender, Command command, String label, String [] Args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command!");
            return true;

        }

        Player player = (Player) sender;

        if (!toggle && sender instanceof Player) {
            toggle = true;
            {
                player.getAttribute(Attribute.MOVEMENT_SPEED).addTransientModifier(new AttributeModifier(NamespacedKey.fromString("rpcore:walking"), -0.04, AttributeModifier.Operation.ADD_NUMBER));
                player.sendMessage(Component.text("You are now walking slowly", NamedTextColor.GOLD));
            }
        }else {
            toggle = false;
            {
                player.getAttribute(Attribute.MOVEMENT_SPEED).removeModifier(new AttributeModifier(NamespacedKey.fromString("rpcore:walking"), -0.04, AttributeModifier.Operation.ADD_NUMBER));
                player.sendMessage(Component.text("You are now walking normally", NamedTextColor.GOLD));
            }
        }
        return true;

    }
}
