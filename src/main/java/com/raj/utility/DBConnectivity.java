package com.raj.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity {

	
	
	

	private static final String URL = "jdbc:mysql://localhost:3306/food_delivery_application";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Raja@root";
	private static Connection connection=null;

	public static  Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
			
		
		
	}
}
