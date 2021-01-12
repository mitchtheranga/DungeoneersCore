package dungeoneers;

import dungeoneers.Events.PlayerStats;
import dungeoneers.Items.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Utils {
    public static String chat(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static Integer getRandomInt(Integer max) {
        Random ran = new Random();
        return ran.nextInt(max);
    }

    public static String invis(String message){
        StringBuilder hidden = new StringBuilder();
        for(char c : message.toCharArray()){
            hidden.append(ChatColor.COLOR_CHAR + "").append(c);
        }
        return hidden.toString();
    }

    public static String checkRarityColor(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        String lastLine = lore.get(lore.size() - 1);
        String lastWord = lastLine.split(" ")[0];
        return lastWord.split("")[0] + lastWord.split("")[1];
    }

    public static String checkRarity(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        String lastLine = lore.get(lore.size() - 1);
        String lastWord = lastLine.split(" ")[0];
        return ChatColor.stripColor(lastWord);
    }

    public static ItemStack changeRarity(ItemStack item, String rarity){
        String color = "&f";
        if(rarity.equalsIgnoreCase("uncommon")){
            color = "&a";
        }
        if(rarity.equalsIgnoreCase("rare")){
            color = "&9";
        }
        if(rarity.equalsIgnoreCase("epic")){
            color = "&5";
        }
        if(rarity.equalsIgnoreCase("legendary")){
            color = "&6";
        }
        if(rarity.equalsIgnoreCase("mythic")){
            color = "&d";
        }
        if(rarity.equalsIgnoreCase("supreme")){
            color = "&4";
        }
        if(rarity.equalsIgnoreCase("special")){
            color = "&c";
        }
        if(rarity.equalsIgnoreCase("very_special")){
            color = "&c";
        }
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(color + ChatColor.stripColor(meta.getDisplayName())));
        List<String> lore = meta.getLore();
        String lastLine = lore.get(lore.size() - 1);
        String lastWord = lastLine.split(" ")[1];
        String newLine = color + "&l"+ rarity.toUpperCase() + " " + lastWord;
        lore.remove(lore.size() - 1);
        if(newLine.contains("_")){
            newLine = newLine.replace("_", " ");
        }
        lore.add(Utils.chat(newLine));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static String checkType(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        String lastLine = lore.get(lore.size() - 1);
        String lastWord = lastLine.split(" ")[lastLine.split(" ").length - 1];
        if(lastWord.contains("helmet") || lastWord.contains("chestplate") || lastWord.contains("leggings") || lastWord.contains("boot")){
            return "armor";
        }
        return ChatColor.stripColor(lastWord);
    }

    public static ItemStack addStat(ItemStack item, String stat, Integer amount, String color, Boolean weapon){
        HashMap<String, Integer> swordSeq = new HashMap<>();
        swordSeq.put("Damage:", 0);
        swordSeq.put("Strength:", 1);
        swordSeq.put("Crit Chance:", 2);
        swordSeq.put("Crit Damage:", 3);
        swordSeq.put("Defence:", 4);
        swordSeq.put("Intelligence:", 5);
        HashMap<String, Integer> armorSeq = new HashMap<>();
        armorSeq.put("Strength:", 0);
        armorSeq.put("Crit Chance:", 1);
        armorSeq.put("Crit Damage:", 2);
        armorSeq.put("Health:", 3);
        armorSeq.put("Defence:", 4);
        armorSeq.put("Intelligence:", 5);
        ItemMeta meta = item.getItemMeta();
        String multi = "+";
        if(amount < 0){
            multi = "-";
            amount *= -1;
        }
        int i = 0;
        boolean contains = false;
        List<String> origLore = meta.getLore();
        List<String> newLores = new ArrayList<>();
        while(i < meta.getLore().size()) {
            String lore = meta.getLore().get(i);
            if (lore.contains(stat)) {
                contains = true;
                if(amount != 0){
                    String nLore = Utils.chat("&7" + stat + color + " " + multi + amount);
                    newLores.add(nLore);
                }
            }else{
                if(i != origLore.size() - 2 && i != origLore.size() - 1) {
                    newLores.add(origLore.get(i));
                }
            }
            i += 1;
        }
        if(!contains){
            if(weapon){
                int slot = swordSeq.get(stat);
                List<String> newLore = new ArrayList<>();
                int x = 0;
                while(x < origLore.size()) {
                    if (slot == x) {
                        newLore.add(Utils.chat("&7" + stat + color + " " + multi + amount));
                    }
                    if(x != origLore.size() - 2 && x != origLore.size() - 1) {
                        newLore.add(origLore.get(x));
                    }

                    x += 1;
                }
                newLore.add(meta.getLore().get(meta.getLore().size() - 2));
                newLore.add(meta.getLore().get(meta.getLore().size() - 1));
                meta.setLore(newLore);
            }else {
                int slot = armorSeq.get(stat);
                List<String> newLore = new ArrayList<>();
                int x = 0;
                while(x < origLore.size()) {
                    if (slot == x) {
                        newLore.add(Utils.chat("&7" + stat + color + " " + multi + amount));
                    }
                    if(x != origLore.size() - 2 && x != origLore.size() - 1) {
                        newLore.add(origLore.get(x));
                    }

                    x += 1;
                }
                newLore.add(meta.getLore().get(meta.getLore().size() - 2));
                newLore.add(meta.getLore().get(meta.getLore().size() - 1));
                meta.setLore(newLore);
            }
        }else{
            newLores.add(meta.getLore().get(meta.getLore().size() - 2));
            newLores.add(meta.getLore().get(meta.getLore().size() - 1));
            meta.setLore(newLores);
        }

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack addReforge(ItemStack item, String reforgeName, Integer strength, Integer critchance, Integer critdamage, Integer health, Integer defence, Integer intelligence) {
        ItemMeta meta = item.getItemMeta();
        meta = ItemList.refreshItem(item).getItemMeta();
        Boolean isWeapon = false;
        if (Utils.checkType(item).equalsIgnoreCase("sword")) {
            isWeapon = true;
        }
        ItemStack nItem = item;
        nItem.setItemMeta(meta);
        if (strength!=0){nItem = Utils.addStat(item, "Strength:", PlayerStats.checkItemStats(item, "Strength:") + strength, "&c", isWeapon);
        }if(critchance!=0){nItem = Utils.addStat(nItem, "Crit Chance:", PlayerStats.checkItemStats(item, "Crit Chance:") + critchance, "&c", isWeapon);
        }if(critdamage!=0){nItem = Utils.addStat(nItem, "Crit Damage:", PlayerStats.checkItemStats(item, "Crit Damage:") + critdamage, "&c", isWeapon);
        }if(defence!=0){nItem = Utils.addStat(nItem, "Defence:", PlayerStats.checkItemStats(item, "Defence:") + defence, "&a", isWeapon);
        }if(intelligence!=0){nItem = Utils.addStat(nItem, "Intelligence:", PlayerStats.checkItemStats(item, "Intelligence:") + intelligence, "&a", isWeapon);
        }if(health!=0&&!isWeapon){nItem = Utils.addStat(nItem, "Health:", PlayerStats.checkItemStats(item, "Health:") + health, "&a", isWeapon); }
        meta = nItem.getItemMeta();
        String color = Utils.checkRarityColor(item);
        reforgeName.toLowerCase();
        reforgeName = reforgeName.substring(0, 1).toUpperCase() + reforgeName.substring(1);
        String newName = Utils.chat(color + reforgeName + " " + ChatColor.stripColor(meta.getDisplayName()));
        meta.setDisplayName(newName);
        List<String> newLore = new ArrayList<>();
        int i = 0;
        while(i < meta.getLore().size()){
            String line = meta.getLore().get(i);
            boolean added = false;
            if(line.contains("Strength:") && strength != 0){
                added = true;
                if(strength > 0){
                    newLore.add(Utils.chat(line + " &9(" + reforgeName + " +" + strength + ")"));
                }
            }
            if(line.contains("Crit Chance:") && critchance != 0){
                added = true;
                if(critdamage > 0){
                    newLore.add(Utils.chat(line + " &9(" + reforgeName + " +" + critchance + ")"));
                }
            }
            if(line.contains("Crit Damage:") && critdamage != 0){
                added = true;
                if(critdamage > 0){
                    newLore.add(Utils.chat(line + " &9(" + reforgeName + " +" + critdamage + ")"));
                }
            }
            if(line.contains("Health:") && health != 0){
                added = true;
                if(health > 0){
                    newLore.add(Utils.chat(line + " &9(" + reforgeName + " +" + health + ")"));
                }
            }
            if(line.contains("Defence:") && defence != 0){
                added = true;
                if(defence > 0){
                    newLore.add(Utils.chat(line + " &9(" + reforgeName + " +" + defence + ")"));
                }
            }
            if(line.contains("Intelligence:") && intelligence != 0){
                added = true;
                if(intelligence > 0){
                    newLore.add(Utils.chat(line + " &9(" + reforgeName + " +" + intelligence + ")"));
                }
            }
            if(!added){
                newLore.add(line);
            }
            i += 1;
        }
        meta.setLore(newLore);
        item.setItemMeta(meta);
        return item;
    }
}
