package com.jshop.action.backstage.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {

	private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";

	protected final String url = "jdbc:mysql://localhost:3306/jshopactive";

	protected final String username = "root";

	protected final String password = "111111";

	protected Connection conn;

	protected Statement stmt;

	protected PreparedStatement prpdStmt;

	protected CallableStatement cablStmt;

	protected ResultSet rs;

	static {
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean openConn(boolean autoCommit) {
		boolean isOpen = true;
		try {
			conn = DriverManager.getConnection(url, username, password);
			if (!autoCommit)
				conn.setAutoCommit(false);
		} catch (SQLException e) {
			isOpen = false;
			e.printStackTrace();
		}
		return isOpen;
	}

	public boolean closeConn() {
		boolean isCommit = true;
		try {
			conn.commit();
		} catch (SQLException e) {
			isCommit = false;
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isCommit;
	}

}
