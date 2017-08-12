package cz.dinohd.bs.prikazy;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cz.dinohd.bs.Main;


public class AFK implements Listener, CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if ( p.hasPermission("essentials.afk")) {
			if (!Main.getInstance().afkPlayers().contains(p.getName())) {
	        StringBuilder message = new StringBuilder();
	        if (args.length > 0) {
	          message.append(args[0]);
	          for (int i = 1; i < args.length; i++) {
	            message.append(" ");
	            message.append(args[i]);
	          }
      Bukkit.broadcastMessage("§8[§e§lAFK§8] §eHráè §6§l" + p.getName() + " §eje nyní AFK! §7(§e" + message + "§7)");
      Main.getInstance().AFKAdd(p.getName());
{
		return true;
}
}
		return false;
} else { 
	Bukkit.broadcastMessage("§8[§e§lAFK§8] §eHráè §6§l" + p.getName() + " §ese vrátil!");
	Main.getInstance().AFKRem(p.getName());
}
} else {
		p.sendMessage("§cNemáš povolení na tento pøíkaz!");
		return false;
}
		return false;
	}
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if ( Main.getInstance().afkPlayers().contains(e.getPlayer().getName())) {
		Player p = e.getPlayer();
		
			Bukkit.broadcastMessage("§8[§e§lAFK§8] §eHráè §6§l" + p.getName() + " §ese vrátil!");
			Main.getInstance().AFKRem(p.getName());
		}
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		if ( Main.getInstance().afkPlayers().contains(e.getPlayer().getName())) {
		Player p = e.getPlayer();
		
			Main.getInstance().AFKRem(p.getName());
		}
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String message = e.getMessage();
		ArrayList<String> afk = Main.getInstance().afkPlayers();
		for (Player online : Bukkit.getOnlinePlayers()) {
		if (message.contains(online.getName())) {
			if (afk.contains(online.getName())) {
			e.getPlayer().sendMessage("§8[§e§lAFK§8] §eUživatel, kterého jsi zmínil je AFK, takže je málá šance, že ti odpoví");
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_PLING, 1, 1);
			
		}
	}
		
	}
	}
}