package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*Cookie
 * 	作用：解决了发送的不同请求的数据共享问题
 * 	使用：
 * 	 //cookie的创建和存储
 * 		//创建cookie对象
		Cookie c=new Cookie(String name,String value);
		//设置cookie（可选）
		 * 	//设置有效期
		 * 	c.setMaxAge(3*24*60*60);//秒为单位的int值
		 * 	//设置有效路径
		 * 	c.setPath("/cookie/gc");
		//响应cookie信息
		resp.addCookie(c);
		
	//cookie的获取	
		//获取cookie数组
		 * 	Cookie[] cks=req.getCookies();
		//遍历数组获取cookie信息
		 * if(cks!=null){
		 * 	for(Cookie c:cks){
		 * 		String name=c.getName();
		 * 		String value=c.getValue();
		 * 		System.out.println(name+":"+value);
		 * 		}
		 *	 }
	注意：一个cookie存储一条数据，多条数据可以多创建几个cookie
 * 	特点：
 * 		浏览器端的数据存储技术
 * 		存储的数据声明在服务器端
 * 		临时存储：存在浏览器的运行内存里，关闭浏览器失效
 * 		定时存储：设置了cookie的有效期，存储在客户端的硬盘中，在有效期内符合路径要求的请求都会附带该信息
 * 		默认cookie信息存储好之后，项目每次请求都会附带，除非设置有效路径
 * 
 * 
*/
public class CookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			
		//处理请求信息
		//响应请求信息
			//使用cookie进行浏览器端的数据存储
				//创建cookie对象
				Cookie c=new Cookie("mouse","thinkpad");
				Cookie c2=new Cookie("yp","1160202");
			
				//设置cookie
					//设置cookie有效期
					c2.setMaxAge(3*24*60*60);//秒为单位的int值
					//设置有效路径
					c2.setPath("/cookie/gc");
				//响应cookie信息
				resp.addCookie(c);
				resp.addCookie(c2);
			//直接响应
			resp.getWriter().write("Cookie~~~~");
			//请求转发
			//重定向
	}
}
