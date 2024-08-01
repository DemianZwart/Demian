package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.isOp()) {
                player.sendMessage("You do not have permission to use this command.");
                return true;
            }
            if (player.isInvulnerable()) {
                player.setInvulnerable(false);
                player.sendMessage("You are no longer invulnerable.");
            } else {
                player.setInvulnerable(true);
                player.sendMessage("You are now invulnerable.");
            }
        }
        return true;
    }
}