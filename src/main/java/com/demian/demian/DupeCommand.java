package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DupeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.isOp()) {
                player.sendMessage("You do not have permission to use this command.");
                return true;
            }
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand.getType().isAir()) {
                player.sendMessage("You are not holding anything.");
                return true;
            }
            player.getInventory().addItem(itemInHand.clone());
            player.sendMessage("Item duplicated.");
        }
        return true;
    }
}