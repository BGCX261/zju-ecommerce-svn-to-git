package com.ecommerce.util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnector {
	private DataSource ds;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private static String username="root";
	private static String password="123";
	private static  String db_driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/ecommerce" ;
	
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
	
	/*public DatabaseConnector(){
		conn=this.getConnection();
	}
	
       
     
  
    public static Connection getConnection() {  
        Connection conn = null; 
        try {  
            try {
				Class.forName(db_driver).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
        try {  
            conn = DriverManager.getConnection(url, username, password);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return conn;  
  
    }  */
	/*private Connection getConnection() throws SQLException{   
		// class.   
		Connection conn = null;   
		try {   
			try {
				Class.forName(db_driver).newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			conn = DriverManager.getConnection(url);   
		}   
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} 
		catch (SQLException e) {  
            e.printStackTrace();  
        }  
		return conn;   
	}   */
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