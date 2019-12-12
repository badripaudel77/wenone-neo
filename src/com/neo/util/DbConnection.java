package com.neo.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getDbConnection()  throws SQLException,ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest","root", "");
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch(Exception e) {
			
			e.getMessage();
		}
		
		return con ;//returning Connection so that we can use Database using this method anywhere in this project.
		
	}
	
}
