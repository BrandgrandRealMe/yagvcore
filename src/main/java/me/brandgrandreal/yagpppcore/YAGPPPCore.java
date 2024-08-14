package me.brandgrandreal.yagpppcore;

import me.brandgrandreal.yagpppcore.commands.DiscordCommand;
import me.brandgrandreal.yagpppcore.commands.RulesCommand;
import me.brandgrandreal.yagpppcore.config.ConfigManager;
import me.brandgrandreal.yagpppcore.listeners.MonsterSpawnListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class YAGPPPCore extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);
        Bukkit.getPluginManager().registerEvents(new MonsterSpawnListener(), this);

        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("rules").setExecutor(new RulesCommand());
    }

    @Override
    public void onDisable() { /* only used if you have to flush some data */ }
}
