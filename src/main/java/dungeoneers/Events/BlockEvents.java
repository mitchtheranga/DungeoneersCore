package dungeoneers.Events;

import dungeoneers.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class BlockEvents implements Listener {
    public final Main plugin;

    public BlockEvents(Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockExplode(EntityExplodeEvent e) {
        e.blockList().clear();
    }

}