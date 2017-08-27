package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import cz.dinohd.bs.nms.TitleAPI;


public class AnnounceCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if ( p.hasPermission("system.shout")) {
			
	        StringBuilder message1 = new StringBuilder();
	        if (args.length > 0) {
	          message1.append(args[0]);
	          for (int i = 1; i < args.length; i++) {
	            message1.append(" ");
	            message1.append(args[i]);
	          }

            String cs = ChatColor.translateAlternateColorCodes('&', message1 + "");
Bukkit.broadcastMessage("§d§lServer §8● §f" + cs);
	        }
	        } else 
	        	if (sender instanceof ConsoleCommandSender) {
	    	        StringBuilder message1 = new StringBuilder();
	    	        if (args.length > 0) {
	    	          message1.append(args[0]);
	    	          for (int i = 1; i < args.length; i++) {
	    	            message1.append(" ");
	    	            message1.append(args[i]);
	    	          }
	        		String cs = ChatColor.translateAlternateColorCodes('&', message1 + "");
	        		Bukkit.broadcastMessage("§d§lServer §8● §f" + cs);
	    	        }
	        	} else {
	        		if (!p.hasPermission("system.shout")) {
				p.damage(0);
				p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 1, 1);
				TitleAPI.sendTitle(p, 20, 50, 20, "§cCHYBA", "§cNemáš dostatečná oprávnění!");
	}
}
		return false;
}
}