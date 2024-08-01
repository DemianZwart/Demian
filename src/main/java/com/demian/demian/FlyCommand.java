package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage("You can no longer fly.");
            } else {
                player.setAllowFlight(true);
                player.sendMessage("You can now fly.");
            }
        } else {
            sender.sendMessage("You need to be a player to use this command!");
        }
        return true;
    }
}