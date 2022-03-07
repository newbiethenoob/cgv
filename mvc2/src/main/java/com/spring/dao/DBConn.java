package com.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	//Field
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@172.16.25.219:1521";
	String user = "hr";
	String pwd = "1234";
	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;	
	
	//Constructor
	public DBConn(){
		try{
			Class.forName(driver); //1.����̹� �ε�
			conn = DriverManager.getConnection(url,user,pwd); // 2. Connection ��ü ����
		}catch(Exception e){
			System.out.println("1~2 �ܰ� ���� �߻�~");
		}
	}
	
	public Statement getStatement(){
		try {
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println("Statement 3�ܰ� ���� �߻�~");
		}
		
		return stmt;
	}
	
	
	public PreparedStatement getPreparedStatement(String sql){
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			System.out.println("PreparedStatement 3�ܰ� ���� �߻�~");
		}
		
		return pstmt;
	}
		
	
	public void close(){
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		} catch (Exception e) {
			System.out.println("���� �� ���� �߻�~~");
		}		
	}

}
