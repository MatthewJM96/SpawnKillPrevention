package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bukkit.Bukkit;

public class TimeParser {
	
	private static String CurDate;
	private int CurSeconds;
	private int CurMinutes;
	private int CurHours;
	private int CurDay;
	private int CurMonth;
	private int CurYear;
	private int AnySeconds;
	private int AnyMinutes;
	private int AnyHours;
	private int AnyDay;
	private int AnyMonth;
	private int AnyYear;
	
	Calendar currentCal = GregorianCalendar.getInstance();
	static Date currentDate = new Date();
	
	public static String getSystDate() {
		
		CurDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(currentDate);
		return CurDate;
		
	}
	
	public int getSystTimeSeconds() {
		
		CurSeconds = currentCal.get(Calendar.SECOND);
		return CurSeconds;
		
	}
	
	public int getSystTimeMinutes() {
		
		CurMinutes = currentCal.get(Calendar.MINUTE);
		return CurMinutes;
		
	}

	public int getSystTimeHours() {
	
		CurHours = currentCal.get(Calendar.HOUR_OF_DAY);
		return CurHours;
	
	}

	public int getSystTimeDay() {
	
		CurDay = currentCal.get(Calendar.DAY_OF_MONTH);
		return CurDay;
	
	}

	public int getSystTimeMonth() {
	
		CurMonth = currentCal.get(Calendar.MONTH);
		return CurMonth;
	
	}

	public int getSystTimeYear() {
	
		CurYear = currentCal.get(Calendar.YEAR);
		return CurYear;
	
	}
	
	
	
	Calendar anyCalendar = GregorianCalendar.getInstance();
	
	public void ThisTimeSeconds(String string) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			Bukkit.getLogger().info("Error while getting the second!");
			e.printStackTrace();
		}
		anyCalendar.setTime(date);
		if (!(date == null)) {
			AnySeconds = anyCalendar.get(Calendar.SECOND);
		} else {
			AnySeconds = -1;
		}
		
	}

	public void ThisTimeMinutes(String string) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			Bukkit.getLogger().info("Error while getting the minute!");
			e.printStackTrace();
		}
		anyCalendar.setTime(date);
		if (!(date == null)) {
			AnyMinutes = anyCalendar.get(Calendar.MINUTE);
		} else {
			AnyMinutes = -1;
		}
		
	}

	public void ThisTimeHours(String string) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			Bukkit.getLogger().info("Error while getting the hour!");
			e.printStackTrace();
		}
		anyCalendar.setTime(date);
		if (!(date == null)) {
			AnyHours = anyCalendar.get(Calendar.HOUR_OF_DAY);
		} else {
			AnyHours = -1;
		}
		
	}

	public void ThisTimeDay(String string) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			Bukkit.getLogger().info("Error while getting the day!");
			e.printStackTrace();
		}
		anyCalendar.setTime(date);
		if (!(date == null)) {
			AnyDay = anyCalendar.get(Calendar.DAY_OF_MONTH);
		} else {
			AnyDay = -1;
		}
		
	}

	public void ThisTimeMonth(String string) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			Bukkit.getLogger().info("Error while getting the month!");
			e.printStackTrace();
		}
		anyCalendar.setTime(date);
		if (!(date == null)) {
			AnyMonth = anyCalendar.get(Calendar.MONTH);
		} else {
			AnyMonth = -1;
		}
		
	}

	public void ThisTimeYear(String string) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			Bukkit.getLogger().info("Error while getting the year!");
			e.printStackTrace();
		}
		anyCalendar.setTime(date);
		if (!(date == null)) {
			AnyYear = anyCalendar.get(Calendar.YEAR);
		} else {
			AnyYear = -1;
		}
		
	}
	
	public int getThisTimeSeconds(String string) {
		
		ThisTimeSeconds(string);
		return AnySeconds;
		
	}

	public int getThisTimeMinutes(String string) {
		
		ThisTimeMinutes(string);
		return AnyMinutes;
		
	}

	public int getThisTimeHours(String string) {
		
		ThisTimeHours(string);
		return AnyHours;
		
	}

	public int getThisTimeDay(String string) {
		
		ThisTimeDay(string);
		return AnyDay;
		
	}

	public int getThisTimeMonth(String string) {
		
		ThisTimeMonth(string);
		return AnyMonth;
		
	}

	public int getThisTimeYear(String string) {
		
		ThisTimeYear(string);
		return AnyYear;
		
	}
	
	public static String updateTime(int Int, String string) {
		
		String newDate;
				
		Calendar calendarDate = GregorianCalendar.getInstance();
		calendarDate.setLenient(true);
		
		if (string.equalsIgnoreCase("seconds")) {
			
			calendarDate.add(Calendar.SECOND, Int);
			
		} else if (string.equalsIgnoreCase("minutes")) {
			
			calendarDate.add(Calendar.MINUTE, Int);
			
		} else if (string.equalsIgnoreCase("hours")) {
			
			calendarDate.add(Calendar.HOUR_OF_DAY, Int);
			
		} else if (string.equalsIgnoreCase("days")) {
			
			calendarDate.add(Calendar.DAY_OF_MONTH, Int);
			
		} else if (string.equalsIgnoreCase("months")) {
			
			calendarDate.add(Calendar.MONTH, Int);
			
		} else if (string.equalsIgnoreCase("years")) {
			
			calendarDate.add(Calendar.YEAR, Int);
			
		} 
		
		Date calDate = new Date();
		calDate = calendarDate.getTime();
		newDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(calDate);
		return newDate;
		
	}
	
	public static boolean compareTimeToCurrent(String string) {
		
		Calendar calendarDate = GregorianCalendar.getInstance();
		Calendar givenDate = GregorianCalendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			Bukkit.getLogger().info("Error while getting the year!");
			e.printStackTrace();
		}
		givenDate.setTime(date);
		
		if (givenDate.compareTo(calendarDate) > 0) {
			
			return true;
			
		} else {
		
		return false;
		
		}
	}
	
}
