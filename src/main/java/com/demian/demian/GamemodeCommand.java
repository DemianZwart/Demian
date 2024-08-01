package com.demian.demian;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (!player.isOp()) {
                player.sendMessage("You do not have permission to use this command.");
                return false;
            }
            if (player.getGameMode() == GameMode.CREATIVE) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("You are now in survival mode.");
            } else {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("You are now in creative mode.");
            }
            return true;
        }
        return false;
    }
}