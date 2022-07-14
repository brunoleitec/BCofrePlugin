package com.github.brunoleitec.bcofreplugin;

import com.github.brunoleitec.bcofreplugin.commands.OpenCommand;
import com.github.brunoleitec.bcofreplugin.listeners.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BCofrePlugin extends JavaPlugin {

    private static BCofrePlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        Objects.requireNonNull(getCommand("vault")).setExecutor(new OpenCommand());

        getServer().getPluginManager().registerEvents(new Listeners(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BCofrePlugin getPlugin() {
        return plugin;
    }
}


