package cz.dinohd.bs.prikazy;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import cz.dinohd.bs.Main;


public class AFK implements Listener, CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if ( p.hasPermission("essentials.afk")) {
			
	        StringBuilder message = new StringBuilder();
	        if (args.length > 0) {
	          message.append(args[0]);
	          for (int i = 1; i < args.length; i++) {
	            message.append(" ");
	            message.append(args[i]);
	          }
      if (args.length <= 0) {
            Bukkit.broadcastMessage("�8[�e�lAFK�8] �cHr�� �6�l" + p.getName() + " �eje nyn� AFK!");
            Main.getInstance().AFKAdd(p.getName());
      }
      Bukkit.broadcastMessage("�8[�e�lAFK�8] �eHr�� �6�l" + p.getName() + " �eje nyn� AFK! �7(�e" + message + "�7)");
      Main.getInstance().AFKAdd(p.getName());
{
		return true;
}
}
		return false;
} else {
	p.sendMessage("�cNem� povolen� na tento p��kaz!");
}
		return false;
}
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if ( Main.getInstance().afkPlayers().contains(e.getPlayer().getName())) {
		Player p = e.getPlayer();
		
			Bukkit.broadcastMessage("�8[�e�lAFK�8] �eHr�� �6�l" + p.getDisplayName() + " �ese vr�til!");
			Main.getInstance().AFKRem(p.getName());
		}
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		if ( Main.getInstance().afkPlayers().contains(e.getPlayer().getName())) {
		Player p = e.getPlayer();
		
			Main.getInstance().AFKRem(p.getName());
		}
	}
}