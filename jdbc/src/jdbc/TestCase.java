package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;



public class TestCase {

	
	 //��Ԫ���ԣ�����Ҫmain������ʹ�õ�Ԫ���Կ���ֱ������
	@Test  //�ִ��(�����add....)
	public void Test1(){
		Connection conn=null;
	
		try {
			//�������ݿ�
			 //1 ע������(����jar��)
			Class.forName("com.mysql.jdbc.Driver");
			//2 ��������
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
			//3 ����statement���󣨸ö�����Է���Ҫִ�е�sql��䣩
			Statement stm=conn.createStatement();
			 String sql="INSERT INTO student(uname,pwd,sex,age,birth) VALUES('СM','456',16,'3/25')";
			 stm.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//���۴����Ƿ���� ��Ҫ�ر���
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	@Test
	public void test2(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			conn.setAutoCommit(false);//�����ֶ��ύ����
			Statement sta=conn.createStatement();
			String sql="update student set name='�ִ�',gender='��',age=56 where student_id=3";//sql�����зֺ�
			String sql1="update student set name='����',gender='��',age=56 where student_id=10";
			
			try {
				int rows = sta.executeUpdate(sql);
				int rows1=sta.executeUpdate(sql1);
				System.out.println(rows+"....."+rows1);
				conn.commit();  //ִ��
			} catch (Exception e) {
				// TODO Auto-generated catch block
				conn.rollback();//����sql���ֻҪĳһ���д������ݻع�
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}



	}
	
	/*	 ���ʹ��properties��ȡdb.properties*/
	@Test
	public void test3(){
		Properties p=new Properties();
		try {
			p.load(TestCase.class.getClassLoader().getResourceAsStream("db.properties"));
			System.out.println(p.getProperty("driver"));
			System.out.println(p.getProperty("url"));
			System.out.println(p.getProperty("username"));
			System.out.println(p.getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test4(){
		Connection conn=null;
		try {
			//��3�� Ӧ��
			conn=DBUtil.getConnection();
			System.out.println(conn);
			Statement stm=conn.createStatement();
			String sql="update student set name='����',gender='��',age=56 where student_id=3";//sql�����зֺ�
			int rows=stm.executeUpdate(sql);//4  ִ��
			System.out.println(rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}

	}
	
	
	@Test
	public void test5(){
		
		Connection conn=null;
		
			try {
				conn=DBUtil.getConnection();
				Statement stm=conn.createStatement();
		
				String sql="select *from student";
				ResultSet rs= stm.executeQuery(sql);//�и�ָ�꣬Ĭ��ָ������֮�ϣ�next����ʱ,ָ��ָ����һ��
				
				while(rs.next()){
					System.out.print(rs.getInt("student_id")+" ");//re.get����(����)
					System.out.print(rs.getString("NAME")+" ");
					System.out.print(rs.getString("gender")+" ");
					System.out.print(rs.getString("age")+" ");
					System.out.println("");
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.close(conn);
			}

		
	}



}
