package com.demian.demian;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (!player.isOp()) {
                player.sendMessage("You do not have permission to use this command.");
                return false;
            }
            if (player.isInvulnerable()) {
                player.setInvulnerable(false);
                player.sendMessage("You are no longer invulnerable.");
            } else {
                player.setInvulnerable(true);
                player.sendMessage("You are now invulnerable.");
            }
            return true;
        }
        return false;
    }
}