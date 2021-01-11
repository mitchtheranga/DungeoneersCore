package dungeoneers.Items;

import dungeoneers.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SetRarityCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("setrarity")) {
            if(!(sender instanceof Player)){
                sender.sendMessage(Utils.chat("&cYou must be a player to run this command!"));
                return true;
            }
            Player player = (Player) sender;
            if (args.length <= 0) {
                player.sendMessage(Utils.chat("&cIncorrect Usage! Do /setrarity <Rarity>."));
                return true;
            }
            player.setItemInHand(Utils.changeRarity(player.getItemInHand(), args[0]));
        }
        return false;
    }

}
