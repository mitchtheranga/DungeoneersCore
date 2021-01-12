package dungeoneers.Events.DamageEvents;

import dungeoneers.Main;
import dungeoneers.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerDamageMobEvents implements Listener {
    public final Main plugin;

    public PlayerDamageMobEvents(Main plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e){
        Entity mob = e.getEntity();
        if(!e.getDamager().getType().equals(EntityType.PLAYER)){
            return;
        }
        if(e.getEntityType().equals(EntityType.ARMOR_STAND)){
            e.setCancelled(true);
            return;
        }
        if(mob.getCustomName().contains(Utils.chat("&7[&fLvl 10&7] &cVillager &7"))){
            String name = mob.getCustomName();
            name = name.replace(Utils.chat("&7[&fLvl 10&7] &cVillager &7[&f"), "");
            name = name.replace(Utils.chat("/100&7]"), "");
            Integer health = Integer.parseInt(ChatColor.stripColor(name));
            health -= DamageCalculator.damageCalc((Player) e.getDamager());
            if(health <= 0) {
                e.setDamage(1000);
                mob.setCustomName(Utils.chat("&7[&fLvl 10&7] &cVillager &7[&f0/100&7]"));
            }else{
                mob.setCustomName(Utils.chat("&7[&fLvl 10&7] &cVillager &7[&f" + health + "/100&7]"));
            }
        }else {
            e.setDamage(1);
            ((LivingEntity) mob).setHealth(((LivingEntity) mob).getMaxHealth());
        }
    }
}
