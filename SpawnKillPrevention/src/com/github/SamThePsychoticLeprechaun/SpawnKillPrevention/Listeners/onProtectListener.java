package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment.RemovePlayer;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.ExcecuteQuery;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util.TimeParser;

public class onProtectListener implements Listener{
	
	public static SpawnKillPrevention plugin;
	private String warnOnAttack = SpawnKillPrevention.warnofprotectedplayer;
	private int damageProtectMult = SpawnKillPrevention.damageprotectionmult;
	private int damageEnvProtectMult = SpawnKillPrevention.environmentprotectionmult;
	private int damageDealtMult = SpawnKillPrevention.damagedealtmult;
	private static Player playerAttacked;
	private static Player playerAttacker;
	private int damageDealt;
	private int damageDealtMultCalc;
	private int damageProtectMultCalc;
	private int damageEnvProtectMultCalc;
	private boolean protectFromEnv = SpawnKillPrevention.protectfromenvironment;
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onDamagePlayer(EntityDamageByEntityEvent event) {
		
	if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
		
		playerAttacked = (Player) event.getEntity();
		playerAttacker = (Player) event.getDamager();
		
		if (TimeParser.compareTimeToCurrent(ExcecuteQuery.checkPlayerProtection(playerAttacked.getName())) && TimeParser.compareTimeToCurrent(ExcecuteQuery.checkPlayerProtection(playerAttacker.getName()))) {
			
			playerAttacker.sendMessage(warnOnAttack);
			damageDealt = event.getDamage();
			damageProtectMultCalc = (100 - damageProtectMult) / 100; 
			damageDealtMultCalc = (100 - damageDealtMult) / 100;
			event.setDamage(damageDealt * damageProtectMultCalc * damageDealtMultCalc);
			RemovePlayer.removePlayer(playerAttacker);
			
		} else if (TimeParser.compareTimeToCurrent(ExcecuteQuery.checkPlayerProtection(playerAttacked.getName()))) {
			
			playerAttacker.sendMessage(warnOnAttack);
			damageDealt = event.getDamage();
			damageProtectMultCalc = (100 - damageProtectMult) / 100; 
			event.setDamage(damageDealt * damageProtectMultCalc);
			
		} else if (TimeParser.compareTimeToCurrent(ExcecuteQuery.checkPlayerProtection(playerAttacker.getName()))) {
			
			damageDealt = event.getDamage();
			damageDealtMultCalc = (100 - damageDealtMult) / 100;
			event.setDamage(damageDealt * damageDealtMultCalc);
			RemovePlayer.removePlayer(playerAttacker);
			
		}
		
	}	else if (event.getEntity() instanceof Player) {
		
		if (protectFromEnv == true) {
		
		playerAttacked = (Player) event.getEntity();
		
		if(TimeParser.compareTimeToCurrent(ExcecuteQuery.checkPlayerProtection(playerAttacked.getName()))) {
			
			damageDealt = event.getDamage();
			damageEnvProtectMultCalc = (100 - damageEnvProtectMult) / 100;
			event.setDamage(damageDealt * damageEnvProtectMultCalc);
		
		}
		
	}
	}
	}
}
