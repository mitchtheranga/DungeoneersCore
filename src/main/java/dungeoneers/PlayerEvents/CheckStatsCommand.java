package dungeoneers.PlayerEvents;

import dungeoneers.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CheckStatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("checkstats")){
            Player player = (Player) sender;
            UUID playerUUID = player.getUniqueId();
            player.sendMessage(Utils.chat("&aHealth: " + PlayerStats.playerHealth.get(playerUUID)));
            player.sendMessage(Utils.chat("&aDefence: " + PlayerStats.playerDefence.get(playerUUID)));
            player.sendMessage(Utils.chat("&cStrength: " + PlayerStats.playerStrength.get(playerUUID)));
            player.sendMessage(Utils.chat("&cCrit Damage: " + PlayerStats.playerCritDamage.get(playerUUID)));
            player.sendMessage(Utils.chat("&cCrit Chance: " + PlayerStats.playerCritChance.get(playerUUID)));
            player.sendMessage(Utils.chat("&aIntelligence: " + PlayerStats.playerIntelligence.get(playerUUID)));
        }
        return false;
    }
}
