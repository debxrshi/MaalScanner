package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ScanDAO {
	
	private static String SELECT_BY_HASH = "SELECT * FROM scans WHERE SHA256=?";
	private static String INSERT_INTO_TABLE = "INSERT INTO scans VALUES (?,?,?)";
	private static String SELECT_JSON = "SELECT DATA FROM scans WHERE SHA256=?";
	private static String DELETE_BY_HASH = "DELETE * FROM scans WHERE SHA256=?";

	DatabaseConnection dbconnect = new DatabaseConnection();
	
	public  void  DbPost(String fileName, String hash, String json) throws SQLException, IOException {
		
		Connection con = dbconnect.getConnection();
		
		PreparedStatement psmt = con.prepareStatement(INSERT_INTO_TABLE);
		
		psmt.setString(1, fileName);
		psmt.setString(2, hash);
		psmt.setString(3, json);
		
		int rowsInserted = psmt.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Inserted!");
		}
		
	}

	public  boolean DbFetch(String hash) throws SQLException {
		Connection con = dbconnect.getConnection();
		PreparedStatement psmt = con.prepareStatement(SELECT_BY_HASH);
		psmt.setString(1, hash);
		System.out.println("Searching in DB for hash");
		ResultSet rs = psmt.executeQuery();
	    return rs.next();
		
	}
	
	public  String DbJsonFetch(String hash) throws SQLException {
		Connection con = dbconnect.getConnection();
		PreparedStatement psmt = con.prepareStatement(SELECT_JSON);
		psmt.setString(1, hash);
		System.out.println("Searching  JSON for hash");
		ResultSet rs = psmt.executeQuery();
		String data = null;
		if (rs.next()) {
	    data = rs.getString("DATA");
		}
		return data;
	}
	public void DbDelete(String hash) throws SQLException{
		Connection con = dbconnect.getConnection();
		PreparedStatement psmt = con.prepareStatement(DELETE_BY_HASH);
		psmt.setString(1, hash);
		psmt.executeQuery();
		System.out.println("Deleted Field with hash: "+hash);
	}
}