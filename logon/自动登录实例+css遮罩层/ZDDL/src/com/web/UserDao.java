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

	//�����û�������������ѯ�û���Ϣ
	public User getUser(String account, String pwd) {

		User user = new User();
		try {
		   DataBaseBean db =new DataBaseBean();
		   String sql="select * from zddl where username='"+account+"' and pass='"+pwd+"'";

		 //��ֹע��ʽ����		   
/*		   String sql1="select * from zddl where username=? and pass=?";
		   conn=db.con();
		   pre = conn.prepareStatement(sql1);
		   pre.setString(1,account);
		   pre.setString(2,pwd);
		   res=pre.executeQuery();   
*/
		   res=db.search(sql);
		 	 
		   while (res.next()) {
			 
			 JOptionPane.showMessageDialog(null, "��������1", "���⡾���ԡ�", JOptionPane.ERROR_MESSAGE);
			 
				user.setUsername(res.getString("username"));
				user.setPass(res.getString("pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();		 
		}
    	return user;
	}

}

