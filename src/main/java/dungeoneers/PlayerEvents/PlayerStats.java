package dungeoneers.PlayerEvents;

import dungeoneers.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class PlayerStats {

    public static HashMap<UUID, Integer> playerHealth = new HashMap<>();
    public static HashMap<UUID, Integer> playerDefence = new HashMap<>();
    public static HashMap<UUID, Integer> playerStrength = new HashMap<>();
    public static HashMap<UUID, Integer> playerCritDamage = new HashMap<>();
    public static HashMap<UUID, Integer> playerCritChance = new HashMap<>();
    public static HashMap<UUID, Integer> playerIntelligence = new HashMap<>();

    public static void checkStats(UUID playerUUID){
        Boolean cont = false;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getUniqueId().equals(playerUUID)){
                cont = true;
            }
        }
        if(!cont){
            return;
        }
        Player player = Bukkit.getPlayer(playerUUID);
        playerHealth.put(playerUUID, checkStat(player, "Health:"));
        playerDefence.put(playerUUID, checkStat(player, "Defence:"));
        playerStrength.put(playerUUID, checkStat(player, "Strength:"));
        playerCritDamage.put(playerUUID, checkStat(player, "Crit Damage:"));
        playerCritChance.put(playerUUID, checkStat(player, "Crit Chance:"));
        playerIntelligence.put(playerUUID, checkStat(player, "Intelligence:"));
    }

    public static Integer checkStat(Player player, String stat){
        Integer statAmount = 0;
        statAmount += checkHelmet(player, stat);
        statAmount += checkChestplate(player, stat);
        statAmount += checkLeggings(player, stat);
        statAmount += checkBoots(player, stat);
        statAmount += checkHand(player, stat);
        return statAmount + 100;
    }

    public static Integer checkHelmet(Player player, String stat){
        if(player.getInventory().getHelmet() != null){
            ItemStack item = player.getInventory().getHelmet();
            if(!item.hasItemMeta()){
                return 0;
            }
            ItemMeta meta = item.getItemMeta();
            if(meta.hasLore()) {
                for (String lore : meta.getLore()) {
                    if (lore.contains(stat)) {
                        lore = lore.replace(stat + " ", "");
                        Integer multiplier = 1;
                        if(lore.contains("+")){
                            multiplier = 1;
                            lore = lore.replace("+", "");
                        }
                        if(lore.contains("-")){
                            multiplier = -1;
                            lore = lore.replace("-", "");
                        }
                        lore = ChatColor.stripColor(lore);
                        return Integer.parseInt(lore) * multiplier;
                    }
                }
            }
        }
        return 0;
    }
    public static Integer checkChestplate(Player player, String stat){
        if(player.getInventory().getChestplate() != null){
            ItemStack item = player.getInventory().getChestplate();
            if(!item.hasItemMeta()){
                return 0;
            }
            ItemMeta meta = item.getItemMeta();
            if(meta.hasLore()) {
                for (String lore : meta.getLore()) {
                    if (lore.contains(stat)) {
                        lore = lore.replace(stat + " ", "");
                        Integer multiplier = 1;
                        if(lore.contains("+")){
                            multiplier = 1;
                            lore = lore.replace("+", "");
                        }
                        if(lore.contains("-")){
                            multiplier = -1;
                            lore = lore.replace("-", "");
                        }
                        lore = ChatColor.stripColor(lore);
                        return Integer.parseInt(lore) * multiplier;
                    }
                }
            }
        }
        return 0;
    }
    public static Integer checkLeggings(Player player, String stat){
        if(player.getInventory().getLeggings() != null){
            ItemStack item = player.getInventory().getLeggings();
            if(!item.hasItemMeta()){
                return 0;
            }
            ItemMeta meta = item.getItemMeta();
            if(meta.hasLore()) {
                for (String lore : meta.getLore()) {
                    if (lore.contains(stat)) {
                        lore = lore.replace(stat + " ", "");
                        Integer multiplier = 1;
                        if(lore.contains("+")){
                            multiplier = 1;
                            lore = lore.replace("+", "");
                        }
                        if(lore.contains("-")){
                            multiplier = -1;
                            lore = lore.replace("-", "");
                        }
                        lore = ChatColor.stripColor(lore);
                        return Integer.parseInt(lore) * multiplier;
                    }
                }
            }
        }
        return 0;
    }
    public static Integer checkBoots(Player player, String stat){
        if(player.getInventory().getLeggings() != null){
            ItemStack item = player.getInventory().getLeggings();
            if(!item.hasItemMeta()){
                return 0;
            }
            ItemMeta meta = item.getItemMeta();
            if(meta.hasLore()) {
                for (String lore : meta.getLore()) {
                    if (lore.contains(stat)) {
                        lore = lore.replace(stat + " ", "");
                        Integer multiplier = 1;
                        if(lore.contains("+")){
                            multiplier = 1;
                            lore = lore.replace("+", "");
                        }
                        if(lore.contains("-")){
                            multiplier = -1;
                            lore = lore.replace("-", "");
                        }
                        lore = ChatColor.stripColor(lore);
                        return Integer.parseInt(lore) * multiplier;
                    }
                }
            }
        }
        return 0;
    }
    public static Integer checkHand(Player player, String stat){
        if(player.getInventory().getItemInHand() != null){
            ItemStack item = player.getInventory().getItemInHand();
            if(!item.hasItemMeta()){
                return 0;
            }
            ItemMeta meta = item.getItemMeta();
            if(meta.hasLore()) {
                for (String lore : meta.getLore()) {
                    if (lore.contains(stat)) {
                        lore = lore.replace(stat + " ", "");
                        Integer multiplier = 1;
                        if(lore.contains("+")){
                            multiplier = 1;
                            lore = lore.replace("+", "");
                        }
                        if(lore.contains("-")){
                            multiplier = -1;
                            lore = lore.replace("-", "");
                        }
                        lore = ChatColor.stripColor(lore);
                        return Integer.parseInt(lore) * multiplier;
                    }
                }
            }
        }
        return 0;
    }
}
