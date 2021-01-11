package dungeoneers.Events.DamageEvents;

import dungeoneers.Events.PlayerStats;
import dungeoneers.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DamageCalculator {
    public static Integer damageCalc(Player player){
        double damage = 10;
        PlayerStats.checkStats(player.getUniqueId());
        if(player.getItemInHand().getType() != null){
            ItemStack item = player.getInventory().getItemInHand();
            if(!item.hasItemMeta()){
                damage = 10;
            }else {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore()) {
                    for (String lore : meta.getLore()) {
                        if (lore.contains("Damage: ")) {
                            lore = lore.replace("Damage:" + " ", "");
                            Integer multiplier = 1;
                            if (lore.contains("+")) {
                                multiplier = 1;
                                lore = lore.replace("+", "");
                            }
                            if (lore.contains("-")) {
                                multiplier = -1;
                                lore = lore.replace("-", "");
                            }
                            lore = ChatColor.stripColor(lore);
                            damage += Integer.parseInt(lore);
                            break;
                        }
                    }
                }
            }
        }
        double chance = PlayerStats.playerCritChance.get(player.getUniqueId());
        boolean crit = false;
        if(Utils.getRandomInt(99) < chance) {
            crit = true;
        }
        double cdamage = 0;
        if(crit){
            cdamage = (PlayerStats.playerCritDamage.get(player.getUniqueId()));
        }
        double strength = (PlayerStats.playerStrength.get(player.getUniqueId()));
        if(false) {
            Bukkit.broadcastMessage("str " + strength + " dmg " + damage + " cdmg " + cdamage);
        }
        if(strength == 0){
            if(crit) {
                return (int) Math.round(damage * (cdamage / 100));
            }
            return (int) Math.round(damage);
        }else {
            if(crit) {
                return (int)  Math.round(damage * (1 + (strength / 50)) * (1 + (cdamage / 100)));
            }
            return (int) Math.round(damage * (1 + (strength / 50)));
        }

    }
}
