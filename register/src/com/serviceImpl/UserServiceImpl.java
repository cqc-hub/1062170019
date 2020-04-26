package com.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBConnection;
import com.service.UserService;

public class UserServiceImpl implements UserService{
	    private Connection conn = null;
	    private Statement stmt = null;
	    private PreparedStatement pstmt = null;
	    DBConnection dbConnection = new DBConnection();

	    @Override
	    public String checkUserName(String username) {
	        conn = DBConnection.getConn();
	        stmt = DBConnection.getStatement(conn);
	        String sql = "select * from User2 where user_name=" + "'" + username + "'";
	        
	        System.out.println("用户查询时的SQL：" + sql);    //调试程序添加的输出语句
	        
	        String str = null;
	        try {
	            pstmt = conn.prepareStatement(sql);
	            if (pstmt.executeQuery().next() == true) {
	                str = "用户名已存在！";
	            } else {
	                str = "用户名可用！";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return str;
	    }
}
