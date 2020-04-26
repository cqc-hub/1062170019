package yp.cqc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yp.cqc.dao.UserDao;
import yp.cqc.pojo.User;

public class UserDaoImpl implements UserDao{
	//�����û����������ѯ�û���Ϣ
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		// TODO Auto-generated method stub
		//����jdbc����
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
		//��������
			User u=null;
		
			try {
				//��������
				Class.forName("com.mysql.jdbc.Driver");
				//��ȡ����
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
				//����sql����
				String sql="select* from table_user where uname=? and pwd=?";
				//����sql�������
				ps=conn.prepareStatement(sql);
				//��ռλ����ֵ
				ps.setString(1, uname);
				ps.setString(2, pwd);
				//ִ��sql
				rs=ps.executeQuery();
				//�������
				while(rs.next()){
					//��������ֵ
					u=new User();
					u.setUid(rs.getInt("uid"));
					u.setUname(rs.getString("uname"));
					u.setPwd(rs.getString("pwd"));
					u.setSex(rs.getString("sex"));
					u.setAge(rs.getInt("age"));
					u.setBirth(rs.getString("birth"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//�ر���Դ
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
		
		
		
		//���ؽ��
		return u;
	}
	//�޸�����
	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		// TODO Auto-generated method stub
				//����jdbc����
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				//��������
				int index=-1;
				
				try {
					//�������� 
					Class.forName("com.mysql.jdbc.Driver");
					//��ȡ����
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
					//����sql���
					String sql="update table_user set pwd=? where uid=?";
					//����sql�������
					ps=conn.prepareStatement(sql);
					//��ռλ����ֵ
					ps.setString(1, newPwd);
					ps.setInt(2, uid);
					//ִ��
					index=ps.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					//�ر���Դ
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
				
				//���ؽ��
				
				return index;
	}
	//��ȡ�����û���Ϣ
	@Override
	public List<User> checkUserShowDao() {
		// TODO Auto-generated method stub
				//����jdbc����
					Connection conn=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
				//��������
					List<User> lu=null;
				
					try {
						//��������
						Class.forName("com.mysql.jdbc.Driver");
						//��ȡ����
						conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
						//����sql����
						String sql="select* from table_user ";
						//����sql�������
						ps=conn.prepareStatement(sql);
						//�����ϸ�ֵ
						lu=new ArrayList<User>();
						
						//ִ��sql
						rs=ps.executeQuery();
						//�������
						while(rs.next()){
							//��������ֵ
							User u=new User();
							u.setUid(rs.getInt("uid"));
							u.setUname(rs.getString("uname"));
							u.setPwd(rs.getString("pwd"));
							u.setSex(rs.getString("sex"));
							u.setAge(rs.getInt("age"));
							u.setBirth(rs.getString("birth"));
							//������洢��������
							lu.add(u);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						//�ر���Դ
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
				
				
				
				//���ؽ��
				return lu;
	}
	//zhuce
	@Override
	public int checkUserRegnDao(User u) {
		// TODO Auto-generated method stub
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//��������
		int index=-1;
		
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			//����sql���
			String sql="insert into table_user values(default,?,?,?,?,?)";
			//����sql������� 
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());
			//ִ��
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر���Դ
		
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

		//���ؽ��
		
		
		return index;
	}

	

}
