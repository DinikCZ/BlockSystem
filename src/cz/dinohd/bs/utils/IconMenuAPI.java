package cz.dinohd.bs.utils;

import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cz.dinohd.bs.Main;

public class IconMenuAPI {
    private String name;
    private static int rows;
    private static ConcurrentHashMap<Integer, MenuIcon> icons = new ConcurrentHashMap<Integer, MenuIcon>();
    private ConcurrentHashMap<String, Inventory> opened;
    
    public static void addIcon(MenuIcon icon, int position) {
	if (icons.get(position) != null)
	    icons.remove(position);
	icons.put(position, icon);
    }
	
    public static void fillUnusedSlots() {
	MenuIcon nullIcon = new MenuIcon(Material.STAINED_GLASS_PANE, " ", "null");
	nullIcon.setMetaData(15);
	for (int i = 0; i < rows * 9; i++) {
	    if (icons.get(i) == null) {
		addIcon(nullIcon, i);
	    }
	}
    }

    public void fillUnusedSlots(int glasstype) {
	if (glasstype > 16 || glasstype < 1)
	    glasstype = 15;
	MenuIcon nullIcon = new MenuIcon(Material.STAINED_GLASS_PANE, " ", "null");
	nullIcon.setMetaData(glasstype);
	for (int i = 0; i < rows * 9; i++) {
	    if (icons.get(i) == null) {
		addIcon(nullIcon, i);
	    }
	}
    }

    @EventHandler
    public void onIconMenuInteract(InventoryInteractEvent e) {
	if (e.getInventory().getTitle().equals(name)) {
	    e.setCancelled(true);
	}
    }

    @EventHandler
    public void onIconMenuDrag(InventoryDragEvent e) {
	if (e.getInventory().getTitle().equals(name)) {
	    e.setCancelled(true);
	}
    }

    @EventHandler
    public void onIconMenuOpen(InventoryOpenEvent e) {
	    if (e.getInventory().getTitle().equals(name)) {
		opened.put(e.getPlayer().getName(), e.getInventory());
	    }
}

}