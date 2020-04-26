package yp.cqc.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
	ServletContext:不同用户使用相同数据
		特点：服务器创建，用户共享
		作用域：整个项目
		生命周期：服务器启动到关闭	
		
		使用：
			获取ServletContext对象
				//第一种方式
				ServletContext sc=this.getServletContext();
				//第二种方式
				ServletContext sc2=this.getServletConfig().getServletContext();
				//第三种方式
				ServletContext sc3=req.getSession().getServletContext();
			使用ServletContext完成数据共享
				//数据存储
				sc.setAttribute(String name, object value);
				//数据存储的获取
				sc.getAttribute(String name) //返回object类型
				
				注意：
					不同用户可以个给ServletContext进行数据存取
					获取的数据不存在返回null.
			获取项目中web.xml文件中的全局配置数据
					sc.getInitParameter(String name); //根据键的名字返回web.xml中全局配置的值（String）
				配置方式
					 <context-param>
					 <!-- 一组context-param只能配一组数据，有多组数据配多组context-param -->
					 <param-name>name</param-name>
					 <param-value>zhangsan</param-value>
					 </context-param>
				作用：将静态数据和动态代码进行解耦。
			获取项目WebRoot下的资源的绝对路径
				sc.getRealPath(String path); //获取的路径为项目的根目录,path参数为项目根目录中的路径
			
			获取项目根目录下的资源的流对象
				InputStream is=sc.getResourceAsStream("/doc/1.txt");
				注意：此种方式只能获取项目根目录下的资源流对象，class文件的流对象需要使用类加载器获取(不能拿class文件)
			
			
			
			
*/
public class ServletContextServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取ServletContext对象(1、3常用)
			//第一种方式
				ServletContext sc=this.getServletContext();
			//第二种方式
				ServletContext sc2=this.getServletConfig().getServletContext();
			//第三种方式
				ServletContext sc3=req.getSession().getServletContext();
				System.out.println(sc==sc2);
				System.out.println(sc==sc3);
			//使用ServletContext完成数据共享
				//数据存储
					sc.setAttribute("str", "ServletContext learnning");
			//获取web.xml的全局配置数据
					String str=sc.getInitParameter("name");
					System.out.println("全局配置参数："+str);
				
			//获取项目根目录资源下的绝对路径
					//String path="D:\\Myeclipse\\Tomcat\\apache-tomcat-9.0.29\\webapps\\sc\\doc\\1.txt";
					String path=sc.getRealPath("/doc/1.txt");
					System.out.println(path);
			
			//获取项目根目录下的资源的流对象
					InputStream is=sc.getResourceAsStream("/doc/1.txt");
					
	}
}
