package cz.dinohd.bs.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.omg.CORBA.portable.InputStream;

import cz.dinohd.bs.Main;

public class AutoUpdater {
	private static final int BUFFER_SIZE = 4096;
    public static void downloadFile(String fileURL, String saveDir)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
 
            if (disposition != null) {
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10,
                            disposition.length() - 1);
                }
            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
                        fileURL.length());
            }
 
            System.out.println("Typ Souboru = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Velikost = " + contentLength);
            System.out.println("Název souboru = " + fileName);
 
            java.io.InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("Soubor stažen");
        } else {
            System.out.println("Chyba pøi stahování! HTML Err Code: " + responseCode);
        }
        httpConn.disconnect();
    }
	public void checkForUpdates(Player p) {
	    try {
			String prefix = Main.config.getString("prefix");
	        HttpURLConnection c = (HttpURLConnection)new URL("http://www.dinik.cz/pluginy/BlockSystem.php").openConnection();
	        c.setDoOutput(true);
	        String oldVersion = Main.getInstance().getDescription().getVersion();
	        String newVersion = new BufferedReader(new InputStreamReader(c.getInputStream())).readLine().replaceAll("[a-zA-Z ]", "");
	        p.sendMessage(prefix + "§aJe dostupná aktualizace! §eNapsáním pøíkazu §c§l/bsupdate §espuštíš aktualizaci");
	        p.sendMessage(prefix + "§eNyní používáš verzi §c" + oldVersion + "§e, ale novìjší verze je §c" + newVersion);
	        if(!newVersion.equals(oldVersion)) {
	          p.sendMessage(prefix + "§aNejsou dostupné žádné aktualizace! §ePoužíváš verzi: " + oldVersion);
	        }
	      }
	      catch(Exception e) {
	    	  String prefix = Main.config.getString("prefix");
	        Bukkit.broadcastMessage(prefix + "Spojení bylo ukonèeno vzdáleným hostitelem");
	      }

	}
	public static void downloadUpdate(Player p) {
		String prefix = Main.config.getString("prefix");
		p.sendMessage(prefix + "§aZahajuji stahování..");
	    Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
			@Override
	        public void run() {
		        String fileURL = "http://www.dinik.cz/pluginy/BlockSystem.jar";
		        String saveDir = new File(".").getAbsolutePath();
		        String saveDir1 = saveDir + "/plugins/"; 
	        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
	        	p.sendMessage(prefix + "§eStahování bylo úspìšné! §7Probìhne reload BlockSystemu.. V této minutì mùžou být menší lagy!");
	        	try {
					downloadFile(fileURL, saveDir1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	}, 300);
	    Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
			@Override
	        public void run() {
	        	p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
	        	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "plugman reload BlockSystem");
	        }
	}, 600);
	}
}