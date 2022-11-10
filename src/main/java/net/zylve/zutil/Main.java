package net.zylve.zutil;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import net.zylve.zutil.commands.GetIP;
import net.zylve.zutil.commands.ReloadConfirm;
import net.zylve.zutil.commands.Shout;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Succesfully loaded ZylveUtil" + ChatColor.GREEN);

        this.getCommand("shout").setExecutor(new Shout());
        this.getCommand("rlc").setExecutor(new ReloadConfirm());
        this.getCommand("getip").setExecutor(new GetIP());
    }

    @Override
    public void onDisable() {
        getLogger().info("Succesfully unloaded Zylve Util" + ChatColor.GREEN);
    }
}
