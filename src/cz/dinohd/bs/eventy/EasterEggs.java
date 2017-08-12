package cz.dinohd.bs.eventy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EasterEggs implements Listener {
	
	@EventHandler
	public void rpCmd(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equals("/rp")) {
			e.getPlayer().setResourcePack("http://softcraft.eu/music_.zip");
			e.getPlayer().sendMessage("§aKontaktuji URL | ../music_.zip");
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void stillAlive(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equals("/stillalive")) {
			Player p = e.getPlayer();
			p.sendMessage("§cTento Easter Egg vyžaduje Resource Pack | /rp");
			p.sendMessage("§a§lNaèítání easter eggu...");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "playsound easteregg.stillalive master " + p.getName() +  " ~ ~ ~ 100000");
			e.setCancelled(true);
		}
	}
}