package dungeoneers.Items;

import dungeoneers.Items.Weapons.SwordOfLegends;
import dungeoneers.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ItemList {

    public static ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();

    public static void checkPlayerItems(Player player){
        addItemsToList();
        Inventory inv = player.getInventory();
        for(ItemStack item : inv.getContents()){
            if(item != null) {
                if(item.hasItemMeta()) {
                    if (item.getItemMeta().hasDisplayName()) {
                        for (ItemStack lItem : itemList) {
                            if (ChatColor.stripColor(item.getItemMeta().getDisplayName()).equalsIgnoreCase(ChatColor.stripColor(lItem.getItemMeta().getDisplayName()))) {
                                item.setItemMeta(lItem.getItemMeta());
                                Bukkit.broadcastMessage("Updated item " + lItem.getItemMeta().getDisplayName());
                            }
                        }
                    }
                }
            }
        }
    }

    public static void addItemsToList(){
        itemList.add(SwordOfLegends.swordOfLegends());
    }
}
