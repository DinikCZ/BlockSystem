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
      Bukkit.broadcastMessage("�8[�6�lInzerat�8] �e" + p.getName() + ": �6" + message);*/
	p.sendMessage("�cOmlouv�me se, ale tento p��kaz je vypnut z mnoha d�vod�. Vyu�ijte pros�m norm�ln� chat.");
	return false;
}
}