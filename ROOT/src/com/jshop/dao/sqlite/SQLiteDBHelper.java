package com.jshop.dao.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class SQLiteDBHelper {
	

	public static final String DRIVERCLASS="org.sqlite.JDBC";
	
	public static final String FILENAME="c:/jshopmactive.db";
	protected Connection conn;
	
	static{
		try{
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void openSQLiteConn(){
		
		try{
			conn=DriverManager.getConnection("jdbc:sqlite:"+FILENAME);		
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
	
	public void closeSQLConn(){
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
