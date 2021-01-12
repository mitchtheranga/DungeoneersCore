package dungeoneers.Items;

import dungeoneers.Events.PlayerStats;
import dungeoneers.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetReforgeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("setreforge")) {
            if(!(sender instanceof Player)){
                sender.sendMessage(Utils.chat("&cYou must be a player to run this command!"));
                return true;
            }
            Player player = (Player) sender;
            if(args.length <= 0) {
                player.sendMessage(Utils.chat("&cIncorrect Usage! Do /setreforge <Reforge>. Do /reforgelist for the list of possible reforges for that item."));
                return true;
            }
            String ref = args[0];
            ItemStack item = player.getItemInHand();
            if(ref.equalsIgnoreCase("stoned")){
                if(!Utils.checkType(item).equalsIgnoreCase("sword")){
                    player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                    return true;
                }
                player.setItemInHand(Utils.addStat(item, "Defence:", Integer.parseInt(args[1]), "&a", true));
            }
        }
        return false;
    }
}
