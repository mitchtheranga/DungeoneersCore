package dungeoneers;

import dungeoneers.Events.PlayerStats;
import dungeoneers.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.UUID;

public class CheckStatsCommand implements CommandExecutor,Listener {
    private final Main plugin;


    public CheckStatsCommand(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("checkstats")){
            Player player = (Player) sender;
            UUID playerUUID = player.getUniqueId();
            PlayerStats.checkStats(playerUUID);
            if(false) {
                player.sendMessage(Utils.chat("&aHealth: " + PlayerStats.playerHealth.get(playerUUID)));
                player.sendMessage(Utils.chat("&aDefence: " + PlayerStats.playerDefence.get(playerUUID)));
                player.sendMessage(Utils.chat("&cStrength: " + PlayerStats.playerStrength.get(playerUUID)));
                player.sendMessage(Utils.chat("&cCrit Damage: " + PlayerStats.playerCritDamage.get(playerUUID)));
                player.sendMessage(Utils.chat("&cCrit Chance: " + PlayerStats.playerCritChance.get(playerUUID)));
                player.sendMessage(Utils.chat("&aIntelligence: " + PlayerStats.playerIntelligence.get(playerUUID)));
            }
            int defence = PlayerStats.playerDefence.get(playerUUID);
            if(defence < 0){
                defence = 0;
            }
            int strength = PlayerStats.playerStrength.get(playerUUID);
            if(strength < 0){
                strength = 0;
            }
            int cdamage = PlayerStats.playerCritDamage.get(playerUUID);
            if(cdamage < 0){
                cdamage = 0;
            }
            int cchance = PlayerStats.playerCritChance.get(playerUUID);
            if(cchance < 0){
                cchance = 0;
            }
            Inventory inv = Bukkit.createInventory(null, 27, Utils.chat("&7Stats"));
            inv.setItem(13, createSkullItem(player, "&9" + player.getName() + "'s Stats",
                    Utils.chat("&cHealth: " + PlayerStats.playerHealth.get(playerUUID)),
                    Utils.chat("&aDefence: " + defence),
                    Utils.chat("&cStrength: " + strength),
                    Utils.chat("&9Crit Chance: " + cchance),
                    Utils.chat("&9Crit Damage: " + cdamage),
                    Utils.chat("&bIntelligence: " + PlayerStats.playerIntelligence.get(playerUUID))));
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run(){
                    player.openInventory(inv);
                }
            }, 1L);
        }
        return false;
    }

    public ItemStack createItem(Material mat, String name, String... lore){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(name));
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack createSkullItem(Player player, String name, String... lore){
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta smeta = (SkullMeta) item.getItemMeta();
        smeta.setOwner(player.getName());
        smeta.setDisplayName(Utils.chat(name));
        smeta.setLore(Arrays.asList(lore));
        item.setItemMeta(smeta);
        return item;
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getInventory().getName().equalsIgnoreCase(Utils.chat("&7Stats"))){
            e.setCancelled(true);
        }
    }
}
