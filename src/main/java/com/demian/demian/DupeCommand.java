package com.demian.demian;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DupeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (!player.isOp()) {
                player.sendMessage("You do not have permission to use this command.");
                return false;
            }
            if (player.getLevel() < 10) {
                player.sendMessage("You do not have enough experience levels to use this command.");
                return false;
            }
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand != null && itemInHand.getType() != org.bukkit.Material.AIR) {
                ItemStack duplicatedItem = itemInHand.clone();
                duplicatedItem.setAmount(itemInHand.getAmount() * 4);
                player.getInventory().addItem(duplicatedItem);
                player.setLevel(player.getLevel() - 10);
                player.sendMessage("Item duplicated 4 times at the cost of 10 experience levels.");
                return true;
            } else {
                player.sendMessage("You are not holding any item.");
                return false;
            }
        }
        return false;
    }
}