package dev.audaxius.playerdistancetracker.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import dev.audaxius.playerdistancetracker.PlayerDistanceTracker;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@CommandAlias("track|playerdistancetracker|pdt")
public class TrackCommand extends BaseCommand {

    @Default
    @Syntax("/track ")
    @Description("Track nearest player's distance")
    public static void onTrack(Player player){

    }
}
