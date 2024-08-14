package me.brandgrandreal.yagpppcore.listeners;

import me.brandgrandreal.yagpppcore.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Arrays;

public class MonsterSpawnListener implements Listener {
    @EventHandler
    public void noNaturalMonsterSpawning(CreatureSpawnEvent event) {
        if (!ConfigManager.getPMS()) {
            Entity entity = event.getEntity();
            if (entity instanceof Monster && event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) {
                event.setCancelled(true);
            } else if (entity instanceof Ghast && event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.SPAWNER) {
                event.setCancelled(true);
            }
        }
    }
}