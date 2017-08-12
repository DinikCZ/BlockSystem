package cz.dinohd.bs.prikazy;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import cz.dinohd.bs.Main;

public class ActivateJumpingEffect implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			Main.getInstance().trampolineAddPlayer(p.getName());
			p.sendMessage("§aTrampoline Efekt aktivován!");
		    Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
	        @Override
	        public void run() {
	        	Main.getInstance().trampolineRemovePlayer(p.getName());
	        	p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0, 0);
	        	p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
	        	p.sendMessage("§aTrampoline Efekt vyprchal!");
	        }
	}, 1200);
		}
		return false;
	}
	@EventHandler
	public void onTrampolineEffectJump(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Block to2 = e.getTo().getBlock();
		if (Main.getInstance().trampolinePlayers().contains(p.getName())) {
		if (p.getWorld().getName().equals("ServerEvent")) {
			if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SLIME_BLOCK) {
		        e.getPlayer().setVelocity(
		                e.getPlayer().getLocation().getDirection().multiply(10));
		              e.getPlayer().setVelocity(new Vector(0, 
		                10, 0));
		}
		}
	}
}
}