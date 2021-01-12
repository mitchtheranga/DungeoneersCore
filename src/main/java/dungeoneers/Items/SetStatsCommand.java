package dungeoneers.Items;

import dungeoneers.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetStatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("setstats")) {
            if(!(sender instanceof Player)){
                sender.sendMessage(Utils.chat("&cYou must be a player to run this command!"));
                return true;
            }
            Player player = (Player) sender;
            if(args.length <= 0) {
                player.sendMessage(Utils.chat("&cIncorrect Usage! Do /setstats <Stat> <Amount>."));
                return true;
            }
            String ref = args[0];
            ItemStack item = player.getItemInHand();
            if(ref.equalsIgnoreCase("Damage")){
                if(!Utils.checkType(item).equalsIgnoreCase("sword")){
                    player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                    return true;
                }
                player.setItemInHand(Utils.addStat(item, "Damage:", Integer.parseInt(args[1]), "&c", true));
            }
            if(ref.equalsIgnoreCase("Strength")){
                if(!Utils.checkType(item).equalsIgnoreCase("sword")){
                    if(!Utils.checkType(item).equalsIgnoreCase("armor")){
                        player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                        return true;
                    }
                }
                player.setItemInHand(Utils.addStat(item, "Strength:", Integer.parseInt(args[1]), "&c", true));
            }
            if(ref.equalsIgnoreCase("CritDamage")){
                if(!Utils.checkType(item).equalsIgnoreCase("sword")){
                    if(!Utils.checkType(item).equalsIgnoreCase("armor")){
                        player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                        return true;
                    }
                }
                player.setItemInHand(Utils.addStat(item, "Crit Damage:", Integer.parseInt(args[1]), "&c", true));
            }
            if(ref.equalsIgnoreCase("CritChance")){
                if(!Utils.checkType(item).equalsIgnoreCase("sword")){
                    if(!Utils.checkType(item).equalsIgnoreCase("armor")){
                        player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                        return true;
                    }
                }
                player.setItemInHand(Utils.addStat(item, "Crit Chance:", Integer.parseInt(args[1]), "&c", true));
            }
            if(ref.equalsIgnoreCase("Intelligence")){
                if(!Utils.checkType(item).equalsIgnoreCase("sword")){
                    if(!Utils.checkType(item).equalsIgnoreCase("armor")){
                        player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                        return true;
                    }
                }
                player.setItemInHand(Utils.addStat(item, "Intelligence:", Integer.parseInt(args[1]), "&a", true));
            }
            if(ref.equalsIgnoreCase("Health")){
                if(!Utils.checkType(item).equalsIgnoreCase("armor")){
                    player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                    return true;
                }
                player.setItemInHand(Utils.addStat(item, "Health:", Integer.parseInt(args[1]), "&a", true));
            }
            if(ref.equalsIgnoreCase("Defence")){
                if(!Utils.checkType(item).equalsIgnoreCase("sword")){
                    if(!Utils.checkType(item).equalsIgnoreCase("armor")){
                        player.sendMessage(Utils.chat("&cThat reforge does not apply to this item."));
                        return true;
                    }
                }
                player.setItemInHand(Utils.addStat(item, "Defence:", Integer.parseInt(args[1]), "&a", true));
            }
        }
        return false;
    }
}
