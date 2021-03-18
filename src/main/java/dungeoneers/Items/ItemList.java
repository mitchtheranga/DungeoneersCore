package dungeoneers.Items;

import dungeoneers.Items.Weapons.SwordOfLegends;
import dungeoneers.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static dungeoneers.Items.SetReforgeCommand.reforgeItem;

public class ItemList implements CommandExecutor {

    public static List<ItemStack> itemList = new CopyOnWriteArrayList<>();

    public static void checkPlayerItems(Player player){
        addItemsToList();
        Inventory inv = player.getInventory();
        for(ItemStack item : inv.getContents()){
            if(item != null) {
                if(item.hasItemMeta()) {
                    if (item.getItemMeta().hasDisplayName()) {
                        for (ItemStack lItem : itemList) {
                            if (ChatColor.stripColor(item.getItemMeta().getDisplayName()).contains(ChatColor.stripColor(lItem.getItemMeta().getDisplayName()))) {
                                SetReforgeCommand.resetReforgeList();
                                if(SetReforgeCommand.reforgeList.contains(ChatColor.stripColor(item.getItemMeta().getDisplayName()).split(" ")[0])){
                                    item.setItemMeta(SetReforgeCommand.reforgeItem(item, ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0])).getItemMeta());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static ItemStack refreshItem(ItemStack item){
        addItemsToList();
        if(item != null) {
            if(item.hasItemMeta()) {
                if (item.getItemMeta().hasDisplayName()) {
                    for (ItemStack lItem : itemList) {
                        if (ChatColor.stripColor(item.getItemMeta().getDisplayName()).contains(ChatColor.stripColor(lItem.getItemMeta().getDisplayName()))) {
                            item.setItemMeta(Utils.changeRarity(lItem, Utils.checkRarity(item)).getItemMeta());
                            return item;
                        }
                    }
                }
            }
        }
        return item;
    }

    public static ItemStack updateItem(ItemStack item){
        if(item != null) {
            if(item.hasItemMeta()) {
                if (item.getItemMeta().hasDisplayName()) {
                    for (ItemStack lItem : itemList) {
                        if (ChatColor.stripColor(item.getItemMeta().getDisplayName()).contains(ChatColor.stripColor(lItem.getItemMeta().getDisplayName()))) {
                            SetReforgeCommand.resetReforgeList();
                            if(SetReforgeCommand.reforgeList.contains(ChatColor.stripColor(item.getItemMeta().getDisplayName()).split(" ")[0])){
                                item.setItemMeta(SetReforgeCommand.reforgeItem(item, ChatColor.stripColor(item.getItemMeta().getDisplayName().split(" ")[0])).getItemMeta());
                            }
                        }
                    }
                }
            }
        }
        return item;
    }

    public static void addItemsToList(){
        itemList.add(SwordOfLegends.swordOfLegends());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("resetitem")) {
            if(!(sender instanceof Player)){
                sender.sendMessage(Utils.chat("&cYou must be a player to run this command!"));
                return true;
            }
            Player player = (Player) sender;
            if(args.length <= 0) {
                player.sendMessage(Utils.chat("&cIncorrect Usage! Do /resetitem."));
                return true;
            }
            player.setItemInHand(refreshItem(player.getItemInHand()));
        }
        if(command.getName().equalsIgnoreCase("updateitem")) {
            if(!(sender instanceof Player)){
                sender.sendMessage(Utils.chat("&cYou must be a player to run this command!"));
                return true;
            }
            Player player = (Player) sender;
            if(args.length <= 0) {
                player.sendMessage(Utils.chat("&cIncorrect Usage! Do /updateitem."));
                return true;
            }
            player.setItemInHand(updateItem(player.getItemInHand()));
        }
        return false;
    }
}
