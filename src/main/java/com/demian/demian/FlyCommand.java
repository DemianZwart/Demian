package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage("You can no longer fly.");
            } else {
                player.setAllowFlight(true);
                player.sendMessage("You can now fly.");
            }
            return true;
        }
        return false;
    }
}