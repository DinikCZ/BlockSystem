package cz.dinohd.bs.eventy;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import cz.dinohd.bs.nms.TitleAPI;

public class Announcments implements Listener, CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if ( p.hasPermission("system.announcment")) {
			
	        StringBuilder message = new StringBuilder();
	        if (args.length > 0) {
	          message.append(args[0]);
	          for (int i = 1; i < args.length; i++) {
	            message.append(" ");
	            message.append(args[i]);
	          }

            String cs = ChatColor.translateAlternateColorCodes('&', message + "");
            for (Player player : Bukkit.getServer().getOnlinePlayers())
            	TitleAPI.sendTitle(player, 20, 50, 20, "§c§lEvent", cs);
Bukkit.broadcastMessage("§c§lEvent §8§l> §7" + cs + "§7 - " + p.getName());
{
		return true;
}
}
		return false;
}
		p.sendMessage("§cNemáš povolení na tento pøíkaz!");
		return false;
}
}