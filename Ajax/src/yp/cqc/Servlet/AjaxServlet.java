package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ajax")

public class AjaxServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置响应、请求编码格式  //这里没有请求所以不用设置
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		/*try {
			Thread.sleep(1000);
			//获取请求信息
			//处理请求信息
			//响应结果
			resp.getWriter().write("今天的雾霾真的新鲜，999");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//获取请求信息
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		System.out.println(name+":"+pwd+":"+req.getMethod());
		//处理请求信息
		//响应结果
		resp.getWriter().write("今天的雾霾真的新鲜，999");
	
	}
}
