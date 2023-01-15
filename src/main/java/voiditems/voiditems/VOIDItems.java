package voiditems.voiditems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import voiditems.voiditems.commands.Hat;
import voiditems.voiditems.commands.SpaceHelmet;
import voiditems.voiditems.util.SpaceHelmetEquip;

import java.util.List;

public final class VOIDItems extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l=-=-=-=-=-=-=-=-=-=-=-=-=-=-"));
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lVOIDItems Successfully Loaded!"));
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l=-=-=-=-=-=-=-=-=-=-=-=-=-=-"));

        // Register Commands
        getCommand("voiditems").setExecutor(new voiditems.voiditems.commands.VOIDItems());
        getCommand("hat").setExecutor(new Hat());
        getCommand("spacehelmet").setExecutor(new SpaceHelmet());

        // Register Events
        new SpaceHelmetEquip(this);

        // Ugly ass code for space helmet please ignore <3
        int id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> Bukkit.getOnlinePlayers().forEach(p -> {
            ItemStack i = p.getInventory().getHelmet();
            if (i == null || !i.hasItemMeta() || !i.getItemMeta().hasLore()) return;
            List<String> lore = i.getItemMeta().getLore();
            if(lore.get(0).equals("§8§oVOID_SPACE_HELMET")) {
                switch (i.getType()){
                    case RED_STAINED_GLASS:
                        i.setType(Material.ORANGE_STAINED_GLASS);
                        break;
                    case ORANGE_STAINED_GLASS:
                        i.setType(Material.YELLOW_STAINED_GLASS);
                        break;
                    case YELLOW_STAINED_GLASS:
                        i.setType(Material.LIME_STAINED_GLASS);
                        break;
                    case LIME_STAINED_GLASS:
                        i.setType(Material.LIGHT_BLUE_STAINED_GLASS);
                        break;
                    case LIGHT_BLUE_STAINED_GLASS:
                        i.setType(Material.BLUE_STAINED_GLASS);
                        break;
                    case BLUE_STAINED_GLASS:
                        i.setType(Material.PURPLE_STAINED_GLASS);
                        break;
                    case PURPLE_STAINED_GLASS:
                        i.setType(Material.PINK_STAINED_GLASS);
                        break;
                    case PINK_STAINED_GLASS:
                        i.setType(Material.RED_STAINED_GLASS);
                        break;
                }
            }
        }), 0, 12);
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l=-=-=-=-=-=-=-=-=-=-=-=-=-=-"));
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&b&lVOIDItems Unloaded Successfully."));
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l=-=-=-=-=-=-=-=-=-=-=-=-=-=-"));
    }
}
