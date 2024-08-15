package me.brandgrandreal.yagpppcore.config;

import me.brandgrandreal.yagpppcore.YAGPPPCore;
import me.brandgrandreal.yagpppcore.utils.Rule;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigManager {

    private static FileConfiguration config;

    public static void setupConfig(YAGPPPCore main) {
        ConfigManager.config = main.getConfig();
        main.saveDefaultConfig();
    }

    public static String getDiscordLink() {
        return config.getString("discord-link");
    }
    public static String getWebsiteLink() {
        return config.getString("website-link");
    }
    public static boolean getPMS() {
        return config.getBoolean("passive-monster-spawning");
    }
    public static List<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        List<Map<?, ?>> configRules = config.getMapList("rules"); // Assuming config is a Configuration object
        for (Map<?, ?> ruleConfig : configRules) {
            String name = (String) ruleConfig.get("name");
            String description = (String) ruleConfig.get("description");
            rules.add(new Rule(name, description));
        }
        return rules;

    }


}
