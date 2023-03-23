package net.zylve.zutil.commands;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.zylve.zutil.lib.CoordinatesManager;

public class CoordinatesConsent implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            return false;
        }

        // if(args.length == 0) {
        //     CoordinatesManager.getConsents();
        //     return true;
        // }

        if(args[0].equals("add")) {
            if(args.length < 2) {
                sender.sendMessage(ChatColor.RED + "Please give a username!");
            }

            for(int i = 1; i < args.length; i++) {
                try {
                    CoordinatesManager.addPlayer(player.getName(), Bukkit.getPlayer(args[i]).getName());
                } catch(SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

        return true;
    }
}
