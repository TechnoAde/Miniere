package it.azuremc.miniere.Listeners;

import it.azuremc.miniere.Commands.DisableMine;
import it.azuremc.miniere.Main;
import net.raidstone.wgevents.WorldGuardEvents;
import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class OnBlockBreak implements Listener {

    private Main plugin;

    public OnBlockBreak(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public static void onBlockBreakEvent(BlockBreakEvent e) {

        Random rand = new Random();
        int upperbound = 6;

        Player p = e.getPlayer();
        Location pos = p.getLocation();
        Block block = e.getBlock();
        if(pos.getWorld() != null) {
            if(WorldGuardEvents.isPlayerInAnyRegion(p.getUniqueId(), Main.plugin.getConfig().getString("regionname"))) {
                if(!DisableMine.mainDisabled.containsKey(p)) {
                    switch (e.getBlock().getType()) {
                        case DIAMOND_ORE:
                            e.setCancelled(true);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.STONE), 1L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                                if(emptyslotnumber(p.getInventory()) > 1) {
                                    p.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
                                } else {
                                    p.sendMessage("§8(§c§l!§8) §7Non hai abbastanza spazio nell'inventario");
                                }
                            }, 2L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.DIAMOND_ORE), Main.plugin.getConfig().getLong("temporegen")*60);
                            break;
                        case GOLD_ORE:
                            e.setCancelled(true);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.STONE), 1L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                                if(emptyslotnumber(p.getInventory()) > 1) {
                                    p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 1));
                                } else {
                                    p.sendMessage("§8(§c§l!§8) §7Non hai abbastanza spazio nell'inventario");
                                }
                            }, 2L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.GOLD_ORE),Main.plugin.getConfig().getLong("temporegen")*60);
                            break;
                        case IRON_ORE:
                            e.setCancelled(true);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.STONE), 1L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                                if(emptyslotnumber(p.getInventory()) > 1) {
                                    p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
                                } else {
                                    p.sendMessage("§8(§c§l!§8) §7Non hai abbastanza spazio nell'inventario");
                                }
                            }, 2L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.IRON_ORE),Main.plugin.getConfig().getLong("temporegen")*60);
                            break;
                        case REDSTONE_ORE:
                            e.setCancelled(true);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.STONE), 1L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                                if(emptyslotnumber(p.getInventory()) > 1) {
                                    p.getInventory().addItem(new ItemStack(Material.REDSTONE, Main.randonumber(6)));
                                } else {
                                    p.sendMessage("§8(§c§l!§8) §7Non hai abbastanza spazio nell'inventario");
                                }
                            }, 2L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.REDSTONE_ORE),Main.plugin.getConfig().getLong("temporegen")*60);
                            break;
                        case LAPIS_ORE:
                            e.setCancelled(true);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.STONE), 1L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                                if(emptyslotnumber(p.getInventory()) > 1) {
                                    p.getInventory().addItem(new ItemStack(Material.LAPIS_ORE, Main.randonumber(8)));
                                } else {
                                    p.sendMessage("§8(§c§l!§8) §7Non hai abbastanza spazio nell'inventario");
                                }
                            }, 2L);
                            Bukkit.getScheduler().runTaskLater(Main.plugin, () -> block.setType(Material.LAPIS_ORE),Main.plugin.getConfig().getLong("temporegen")*60);
                            break;
                    }
                }
            }
        }
    }

    public static int emptyslotnumber(Inventory inv) {
        int a = 0;
        for(int i = 0; i < 36; i++) {
            if(inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
                a++;
            }
        }
        return a;
    }

}
