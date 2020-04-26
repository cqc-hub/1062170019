package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	//构造函数
	public DBConnection() { } 
	public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=XSCJ"; 
			String user = "sa"; 
			String password = "hy1234";     
			conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
        	 System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return conn;
    }

    public static PreparedStatement prepare(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public static PreparedStatement prepare(Connection conn, String sql,
            int autoGenereatedKeys) {
        PreparedStatement pstmt = null;
        try {
            if (conn != null) {
                pstmt = conn.prepareStatement(sql, autoGenereatedKeys);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public static Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            if (conn != null) {
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public static ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return rs;
    }

    public static void executeUpdate(Statement stmt, String sql) {
        try {
            if (stmt != null) {
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
