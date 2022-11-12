package net.zylve.zutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Shout implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            return false;
        }

        String world = "";

        int x = (int)player.getLocation().getX();
        int y = (int)player.getLocation().getY();
        int z = (int)player.getLocation().getZ();

        switch(player.getWorld().getName()) {
            case "world":
                world = String.format("the Overworld (%d %d %d Nether)", x / 8, y, z / 8);
                break;

            case "world_nether":
                world = String.format("the Nether (%d %d %d Overworld)", x * 8, y, z * 8);
                break;

            case "world_the_end":
                world = "The End";
                break;

            default:
                world = "an unknown dimension";
                break;
        }

        String message = String.format("%s is at %d %d %d in %s", player.getName(), x, y, z, world);

        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + message);
        return true;
    }
}
