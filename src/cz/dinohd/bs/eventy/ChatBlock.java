package cz.dinohd.bs.eventy;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import cz.dinohd.bs.Main;
import net.md_5.bungee.api.ChatColor;

public class ChatBlock implements Listener {
	
	@EventHandler
	public void checkUserIfBlocked(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String prefix = Main.config.getString("prefix");
		String blockmessage = Main.config.getString("msgblock");
		String errorcolor = Main.config.getString("errorcolor");
		for (String users : Main.config.getStringList("chatbloknuti")){
		if (p.getName().equals(users)) {
		e.setCancelled(true);
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "§" + errorcolor + blockmessage));
		p.playSound(p.getLocation(), Sound.ENTITY_CAT_PURREOW, 1, 1);
		} else {
			// Nic :/
				
			}
		}
			
}
	@EventHandler
	public void sendInfo(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String prefix = Main.config.getString("prefix");
		for (String users : Main.config.getStringList("chatbloknuti")){
		if (p.getName().equals(users)) {
		for (Player admin : Bukkit.getOnlinePlayers()) {
		if (admin.hasPermission("system.info")) {
		admin.sendMessage(prefix + "§dUivatel §5" + p.getName() + " §dse snail promluvit, ale je zablokován systémem!");
		admin.sendMessage(prefix + "§8[ §7" + p.getName() + " §8] §b> §f" + e.getMessage());
				
			}
		}
		}	
}
	}
}