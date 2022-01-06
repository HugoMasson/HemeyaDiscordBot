package fr.kaze.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {
	
	static final String DB_URL = "jdbc:mysql://185.98.131.149:3306/hugoc1584666_2kwygn";
	static final String USER = "hugoc1584666";
	static final String PASS = "yA1@MbJYCTcP7KR";
	static final String QUERY = "SELECT id, userId, content, lastAccess FROM HemeyaBot";
	
	public static void connectionDB() {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(QUERY);) {
			System.out.println("zaeazeazeazea");
		    while (rs.next()) {
		            // Retrieve by column name
		    	System.out.print("ID: " + rs.getInt("id"));
		        //System.out.print(", Age: " + rs.getInt("age"));
		        //System.out.print(", First: " + rs.getString("first"));
		        //System.out.println(", Last: " + rs.getString("last"));
		    }
		 } catch (SQLException e) {
			 e.printStackTrace();
			 System.out.println("zaeazeazeazea");
		 } 
	}
	
}
