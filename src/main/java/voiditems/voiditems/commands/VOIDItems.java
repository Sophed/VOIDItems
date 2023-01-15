package voiditems.voiditems.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VOIDItems implements CommandExecutor {
    String prefix = "&b&lVOIDItems &f> ";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length == 0) {
            infoMsg(player, "&b&l[ VOIDItems, Created By Sophed ]");
            infoMsg(player, "&7&ohttps://github.com/Sophed");
            infoMsg(player, "&7&oUse \"/void help\" for more information.");
            return true;
        }

        // Check if the player has permission
        if (!player.hasPermission("VOID.Admin")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cYou do not have permission to do this."));
            return true;
        }

        return true;
    }

    public void infoMsg(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
}
