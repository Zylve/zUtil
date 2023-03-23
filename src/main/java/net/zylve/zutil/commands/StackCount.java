package net.zylve.zutil.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StackCount implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Please input a number!");
            return false;
        }

        int items;

        int sbox = 0;
        int stack = 0;

        String sboxPl = "";
        String stackPl = "";
        String itemPl = "";

        try {
            items = Integer.parseUnsignedInt(args[0]);
        } catch(Exception e) {
            sender.sendMessage(ChatColor.RED + "Please input a number!");
            return false;
        }

        if(items >= 1728) {
            sbox = items / 1728;
            items %= 1728;
        }

        if(sbox != 1) {
            sboxPl = "es";
        }

        if(items >= 64) {
            stack = items / 64;
            items %= 64;
        }

        if(stack != 1) {
            stackPl = "s";
        }

        if(items != 1) {
            itemPl = "s";
        }

        String message = String.format("%d Shulker box%s, %d stack%s, %d item%s", sbox, sboxPl, stack, stackPl, items, itemPl);

        sender.sendMessage(message);
        return true;
    }
}
