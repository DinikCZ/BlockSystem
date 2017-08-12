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
		        	p.sendMessage(prefix + "�eResidenci vytvo�� ozna�en� bod� pomoc� d�ev�n� motyky");
		        	p.sendTitle("�e�lResidenci vytvor�s...", "�7ozna�en�m bod� pomoc� d�ev�n� motyky");
		        }
		}, 20);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix +"�ePo ozna�en� bod� napi� /res select vert");
		        	p.sendTitle("�e�lPo oznaceni bodu", "�7napi� /res select vert");
		        }
		}, 120);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix + "�ePro pln� vytvo�en� res napi� /res create <n�zev>");
		        	p.sendTitle("�e�lPro plne vytvoreni res", "�7napi� /res create <n�zev>");
		        }
		}, 180);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix + "�ePo vytvo�en� Residence se ti zobraz� n�vod jak p�idat do residence kamar�da.");
		        	p.sendTitle("�e�lPo vytvo�en� residence", "�7se ti zobraz� n�vod jak p�idat do res kamar�da");
		        }
		}, 240);
		    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
		        @SuppressWarnings("deprecation")
				@Override
		        public void run() {
		        	if (e.getPlayer().getInventory().contains(res)) {
		            	p.sendMessage(prefix + "�cMotyka ti nebyla p�id�lena, jeliko� ji� jednu vlastn�");
		            	p.sendTitle("�4�lChyba!", "�cJi� vlastn� jednu d�ev�nou motyku");
		            	p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 1, 1);
		        	} else {
		        		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
		        	p.sendMessage(prefix + "�eZde m� d�ev�nou motyku na ozna�en�.");
		        	p.sendTitle("�e�lZde mas", "�7d�ev�nou motyku na ozna�en�.");
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
			e.getPlayer().sendMessage("�4Tento server vyu��v� plugin �fBlockSystem v1.0 �4od �fiTzDinikCZ �4(skype: �fitzdinohd.original�f)");
		}
	}
}
