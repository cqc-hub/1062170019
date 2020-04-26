package com.web;

import java.sql.*;

public class DataBaseBean {

	public DataBaseBean() {

	}

	public ResultSet search(String sql) {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=XSCJ";

		Connection dbConn;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, "sa", "hy1234");
			stmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return rs;
	}

	public Connection con() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=XSCJ";

		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, "sa", "hy1234");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return dbConn;
	}

	public int update(String sql) {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=XSCJ";

		Connection dbConn;
		Statement stmt = null;

		int count = 0;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, "sa", "hy1234");
			stmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// test
			if (stmt.executeUpdate(sql) == 1)
				count = 1;
			else
				count = 0;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return count;
	}

	public int insert(String username, String pass) {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=XSCJ";

		Connection dbConn;
		Statement stmt = null;

		int count = 0;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, "sa", "hy1234");
			stmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			// test
			if (stmt.executeUpdate("insert into zddl values('" + username
					+ "','" +pass + "', '30')") == 1)
				count = 1;
			else
				count = 0;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return count;
	}
	public int insert_1(String sql)
	{String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=XSCJ";

	Connection dbConn;
	Statement stmt = null;

	int count = 0;
	try {
		Class.forName(driverName);
		dbConn = DriverManager.getConnection(dbURL, "sa", "hy1234");
		stmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// test
		if (stmt.executeUpdate(sql) == 1)
			count = 1;
		else
			count = 0;

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	return count;
		
	}
}
