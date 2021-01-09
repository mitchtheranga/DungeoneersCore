package dungeoneers.Events.DamageEvents;

import dungeoneers.Main;
import dungeoneers.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageMobEvents implements Listener {
    public final Main plugin;

    public PlayerDamageMobEvents(Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
        if(!e.getDamager().getType().equals(EntityType.PLAYER)){
            return;
        }
        e.setCancelled(true);
        Entity mob = e.getEntity();
        e.setDamage(1);
        ((LivingEntity)mob).setHealth(((LivingEntity) mob).getMaxHealth());
        Bukkit.broadcastMessage(DamageCalculator.damageCalc((Player) e.getDamager()).toString());
    }
}
