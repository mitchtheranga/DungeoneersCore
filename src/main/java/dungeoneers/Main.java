package dungeoneers;

import dungeoneers.PlayerEvents.BlockEvents;
import dungeoneers.PlayerEvents.CheckStatsCommand;
import dungeoneers.PlayerEvents.JoinLeaveEvents;
import dungeoneers.PlayerEvents.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerEvents();
        getCommand("testitem").setExecutor(new GiveTestItem());
        getCommand("checkstats").setExecutor(new CheckStatsCommand());

        checkStats();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents(){
        new JoinLeaveEvents(this);
        new BlockEvents(this);
    }

    public void checkStats() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()){
                    PlayerStats.checkStats(player.getUniqueId());
                }
            }
        }, 0L, 20L);
    }
}
