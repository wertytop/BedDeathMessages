package me.wertytop.bedkillmessages;

import me.wertytop.bedkillmessages.Events.onDeath;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedKillMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[BKM] BedKillMessages starting up");
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new onDeath(), this);

    }

    @Override
    public void onDisable() {
        System.out.println("[BKM] BedKillMessages shutting down");
    }
}
