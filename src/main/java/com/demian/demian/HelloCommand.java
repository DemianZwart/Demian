package com.demian.demian;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelloCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage("No, this is a console only command");
        } else {
            Bukkit.getLogger().info("");
            System.out.println("Hello, you have messaged the console!");
        }
        return true; // Ensure the command returns true
    }
}