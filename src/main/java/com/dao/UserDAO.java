package com.dao;

public class UserDAO {
	public static final String url = "jdbc:mysql://localhost:3306/scan_schema";
	public static final String username = "root";
	public static final String password = "root";
	
	public static String SELECT_BY_ID = "SELECT * FROM users WHERE ID=?";
	public static String DELETE_BY_ID = "DELETE * FROM users WHERE ID=?";
	public static String INSERT = "INSERT INTO users VALUES (?, ?, ?, ?)";
	
	

}
