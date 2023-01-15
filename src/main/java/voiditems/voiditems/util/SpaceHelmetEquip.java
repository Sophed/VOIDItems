package voiditems.voiditems.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import voiditems.voiditems.VOIDItems;

import java.util.List;


public class SpaceHelmetEquip implements Listener {
    public SpaceHelmetEquip(VOIDItems plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private final Plugin plugin = VOIDItems.getPlugin(VOIDItems.class);
    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getInventory().getItemInMainHand();
        if (!i.hasItemMeta() || !i.getItemMeta().hasLore()) return;
        List<String> lore = i.getItemMeta().getLore();
        if(lore.get(0).equals("§8§oVOID_SPACE_HELMET")) {
            ItemStack currentHelmet = p.getInventory().getHelmet();
            p.getInventory().setHelmet(p.getInventory().getItemInMainHand());
            p.getInventory().setItemInMainHand(currentHelmet);
        }
    }
}
