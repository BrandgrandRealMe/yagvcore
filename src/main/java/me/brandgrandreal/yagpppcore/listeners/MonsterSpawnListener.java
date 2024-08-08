package me.brandgrandreal.yagpppcore.listeners;

import me.brandgrandreal.yagpppcore.config.ConfigManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.Arrays;

public class MonsterSpawnListener implements Listener {
    @EventHandler
    public void noNaturalMonsterSpawning(CreatureSpawnEvent event) {
        if (ConfigManager.getPMS()) {
            Entity entity = event.getEntity();
            String[] ValidSpawnReasons = {"BUILD_WITHER", "COMMAND", "DISPENSE_EGG", "EGG", "SPAWNER", "SPAWNER_EGG", "TRIAL_SPAWNER"};

            if (entity instanceof Monster && Arrays.asList(ValidSpawnReasons).contains(event.getSpawnReason()))
                event.setCancelled(true);
        }
    }
}