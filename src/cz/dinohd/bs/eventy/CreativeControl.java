package cz.dinohd.bs.eventy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class CreativeControl implements Listener {
	
	@EventHandler
	public void onPotionInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (!p.getGameMode().equals(GameMode.CREATIVE)) {
			return;
		}
		if (e.getItem() == null) {
			return;
		}
			if (!e.getItem().getType().equals(Material.SPLASH_POTION)) {
				return;
			}
			if (e.getItem().getType().equals(Material.SPLASH_POTION)) {
			if (!p.hasPermission("creativecontrol.*") || !p.hasPermission("cc.*")) {
			e.setCancelled(true);
			p.sendMessage("§c§lHey! §7Nemáš povolení házet §e" + e.getItem().getType() + "§7(" + e.getItem().getTypeId() + ") v Creative módu!");
			}
		}
}
	   @EventHandler
	   public void onEnderDragonWingsDrop(PlayerDropItemEvent e) {
		   try {
		   ItemStack item = e.getItemDrop().getItemStack();
		   Player p = e.getPlayer();
	       if (!item.hasItemMeta()) {
	           return;
	       }
	       if (!item.getType().equals(Material.ELYTRA)) {
	           return;
	       }
	       if (!item.getItemMeta().getDisplayName().contains("Ender Dragon Wings")) {
	           return;
	       }
	       e.setCancelled(true);
	       p.getInventory().getItemInMainHand().setType(null);
	       Bukkit.broadcastMessage("§8[§c-§8] §7Hráè §c" + p.getName() + " §7vlastnil §cEnder Dragon Wings §7. Tento pøedmìt mu byl odebrán z dùvodu givingu.");
	       
	   }
	   catch (Exception p) {
	       // empty catch block
	   }
	}
	@EventHandler
	public void onEDWMove(PlayerMoveEvent e) {
		try {
		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getChestplate();
		if (item.getType() == Material.ELYTRA) {
			if (!item.hasItemMeta()) {
				return;
			}
			if (item.getItemMeta().getDisplayName().contains("Ender Dragon Wings")) {
				Bukkit.broadcastMessage("§8[§c-§8] §7Hráè §c" + p.getName() + " §7vlastnil §c" + item.getItemMeta().getDisplayName() + " §7. Tento pøedmìt mu byl odebrán z dùvodu givingu.");
				p.getInventory().getChestplate().setAmount(0);
			}
		}
		}
		catch (Exception p) {
			
		}
	}
	@EventHandler
	public void onEDWInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem();
		if (item.getType() == Material.ELYTRA) {
			if (!item.hasItemMeta()) {
				return;
			}
			if (item.getItemMeta().getDisplayName().contains("Ender Dragon Wings")) {
				Bukkit.broadcastMessage("§8[§c-§8] §7Hráè §c" + p.getName() + " §7vlastnil §c" + item.getItemMeta().getDisplayName() + " §7. Tento pøedmìt mu byl odebrán z dùvodu givingu.");
				item.setAmount(0);
				e.setCancelled(true);
			}
		}
	}
	}