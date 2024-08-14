package me.brandgrandreal.yagpppcore.commands;

import me.brandgrandreal.yagpppcore.utils.Rule;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.brandgrandreal.yagpppcore.config.ConfigManager;


import java.util.List;

public class RulesCommand implements CommandExecutor {
    private static final int RULES_PER_PAGE = 5;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player player)) {
            Bukkit.getLogger().info("Only a player can execute this command!");
            return true;
        }

        List<Rule> rules = ConfigManager.getRules();
        Bukkit.getLogger().info(ConfigManager.getRules().toString());
        int totalPages = (int) Math.ceil((double) rules.size() / RULES_PER_PAGE);
        int page = 1; // Default page

        // Handle page argument if provided
        if (args.length > 0) {
            try {
                page = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                player.sendMessage("Invalid page number.");
                return true;
            }
        }
        if (page < 1 || page > totalPages) {
            player.sendMessage("Invalid page number. Valid range: 1-" + totalPages);
            return true;
        }

        int startIndex = (page - 1) * RULES_PER_PAGE;
        int endIndex = Math.min(startIndex + RULES_PER_PAGE, rules.size());
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lRULES"));

        for (int i = startIndex; i < endIndex; i++) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "• &l" + rules.get(i).getName() + "&r " + rules.get(i).getDescription()));
        }

        player.sendMessage("Rules page " + page + " of " + totalPages);

        return true;
    }
}
