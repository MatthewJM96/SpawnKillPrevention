package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Commands.SpawnKillPreventionCommandHandler;
//import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners.onBannedLoginListener;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners.onDamageListener;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners.onDeathListener;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners.onKilledListener;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners.onLoginListener;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners.onProtectListener;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.ExcecuteQuery;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.TimeParser;

public class SpawnKillPrevention extends JavaPlugin {
	
	/**
	 * Declare some variables
	 */
	protected static File configFile;
	public static SpawnKillPrevention plugin = (SpawnKillPrevention) Bukkit.getServer().getPluginManager().getPlugin("SpawnKillPrevention");
	
	/**
	 * Declaring all config value variables
	 */
	public static boolean protectplayeronlogin;
	public static boolean protectplayeronkill;
	public static boolean protectplayerondeath;
	public static boolean warnonprotection;
	public static String warnonprotectionmessage;
	public static boolean warnonprotectionlost;
	public static String  warnonlostprotectionmessage;
	public static int protectionperiod;
	public static int distancetravelledlimit;
	public static boolean incorporateverticaltravel;
	public static boolean removeprotectiononweaponequip;
	public static boolean removeprotectiononattack;
	public static boolean removeprotectiononattackwithweapon;
	public static List<Integer> weaponlist;
	public static int damageprotectionmult;
	public static boolean protectfromenvironment;
	public static int environmentprotectionmult;
	public static int expretentionmult;
	public static int damagedealtmult;
	public static String warnofprotectedplayer;
	public static int spawnkillstofirstwarn;
	public static String firstwarn;
	public static int firstkilldiscountdelay;
	public static int spawnkillstofirstadminwarn;
	public static int spawnkillstokick;
	public static String messageonkick;
	public static int spawnkillstosecondwarn;
	public static String secondwarn;
	public static int secondkilldiscountdelay;
	public static int spawnkillstosecondadminwarn;
	public static int spawnkillstotempban;
	public static String messageontempban;
	public static int tempbanduration;
	public static int thirdkilldiscountdelay;
	public static int spawnkillstothirdwarn;
	public static String thirdwarn;
	public static int spawnkillstopermaban;
	public static String messageonban;
	public static String Server;
	public static int Port;
	public static String User;
	public static String Password;
	public static String Database;
	
	@Override
	public void onEnable() {
		
	/**
	 * Confirm plugin enabled
	 */
	PluginDescriptionFile pdfFile = this.getDescription();
	getLogger().info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " is enabled");
		
		
	/**
	 * Create and load config file	
	 */
	configFile = new File(getDataFolder(), "config.yml");
		
	if(configFile.exists()) {
		try {
        getConfig().load(configFile);
        getLogger().info("Config file successfully loaded.");
			} catch (FileNotFoundException e) {
			getLogger().info("Error while loading config!");
            e.printStackTrace();
        	} catch (IOException e) {
            getLogger().info("Error while loading config!");
            e.printStackTrace();
        	} catch (InvalidConfigurationException e) {
            getLogger().info("Error while loading config!");
            e.printStackTrace();
        	}	
		} else {
			getLogger().info("Creating Config File!");
			this.saveDefaultConfig();
			try {
			    getConfig().load(configFile);
			    getLogger().info("Config file successfully loaded.");
				} catch (FileNotFoundException e) {
				getLogger().info("Error while loading config!");
			    e.printStackTrace();
			    } catch (IOException e) {
			    getLogger().info("Error while loading config!");
			    e.printStackTrace();
			    } catch (InvalidConfigurationException e) {
			    getLogger().info("Error while loading config!");
			    e.printStackTrace();
			    }
		}
			
	
	/**
	 * Register commands with command handler
	 */
	getCommand("SpawnKillPrevention").setExecutor(new SpawnKillPreventionCommandHandler());
	getCommand("SKP").setExecutor(new SpawnKillPreventionCommandHandler());

	
	/**
	 * Register all listeners
	 */
	getServer().getPluginManager().registerEvents(new onLoginListener(), this);
	getServer().getPluginManager().registerEvents(new onKilledListener(), this);
	getServer().getPluginManager().registerEvents(new onDeathListener(), this);
	getServer().getPluginManager().registerEvents(new onDamageListener(), this);
	getServer().getPluginManager().registerEvents(new onProtectListener(), this);
	//getServer().getPluginManager().registerEvents(new onBannedLoginListener(config.getString("messageonban"), config.getString("messageontempban")), this);

	
	/**
	 * Load all values from config file
	 */
	FileConfiguration config = getConfig();	
	
