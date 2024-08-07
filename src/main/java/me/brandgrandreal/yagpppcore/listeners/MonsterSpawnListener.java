package me.brandgrandreal.yagpppcore.listeners;

import me.brandgrandreal.yagpppcore.config.ConfigManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MonsterSpawnListener implements Listener {
    @EventHandler
    public void noNaturalMonsterSpawning(EntitySpawnEvent event) {
        if (ConfigManager.getPMS()) {
            Entity entity = event.getEntity();
            if (entity instanceof Monster)
                event.setCancelled(true);
        }
    }
}