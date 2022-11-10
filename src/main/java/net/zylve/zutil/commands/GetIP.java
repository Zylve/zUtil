package net.zylve.zutil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class GetIP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            return false;
        }

        String message = String.format("The IP address of %s is %s", player.getName(), player.getAddress().getAddress().getHostAddress());
        sender.sendMessage(ChatColor.RED + message);
        return true;
    }
}