	SpawnKillPrevention.protectplayeronlogin = config.getBoolean("protectplayeronlogin");
	SpawnKillPrevention.protectplayeronkill = config.getBoolean("protectplayeronkill");
	SpawnKillPrevention.protectplayerondeath = config.getBoolean("protectplayerondeath");
	SpawnKillPrevention.warnonprotection = config.getBoolean("warnonprotection");
	SpawnKillPrevention.warnonprotectionmessage = config.getString("warnonprotectionmessage");
	SpawnKillPrevention.warnonprotectionlost = config.getBoolean("warnonprotectionlost");
	SpawnKillPrevention.warnonlostprotectionmessage = config.getString("warnonlostprotectionmessage");
	SpawnKillPrevention.protectionperiod = config.getInt("protectionperiod");
	SpawnKillPrevention.distancetravelledlimit = config.getInt("distancetravelledlimit");
	SpawnKillPrevention.incorporateverticaltravel = config.getBoolean("incorporateverticaltravel");
	SpawnKillPrevention.removeprotectiononweaponequip = config.getBoolean("removeprotectiononweaponequip");
	SpawnKillPrevention.removeprotectiononattack = config.getBoolean("removeprotectiononattack");
	SpawnKillPrevention.removeprotectiononattackwithweapon = config.getBoolean("removeprotectiononattackwithweapon");
	SpawnKillPrevention.weaponlist = config.getIntegerList("weaponlist");
	SpawnKillPrevention.damageprotectionmult = config.getInt("damageprotectionmult");
	SpawnKillPrevention.protectfromenvironment = config.getBoolean("protectfromenvironment");
	SpawnKillPrevention.environmentprotectionmult = config.getInt("environmentprotectionmult");
	SpawnKillPrevention.expretentionmult = config.getInt("expretentionmult");
	SpawnKillPrevention.damagedealtmult = config.getInt("damagedealtmult");
	SpawnKillPrevention.warnofprotectedplayer = config.getString("warnofprotectedplayer");
	SpawnKillPrevention.spawnkillstofirstwarn = config.getInt("spawnkillstofirstwarn");
	SpawnKillPrevention.firstwarn = config.getString("firstwarn");
	SpawnKillPrevention.firstkilldiscountdelay = config.getInt("firstkilldiscountdelay");
	SpawnKillPrevention.spawnkillstofirstadminwarn = config.getInt("spawnkillstofirstadminwarn");
	SpawnKillPrevention.spawnkillstokick = config.getInt("spawnkillstokick");
	SpawnKillPrevention.messageonkick = config.getString("messageonkick");
	SpawnKillPrevention.spawnkillstosecondwarn = config.getInt("spawnkillstosecondwarn");
	SpawnKillPrevention.secondwarn = config.getString("secondwarn");
	SpawnKillPrevention.secondkilldiscountdelay = config.getInt("secondkilldiscountdelay");
	SpawnKillPrevention.spawnkillstosecondadminwarn = config.getInt("spawnkillstosecondadminwarn");
	SpawnKillPrevention.spawnkillstotempban = config.getInt("spawnkillstotempban");
	SpawnKillPrevention.messageontempban = config.getString("messageontempban");
	SpawnKillPrevention.tempbanduration = config.getInt("tempbanduration");
	SpawnKillPrevention.thirdkilldiscountdelay = config.getInt("thirdkilldiscountdelay");
	SpawnKillPrevention.spawnkillstothirdwarn = config.getInt("spawnkillstothirdwarn");
	SpawnKillPrevention.thirdwarn = config.getString("thirdwarn");
	SpawnKillPrevention.spawnkillstopermaban = config.getInt("spawnkillstopermaban");
	SpawnKillPrevention.messageonban = config.getString("messageonban");
	SpawnKillPrevention.Server = config.getString("Server");
	SpawnKillPrevention.Port = config.getInt("Port");
	SpawnKillPrevention.User = config.getString("User");
	SpawnKillPrevention.Password = config.getString("Password");
	SpawnKillPrevention.Database = config.getString("Database");
	
	/**
	 * Create, fill and load tables
	 */
	ExcecuteQuery.createTable("CREATE TABLE IF NOT EXISTS Protected(playerName VARCHAR(16),timeToEnd VARCHAR(16))");
	
	for(Player player: Bukkit.getServer().getOnlinePlayers()) {
		String name = player.getName();
		String string = null;
		try {
		string = ExcecuteQuery.getString("SELECT playerName, timeToEnd FROM Protected WHERE playerName = '" + name + "'", 1);
		} catch(Exception ex){
			string = null;
		} finally {
			if(string == null ) {
				ExcecuteQuery.setString("INSERT INTO Protected(playerName, timeToEnd) VALUES('" + name + "', '" + TimeParser.getSystDate() + "')");
			}
		}
		
	}
	
	}
	

	@Override
	public void onDisable() {
		
		/**
		 * Unregister all handlers
		 */
		HandlerList.unregisterAll(this);
		
	}
	
	/**
	 * Get online players
	 * @return
	 */
	public static Player[] onlinePlayers() {
		Player[] onlinePlayers = Bukkit.getServer().getOnlinePlayers();
		return onlinePlayers;
	}
	
	//This section is disabled until a fix can be found for the "/SKP Add <Player>" command.
	
	//public static String messageOnProtectGetter() {
		//FileConfiguration config = plugin.getConfig();
		//String messageOnProtect = config.getString("warnonprotectionmessage");
		//return messageOnProtect;		
	//}
	
	//public static String messageOnLosttGetter() {
		//FileConfiguration config = plugin.getConfig();
		//String messageOnLost = config.getString("warnonlostprotectionmessage");
		//return messageOnLost;		
	//}
	
	//public static int protectionPeriodGetter() {
		//FileConfiguration config = plugin.getConfig();
		//int protectionDuration = config.getInt("protectionperiod");
		//return protectionDuration;		
	//}
}
