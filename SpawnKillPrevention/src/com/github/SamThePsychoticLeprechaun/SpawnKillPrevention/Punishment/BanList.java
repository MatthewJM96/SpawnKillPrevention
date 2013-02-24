package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.Punishment;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.entity.Player;

public class BanList {
	
	private static PriorityQueue<Player> tempBannedList = new PriorityQueue<Player>();
	private static List<Player> BannedList;
	
	private static Player p;
	
	public void addPlayerToTempBannedList(Player player, int duration) {
		
		p = player;
		int d = duration * 3600000;
		
		BanList.getTempBannedPlayerList().add(player);
		
		new Timer().schedule(new TimerTask() {          
		    @Override
		    public void run() {
		    		BanList.getTempBannedPlayerList().remove(p);
		    }
		}, d);
		
	}
	
	
	public static PriorityQueue<Player> getTempBannedPlayerList() {
		return tempBannedList;
	}
	
	public static List<Player> getBannedList() {
		return BannedList;
	}
	
	public static void setTempBannedList(PriorityQueue<Player> tempBannedList) {
		BanList.tempBannedList = tempBannedList;
	}
	
	public static void setBannedList(List<Player> BannedList) {
		BanList.BannedList = BannedList;
	}
	
}
