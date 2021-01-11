package dungeoneers;

import dungeoneers.Items.Weapons.SwordOfLegends;
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
            if(args[0].equalsIgnoreCase("SWORD_OF_LEGENDS")){
                player.getInventory().addItem(SwordOfLegends.swordOfLegends());
            }
        }
        return false;
    }
}
