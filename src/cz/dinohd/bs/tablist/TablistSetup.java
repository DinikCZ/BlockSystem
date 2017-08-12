package cz.dinohd.bs.tablist;

import org.bukkit.entity.Player;

import cz.dinohd.bs.Main;

public class TablistSetup {

    public static void setupTablist(final Player p){
        if (Main.config.getString("server").equalsIgnoreCase("creative")) {
            setupPrefixInTabCreative(p);
        } else if (Main.config.getString("server").equalsIgnoreCase("softcraft")) {
        	setupPrefixInTabSurvivalExtreme(p);
        } else if (Main.config.getString("server").equalsIgnoreCase("survival")){
            setupPrefixInTabSurvival(p);
        } else if (Main.config.getString("server").equalsIgnoreCase("skyblock")){
            setupPrefixInTabSkyblock(p);
        } else if (Main.config.getString("server").equalsIgnoreCase("lobby")){
            setupPrefixInTabLobby(p);
        } else if (Main.config.getString("server").equalsIgnoreCase("pingy")){
            setupPrefixInTabPingy(p);
        } else {
        }
    }

    private static void setupPrefixInTabSkyblock(final Player p){
        if(p.hasPermission("system.prefix.majitel")){
            p.setPlayerListName("§b§lMAJITEL §f" + p.getName());
        } else if (p.hasPermission("system.prefix.hladmin")){
            p.setPlayerListName("§4§lHL.ADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.adminka")){
            p.setPlayerListName("§4§lADMINKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.admin")){
            p.setPlayerListName("§4§lADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.builder")){
            p.setPlayerListName("§5§lBUILDER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helperka")){
            p.setPlayerListName("§2§lHELPERKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helper")){
            p.setPlayerListName("§2§lHELPER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.vip")){
            p.setPlayerListName("§a§lVIP §f" + p.getName());
        } else {
            p.setPlayerListName("§f" + p.getName());
        }
    }
    private static void setupPrefixInTabLobby(final Player p){
        if(p.hasPermission("system.prefix.majitel")){
            p.setPlayerListName("§b§lMAJITEL §f" + p.getName());
        } else if (p.hasPermission("system.prefix.hladmin")){
            p.setPlayerListName("§4§lHL.ADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.adminka")){
            p.setPlayerListName("§4§lADMINKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.admin")){
            p.setPlayerListName("§4§lADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.builder")){
            p.setPlayerListName("§5§lBUILDER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helperka")){
            p.setPlayerListName("§2§lHELPERKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helper")){
            p.setPlayerListName("§2§lHELPER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.vip")){
            p.setPlayerListName("§a§lVIP §f" + p.getName());
        } else {
            p.setPlayerListName("§f" + p.getName());
        }
    }

    private static void setupPrefixInTabSurvival(final Player p){
        if(p.hasPermission("system.prefix.majitel")){
            p.setPlayerListName("§c§lMajitel §f" + p.getName());
        } else if (p.hasPermission("system.prefix.hladmin")){
            p.setPlayerListName("§4§lHL.ADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.adminka")){
            p.setPlayerListName("§4§lAdminka §f" + p.getName());
        } else if (p.hasPermission("system.prefix.admin")){
            p.setPlayerListName("§4§lAdmin §f" + p.getName());
        } else if (p.hasPermission("system.prefix.builder")){
            p.setPlayerListName("§5§lBuilder §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helperka")){
            p.setPlayerListName("§2§lHelperka §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helper")){
            p.setPlayerListName("§2§lHelper §f" + p.getName());
        } else if (p.hasPermission("system.prefix.boss")){
            p.setPlayerListName("§b§lHero §f" + p.getName());
        } else if (p.hasPermission("system.prefix.vipplus")){
            p.setPlayerListName("§3§lUltra §f" + p.getName());
        } else if (p.hasPermission("system.prefix.vip")){
            p.setPlayerListName("§a§lVIP §f" + p.getName());
        } else {
            p.setPlayerListName("§7" + p.getName());
        }
    }
    private static void setupPrefixInTabPingy(final Player p){
        if(p.hasPermission("system.prefix.majitel")){
            p.setPlayerListName("§b§lMAJITEL §f" + p.getName());
        } else if (p.hasPermission("system.prefix.hladmin")){
            p.setPlayerListName("§4§lHL.ADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.adminka")){
            p.setPlayerListName("§4§lADMINKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.admin")){
            p.setPlayerListName("§4§lADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.builder")){
            p.setPlayerListName("§5§lBUILDER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helperka")){
            p.setPlayerListName("§2§lHELPERKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helper")){
            p.setPlayerListName("§2§lHELPER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.boss")){
            p.setPlayerListName("§6§lSPONZOR §f" + p.getName());
        } else if (p.hasPermission("system.prefix.vipplus")){
            p.setPlayerListName("§b§lBOSS §f" + p.getName());
        } else if (p.hasPermission("system.prefix.vip")){
            p.setPlayerListName("§a§lVIP §f" + p.getName());
        } else {
            p.setPlayerListName("§f" + p.getName());
        }
    }
    private static void setupPrefixInTabSurvivalExtreme(final Player p){
        if(p.hasPermission("system.prefix.majitel")){
            p.setPlayerListName("§8[§bMajitel§8] §3" + p.getName());
        } else if (p.hasPermission("system.prefix.vedeni")){
            p.setPlayerListName("§8[§cVedení§8] §c" + p.getName());
        } else if (p.hasPermission("system.prefix.hladmin")){
            p.setPlayerListName("§8[§4HlAdmin§8] §c" + p.getName());
        } else if (p.hasPermission("system.prefix.admin")){
            p.setPlayerListName("§8[§4Admin§8] §c" + p.getName());
        } else if (p.hasPermission("system.prefix.builder")){
            p.setPlayerListName("§8[§5Builder§8] §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helper")){
            p.setPlayerListName("§8[§2Helper§8] §a" + p.getName());
        } else if (p.hasPermission("system.prefix.boss")){
            p.setPlayerListName("§8[§6Ultra§8] §e" + p.getName());
        } else if (p.hasPermission("system.prefix.vipplus")){
            p.setPlayerListName("§8[§6EVIP§8] §e" + p.getName());
        } else if (p.hasPermission("system.prefix.vip")){
            p.setPlayerListName("§8[§6VIP§8] §e" + p.getName());
        } else {
            p.setPlayerListName("§8[§3Hrac§8] §a" + p.getName());
        }
    }
    private static void setupPrefixInTabCreative(final Player p){
        if(p.hasPermission("system.prefix.majitel")){
            p.setPlayerListName("§b§lMAJITEL §f" + p.getName());
        } else if (p.hasPermission("system.prefix.hladmin")){
            p.setPlayerListName("§4§lHL.ADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.adminka")){
            p.setPlayerListName("§4§lADMINKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.admin")){
            p.setPlayerListName("§4§lADMIN §f" + p.getName());
        } else if (p.hasPermission("system.prefix.builder")){
            p.setPlayerListName("§5§lBUILDER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helperka")){
            p.setPlayerListName("§2§lHELPERKA §f" + p.getName());
        } else if (p.hasPermission("system.prefix.helper")){
            p.setPlayerListName("§2§lHELPER §f" + p.getName());
        } else if (p.hasPermission("system.prefix.vip")){
            p.setPlayerListName("§a§lVIP §f" + p.getName());
        } else {
            p.setPlayerListName("§f" + p.getName());
        }
    }
}