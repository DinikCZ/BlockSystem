package cz.dinohd.bs.eventy;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

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
}