package jdbc;
//��2��(��װ)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*�������ݿ�Ĺ�����*/
public class DBUtil {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/*���౻����ʱִ�У��ڸô������ȡproperties*/
	static{

		try {
			Properties p=new Properties();
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver=p.getProperty("driver");
			url=p.getProperty("url");
			username=p.getProperty("username");
			password=p.getProperty("password");

			Class.forName(driver); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static Connection getConnection()throws Exception{
		return DriverManager.getConnection(url,username,password);
	}
	
	public static void close(Connection conn){
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
