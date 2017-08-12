package cz.dinohd.bs.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class MenuIcon {

    private ItemStack item;
    private Material material;
    private String name;
    private String[] lore;
    private int amount;
    private String type;

    public MenuIcon(Material material, String name, String type) {
	this.type = type;
	this.amount = 1;
	this.item = new ItemStack(material, amount);
	this.setName(name);
	this.setMaterial(material);

    }

    public String[] getLore() {
	return lore;
    }

    public void setLore(String[] lore) {
	this.lore = lore;

	List<String> listLore = new ArrayList<String>();

	for (int i = 0; i < lore.length; i++) {
	    listLore.add(lore[i]);
	}

	setLore(listLore);
    }

    public void setLore(List<String> lore) {
	ItemMeta im = item.getItemMeta();
	im.setLore(lore);
	item.setItemMeta(im);
    }

    public void setMetaData(int data) {
	ItemStack tmp = new ItemStack(material, amount, (short) data);
	item = tmp;
	setName(name);
    }

    public void addEnchant(Enchantment enchant, int power) {
	ItemMeta im = item.getItemMeta();
	im.addEnchant(enchant, power, true);
	item.setItemMeta(im);
    }

    public void clearEnchants() {
	ItemMeta im = item.getItemMeta();
	if (im.hasEnchants())
	    for (Enchantment en : im.getEnchants().keySet())
		im.removeEnchant(en);
	item.setItemMeta(im);
    }

    public void setSkullOwner(String nick) {
	if (item.getType() == Material.SKULL_ITEM) {
	    SkullMeta sm = (SkullMeta) item.getItemMeta();
	    sm.setOwner(nick);
	    item.setItemMeta(sm);
	}
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
	ItemMeta im = item.getItemMeta();
	im.setDisplayName(name);
	item.setItemMeta(im);
    }

    public Material getMaterial() {
	return material;
    }

    public void setMaterial(Material material) {
	this.material = material;
	item.setType(material);
    }

    public ItemStack getItem() {
	return item;
    }

    public int getAmount() {
	return amount;
    }

    public void setAmount(int amount) {
	this.amount = amount;
	if (amount > 64) {
	    item.setAmount(64);
	} else
	    item.setAmount(amount);
    }

    public String getType() {
	return type;
    }

    public void destroy() {
	item = null;
	material = null;
	name = null;
	lore = null;
	amount = 0;
	type = null;
    }
}

