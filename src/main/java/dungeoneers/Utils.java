package dungeoneers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
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
}
