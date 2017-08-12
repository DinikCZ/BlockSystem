package cz.dinohd.bs.vyhody.chatcolor;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.dinohd.bs.Main;

public class Events implements Listener {
  
  


  @EventHandler
  public void onChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    
    String msg = e.getMessage();
    if (e.getMessage().contains("/" + e.getMessage()) || e.getMessage().contains("#" + e.getMessage())) {
    // NIC
    } else {
    	if (!Main.chatcolorconfig.contains(p.getUniqueId().toString())) {
    		// NIC
    	} else {
    e.setMessage(Config.getColor(p).replaceAll("&", "§") + msg);
  }
}
}
}
