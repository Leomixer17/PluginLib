package net.leonardo_dgs.pluginlib.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public final class Text {

    private static final Plugin PAPIPLUGIN = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");

    public static String setPlaceholders(String text)
    {
        return setPlaceholders(null, text);
    }

    public static String setPlaceholders(CommandSender sender, String text)
    {
        if (isPlaceholderAPISupported())
        {
            if (sender instanceof OfflinePlayer)
                return PlaceholderAPI.setPlaceholders((OfflinePlayer) sender, text);

            return PlaceholderAPI.setPlaceholders(null, text);
        }

        return ChatColor.translateAlternateColorCodes('&', text);
    }

    private static boolean isPlaceholderAPISupported()
    {
        return PAPIPLUGIN != null && PAPIPLUGIN.isEnabled();
    }

}
