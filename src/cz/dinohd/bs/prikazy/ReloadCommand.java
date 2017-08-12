package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cz.dinohd.bs.Main;

public class ReloadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("system.reload") || p.getName().equals("iTzDinikCZ")) {
			Main.config = YamlConfiguration.loadConfiguration(Main.f);
		p.sendMessage("§aConfig úspìšnì obnoven!");
		} else {
			p.sendMessage("§cNemáš dostateèná oprávnìní");
			for (Player admin : Bukkit.getOnlinePlayers()) {
				if (admin.hasPermission("system.info") || p.getName().equals("iTzDinikCZ")) {
					admin.sendMessage("§4" + p.getName() + " §cse pokusil o pøíkaz §4" + cmd.getName());
				}
			}
		return false;
	}
		return false;
	
}
}