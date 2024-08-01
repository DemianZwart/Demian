package com.demian.demian;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.isOp()) {
                player.sendMessage("You do not have permission to use this command.");
                return true;
            }
            if (player.getGameMode() == GameMode.CREATIVE) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("You are now in survival mode.");
            } else {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("You are now in creative mode.");
            }
        } else {
            sender.sendMessage("This command can only be used by players.");
        }
        return true;
    }
}