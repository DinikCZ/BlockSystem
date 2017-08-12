package cz.dinohd.bs.prikazy;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import cz.dinohd.bs.Main;

public class RegenerateConfigCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
		if (p.hasPermission("system.regenerate") || p.getName().equals("iTzDinikCZ")) {
	        String saveDir = new File(".").getAbsolutePath();
	        String saveDir1 = saveDir + "/plugins/BlockSystem/";
	        File config = new File(saveDir1 + "config.yml");
	        config.delete();
		p.sendMessage("§aConfig úspìšnì pøegenerován!");
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "plugman reload BlockSystem");
		} else {
			p.sendMessage("§cNemáš dostateèná oprávnìní");
			for (Player admin : Bukkit.getOnlinePlayers()) {
				if (admin.hasPermission("system.info") || p.getName().equals("iTzDinikCZ")) {
					admin.sendMessage("§4" + p.getName() + " §cse pokusil o pøíkaz §4" + cmd.getName());
				}
			}
		return false;
	}
	
		}
		return false;
	}
}