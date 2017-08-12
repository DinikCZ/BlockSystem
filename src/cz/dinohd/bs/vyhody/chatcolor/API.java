package cz.dinohd.bs.vyhody.chatcolor;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;




public class API
{
  
  public static String color(String msg)
  {
    return ChatColor.translateAlternateColorCodes('&', msg);
  }
  
  public static ItemStack createItem(Material mat, short id, String name) {
    ItemStack item = new ItemStack(mat);
    item.setDurability(id);
    ItemMeta im = item.getItemMeta();
    im.setDisplayName(color(name));
    item.setItemMeta(im);
    return item;
  }
}
