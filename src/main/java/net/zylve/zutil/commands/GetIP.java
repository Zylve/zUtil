package net.zylve.zutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetIP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            return false;
        }

        String message = String.format("The IP address of %s is %s", player.getName(), player.getAddress().getAddress().getHostAddress());
        Bukkit.broadcastMessage(ChatColor.RED + message);
        return true;
    }
}
