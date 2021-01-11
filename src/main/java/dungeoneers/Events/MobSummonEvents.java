package dungeoneers.Events;

import dungeoneers.Main;
import dungeoneers.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSummonEvents implements Listener {
    public final Main plugin;

    public MobSummonEvents(Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onSummon(EntitySpawnEvent e){
        if(e.getEntityType().equals(EntityType.VILLAGER)){
            Villager villager = (Villager) e.getEntity();
            villager.setCustomName(Utils.chat("&7[&fLvl 10&7] &cVillager &7[&f100/100&7]"));
            villager.setCustomNameVisible(true);
            villager.setProfession(Villager.Profession.FARMER);
            villager.setCanPickupItems(false);
            villager.setAdult();
        }
    }
}
