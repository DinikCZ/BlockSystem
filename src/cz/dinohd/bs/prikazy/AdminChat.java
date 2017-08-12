package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import cz.dinohd.bs.Main;

public class AdminChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		String prefix = Main.config.getString("prefix");
		String format = Main.config.getString("acformat");
		String acprefix = Main.config.getString("acprefix");
			if (!(sender instanceof ConsoleCommandSender)) {
				Player p = (Player) sender;
		if (p.hasPermission("system.ac")) {
			    StringBuilder message = new StringBuilder();
			    if (args.length > 0) {
				      message.append(args[0]);
				      for (int i = 1; i < args.length; i++) {
				        message.append(" ");
				        message.append(args[i]);
				      }
					Bukkit.broadcast(format.replace("{PREFIX}", acprefix).replace("{HRAC}", p.getDisplayName()) + ChatColor.translateAlternateColorCodes('&', message.toString()), "system.ac");
					Bukkit.getConsoleSender().sendMessage(format.replace("{PREFIX}", acprefix).replace("{HRAC}", p.getDisplayName()) + ChatColor.translateAlternateColorCodes('&', message.toString()));
			    }
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
				Bukkit.broadcast(format.replace("{PREFIX}", acprefix).replace("{HRAC}", "§fKonzole") + ChatColor.translateAlternateColorCodes('&', message1.toString()), "system.ac");
				Bukkit.getConsoleSender().sendMessage(format.replace("{PREFIX}", acprefix).replace("{HRAC}", "§fKonzole") + ChatColor.translateAlternateColorCodes('&', message1.toString()));
			}
		} else {
			Player p = (Player) sender;
			p.sendMessage(prefix + "§cNemáš povolení na tento pøíkaz!");
		return false;
	}
			return false;
	
}
}