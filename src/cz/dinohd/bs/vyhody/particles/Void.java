package cz.dinohd.bs.vyhody.particles;

import cz.dinohd.bs.Main;
import cz.dinohd.bs.utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Void {

    public static final HashMap<String, Integer> e = new HashMap();
    int task;

    @SuppressWarnings("deprecation")
    public void activate(Player p) {
        if (!e.containsKey(p.getName())) {
            task = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (e.containsKey(p.getName()) && p.isOnline()) {
                    	for (Player online : Bukkit.getOnlinePlayers()) {
                        ParticleEffect.TOWN_AURA.display(1.0f, 1.0f, 1.0f, 0.05f, 15, p.getLocation(), online);
                    }
                    }
                }
            }, 0L, 5L).getTaskId();
            e.put(p.getName(), Integer.valueOf(task));
        }
    }
}
