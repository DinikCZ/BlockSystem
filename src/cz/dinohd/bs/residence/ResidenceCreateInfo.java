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
        	p.sendMessage("�8[�2�lInformace�8] �2" + p.getName() + "�a, pr�v� jsi vytvo�il residenci s n�zvem �2" + jmeno + "�a.");
        }
}, 40);
    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
        @Override
        public void run() {
        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        	p.sendMessage("�8[�2�lInformace�8] �aKamar�dovi povol� residenci p��kazem �2/res pset <residence> <nick> trusted t");
        }
}, 80);
    Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
        @Override
        public void run() {
        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        	p.sendMessage("�8[�2�lInformace�8] �aV p��pad�, �e kamar�d nem��e ni�it v residenci napi� n�sleduj�c� p��kaz:");
        	p.sendMessage("�2/res pset <residence> <nick> destroy t");
        }
}, 120);
}
@EventHandler
public void ResidenceTPInfo(ResidenceTPEvent e) {
	Player p = e.getPlayer();
	String majitel = e.getResidence().getOwner();
	p.sendMessage("�8[�4�lUpozornen�8] �cTeleportace na residenci za ��elem zabit� je trestn�!");
	 Bukkit.broadcast("�8[�6�lTeleportace�8] �eHr�� �6" + p.getName() + " �ese teleportoval na residenci �6" + e.getResidence().getResidenceName() + "�e, kterou vlastn� �6" + majitel, "system.admin"); 
}
}
