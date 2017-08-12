package cz.dinohd.bs.vyhody.chatcolor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("chatcolor"))) {
                try {
                    if (ArrayOfString.length == 0) {
                         GUI.openParticlesMenu(player);
                        return true;
                    }
                    return true;
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
