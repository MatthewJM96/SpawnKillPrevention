package com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.github.SamThePsychoticLeprechaun.SpawnKillPrevention.SpawnKillPrevention;

public class ExcecuteQuery {
	
	public static SpawnKillPrevention plugin = SpawnKillPrevention.plugin;
	
	public static void createTable(String query){
		  Connection conn;
		  String username = SpawnKillPrevention.User;
		  String password = SpawnKillPrevention.Password;
		  String databaseHost = SpawnKillPrevention.Server;
		  String databaseName = SpawnKillPrevention.Database;
		  int port = SpawnKillPrevention.Port;
		  String url = "jdbc:mysql://" + databaseHost + ":" + port + "/" + databaseName;
		 
		  //Attempt to connect
		  try{
		    //Connection succeeded
		    conn = DriverManager.getConnection(url, username, password);
		    PreparedStatement statement = conn.prepareStatement(query);
		    statement.executeQuery();
		    try{
		    	statement.close();
		    	conn.close();
		    } catch (Exception ex){
		    	plugin.getLogger().info("Could not close connection to the database!");
		    }
		  } catch(Exception e){
		    plugin.getLogger().info("Could not connect to the database!");
		  }
		  
	}
	
	public static String getString(String query, int Int) {
		  Connection conn;
		  String username = SpawnKillPrevention.User;
		  String password = SpawnKillPrevention.Password;
		  String databaseHost = SpawnKillPrevention.Server;
		  String databaseName = SpawnKillPrevention.Database;
		  int port = SpawnKillPrevention.Port;
		  
		  String string = "null";
		  
		  String url = "jdbc:mysql://" + databaseHost + ":" + port + "/" + databaseName;
		 
		  //Attempt to connect
		  try{
		    //Connection succeeded
		    conn = DriverManager.getConnection(url, username, password);
		    PreparedStatement statement = conn.prepareStatement(query);
		    statement.executeQuery();
		    string = statement.getResultSet().getString(Int);
		    try{
		    	statement.close();
		    	conn.close();
		    } catch (Exception ex){
		    	plugin.getLogger().info("Could not close connection to the database!");
		    }
		  } catch(Exception e){
		    plugin.getLogger().info("Could not connect to the database!");
		  }
		  return string;
		
	}
	
	public static void setString(String query) {
		  Connection conn;
		  String username = SpawnKillPrevention.User;
		  String password = SpawnKillPrevention.Password;
		  String databaseHost = SpawnKillPrevention.Server;
		  String databaseName = SpawnKillPrevention.Database;
		  int port = SpawnKillPrevention.Port;
		  
		  String url = "jdbc:mysql://" + databaseHost + ":" + port + "/" + databaseName;
		 
		  //Attempt to connect
		  try{
		    //Connection succeeded
		    conn = DriverManager.getConnection(url, username, password);
		    PreparedStatement statement = conn.prepareStatement(query);
		    statement.executeQuery();
		    try{
		    	statement.close();
		    	conn.close();
		    } catch (Exception ex){
		    	plugin.getLogger().info("Could not close connection to the database!");
		    }
		  } catch(Exception e){
		    plugin.getLogger().info("Could not connect to the database!");
		  }
		
	}
	
	public static String checkPlayerProtection(String string) {
		
		Connection conn;
		  String username = SpawnKillPrevention.User;
		  String password = SpawnKillPrevention.Password;
		  String databaseHost = SpawnKillPrevention.Server;
		  String databaseName = SpawnKillPrevention.Database;
		  int port = SpawnKillPrevention.Port;
		  
		  String url = "jdbc:mysql://" + databaseHost + ":" + port + "/" + databaseName;
		 
		  String query = "SELECT playerName, timeToEnd FROM Protected WHERE playerName '" + string + "'";
		  
		  String result = TimeParser.getSystDate();
		  //Attempt to connect
		  try{
		    //Connection succeeded
		    conn = DriverManager.getConnection(url, username, password);
		    PreparedStatement statement = conn.prepareStatement(query);
		    statement.executeQuery();
		    result = statement.getResultSet().getString(1);
		    try{
		    	statement.close();
		    	conn.close();
		    } catch (Exception ex){
		    	plugin.getLogger().info("Could not close connection to the database!");
		    }
		  } catch(Exception e){
		    plugin.getLogger().info("Could not connect to the database!");
		  }
		  return result;
		
	}
	
}
