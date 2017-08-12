package cz.dinohd.bs.residence;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import com.bekvon.bukkit.residence.event.ResidenceCreationEvent;
import com.bekvon.bukkit.residence.event.ResidenceTPEvent;

public class ResidenceCreateInfo implements Listener {
	Plugin plugin;
	 
	public ResidenceCreateInfo(Plugin plg) {
	plugin = plg;
	}
	
@SuppressWarnings("deprecation")
@EventHandler
public void ResidenceCreatedInfo(ResidenceCreationEvent e) {
	Player p = e.getPlayer();
	String jmeno = e.getResidenceName();
	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
	p.playEffect(p.getLocation(), Effect.HAPPY_VILLAGER, 120);
    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
        @Override
        public void run() {
        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        	p.sendMessage("§8[§2§lInformace§8] §2" + p.getName() + "§a, právì jsi vytvoøil residenci s názvem §2" + jmeno + "§a.");
        }
}, 40);
    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
        @Override
        public void run() {
        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        	p.sendMessage("§8[§2§lInformace§8] §aKamarádovi povolíš residenci pøíkazem §2/res pset <residence> <nick> trusted t");
        }
}, 80);
    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
        @Override
        public void run() {
        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        	p.sendMessage("§8[§2§lInformace§8] §aV pøípadì, že kamarád nemùže nièit v residenci napiš následující pøíkaz:");
        	p.sendMessage("§2/res pset <residence> <nick> destroy t");
        }
}, 120);
}
@EventHandler
public void ResidenceTPInfo(ResidenceTPEvent e) {
	Player p = e.getPlayer();
	String majitel = e.getResidence().getOwner();
	p.sendMessage("§8[§4§lUpozornení§8] §cTeleportace na residenci za úèelem zabití je trestná!");
	 Bukkit.broadcast("§8[§6§lTeleportace§8] §eHráè §6" + p.getName() + " §ese teleportoval na residenci §6" + e.getResidence().getResidenceName() + "§e, kterou vlastní §6" + majitel, "system.admin"); 
}
}
