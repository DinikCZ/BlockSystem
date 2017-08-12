package cz.dinohd.bs.eventy;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import cz.dinohd.bs.Main;
import cz.dinohd.bs.tablist.TablistSetup;
import cz.dinohd.bs.vyhody.particles.ParticlesAPI;

public class JoinListener implements Listener {
	Plugin plugin;
	ParticlesAPI partAPI = new ParticlesAPI();
	 
	public JoinListener(Plugin pl) {
	plugin = pl;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		int online = Bukkit.getOnlinePlayers().size();
		if (online == Bukkit.getServer().getMaxPlayers()) {
			Bukkit.broadcastMessage("§b§lSystem §8§l» §fServer dosáhl maximálního poètu hráèù online! " + online + "/" + Bukkit.getServer().getMaxPlayers() );
			
		}
	}
	@EventHandler
	public void onTest(PlayerCommandPreprocessEvent e) {
		int online = Bukkit.getOnlinePlayers().size();
		if (e.getMessage().equals("/jointest")) {
			if (e.getPlayer().hasPermission("system.bypassall")) {
			Bukkit.broadcastMessage("§b§lSystem §8§l» §fServer dosáhl maximálního poètu hráèù online! " + online + "/" + Bukkit.getServer().getMaxPlayers() );
			e.setCancelled(true);
		}
		}
		}
    @EventHandler
    public void setupTablistPlayerJoin(PlayerJoinEvent e) {
    	final Player p = e.getPlayer();
        // Nastaveni tablistu
        TablistSetup.setupTablist(p);
        Main.getInstance().addPlayer(p);
    }
    @EventHandler
    public void gamemodeChange(PlayerGameModeChangeEvent e) {
    	Player p = e.getPlayer();
    	if (e.getNewGameMode() == GameMode.SPECTATOR ) {
    	if (p.hasPermission("system.gamemode.spectator")) {
    	} else {
    		e.setCancelled(true);
    		p.sendMessage("§cNemáš povolení pøejít do Spectator modu!");
    	}
    }
    }
@EventHandler
public void gamemodeChangeCommandBlock(PlayerCommandPreprocessEvent e) {
	Player p = e.getPlayer();
	if (e.getMessage().equals("/gm 3") || e.getMessage().equals("/gmsp") || e.getMessage().equals("/gamemode 3") || e.getMessage().equals("/gamemodesp") || e.getMessage().equals("/gm spectator") || e.getMessage().equals("/gamemode spectator")){
	if (p.hasPermission("system.gamemode.spectator")) {
	} else {
		e.setCancelled(true);
		p.sendMessage("§cNemáš povolení pøejít do Spectator modu!");
	}
}
}
@EventHandler
public void onLeave(PlayerQuitEvent e) {
    final Player p = e.getPlayer();
       partAPI.deactivateParticles(p);
        Main.getInstance().removePlayer(p);
}
}