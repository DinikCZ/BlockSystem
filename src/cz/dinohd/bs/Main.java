package cz.dinohd.bs;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.bobacadodl.imgmessage.ImageChar;
import com.bobacadodl.imgmessage.ImageMessage;

import cz.dinohd.bs.eventy.Announcments;
import cz.dinohd.bs.eventy.AntiBugger;
import cz.dinohd.bs.eventy.ChatBlock;
import cz.dinohd.bs.eventy.CreativeControl;
import cz.dinohd.bs.eventy.FireworkSpawnEvent;
import cz.dinohd.bs.eventy.IceBoatSpawn;
import cz.dinohd.bs.eventy.JoinListener;
import cz.dinohd.bs.prikazy.AFK;
import cz.dinohd.bs.prikazy.ActivateJumpingEffect;
import cz.dinohd.bs.prikazy.AdminChat;
import cz.dinohd.bs.prikazy.ClearChatCommand;
import cz.dinohd.bs.prikazy.DownloadUpdate;
import cz.dinohd.bs.prikazy.InvCommand;
import cz.dinohd.bs.prikazy.InzeratCommand;
import cz.dinohd.bs.prikazy.RegenerateConfigCommand;
import cz.dinohd.bs.prikazy.ReloadCommand;
import cz.dinohd.bs.prikazy.SoftControllerCommand;
import cz.dinohd.bs.prikazy.SoftRestartCommand;
import cz.dinohd.bs.residence.ResidenceCreateInfo;
import cz.dinohd.bs.residence.ResidenceTutorial;
import cz.dinohd.bs.vyhody.Particles_command;
import cz.dinohd.bs.vyhody.chatcolor.CMD;
import cz.dinohd.bs.vyhody.chatcolor.Events;
import cz.dinohd.bs.vyhody.chatcolor.GUI;
import cz.dinohd.bs.vyhody.particles.ParticlesAPI;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.Economy;


public class Main extends JavaPlugin implements Plugin, Listener, PluginMessageListener {
    private static Main instance;
    Player pl;
	public static File f;
	public static File file;
	public static YamlConfiguration config;
	public static YamlConfiguration chatcolorconfig;
	
