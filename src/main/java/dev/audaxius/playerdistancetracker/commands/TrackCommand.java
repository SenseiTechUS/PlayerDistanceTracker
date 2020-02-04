package dev.audaxius.playerdistancetracker.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import dev.audaxius.playerdistancetracker.PlayerDistanceTracker;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

@CommandAlias("track|playerdistancetracker|pdt")
public class TrackCommand extends BaseCommand {

    public static Map<Player, Player> trackers = new HashMap<>();
    private static PlayerDistanceTracker instance = PlayerDistanceTracker.getInstance();
    private static Server server = instance.getServer();

    @Default
    @Syntax("/track [target]")
    @Description("Track nearest player's distance")
    @CommandCompletion("@players")
    public static void onTrack(Player player, @Optional String target) {
        if (target != null) {
            if (server.getPlayer(target) != null) {
                trackers.put(player, server.getPlayer(target));
                player.sendMessage(ChatColor.AQUA + "Tracking " + ChatColor.WHITE + target);
            } else {
                player.sendMessage(ChatColor.RED + target + " not found!");
                return;
            }
        } else {
            double distance = Double.MAX_VALUE;
            Player closestTarget = player;
            for (Player cTarget : server.getOnlinePlayers()) {
                double distanceTemp = player.getLocation().distance(cTarget.getLocation());
                if (distanceTemp < distance && distanceTemp != 0) {
                    distance = distanceTemp;
                    closestTarget = cTarget;
                }
            }
            trackers.put(player, closestTarget);
            player.sendMessage(ChatColor.AQUA + "Tracking " + ChatColor.WHITE + closestTarget.getDisplayName());
        }
    }

    public static Map<Player, Player> getTrackers() {
        return trackers;
    }
}
