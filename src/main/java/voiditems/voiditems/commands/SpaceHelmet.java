package voiditems.voiditems.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class SpaceHelmet implements CommandExecutor {

    public String prefix = "&b&lVOIDItems &f> ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the sender is console
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cYou cannot run this command from console."));
            return true;
        }
        // Check if the player has permission
        if (!sender.hasPermission("VOIDItems.SpaceHelmet")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cYou do not have permission to use this."));
            return true;
        }
        // Now we know that the player is NOT console and DOES have permissions.
        Player player = (Player) sender;

        if (args.length == 0) { // No argument provided.
            giveSpaceHelmet(player, player);

        } else { // Argument provided

            Player targetPlayer = player.getServer().getPlayer(args[0]);

            if (targetPlayer != null) { // If target is valid player
                giveSpaceHelmet(targetPlayer, player);

            } else { // Target is not valid player
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&cInvalid player"));
            }
        }
        return true;
    }

    public void giveSpaceHelmet(Player target, Player sender) {

        ItemStack item = new ItemStack(Material.RED_STAINED_GLASS);

        Inventory inv = target.getInventory();
        ItemMeta m = item.getItemMeta();
        if (m == null) { return; } // Return if there is no item data
        ArrayList<String> lore = new ArrayList<>();

        m.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lSpace Helmet"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&8&oVOID_SPACE_HELMET"));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7A rare space helmet given"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7to players by an admin."));
        lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7To: &c" + target.getPlayerListName()));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7From: &c" + sender.getPlayerListName()));
        m.setLore(lore);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        m.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        m.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier2);

        item.setItemMeta(m);
        inv.addItem(item);
    }
}
