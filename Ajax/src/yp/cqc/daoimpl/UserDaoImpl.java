package yp.cqc.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import yp.cqc.dao.UserDao;
import yp.cqc.vo.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUserInfo(String name) {
		// TODO Auto-generated method stub
		User u=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			
			String sql="select *from user1 where uname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPrice(rs.getDouble("price"));
				u.setLoc(rs.getString("loc"));
				u.setDesc(rs.getString("des"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
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
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return u;
	}

}
