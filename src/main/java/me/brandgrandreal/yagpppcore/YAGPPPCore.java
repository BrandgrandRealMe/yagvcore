package me.brandgrandreal.yagpppcore;

import me.brandgrandreal.yagpppcore.commands.DiscordCommand;
import me.brandgrandreal.yagpppcore.config.ConfigManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class YAGPPPCore extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.setupConfig(this);

        getCommand("discord").setExecutor(new DiscordCommand());
    }

    @Override
    public void onDisable() { /* only used if you have to flush some data */ }

    @EventHandler
    public void noNaturalMonsterSpawning(EntitySpawnEvent event) {
        if (ConfigManager.getPMS()) {
            Entity entity = event.getEntity();
            if (entity instanceof Monster)
                event.setCancelled(true);
        }
    }
}
