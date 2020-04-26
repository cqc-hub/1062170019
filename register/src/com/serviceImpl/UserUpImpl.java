package com.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBConnection;
import com.service.UserUpdate;

public class UserUpImpl implements UserUpdate{
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    DBConnection dbConnection = new DBConnection();

    @Override
    public String UserUp(String sql) {
        conn = DBConnection.getConn();
        stmt = DBConnection.getStatement(conn);

        System.out.println("用户插入时的SQL：" + sql);  //调试程序添加的输出语句
        
        String str = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if(pstmt.executeUpdate()==1) {
                str = "用户注册成功！";
            } else {
                str = "用户注册失败！";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

}
