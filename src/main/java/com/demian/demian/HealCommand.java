package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.isOp()) {
                player.sendMessage("You do not have permission to use this command.");
                return true;
            }
            player.setHealth(player.getMaxHealth());
            player.sendMessage("You have been healed.");
        } else {
            sender.sendMessage("You need to be a player to use this command!");
        }
        return true;
    }
}