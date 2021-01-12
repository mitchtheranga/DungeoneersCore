package dungeoneers.Items;

import dungeoneers.Events.PlayerStats;
import dungeoneers.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class SetReforgeCommand implements CommandExecutor {

    public static ArrayList<String> reforgeList = new ArrayList<>();

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
                String rarity = Utils.checkRarity(item);
                if(rarity.equalsIgnoreCase("supreme")){
                    Utils.addReforge(item, "Stoned", 35, 0, 0, 0, 50, 0);
                }
                if(rarity.equalsIgnoreCase("mythic")){
                    Utils.addReforge(item, "Stoned", 30, 0, 0, 0, 40, 0);
                }
                if(rarity.equalsIgnoreCase("legendary")){
                    Utils.addReforge(item, "Stoned", 25, 0, 0, 0, 35, 0);
                }
                if(rarity.equalsIgnoreCase("epic")){
                    Utils.addReforge(item, "Stoned", 20, 0, 0, 0, 30, 0);
                }
                if(rarity.equalsIgnoreCase("rare")){
                    Utils.addReforge(item, "Stoned", 15, 0, 0, 0, 25, 0);
                }
                if(rarity.equalsIgnoreCase("uncommon")){
                    Utils.addReforge(item, "Stoned", 10, 0, 0, 0, 20, 0);
                }
                if(rarity.equalsIgnoreCase("common")){
                    Utils.addReforge(item, "Stoned", 5, 0, 0, 0, 15, 0);
                }
            }
        }
        return false;
    }

    public static void resetReforgeList(){
        reforgeList.add("Stoned");
    }

    public static boolean containsReforge(String reforge){
        reforgeList.add("Stoned");
        if(reforgeList.contains("reforge")){
            return true;
        }
        return false;
    }

    public static ItemStack reforgeItem(ItemStack item, String ref){
        if(ref.equalsIgnoreCase("stoned")){
            String rarity = Utils.checkRarity(item);
            if(rarity.equalsIgnoreCase("supreme")){
                item = Utils.addReforge(item, "Stoned", 35, 0, 0, 0, 50, 0);
            }
            if(rarity.equalsIgnoreCase("mythic")){
                item = Utils.addReforge(item, "Stoned", 30, 0, 0, 0, 40, 0);
            }
            if(rarity.equalsIgnoreCase("legendary")){
                item = Utils.addReforge(item, "Stoned", 25, 0, 0, 0, 35, 0);
            }
            if(rarity.equalsIgnoreCase("epic")){
                item = Utils.addReforge(item, "Stoned", 20, 0, 0, 0, 30, 0);
            }
            if(rarity.equalsIgnoreCase("rare")){
                item = Utils.addReforge(item, "Stoned", 15, 0, 0, 0, 25, 0);
            }
            if(rarity.equalsIgnoreCase("uncommon")){
                item = Utils.addReforge(item, "Stoned", 10, 0, 0, 0, 20, 0);
            }
            if(rarity.equalsIgnoreCase("common")){
                item = Utils.addReforge(item, "Stoned", 5, 0, 0, 0, 15, 0);
            }
        }
        if(ref.equalsIgnoreCase("stoned")){
            String rarity = Utils.checkRarity(item);
            if(rarity.equalsIgnoreCase("supreme")){
                item = Utils.addReforge(item, "Stoned", 35, 0, 0, 0, 50, 0);
            }
            if(rarity.equalsIgnoreCase("mythic")){
                item = Utils.addReforge(item, "Stoned", 30, 0, 0, 0, 40, 0);
            }
            if(rarity.equalsIgnoreCase("legendary")){
                item = Utils.addReforge(item, "Stoned", 25, 0, 0, 0, 35, 0);
            }
            if(rarity.equalsIgnoreCase("epic")){
                item = Utils.addReforge(item, "Stoned", 20, 0, 0, 0, 30, 0);
            }
            if(rarity.equalsIgnoreCase("rare")){
                item = Utils.addReforge(item, "Stoned", 15, 0, 0, 0, 25, 0);
            }
            if(rarity.equalsIgnoreCase("uncommon")){
                item = Utils.addReforge(item, "Stoned", 10, 0, 0, 0, 20, 0);
            }
            if(rarity.equalsIgnoreCase("common")){
                item = Utils.addReforge(item, "Stoned", 5, 0, 0, 0, 15, 0);
            }
        }
        return item;
    }
}
