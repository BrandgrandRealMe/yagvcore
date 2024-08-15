package me.brandgrandreal.yagpppcore.utils;

import me.brandgrandreal.yagpppcore.config.ConfigManager;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ChatUtil {

    public static void sendClickableDiscordMsg(Player player, String message, String url) {
        TextComponent textComponent = new TextComponent(message);
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));

        player.spigot().sendMessage(textComponent);
    }

}
