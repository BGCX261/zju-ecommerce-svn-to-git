package com.ecommerce.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnector {
	private DataSource ds;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public DatabaseConnector(){
		try {
			Context context=new InitialContext();
			Context envContext=(Context)context.lookup("java:/comp/env");
			ds=(DataSource)envContext.lookup("jdbc/ecommerce");
	
			try {
				conn=ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error in getConnection()");
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("error in initialContext");
		}
		
	}
	public PreparedStatement getPreparedStatement(String sql){
		try {
			pstmt=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	
	public void close(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error in close()");
			}
		}
	}
}