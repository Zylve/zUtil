package net.zylve.zutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.zylve.zutil.commands.CoordinatesConsent;
import net.zylve.zutil.commands.GetIP;
import net.zylve.zutil.commands.ReloadConfirm;
import net.zylve.zutil.commands.Shout;
import net.zylve.zutil.commands.StackCount;
import net.zylve.zutil.commands.Sudo;
import net.zylve.zutil.events.DeathLocation;
import net.zylve.zutil.events.PlayerJoin;
import net.zylve.zutil.lib.CoordinatesManager;

public class Main extends JavaPlugin {
    private final FileConfiguration config = this.getConfig();
    private Connection connection;

    
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

    private void InitializeDatabase() {
        String host = (String)config.get("database.host");
        String port = config.get("database.port").toString();
        String database = (String)config.get("database.database");
        String user = (String)config.get("database.user");
        String password = (String)config.get("database.password");

        String url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[zUtil] Failed to connect to the MySQL server! Is config.yml correct?");
        }
    }

    private void TerminateDatabase() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[zUtil] Failed to close the MySQL connection!");
        }
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        InitializeDatabase();
        CoordinatesManager.init(connection);

        RegisterCommands();
        RegisterEvents();
    }

    @Override
    public void onDisable() {
        TerminateDatabase();
    }

    private final HashMap<String, CommandExecutor> Commands = new HashMap<String, CommandExecutor>() {
        {
            put("shout", new Shout());
            put("rlc", new ReloadConfirm());
            put("getip", new GetIP());
            put("stackcount", new StackCount());
            put("sc", new StackCount());
            put("coordinatesconsent", new CoordinatesConsent());
            put("cc", new CoordinatesConsent());
            put("sudo", new Sudo());
        }
    };
    
    private final HashSet<Listener> Events = new HashSet<Listener>() {
        {
            add(new DeathLocation());
            add(new PlayerJoin());
        }
    };
}
