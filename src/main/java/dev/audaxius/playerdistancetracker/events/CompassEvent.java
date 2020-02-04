package dev.audaxius.playerdistancetracker.events;

import dev.audaxius.playerdistancetracker.commands.TrackCommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class CompassEvent implements Listener {

    private static Map<Player, Player> trackers = TrackCommand.getTrackers();

    @EventHandler
    public void onHoldCompass(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItem(event.getNewSlot());

        ItemStack compass = new ItemStack(Material.COMPASS);
        if (item == null) {
            return;
        }
        if (item.isSimilar(compass)) {
            if (trackers.containsKey(player)) {
                Player target = trackers.get(player);
                int distance = (int) player.getLocation().distance(target.getLocation());
                player.sendActionBar(ChatColor.WHITE + target.getDisplayName() + ChatColor.AQUA + " is " + ChatColor.WHITE + distance + ChatColor.AQUA + " blocks away");
            }
        }
    }
}
