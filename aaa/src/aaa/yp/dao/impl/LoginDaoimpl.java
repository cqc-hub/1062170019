package aaa.yp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aaa.yp.dao.LoginDao;
import aaa.yp.pojo.User;

public class LoginDaoimpl implements  LoginDao{
	@Override
	public User checkLoginDao(String uname,String pwd){
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null; //结果集对象
		//声明数据存储对象
		User u=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			//创建sql命令
			String sql="select * from t_user where uname=? and pwd=?";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,uname);
			ps.setString(2,pwd);
			//执行sql
			rs=ps.executeQuery();
			//遍历执行结果
			while(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		//返回
		return u;
	}
}
