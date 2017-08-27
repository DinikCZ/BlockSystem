package cz.dinohd.bs;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Sound;
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
import cz.dinohd.bs.eventy.EasterEggs;
import cz.dinohd.bs.eventy.FireworkSpawnEvent;
import cz.dinohd.bs.eventy.IceBoatSpawn;
import cz.dinohd.bs.eventy.JoinListener;
import cz.dinohd.bs.prikazy.ActivateJumpingEffect;
import cz.dinohd.bs.prikazy.AdminChat;
import cz.dinohd.bs.prikazy.AnnounceCommand;
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
	public static File ateam;
	public static YamlConfiguration config;
	public static YamlConfiguration chatcolorconfig;
	public static YamlConfiguration ateamfile;
	
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
    this.loadEvents();
    this.loadCommand();
    try {
    Bukkit.getScheduler().runTaskLaterAsynchronously(this, new Runnable() {
    @Override
    public void run() {
			this.startup();
		}

	private void startup() {
    	try {
    		List<String> ateam = ateamfile.getStringList("ateam");
    		Random random = new Random();
    		int index = random.nextInt(ateam.size());
		URL url = new URL("http://cravatar.eu/avatar/" + ateam.get(index) + "/500.png");
        BufferedImage imageToSend;
			imageToSend = ImageIO.read(url);
        for (Player pl : Bukkit.getServer().getOnlinePlayers()){
            new ImageMessage(
            imageToSend,
            8,
            ImageChar.BLOCK.getChar() 
            ).appendText(
            "§7§m+-------------------------------------+",
            "",
            "",
            "§b§lSystem §8§l» §eBlockSystem v1.5.1 byl naèten!",
            "§b§lSystem §8§l» §eI'm different",
            "",
            "",
            "§7§m+-------------------------------------+"
            ).sendToPlayer(pl);
    }
    	} catch (Exception e) {
    	e.printStackTrace();
    	}
		
	}
}, 1);
    } catch (Exception e) {
    e.printStackTrace();
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
	
	ateam = new File(getDataFolder(), "ateam.yml");
	if (!ateam.exists()) {
		try {
			Files.copy(getResource("ateam.yml"), ateam.toPath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	ateamfile = YamlConfiguration.loadConfiguration(ateam);
    
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
/*    public void startup() throws IOException {
    	try {
    		List<String> ateam = ateamfile.getStringList("ateam");
    		Random random = new Random();
    		int index = random.nextInt(ateam.size());
		URL url = new URL("http://cravatar.eu/avatar/" + ateam.get(index) + "/500.png");
        BufferedImage imageToSend;
			imageToSend = ImageIO.read(url);
        for (Player pl : Bukkit.getServer().getOnlinePlayers()){
            new ImageMessage(
            imageToSend,
            8,
            ImageChar.BLOCK.getChar() 
            ).appendText(
            "§7§m+-------------------------------------+",
            "",
            "",
            "§b§lSystem §8§l» §eBlockSystem v1.5 byl naèten!",
            "§b§lSystem §8§l» §eGoodbye Ender Dragon Wings",
            "",
            "",
            "§7§m+-------------------------------------+"
            ).sendToPlayer(pl);
    }
    	} catch (Exception e) {
    	e.printStackTrace();
    	}
    }*/
   public void loadCommand() {
	    this.getCommand("cc").setExecutor(new ClearChatCommand());
	    this.getCommand("softrestart").setExecutor(new SoftRestartCommand());
	    this.getCommand("softcontroller").setExecutor(new SoftControllerCommand());
	    this.getCommand("bsreload").setExecutor(new ReloadCommand());
	    this.getCommand("bsdownload").setExecutor(new DownloadUpdate());
	    this.getCommand("bsregenerate").setExecutor(new RegenerateConfigCommand());
	    this.getCommand("ac").setExecutor(new AdminChat());
	    this.getCommand("event").setExecutor(new Announcments());
	    this.getCommand("inv").setExecutor(new InvCommand());
	    this.getCommand("inzerat").setExecutor(new InzeratCommand());
	    this.getCommand("chatcolor").setExecutor(new CMD());
	    this.getCommand("particles").setExecutor(new Particles_command());
	    this.getCommand("spawnboat").setExecutor(new IceBoatSpawn());
	    this.getCommand("activatejumpingeffectcommand").setExecutor(new ActivateJumpingEffect());
	    this.getCommand("announce").setExecutor(new AnnounceCommand());
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
	    getServer().getPluginManager().registerEvents(new EasterEggs(), this);
   }
}