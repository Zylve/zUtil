package net.zylve.zutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Shout implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            return false;
        }

        String world = "";

        switch(player.getWorld().getName()) {
            case "world":
                world = String.format("the Overworld (%d %d %d Nether)", (int)player.getLocation().getX() / 8, (int)player.getLocation().getY(), (int)player.getLocation().getZ() / 8);
                break;

            case "world_nether":
            world = String.format("the Nether (%d %d %d Overworld)", (int)player.getLocation().getX() * 8, (int)player.getLocation().getY(), (int)player.getLocation().getZ() * 8);
                break;

            case "world_the_end":
                world = "The End";
                break;

            default:
                world = "an unknown dimension";
                break;
        }

        String message = String.format("%s is at %d %d %d in %s", player.getName(), (int)player.getLocation().getX(), (int)player.getLocation().getY(), (int)player.getLocation().getZ(), world);

        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + message);
        return true;
    }
}
