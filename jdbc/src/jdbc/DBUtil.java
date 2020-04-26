package jdbc;
//第2步(封装)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*连接数据库的工具类*/
public class DBUtil {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/*当类被加载时执行，在该代码里读取properties*/
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
