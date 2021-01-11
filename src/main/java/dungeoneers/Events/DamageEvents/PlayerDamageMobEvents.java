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
        Player player = (Player) e.getDamager();
        Location mobLoc = mob.getLocation();
        Location playerLoc = player.getLocation();
        if(false) {
            double difX = mobLoc.getX() - playerLoc.getX();
            double difY = mobLoc.getY() - playerLoc.getY();
            double difZ = mobLoc.getZ() - playerLoc.getZ();
            Location sLoc = mobLoc;
            double rX = Utils.getRandomInt(3) + 2;
            rX = rX / 10;
            double rY = Utils.getRandomInt(3) + 2;
            rY = rY / 10;
            double rZ = Utils.getRandomInt(3) + 2;
            rZ = rZ / 10;
            if (difX > 0 && difZ > 0) {
                sLoc = new Location(sLoc.getWorld(), sLoc.getX() - rX, sLoc.getY() - rY + .75, sLoc.getZ() - rZ);
            }
            if (difX > 0 && difZ < 0) {
                sLoc = new Location(sLoc.getWorld(), sLoc.getX() - rX, sLoc.getY() - rY + .75, sLoc.getZ() + rZ);
            }
            if (difX < 0 && difZ < 0) {
                sLoc = new Location(sLoc.getWorld(), sLoc.getX() + rX, sLoc.getY() - rY + .75, sLoc.getZ() + rZ);
            }
            if (difX < 0 && difZ > 0) {
                sLoc = new Location(sLoc.getWorld(), sLoc.getX() + rX, sLoc.getY() - rY + .75, sLoc.getZ() - rZ);
            }
            ArmorStand stand = (ArmorStand) mobLoc.getWorld().spawnEntity(sLoc, EntityType.ARMOR_STAND);
            stand.setCustomName(Utils.chat("&7" + DamageCalculator.damageCalc((Player) e.getDamager()).toString()));
            stand.setCustomNameVisible(true);
            stand.setGravity(false);
            stand.setCanPickupItems(false);
            stand.setSmall(true);

            Location difference = new Location(mobLoc.getWorld(), difX, difY, difZ);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {
                    stand.remove();
                }
            }, 20L);
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
