package dungeoneers;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GiveTestItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("testitem")) {
            if (true) {
                ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Utils.chat("&3Test Item"));
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(Utils.chat("&7Strength: &c+10"));
                lore.add(Utils.chat("&7Crit Chance: &c+16"));
                lore.add(Utils.chat("&7Crit Damage: &c+11"));
                lore.add(Utils.chat(""));
                lore.add(Utils.chat("&7Health: &a+16"));
                lore.add(Utils.chat("&7Defence: &a-21"));
                lore.add(Utils.chat("&7Intelligence: &a+10"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
            }
            if (true) {
                ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Utils.chat("&3Test Item"));
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(Utils.chat("&7Strength: &c+102"));
                lore.add(Utils.chat("&7Crit Chance: &c+1"));
                lore.add(Utils.chat("&7Crit Damage: &c+2"));
                lore.add(Utils.chat(""));
                lore.add(Utils.chat("&7Health: &a+13"));
                lore.add(Utils.chat("&7Defence: &a-24"));
                lore.add(Utils.chat("&7Intelligence: &a+15"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
            }
            if (true) {
                ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Utils.chat("&3Test Item"));
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(Utils.chat("&7Strength: &c+1024"));
                lore.add(Utils.chat("&7Crit Chance: &c+916"));
                lore.add(Utils.chat("&7Crit Damage: &c-1911"));
                lore.add(Utils.chat(""));
                lore.add(Utils.chat("&7Health: &a-616"));
                lore.add(Utils.chat("&7Defence: &a+721"));
                lore.add(Utils.chat("&7Intelligence: &a+80"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
            }
            if (true) {
                ItemStack item = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Utils.chat("&3Test Item"));
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(Utils.chat("&7Strength: &c-5"));
                lore.add(Utils.chat("&7Crit Chance: &c+16"));
                lore.add(Utils.chat("&7Crit Damage: &c-11"));
                lore.add(Utils.chat(""));
                lore.add(Utils.chat("&7Health: &a-16"));
                lore.add(Utils.chat("&7Defence: &a-21"));
                lore.add(Utils.chat("&7Intelligence: &a+10"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
            }
            if (true) {
                ItemStack item = new ItemStack(Material.WOOD_SWORD);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Utils.chat("&3Test Item"));
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(Utils.chat("&7Strength: &c+15"));
                lore.add(Utils.chat("&7Crit Chance: &c+11"));
                lore.add(Utils.chat("&7Crit Damage: &c+16"));
                lore.add(Utils.chat(""));
                lore.add(Utils.chat("&7Health: &a-12"));
                lore.add(Utils.chat("&7Defence: &a-5"));
                lore.add(Utils.chat("&7Intelligence: &a-18"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
            }
        }
        return false;
    }
}
