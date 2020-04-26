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

	
	 //单元测试，不需要main方法，使用单元测试可以直接运行
	@Test  //手打的(鼠标点击add....)
	public void Test1(){
		Connection conn=null;
	
		try {
			//连接数据库
			 //1 注册驱动(加载jar包)
			Class.forName("com.mysql.jdbc.Driver");
			//2 创建连接
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
			//3 创建statement对象（该对象可以发送要执行的sql语句）
			Statement stm=conn.createStatement();
			 String sql="INSERT INTO student(uname,pwd,sex,age,birth) VALUES('小M','456',16,'3/25')";
			 stm.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//无论代码是否出错 都要关闭流
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
			conn.setAutoCommit(false);//设置手动提交事务
			Statement sta=conn.createStatement();
			String sql="update student set name='手打',gender='男',age=56 where student_id=3";//sql不能有分号
			String sql1="update student set name='老王',gender='男',age=56 where student_id=10";
			
			try {
				int rows = sta.executeUpdate(sql);
				int rows1=sta.executeUpdate(sql1);
				System.out.println(rows+"....."+rows1);
				conn.commit();  //执行
			} catch (Exception e) {
				// TODO Auto-generated catch block
				conn.rollback();//上面sql语句只要某一条有错误，数据回滚
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
	
	/*	 如何使用properties读取db.properties*/
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
			//第3步 应用
			conn=DBUtil.getConnection();
			System.out.println(conn);
			Statement stm=conn.createStatement();
			String sql="update student set name='老王',gender='男',age=56 where student_id=3";//sql不能有分号
			int rows=stm.executeUpdate(sql);//4  执行
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
				ResultSet rs= stm.executeQuery(sql);//有个指标，默认指向首行之上，next（）时,指标指向下一条
				
				while(rs.next()){
					System.out.print(rs.getInt("student_id")+" ");//re.get类型(列名)
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
