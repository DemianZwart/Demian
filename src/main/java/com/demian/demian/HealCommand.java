package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            double halfHealth = player.getMaxHealth() / 2;
            if (player.getHealth() < halfHealth) {
                player.setHealth(20);
                player.sendMessage("You have been healed!");
                player.removePotionEffect(PotionEffectType.POISON);
                player.giveExpLevels(10);
                player.sendMessage("You have been gifted 10 experience levels");
                return true;
            } else {
                player.sendMessage("You can only use this command when you are below half health.");
                return false;
            }
        }
        return false;
    }
}