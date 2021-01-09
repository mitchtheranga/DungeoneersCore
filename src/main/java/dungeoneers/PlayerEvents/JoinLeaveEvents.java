package dungeoneers.PlayerEvents;

import dungeoneers.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinLeaveEvents implements Listener {
    public final Main plugin;

    public JoinLeaveEvents(Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        PlayerStats.checkStats(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        e.blockList().clear();
    }
}
