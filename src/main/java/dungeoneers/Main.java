package dungeoneers;

import dungeoneers.Events.BlockEvents;
import dungeoneers.Events.DamageEvents.PlayerDamageMobEvents;
import dungeoneers.Events.JoinLeaveEvents;
import dungeoneers.Events.MobSummonEvents;
import dungeoneers.Events.PlayerStats;
import dungeoneers.Items.SetRarityCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        checkStats();
        registerEvents();
        getCommand("testitem").setExecutor(new GiveTestItem());
        getCommand("checkstats").setExecutor(new CheckStatsCommand(this));
        getCommand("setrarity").setExecutor(new SetRarityCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents(){
        new JoinLeaveEvents(this);
        new BlockEvents(this);
        new PlayerDamageMobEvents(this);
        new CheckStatsCommand(this);
        new MobSummonEvents(this);
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
