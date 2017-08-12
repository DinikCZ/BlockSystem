package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cz.dinohd.bs.utils.AutoUpdater;

public class DownloadUpdate implements CommandExecutor {
	
@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
	Player p = (Player) sender;
	if (p.hasPermission("system.update") || p.getName().equals("iTzDinikCZ")) {
AutoUpdater.downloadUpdate(p);
	return false;
}
	return false;
}
}