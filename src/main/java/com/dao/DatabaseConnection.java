package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String url = "jdbc:mysql://localhost:3306/scanner";
	private static final String username = "root";
	private static final String password = "root";
	
	public Connection getConnection() throws SQLException {
		Connection con =  DriverManager.getConnection(url,username,password);
		return con;
	}

}
