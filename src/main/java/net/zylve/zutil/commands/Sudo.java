package net.zylve.zutil.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sudo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "You must provide a player!");
            return false;
        }

        if(args.length == 1) {
            return true;
        }

        Player player = Bukkit.getPlayerExact(args[0]);
        String message = "";

        if(player == null) {
            sender.sendMessage(ChatColor.RED + "Player is not online!");
            return false;
        }

        for(int i = 1; i < args.length; i++) {
            message += args[i] + " ";
        }

        player.chat(message);

        return true;
    }
    
}
