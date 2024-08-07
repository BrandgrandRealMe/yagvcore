package me.brandgrandreal.yagpppcore;

import me.brandgrandreal.yagpppcore.commands.DiscordCommand;
import me.brandgrandreal.yagpppcore.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class YAGPPPCore extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);

        getCommand("discord").setExecutor(new DiscordCommand());
    }

    @Override
    public void onDisable() { /* only used if you have to flush some data */ }
}
