package cz.dinohd.bs.vyhody.chatcolor;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cz.dinohd.bs.Main;
import cz.dinohd.bs.utils.ItemFactory;
import cz.dinohd.bs.vyhody.particles.Angry;
import cz.dinohd.bs.vyhody.particles.Cloud;
import cz.dinohd.bs.vyhody.particles.Enchanted;
import cz.dinohd.bs.vyhody.particles.Firework;
import cz.dinohd.bs.vyhody.particles.Flame;
import cz.dinohd.bs.vyhody.particles.Happy;
import cz.dinohd.bs.vyhody.particles.Hearts;
import cz.dinohd.bs.vyhody.particles.Lava;
import cz.dinohd.bs.vyhody.particles.Portal;
import cz.dinohd.bs.vyhody.particles.Redstone;
import cz.dinohd.bs.vyhody.particles.Slime;
import cz.dinohd.bs.vyhody.particles.Smoke;
import cz.dinohd.bs.vyhody.particles.Snowball;
import cz.dinohd.bs.vyhody.particles.Void;
import cz.dinohd.bs.vyhody.particles.WhiteMagic;
import cz.dinohd.bs.vyhody.particles.WitchMagic;



public class GUI implements Listener
{
    public static void openParticlesMenu(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 54, "§a§lChatColor");

        if (p.hasPermission("color.red")) {
                ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 1, "§eRed", "§7Kliknutím aktivuješ!");
                inv.setItem(10, i);
            }
        else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cRed", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
            inv.setItem(10, i);
        }
        if (p.hasPermission("color.purple")) {
                ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 5, "§5Purple", "§7Kliknutím aktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(11, i);
        }
            else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§5Purple", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
            inv.setItem(11, i);
        }
        if (p.hasPermission("color.white")) {
                ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 15, "§fReset / White", "§7Kliknutím aktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(12, i);
        } 
            else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§fReset / White", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
            inv.setItem(12, i);
        }
        if (p.hasPermission("color.yellow")) {
                ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 11, "§eYellow", "§7Kliknutím aktvuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(13, i);
        }
            else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§eYellow", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
            inv.setItem(13, i);
        }
        if (p.hasPermission("color.green")) {
                ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 10, "§aGreen", "§7Kliknutím aktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(14, i);
        } 
            else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§aGreen", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
            inv.setItem(14, i);
        }
        if (p.hasPermission("color.blue")) {
                ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 12, "§bBlue", "§7Kliknutím aktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(15, i);
        } 
            else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 9, "§bBlue", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
            inv.setItem(15, i);
        }
        if (p.hasPermission("color.pink")) {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 12, "§dPink", "§7Kliknutím aktivuješ!");
            i = ItemFactory.addGlow(i);
            inv.setItem(16, i);
    } 
        else {
        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§dPink", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
        inv.setItem(16, i);
    }
        if (p.hasPermission("color.gold")) {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 14, "§6Gold", "§7Kliknutím aktivuješ!");
            i = ItemFactory.addGlow(i);
            inv.setItem(19, i);
    } 
        else {
        ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§6Gold", "", "§7Toto je dostupné pouze pro IronVIP a vyšší");
        inv.setItem(19, i);
    }
        if (Main.chatcolorconfig.contains(p.getUniqueId().toString())) {
                    ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte) 0, "§4Deaktivovat", "§7Kliknutím aktivuješ!");
                    inv.setItem(49, deaktivace);
        }
                    else {
                        ItemStack deaktivace = ItemFactory.create(Material.INK_SACK, (byte) 8, "§4Deaktivovat", "", "§7Nemáš aktivovaný ChatColor!");
                        inv.setItem(49, deaktivace);
                    }

        p.openInventory(inv);
    }
    @EventHandler
    private void onInteract(InventoryClickEvent e) throws IOException {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("§a§lChatColor")) {
        	e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("color.red")) {
                    p.closeInventory();
                    Config.setColor(p, "&c");
                    p.sendMessage("§cVybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 11) {
                if (p.hasPermission("color.purple")) {
                    p.closeInventory();
                    Config.setColor(p, "&5");
                    p.sendMessage("§5Vybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 12) {
                if (p.hasPermission("color.white")) {
                    p.closeInventory();
                    Config.setColor(p, "&f");
                    p.sendMessage("§fVybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 13) {
                if (p.hasPermission("color.yellow")) {
                    p.closeInventory();
                    Config.setColor(p, "&e");
                    p.sendMessage("§eVybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 14) {
                if (p.hasPermission("color.green")) {
                    p.closeInventory();
                    Config.setColor(p, "&a");
                    p.sendMessage("§aVybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 15) {
                if (p.hasPermission("color.blue")) {
                    p.closeInventory();
                    Config.setColor(p, "&b");
                    p.sendMessage("§bVybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 16) {
                if (p.hasPermission("color.pink")) {
                    p.closeInventory();
                    Config.setColor(p, "&d");
                    p.sendMessage("§dVybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 19) {
                if (p.hasPermission("color.gold")) {
                    p.closeInventory();
                    Config.setColor(p, "&6");
                    p.sendMessage("§6Vybrána barva tohoto typu");
                } else {
                    p.sendMessage("§7Toto je dostupné pouze pro IronVIP a vyšší");
                    p.closeInventory();
                }
            }
                if (e.getSlot() == 49) {
                        if (Main.chatcolorconfig.contains(p.getUniqueId().toString())) {
                        p.closeInventory();
                       Config.removeColor(p);
                        p.sendMessage("§7Deaktivováno");
                    } else {
                    	p.sendMessage("§7Nemáš aktivovaný žádný ChatColor!");
                    	p.closeInventory();
                    }
            }
        }
    }
}



