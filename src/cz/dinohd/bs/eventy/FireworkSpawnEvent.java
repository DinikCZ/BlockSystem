package cz.dinohd.bs.eventy;

import java.io.IOException;
import java.time.LocalTime;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class FireworkSpawnEvent implements Listener {
	  public static String getTime()
	  {
	    LocalTime lt = LocalTime.now();
	    int h;
	    if (lt.getHour() < 10) {
	      h = lt.getHour();
	    } else {
	      h = lt.getHour();
	    }
	    int m;
	    if (lt.getMinute() < 10) {
	      m = lt.getMinute();
	    } else {
	      m = lt.getMinute();
	    }
	    int s;
	    if (lt.getSecond() < 10) {
	    	s = lt.getSecond();
	    } else {
	      s = lt.getSecond();
	    }
	    String t = h + ":" + m + ":" + s;
	    return t;
	  }
	
	@EventHandler
	public void spawnFireworkAtTime(PlayerCommandPreprocessEvent e) throws IOException {
		LocalTime lt = LocalTime.now();
		Player p = e.getPlayer();
		if (p.hasPermission("system.fireworks")) {
		if (e.getMessage().equals("/fireworks")) {
			if (lt.getHour() < 1)
        Bukkit.dispatchCommand(p, "afw spawnall random");
		e.setCancelled(true);
	}
	else {
		if (p.hasPermission("system.fireworks")) {
			if (e.getMessage().equals("/fireworks")) {
					p.sendMessage("§aPromiò " + p.getName()+ " tento pøíkaz již není dostupný.");
					e.setCancelled(true);
			}
	}
}
		}
	}
}