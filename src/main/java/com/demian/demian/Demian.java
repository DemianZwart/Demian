package com.demian.demian;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for the Demian plugin.
 * This class extends JavaPlugin and contains the plugin's startup logic.
 */
public class Demian extends JavaPlugin {
    /**
     * This method is called when the plugin is enabled.
     * It sets the executors for the commands defined in the plugin.
     */
    @Override
    public void onEnable() {
        if (getCommand("heal") != null) {
            getCommand("heal").setExecutor(new HealCommand());
        }
        if (getCommand("feed") != null) {
            getCommand("feed").setExecutor(new FeedCommand());
        }
        if (getCommand("fly") != null) {
            getCommand("fly").setExecutor(new FlyCommand());
        }
        if (getCommand("god") != null) {
            getCommand("god").setExecutor(new GodCommand());
        }
        if (getCommand("gm") != null) {
            getCommand("gm").setExecutor(new GamemodeCommand());
        }
        if (getCommand("dupe") != null) {
            getCommand("dupe").setExecutor(new DupeCommand());
        }
    }

    @Override
    public void onDisable() {
        // Any necessary cleanup
    }
}