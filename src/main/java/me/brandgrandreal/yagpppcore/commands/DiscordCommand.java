package me.brandgrandreal.yagpppcore.commands;

import me.brandgrandreal.yagpppcore.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player player)) {
            Bukkit.getLogger().info("Only a player can execute this command!");
            return true;
        }

        player.sendMessage(" ");

        String discordMessage = ChatColor.translateAlternateColorCodes
                ('&', "&b&lClick on me to join our discord! :)");
        ChatUtil.sendClickableDiscordMsg(player, discordMessage);

        player.sendMessage(" ");

        return true;
    }
}
