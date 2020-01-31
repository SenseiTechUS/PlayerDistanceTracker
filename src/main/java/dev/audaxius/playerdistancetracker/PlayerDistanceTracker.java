package dev.audaxius.playerdistancetracker;

import co.aikar.commands.PaperCommandManager;
import dev.audaxius.playerdistancetracker.commands.TrackCommand;
import dev.audaxius.playerdistancetracker.events.CompassEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerDistanceTracker extends JavaPlugin {

    public static PlayerDistanceTracker instance;
    public static PaperCommandManager commandManager;
    public static PluginManager pluginManager;

    @Override
    public void onLoad() {

        getLogger().info("PlayerDistanceTracker is loading...");
    }

    @Override
    public void onEnable() {
        instance = this;
        commandManager = new PaperCommandManager(this);
        pluginManager = getServer().getPluginManager();

        commandManager.registerCommand(new TrackCommand());

        pluginManager.registerEvents(new CompassEvent(), this);

        getLogger().info("PlayerDistanceTracker is enabled!");
    }

    @Override
    public void onDisable() {

        getLogger().info("PlayerDistanceTracker is disabled!");
    }

    public static PlayerDistanceTracker getInstance() {
        return instance;
    }

    public static PaperCommandManager getCommandManager() {
        return commandManager;
    }

    public static PluginManager getPluginManager() {
        return pluginManager;
    }
}
