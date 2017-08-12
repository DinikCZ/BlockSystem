package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InzeratCommand implements CommandExecutor {
	
@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
	Player p = (Player) sender;
    /*StringBuilder message = new StringBuilder();
    if (args.length > 0) {
      message.append(args[0]);
      for (int i = 1; i < args.length; i++) {
        message.append(" ");
        message.append(args[i]);
      }
      Bukkit.broadcastMessage("§8[§6§lInzerat§8] §e" + p.getName() + ": §6" + message);*/
	p.sendMessage("§cOmlouváme se, ale tento pøíkaz je vypnut z mnoha dùvodù. Vyuijte prosím normální chat.");
	return false;
}
}