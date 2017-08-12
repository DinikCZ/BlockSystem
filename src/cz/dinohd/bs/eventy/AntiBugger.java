package cz.dinohd.bs.eventy;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import cz.dinohd.bs.Main;

public class AntiBugger implements Listener {
	
	
	 @EventHandler
	   public void onBlockPlace(BlockPlaceEvent e){
	    String server = Main.config.getString("server");
	    String prefix = Main.config.getString("prefix");
	    if (!server.equals("softcraft")) {
	    Player player = e.getPlayer();
	    Block block = e.getBlock();
	   Location loc = block.getLocation();
	         int x = loc.getBlockX();
	         int z = loc.getBlockZ();
	         int y = loc.getBlockY();
	         Block b1 = loc.getBlock().getRelative(BlockFace.NORTH);
	         Block b2 = loc.getBlock().getRelative(BlockFace.EAST);
	         Block b3 = loc.getBlock().getRelative(BlockFace.SOUTH);
	         Block b4 = loc.getBlock().getRelative(BlockFace.WEST);
	         if (player.getGameMode() == GameMode.CREATIVE) {
	         if(e.getBlock().getType() == Material.PISTON_BASE) {
	      if(b1.getType() == org.bukkit.Material.DIAMOND_BLOCK
	                   || b2.getType() == org.bukkit.Material.DIAMOND_BLOCK
	                   || b3.getType() == org.bukkit.Material.DIAMOND_BLOCK
	                   || b4.getType() == org.bukkit.Material.DIAMOND_BLOCK)
	           {
	    	  player.sendMessage("§cPrávì zneužíváš bug, nedìlal bych to...");
	               e.setCancelled(true);
	           }
	          
	          
	    } else 
		    if (!server.equals("softcraft")) {
		    	if (player.getGameMode() == GameMode.CREATIVE) {
		         if(e.getBlock().getType() == Material.DIAMOND_BLOCK) {
		      if(b1.getType() == org.bukkit.Material.PISTON_BASE
		                   || b2.getType() == org.bukkit.Material.PISTON_BASE
		                   || b3.getType() == org.bukkit.Material.PISTON_BASE
		                   || b4.getType() == org.bukkit.Material.PISTON_BASE)
		           {
		              player.sendMessage("§cPrávì zneužíváš bug, nedìlal bych to...");
		               e.setCancelled(true);
	    }

	    
	   }
}
	 }
}
	 }
}
	 @EventHandler
	 public void armorStandInteractCreative(PlayerInteractAtEntityEvent e) {
		 Player p = e.getPlayer();
		 if (p.getGameMode() == GameMode.CREATIVE) {
			 if (!p.hasPermission("system.bypass")) {
			 if (e.getRightClicked().getType() == EntityType.ARMOR_STAND) {
				 p.sendMessage("§b§lSystem §8§l» §fPrávì zneužíváš bug, nedìlal bych to...");
				 e.setCancelled(true);
			 } else {
				 if (p.getGameMode() == GameMode.CREATIVE) {
					 if (e.getRightClicked().getType() == EntityType.ARMOR_STAND) {
							 // NIC
			 }
		 }
		 }
		    }
	 }
}
}