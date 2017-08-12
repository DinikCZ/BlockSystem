package cz.dinohd.bs.prikazy;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import cz.dinohd.bs.Main;
import net.md_5.bungee.api.ChatColor;

public class SoftRestartCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		String prefix = Main.config.getString("prefix");
		String srmsg = Main.config.getString("srmsg");
		String warningcolor = Main.config.getString("warningcolor");
		if (sender instanceof ConsoleCommandSender || sender.getName().equals("Refox")
				|| sender.getName().equals("iTzDinikCZ")) {
			sender.sendMessage(
					prefix + "§c" + warningcolor + srmsg);
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

				@Override
				public void run() {
					if (Bukkit.getOnlinePlayers().isEmpty())
						Bukkit.shutdown();
				}

			}, 0L, 60L);
		} else
			sender.sendMessage(ChatColor.RED + "Na tohle nemas povoleni!");
		return false;
	}

}