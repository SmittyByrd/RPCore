package com.github.smittybyrd.rpcore.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.github.smittybyrd.rpcore.config.ConfigManager.getModInput;
import static com.github.smittybyrd.rpcore.config.ConfigManager.modInput;

public class Walk implements CommandExecutor {

    boolean toggle = false;

    @Override
    public boolean  onCommand(CommandSender sender, Command command, String label, String [] Args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command!");
            return true;

        }

        Player player = (Player) sender;

        if (!toggle && player.hasPermission("rpcore.walk")) {
            toggle = true;
            {
                player.getAttribute(Attribute.MOVEMENT_SPEED).addTransientModifier(
                        new AttributeModifier(NamespacedKey.fromString("rpcore:walking"), getModInput(), AttributeModifier.Operation.ADD_NUMBER));
                player.sendMessage(Component.text("You are now walking slowly", NamedTextColor.GOLD));
            }
        }else {
            toggle = false;
            {
                player.getAttribute(Attribute.MOVEMENT_SPEED).removeModifier(
                        new AttributeModifier(NamespacedKey.fromString("rpcore:walking"), getModInput(), AttributeModifier.Operation.ADD_NUMBER));
                player.sendMessage(Component.text("You are now walking normally", NamedTextColor.GOLD));
            }
        }
        return true;

    }
}
