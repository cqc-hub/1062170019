package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class UserDao {
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet res = null;

	//根据用户名和密码来查询用户信息
	public User getUser(String account, String pwd) {

		User user = new User();
		try {
		   DataBaseBean db =new DataBaseBean();
		   String sql="select * from zddl where username='"+account+"' and pass='"+pwd+"'";

		 //防止注入式攻击		   
/*		   String sql1="select * from zddl where username=? and pass=?";
		   conn=db.con();
		   pre = conn.prepareStatement(sql1);
		   pre.setString(1,account);
		   pre.setString(2,pwd);
		   res=pre.executeQuery();   
*/
		   res=db.search(sql);
		 	 
		   while (res.next()) {
			 
			 JOptionPane.showMessageDialog(null, "程序正常1", "标题【调试】", JOptionPane.ERROR_MESSAGE);
			 
				user.setUsername(res.getString("username"));
				user.setPass(res.getString("pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();		 
		}
    	return user;
	}

}

