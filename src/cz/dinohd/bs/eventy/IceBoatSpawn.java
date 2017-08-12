package cz.dinohd.bs.eventy;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;

public class IceBoatSpawn implements Listener, CommandExecutor {
/*	@EventHandler
	public void spawnButtonClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		double takeamount = Double.parseDouble("100");
		@SuppressWarnings("deprecation")
		OfflinePlayer op = Bukkit.getOfflinePlayer(p.getName());
		Location loc = new Location(p.getWorld(), -551, 4, -92);
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)) {
				if (e.getClickedBlock().getLocation().getBlockX() == -548 && e.getClickedBlock().getLocation().getBlockY() == 5 && e.getClickedBlock().getLocation().getBlockZ() == -77) {
        Boat boat = p.getWorld().spawn(loc, Boat.class);
        boat.setCustomNameVisible(true);
        boat.setInvulnerable(true);
        boat.setCustomName("§a" + p.getName() + "'s §2Loïka");
        boat.addPassenger(p);
        Economy.depositPlayer(op, 100);
	}
	}
}
}*/
	@SuppressWarnings("deprecation")
	@EventHandler
	public void leaveBoatEvent(VehicleExitEvent e) {
		if (e.getVehicle().getPassenger() instanceof Player) {
		Player p = (Player) e.getVehicle().getPassenger();
		Location loc = new Location(p.getWorld(), -551, 4, -73);
		if (p.getWorld().getName().equals("ServerEvent")) {
			if (e.getVehicle() instanceof Boat) {
			e.getVehicle().remove();
			p.teleport(loc);
}
}
		}
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Location loc = new Location(p.getWorld(), -551, 4, -92);
	        Boat boat = p.getWorld().spawn(loc, Boat.class);
	        boat.setCustomNameVisible(true);
	        boat.setInvulnerable(true);
	        boat.setCustomName("§a" + p.getName() + " §2Loïka");
	        boat.addPassenger(p);
		}
		return false;
	}
}