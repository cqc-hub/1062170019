package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * session:一个用户的不同请求处理的数据共享(session存储在服务器，JSESSIONID存储在浏览器)
 * 		使用时机：一般用户在登陆web项目时会将用户的个人数据存储在session中，给改用户的其他请求使用
 * 		原理：
 * 			用户第一次访问服务器，服务器会创建一个session对象给此用户，并将该session对象的
 *          JSESESSIONID使用Cookie技术存储到浏览器中，保证用户的其他请求能够获取到同一个
 *          session对象，也保证了不同请求能获取到共享的数据。
 *          
 * 		特点：
 * 			存储在服务器端
 * 			服务器进行创建
 * 			依赖cookie技术
 * 			一次会话（不关浏览器）
 * 			默认存储时间是30分钟
 * 		使用：
 * 			创建session对象/获取session对象
	 * 				HttpSession hs=req.getSession();
	 * 				如果请求中有session的标识符也就是JSESSIONID,则返回其对应的session对象
	 * 				如果请求中没有session的标识符，则创建新的session对象并将其JSESSIONID作为从cookie数据存储到浏览器中
	 * 				如果session对象失效，也会出现创建session对象并将其JSESSIONID作为从cookie数据存储到浏览器中
		 * 			注意：
		 * 				JSESSIONID存储在cookie的临时存储空间内，浏览器关闭失效
 * 			//设置session存储时间
 * 			hs.setMaxInactiveInterval(5);//默认存储时间是30分钟，在存在期间被使用会重新计时
 * 
 * 			//设置session强制失效
 * 				hs.invalidate();
 * 			
 * 			存储/获取数据从session对象
 * 				存储：hs.setAttribute(String name,object value);
 * 				获取：hs.getAttribute(String name) //返回object类型
 * 			
 * 		session失效处理：
 * 				将用户请求中的JSESSIONID与后台获取的	JSESSIONID进行对比，如果一致则session有效，else 失效 (重定向到登录页面重新登陆)
 * 				
 * 
*/
public class SessionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求数据
			String name="张三";
			
		//处理请求信息
			//创建session对象
			HttpSession hs=req.getSession(); //既是创建，也是获取(看请求里有没有sessionid)
			//设置session存储时间
				//hs.setMaxInactiveInterval(50);
			System.out.println(hs.getId());
			//设置session强制失效
				//hs.invalidate();
			//存储数据
				hs.setAttribute("name", name);
		//响应处理结果
			//直接响应
			resp.getWriter().write("session learnning");
			//请求转发
			//重定向
		
	}
	
}
