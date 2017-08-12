package cz.dinohd.bs.residence;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import cz.dinohd.bs.Main;

public class ResidenceTutorial implements Listener {
	Plugin plugin;
	 
	public ResidenceTutorial(Plugin plg) {
	plugin = plg;
	}
	
	@EventHandler
	public void ResTutorialCommand(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String prefix = Main.config.getString("prefix");
		ItemStack res = new ItemStack(Material.WOOD_HOE, 1);
		if (e.getMessage().equals("/restutorial")){
			e.setCancelled(true);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix + "§eResidenci vytvoøíš oznaèení bodù pomocí døevìné motyky");
		        	p.sendTitle("§e§lResidenci vytvorís...", "§7oznaèením bodù pomocí døevìné motyky");
		        }
		}, 20);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix +"§ePo oznaèení bodù napiš /res select vert");
		        	p.sendTitle("§e§lPo oznaceni bodu", "§7napiš /res select vert");
		        }
		}, 120);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix + "§ePro plné vytvoøení res napiš /res create <název>");
		        	p.sendTitle("§e§lPro plne vytvoreni res", "§7napiš /res create <název>");
		        }
		}, 180);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix + "§ePo vytvoøení Residence se ti zobrazí návod jak pøidat do residence kamaráda.");
		        	p.sendTitle("§e§lPo vytvoøení residence", "§7se ti zobrazí návod jak pøidat do res kamaráda");
		        }
		}, 240);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	if (e.getPlayer().getInventory().contains(res)) {
		            	p.sendMessage(prefix + "§cMotyka ti nebyla pøidìlena, jelikož již jednu vlastníš");
		            	p.sendTitle("§4§lChyba!", "§cJiž vlastníš jednu døevìnou motyku");
		            	p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 1, 1);
		        	} else {
		        		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix + "§eZde máš døevìnou motyku na oznaèení.");
		        	p.sendTitle("§e§lZde mas", "§7døevìnou motyku na oznaèení.");
		        	e.getPlayer().getInventory().addItem(res);
		        }
		}}, 300);
}
}
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e){
		if (e.getMessage().equals("/dinik")){
			e.setCancelled(true);
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			e.getPlayer().sendMessage("§4Tento server využívá plugin §fBlockSystem v1.0 §4od §fiTzDinikCZ §4(skype: §fitzdinohd.original§f)");
		}
	}
}
