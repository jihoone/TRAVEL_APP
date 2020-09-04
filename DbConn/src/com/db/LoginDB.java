package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {
	private static LoginDB instance = new LoginDB();
	
	public static LoginDB getInstance() {
		return instance;
	}
	
	public LoginDB() {}
	
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
	
	public String connectionDB(String id, String pw) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
			
			sql = "SELECT * FROM userTBL WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				returns = "아이디를 다시 확인해주세요.";
			}else {
				String tmp_pw = rs.getString("PW");
				if(pw.equals(tmp_pw)) {
					returns = "SUCCESS";
				}else {
					returns = "비밀번호를 다시 확인해주세요.";
				}
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
