package net.zylve.zutil;

import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.zylve.zutil.commands.GetIP;
import net.zylve.zutil.commands.ReloadConfirm;
import net.zylve.zutil.commands.Shout;
import net.zylve.zutil.commands.StackCount;
import net.zylve.zutil.commands.Sudo;
import net.zylve.zutil.events.DeathLocation;

public class Main extends JavaPlugin {
    private final HashMap<String, CommandExecutor> Commands = new HashMap<String, CommandExecutor>() {
        {
            put("shout", new Shout());
            put("rlc", new ReloadConfirm());
            put("getip", new GetIP());
            put("stackcount", new StackCount());
            put("sc", new StackCount());
            put("sudo", new Sudo());
        }
    };

    private final HashSet<Listener> Events = new HashSet<Listener>() {
        {
            add(new DeathLocation());
        }
    };

    private void RegisterCommands() {
        for(String key : Commands.keySet()) {
            this.getCommand(key).setExecutor(Commands.get(key));
        }
    }

    private void RegisterEvents() {
        for(Listener l : Events) {
            this.getServer().getPluginManager().registerEvents(l, this);
        }
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Succesfully loaded zUtil");

        RegisterCommands();
        RegisterEvents();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Succesfully unloaded zUtil");
    }
}
