package com.demian.demian;

import org.bukkit.plugin.java.JavaPlugin;

public class Demian extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("dupe").setExecutor(new DupeCommand());
        getCommand("hello").setExecutor(new HelloCommand());
       // getCommand("nuke").setExecutor(new NukeCommand());
   }

    @Override
    public void onDisable() {
        // Any necessary cleanup
    }
}