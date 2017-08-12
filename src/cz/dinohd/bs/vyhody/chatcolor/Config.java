package cz.dinohd.bs.vyhody.chatcolor;

import java.io.IOException;
import java.util.UUID;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import cz.dinohd.bs.Main;




public class Config
{
  public Config() {}
  
  public static void setColor(Player p, String color) throws IOException
  {
    String uuid = p.getUniqueId().toString();
    
    Main.chatcolorconfig.set(uuid + ".Color", color);
    Main.chatcolorconfig.save(Main.file);
  }
  
  public static String getColor(Player p)
  {
    if (Main.chatcolorconfig.contains(p.getUniqueId().toString())) {
      return Main.chatcolorconfig.getString(p.getUniqueId().toString() + ".Color");
    }
    
    return null;
  }
  public static void removeColor(Player p)
  {
      Main.chatcolorconfig.set(p.getUniqueId().toString(), null);
    }
    
  }
