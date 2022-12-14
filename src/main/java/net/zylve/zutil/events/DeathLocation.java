package net.zylve.zutil.events;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathLocation implements Listener {
    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent event) {
        Location location = event.getEntity().getLocation();

        int x = (int)location.getX();
        int y = (int)location.getY();
        int z = (int)location.getZ();

        String message = event.getDeathMessage();

        switch(location.getWorld().getName()) {
            case "world":
                message += String.format(" at %d %d %d in the Overworld", x, y, z);
                break;

            case "world_nether":
                message += String.format(" at %d %d %d in the Nether", x, y, z);
                break;

            case "world_the_end":
                message += String.format(" at %d %d %d in The End", x, y, z);
                break;

            default:
                message += String.format(" at %d %d %d in an unknown dimension", x, y, z);
                break;
        }

        event.setDeathMessage(message);
    }
}