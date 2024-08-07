package me.brandgrandreal.yagpppcore.config;

import me.brandgrandreal.yagpppcore.YAGPPPCore;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private static FileConfiguration config;

    public static void setupConfig(YAGPPPCore main) {
        ConfigManager.config = main.getConfig();
        main.saveDefaultConfig();
    }

    public static String getDiscordLink() {
        return config.getString("discord-link");
    }
    public static boolean getPMS() {
        return config.getBoolean("passive-monster-spawning");
    }

}
