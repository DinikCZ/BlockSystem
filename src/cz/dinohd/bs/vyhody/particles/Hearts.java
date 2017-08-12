package cz.dinohd.bs.vyhody.particles;

import cz.dinohd.bs.Main;
import cz.dinohd.bs.utils.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Hearts {

    public static final HashMap<String, Integer> e = new HashMap();
    int task;

    @SuppressWarnings("deprecation")
    public void activateLove(Player p) {
        if (!e.containsKey(p.getName())) {
            task = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new BukkitRunnable() {
                @Override
                public void run() {
                    if (e.containsKey(p.getName()) && p.isOnline()) {
                    	for (Player online : Bukkit.getOnlinePlayers()) {
                        ParticleEffect.HEART.display(0.7f, 0.7f, 0.7f, 0.05f, 3, p.getLocation(), online);
                    }
                    }
                }
            }, 0L, 5L).getTaskId();
            e.put(p.getName(), Integer.valueOf(task));
        }
    }
}
