package dungeoneers;

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
        String hidden = "";
        for(char c : message.toCharArray()){
            hidden += ChatColor.COLOR_CHAR + "" + c;
        }
        return hidden;
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
        HashMap<String, Integer> swordSeq = new HashMap<String, Integer>();
        swordSeq.put("Damage:", 0);
        swordSeq.put("Strength:", 1);
        swordSeq.put("Crit Chance:", 2);
        swordSeq.put("Crit Damage:", 3);
        swordSeq.put("Defence:", 4);
        swordSeq.put("Intelligence:", 5);
        HashMap<String, Integer> armorSeq = new HashMap<String, Integer>();
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
                if(amount == 0){
                }else {
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
}
