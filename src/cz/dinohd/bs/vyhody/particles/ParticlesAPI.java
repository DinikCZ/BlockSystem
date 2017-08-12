package cz.dinohd.bs.vyhody.particles;

import cz.dinohd.bs.Main;
import cz.dinohd.bs.utils.IconMenuAPI;
import cz.dinohd.bs.utils.ItemFactory;
import cz.dinohd.bs.utils.MenuIcon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ParticlesAPI implements Listener {

    Hearts h = new Hearts();
    Angry a = new Angry();
    WhiteMagic w = new WhiteMagic();
    WitchMagic m = new WitchMagic();
    Slime s = new Slime();
    Flame f = new Flame();
    Redstone r = new Redstone();
    Cloud l = new Cloud();
    Enchanted e = new Enchanted();
    Firework k = new Firework();
    Portal p = new Portal();
    Lava la = new Lava();
    Smoke sm = new Smoke();
    Happy ha = new Happy();
    Snowball sn = new Snowball();
    Void vo = new Void();
    Helix helix = new Helix();
    private static int rows;

    public void openParticlesMenu(final Player p) {

        Inventory inv = Bukkit.createInventory(null, 54, "§0        §9§lParticles");

        if (p.hasPermission("system.particles.hearts")) {
            if (Hearts.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.APPLE, (byte) 0, "§eHearts", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(10, i);
            } else {
                ItemStack i = ItemFactory.create(Material.APPLE, (byte) 0, "§eHearts", "§7Kliknutím aktivuješ!");
                inv.setItem(10, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cHearts", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(10, i);
        }
        if (p.hasPermission("system.particles.angry")) {
            if (Angry.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.BLAZE_POWDER, (byte) 0, "§eAngry", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(11, i);
            } else {
                ItemStack i = ItemFactory.create(Material.BLAZE_POWDER, (byte) 0, "§eAngry", "§7Kliknutím aktivuješ!");
                inv.setItem(11, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cAngry", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(11, i);
        }
        if (p.hasPermission("system.particles.whitemagic")) {
            if (WhiteMagic.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.BONE, (byte) 0, "§eWhite Magic", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(12, i);
            } else {
                ItemStack i = ItemFactory.create(Material.BONE, (byte) 0, "§eWhite Magic", "§7Kliknutím aktivuješ!");
                inv.setItem(12, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cWhite Magic", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(12, i);
        }
        if (p.hasPermission("system.particles.witchmagic")) {
            if (WitchMagic.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.FERMENTED_SPIDER_EYE, (byte) 0, "§eWitch Magic", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(13, i);
            } else {
                ItemStack i = ItemFactory.create(Material.FERMENTED_SPIDER_EYE, (byte) 0, "§eWitch Magic", "§7Kliknutím aktivuješ!");
                inv.setItem(13, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cWitch Magic", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(13, i);
        }
        if (p.hasPermission("system.particles.slime")) {
            if (Slime.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.SLIME_BALL, (byte) 0, "§eSlime", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(14, i);
            } else {
                ItemStack i = ItemFactory.create(Material.SLIME_BALL, (byte) 0, "§eSlime", "§7Kliknutím aktivuješ!");
                inv.setItem(14, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cSlime", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(14, i);
        }
        if (p.hasPermission("system.particles.snowball")) {
            if (Snowball.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§eSnow", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(15, i);
            } else {
                ItemStack i = ItemFactory.create(Material.SNOW_BALL, (byte) 0, "§eSnow", "§7Kliknutím aktivuješ!");
                inv.setItem(15, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cSnow", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(15, i);
        }
        if (p.hasPermission("system.particles.flame")) {
            if (Flame.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.BLAZE_POWDER, (byte) 0, "§eFlame", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(16, i);
            } else {
                ItemStack i = ItemFactory.create(Material.BLAZE_POWDER, (byte) 0, "§eFlame", "§7Kliknutím aktivuješ!");
                inv.setItem(16, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cFlame", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(16, i);
        }
        if (p.hasPermission("system.particles.redstone")) {
            if (Redstone.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.REDSTONE, (byte) 0, "§eRedstone", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(19, i);
            } else {
                ItemStack i = ItemFactory.create(Material.REDSTONE, (byte) 0, "§eRedstone", "§7Kliknutím aktivuješ!");
                inv.setItem(19, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cRedstone", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(19, i);
        }
        if (p.hasPermission("system.particles.cloud")) {
            if (Cloud.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.QUARTZ, (byte) 0, "§eCloud", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(20, i);
            } else {
                ItemStack i = ItemFactory.create(Material.QUARTZ, (byte) 0, "§eCloud", "§7Kliknutím aktivuješ!");
                inv.setItem(20, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cCloud", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(20, i);
        }
        if (p.hasPermission("system.particles.enchanted")) {
            if (Enchanted.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.BOOK, (byte) 0, "§eEnchanted", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(21, i);
            } else {
                ItemStack i = ItemFactory.create(Material.BOOK, (byte) 0, "§eEnchanted", "§7Kliknutím aktivuješ!");
                inv.setItem(21, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cEnchanted", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(21, i);
        }
        if (p.hasPermission("system.particles.firework")) {
            if (Firework.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.FIREWORK, (byte) 0, "§eFirework", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(22, i);
            } else {
                ItemStack i = ItemFactory.create(Material.FIREWORK, (byte) 0, "§eFirework", "§7Kliknutím aktivuješ!");
                inv.setItem(22, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cFirework", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(22, i);
        }
        if (p.hasPermission("system.particles.portal")) {
            if (Portal.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.OBSIDIAN, (byte) 0, "§ePortal", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(23, i);
            } else {
                ItemStack i = ItemFactory.create(Material.OBSIDIAN, (byte) 0, "§ePortal", "§7Kliknutím aktivuješ!");
                inv.setItem(23, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cPortal", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(23, i);
        }
        if (p.hasPermission("system.particles.lava")) {
            if (Lava.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§eLava", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(28, i);
            } else {
                ItemStack i = ItemFactory.create(Material.LAVA_BUCKET, (byte) 0, "§eLava", "§7Kliknutím aktivuješ!");
                inv.setItem(28, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cLava", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(28, i);
        }
        if (p.hasPermission("system.particles.smoke")) {
            if (Smoke.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§eSmoke", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(29, i);
            } else {
                ItemStack i = ItemFactory.create(Material.COAL, (byte) 0, "§eSmoke", "§7Kliknutím aktivuješ!");
                inv.setItem(29, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cSmoke", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(29, i);
        }
        if (p.hasPermission("system.particles.happy")) {
            if (Happy.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.EMERALD, (byte) 0, "§eHappy", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(25, i);
            } else {
                ItemStack i = ItemFactory.create(Material.EMERALD, (byte) 0, "§eHappy", "§7Kliknutím aktivuješ!");
                inv.setItem(25, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cHappy", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(25, i);
        }
        if (p.hasPermission("system.particles.void")) {
            if (Void.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.BEDROCK, (byte) 0, "§eVoid", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(24, i);
            } else {
                ItemStack i = ItemFactory.create(Material.BEDROCK, (byte) 0, "§eVoid", "§7Kliknutím aktivuješ!");
                inv.setItem(24, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cVoid", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(24, i);
        }
        if (p.hasPermission("system.particles.helix")) {
            if (Void.e.containsKey(p.getName())) {
                ItemStack i = ItemFactory.create(Material.REDSTONE_BLOCK, (byte) 0, "§c§lHelix", "§7Kliknutím deaktivuješ!");
                i = ItemFactory.addGlow(i);
                inv.setItem(30, i);
            } else {
                ItemStack i = ItemFactory.create(Material.REDSTONE_BLOCK, (byte) 0, "§c§lHelix", "§7Kliknutím aktivuješ!");
                inv.setItem(30, i);
            }
        } else {
            ItemStack i = ItemFactory.create(Material.INK_SACK, (byte) 8, "§cHelix", "", "§7Tento efekt je dostupný pro §b§lHero §7a §6§lvyšší");
            inv.setItem(30, i);
        }

        ItemStack deaktivace = ItemFactory.create(Material.BARRIER, (byte) 0, "§cDeaktivovat", "§7Kliknutim deaktivujes particles.");
        inv.setItem(49, deaktivace);


        p.openInventory(inv);
    }

    @EventHandler
    private void onDrop(PlayerDropItemEvent e) {
        final Player p =  e.getPlayer();
        if (p.getInventory().getTitle().equals("§0        §9§lParticles")) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    private void onInteract(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("§0        §9§lParticles")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 49) {
                deactivateParticles(p);
            }
            if (e.getSlot() == 10) {
                if (p.hasPermission("system.particles.hearts")) {
                    deactivateParticles(p);
                    this.h.activateLove(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 11) {
                if (p.hasPermission("system.particles.angry")) {
                    deactivateParticles(p);
                    this.a.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 12) {
                if (p.hasPermission("system.particles.whitemagic")) {
                    deactivateParticles(p);
                    this.w.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 13) {
                if (p.hasPermission("system.particles.witchmagic")) {
                    deactivateParticles(p);
                    this.m.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 14) {
                if (p.hasPermission("system.particles.slime")) {
                    deactivateParticles(p);
                    this.s.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 15) {
                if (p.hasPermission("system.particles.snowball")) {
                    deactivateParticles(p);
                    this.sn.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 16) {
                if (p.hasPermission("system.particles.flame")) {
                    deactivateParticles(p);
                    f.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 19) {
                if (p.hasPermission("system.particles.redstone")) {
                    deactivateParticles(p);
                    this.r.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 20) {
                if (p.hasPermission("system.particles.cloud")) {
                    deactivateParticles(p);
                    this.l.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 21) {
                if (p.hasPermission("system.particles.enchanted")) {
                    deactivateParticles(p);
                    this.e.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 22) {
                if (p.hasPermission("system.particles.firework")) {
                    deactivateParticles(p);
                    this.k.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 23) {
                if (p.hasPermission("system.particles.portal")) {
                    deactivateParticles(p);
                    this.p.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 28) {
                if (p.hasPermission("system.particles.lava")) {
                    deactivateParticles(p);
                    this.la.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 29) {
                if (p.hasPermission("system.particles.smoke")) {
                    deactivateParticles(p);
                    this.sm.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 25) {
                if (p.hasPermission("system.particles.happy")) {
                    deactivateParticles(p);
                    this.ha.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
            if (e.getSlot() == 24) {
                if (p.hasPermission("system.particles.void")) {
                    deactivateParticles(p);
                    this.vo.activate(p);
                    p.closeInventory();
                } else {
                    p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                    p.closeInventory();
                }
            }
        if (e.getSlot() == 30) {
            if (p.hasPermission("system.particles.helix")) {
                deactivateParticles(p);
                this.helix.activate(p);
                p.closeInventory();
                p.sendMessage("§cTento Particle je v Betì a je více pravdìpodobné, že nebude fungovat.");
            } else {
                p.sendMessage("§cTento efekt je dostupný pro §b§lHero §ca §6§lvyšší");
                p.closeInventory();
            }
        }
        }
    }


    public void deactivateParticles(Player p) {
        if (Hearts.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Hearts.e.get(p.getName())).intValue());
            Hearts.e.remove(p.getName());
            p.closeInventory();
        }
        if (Angry.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Angry.e.get(p.getName())).intValue());
            Angry.e.remove(p.getName());
            p.closeInventory();
        }
        if (WhiteMagic.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) WhiteMagic.e.get(p.getName())).intValue());
            WhiteMagic.e.remove(p.getName());
            p.closeInventory();
        }
        if (WitchMagic.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) WitchMagic.e.get(p.getName())).intValue());
            WitchMagic.e.remove(p.getName());
            p.closeInventory();
        }
        if (Slime.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Slime.e.get(p.getName())).intValue());
            Slime.e.remove(p.getName());
            p.closeInventory();
        }
        if (Snowball.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Snowball.e.get(p.getName())).intValue());
            Snowball.e.remove(p.getName());
            p.closeInventory();
        }
        if (Flame.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Flame.e.get(p.getName())).intValue());
            Flame.e.remove(p.getName());
            p.closeInventory();
        }
        if (Redstone.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Redstone.e.get(p.getName())).intValue());
            Redstone.e.remove(p.getName());
            p.closeInventory();
        }
        if (Cloud.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Cloud.e.get(p.getName())).intValue());
            Cloud.e.remove(p.getName());
            p.closeInventory();
        }
        if (Enchanted.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Enchanted.e.get(p.getName())).intValue());
            Enchanted.e.remove(p.getName());
            p.closeInventory();
        }
        if (Firework.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Firework.e.get(p.getName())).intValue());
            Firework.e.remove(p.getName());
            p.closeInventory();
        }
        if (Portal.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Portal.e.get(p.getName())).intValue());
            Portal.e.remove(p.getName());
            p.closeInventory();
        }
        if (Lava.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Lava.e.get(p.getName())).intValue());
            Lava.e.remove(p.getName());
            p.closeInventory();
        }
        if (Smoke.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Smoke.e.get(p.getName())).intValue());
            Smoke.e.remove(p.getName());
            p.closeInventory();
        }
        if (Happy.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Happy.e.get(p.getName())).intValue());
            Happy.e.remove(p.getName());
            p.closeInventory();
        }
        if (Void.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Void.e.get(p.getName())).intValue());
            Void.e.remove(p.getName());
            p.closeInventory();
        }
        if (Helix.e.containsKey(p.getName())) {
            Bukkit.getScheduler().cancelTask(((Integer) Helix.e.get(p.getName())).intValue());
            Helix.e.remove(p.getName());
            p.closeInventory();
        }
    }

}