    private ParticlesAPI particlesAPI = new ParticlesAPI();
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<Player> softauth = new ArrayList<Player>();
    private static ArrayList<String> trampoline = new ArrayList<String>();
    private static ArrayList<String> afk = new ArrayList<String>();
    @Override
public void onEnable() {
    Server server = Bukkit.getServer();
    instance = this;
    ConsoleCommandSender console = server.getConsoleSender();
    console.sendMessage((Object)ChatColor.AQUA + "[BlockSystem]" + (Object)ChatColor.GRAY + " byl zapnut!");
    console.sendMessage((Object)ChatColor.YELLOW + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    console.sendMessage((Object)ChatColor.GRAY + "");
    console.sendMessage((Object)ChatColor.GRAY + "            BlockSystem");
    console.sendMessage((Object)ChatColor.GRAY + "          Vytvoøil _Dinik_");
    console.sendMessage((Object)ChatColor.GRAY + "             Verze 1.0");
    console.sendMessage((Object)ChatColor.RED + "             Naèítání...");
    console.sendMessage((Object)ChatColor.GRAY + "");
    console.sendMessage((Object)ChatColor.YELLOW + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    console.sendMessage((Object)ChatColor.YELLOW + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    console.sendMessage((Object)ChatColor.RED + "          Úspìšnì naèteno!");
    console.sendMessage((Object)ChatColor.YELLOW + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    this.loadEvents();
    this.loadCommand();
    try {
			this.startup();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	getDataFolder().mkdirs();
	f = new File(getDataFolder(), "config.yml");
	if (!f.exists()) {
		try {
			Files.copy(getResource("config.yml"), f.toPath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	config = YamlConfiguration.loadConfiguration(f);
	      
	
	file = new File(getDataFolder(), "chatcolor.yml");
	if (!file.exists()) {
		try {
			Files.copy(getResource("chatcolor.yml"), file.toPath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	chatcolorconfig = YamlConfiguration.loadConfiguration(file);
    
    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");        
    Bukkit.getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
		}

    	
    public static Main getInstance() {
    	return instance;
    }
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord")) return;
		
	}
    public ParticlesAPI getParticlesAPI() {
        return particlesAPI;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public ArrayList<Player> getSoftPlayers() {
        return softauth;
    }
    public ArrayList<String> trampolinePlayers() {
        return trampoline;
    }
    public ArrayList<String> afkPlayers() {
        return afk;
    }
    public void addPlayer(Player p) {
        players.add(p);
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }
    public void softAddPlayer(Player p) {
        softauth.add(p);
    }

    public void softRemovePlayer(String p) {
        softauth.remove(p);
    }
    public void trampolineAddPlayer(String p) {
        trampoline.add(p);
    }

    public void trampolineRemovePlayer(String p) {
        trampoline.remove(p);
    }
    public void AFKAdd(String p) {
        afk.add(p);
    }

    public void AFKRem(String p) {
        afk.remove(p);
    }
    public void startup() throws IOException {
       URL url = new URL("http://cravatar.eu/avatar/" + "5fe7bc6f-6f47-4a4a-bac4-561538f734e5" + "/500.png");
        BufferedImage imageToSend = ImageIO.read(url);
        for (Player pl : Bukkit.getServer().getOnlinePlayers()){
            new ImageMessage(
            imageToSend,
            8,
            ImageChar.BLOCK.getChar() 
            ).appendText(
            "§7§m+-------------------------------------+",
            "",
            "",
            "§b§lSystem §8§l» §eBlockSystem byl naèten!",
            "§b§lSystem §8§l» §eHello world",
            "",
            "",
            "§7§m+-------------------------------------+"
            ).sendToPlayer(pl);
    }
    }
   public void loadCommand() {
	    this.getCommand("cc").setExecutor(new ClearChatCommand());
	    this.getCommand("softrestart").setExecutor(new SoftRestartCommand());
	    this.getCommand("softcontroller").setExecutor(new SoftControllerCommand());
	    this.getCommand("bsreload").setExecutor(new ReloadCommand());
	    this.getCommand("bsdownload").setExecutor(new DownloadUpdate());
	    this.getCommand("bsregenerate").setExecutor(new RegenerateConfigCommand());
	    this.getCommand("ac").setExecutor(new AdminChat());
	    this.getCommand("announce").setExecutor(new Announcments());
	    this.getCommand("inv").setExecutor(new InvCommand());
	    this.getCommand("inzerat").setExecutor(new InzeratCommand());
	    this.getCommand("chatcolor").setExecutor(new CMD());
	    this.getCommand("particles").setExecutor(new Particles_command());
	    this.getCommand("spawnboat").setExecutor(new IceBoatSpawn());
	    this.getCommand("activatejumpingeffectcommand").setExecutor(new ActivateJumpingEffect());
	    this.getCommand("afk").setExecutor(new AFK());
   }
   public void loadEvents() {
	    getServer().getPluginManager().registerEvents(new ResidenceCreateInfo(this), this);
	    getServer().getPluginManager().registerEvents(new ResidenceTutorial(this), this);
	    getServer().getPluginManager().registerEvents(new JoinListener(this), this);
	    getServer().getPluginManager().registerEvents(new ParticlesAPI(), this);
	    getServer().getPluginManager().registerEvents(this, this);
	    getServer().getPluginManager().registerEvents(new ChatBlock(), this);
	    getServer().getPluginManager().registerEvents(new Events(), this);
	    getServer().getPluginManager().registerEvents(new GUI(), this);
	    getServer().getPluginManager().registerEvents(new SoftControllerCommand(), this);
	    getServer().getPluginManager().registerEvents(new AntiBugger(), this);
	    getServer().getPluginManager().registerEvents(new IceBoatSpawn(), this);
	    getServer().getPluginManager().registerEvents(new ActivateJumpingEffect(), this);
	    getServer().getPluginManager().registerEvents(new CreativeControl(), this);
	    getServer().getPluginManager().registerEvents(new AFK(), this);
   }
}