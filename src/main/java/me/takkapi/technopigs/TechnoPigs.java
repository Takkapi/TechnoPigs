package me.takkapi.technopigs;

import me.takkapi.technopigs.listener.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class TechnoPigs extends JavaPlugin {

    private static TechnoPigs instance;

    public TechnoPigs() {
    }

    public static TechnoPigs getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    public void onDisable() {
        instance = null;
    }

}
