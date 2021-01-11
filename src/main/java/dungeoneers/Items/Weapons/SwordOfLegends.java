package dungeoneers.Items.Weapons;

import dungeoneers.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SwordOfLegends {
    public static ItemStack swordOfLegends(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat("&5Sword Of Legends"));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Utils.chat("&7Damage: &c+200"));
        lore.add(Utils.chat("&7Strength: &c+125"));
        lore.add(Utils.chat("&7Crit Chance: &c+100"));
        lore.add(Utils.invis(String.valueOf(System.currentTimeMillis())));
        lore.add(Utils.chat("&8this item can be reforged."));
        lore.add(Utils.chat("&5&lEPIC SWORD"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
