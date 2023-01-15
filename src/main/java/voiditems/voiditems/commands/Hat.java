package voiditems.voiditems.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hat implements CommandExecutor {

    public String prefix = "&b&lVOIDItems &f> ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the sender is console
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cYou cannot run this command from console."));
            return true;
        }
        // Check if the player has permission
        if (!sender.hasPermission("VOIDItems.Hat")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cYou do not have permission to use this."));
            return true;
        }
        // Now we know that the player is NOT console and DOES have permissions.
        Player player = (Player) sender;
        ItemStack currentHelmet = player.getInventory().getHelmet();
        player.getInventory().setHelmet(player.getInventory().getItemInMainHand());
        player.getInventory().setItemInMainHand(currentHelmet);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&7Swapped item in your main hand with item on your head!"));

        return true;
    }
}
