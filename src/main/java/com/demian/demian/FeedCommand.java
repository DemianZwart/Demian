package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int halfHunger = 10; // Half of the maximum food level, which is 20
            if (player.getFoodLevel() < halfHunger) {
                player.setFoodLevel(20);
                player.sendMessage("You have been fed!");
                player.removePotionEffect(PotionEffectType.HUNGER);
                player.giveExpLevels(10);
                return true;
            } else {
                player.sendMessage("You can only use this command when you are below half hunger.");
                return false;
            }
        }
        return false;
    }
}