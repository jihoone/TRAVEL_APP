package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public ConnectDB() {}
	
	//oracle 계정
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	String userId = "hr";
	String userPw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	
	String sql = "";
	String sql2 = "";
	String returns = "a";
	
	public String connectionDB(String id, String pw, String name, String birth, String email, String hp) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
			
			sql = "SELECT ID FROM userTBL WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				returns = "이미 존재하는 아이디 입니다.";
			}else {
				sql2 = "INSERT INTO userTBL VALUES(?,?,?,?,?,?)";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, pw);
				pstmt2.setString(3, name);
				pstmt2.setString(4, birth);
				pstmt2.setString(5, email);
				pstmt2.setString(6, hp);
				pstmt2.executeUpdate();
				returns = "SUCCESS";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt2 != null)try {pstmt2.close();}catch(SQLException ex) {}
			if(pstmt != null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn != null)try {conn.close();}catch(SQLException ex) {}
		}
		return returns;
	}

}
