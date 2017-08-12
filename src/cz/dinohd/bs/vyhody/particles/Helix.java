package cz.dinohd.bs.vyhody.particles;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cz.dinohd.bs.Main;
import cz.dinohd.bs.utils.ParticleEffect;

public class Helix {
	
    public static final HashMap<String, Integer> e = new HashMap();
    int task;
    double i = 0;

    @SuppressWarnings("deprecation")
    public void activate(Player p) {
        if (!e.containsKey(p.getName())) {
 /*               @Override
                public void run() {
                	    Location loc = p.getLocation();
                	    int radius = 2;
                	    for(double y = 0; y <= 50; y+=0.05) {
                	        double x = radius * Math.cos(y);
                	        double z = radius * Math.sin(y);
                	        if (y >= 3) {
                	        	y = 0;
                	        }
                	        for(Player online : Bukkit.getOnlinePlayers()) {
                	            online.spawnParticle(Particle.DRAGON_BREATH, loc.getX() + x, loc.getY() + y, loc.getZ() + z, 10);
                	        }
                	    }
                	}
                }, 0L, 5L).getTaskId();
            }
    }*/
            	
            }
        }
    }