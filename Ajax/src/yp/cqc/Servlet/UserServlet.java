package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import yp.cqc.service.UserService;
import yp.cqc.serviceimpl.UserServiceImpl;
import yp.cqc.vo.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求/响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//resp.setContentType("text/xml;charset=utf-8");
		//获取请求信息
		String name=req.getParameter("name");
		System.out.println("用户请求信息："+name);
		//处理请求信息
			//获取业务层对象
			UserService us=new UserServiceImpl();
			User u=us.getUserInfoService(name);
			System.out.println("查询结果为："+u);
		//响应处理结果
			resp.getWriter().write(new Gson().toJson(u));
			//Gson资源包自己导入 toJson功能：把对象变成字符串(json格式)
			
			
			//XML数据
			//resp.getWriter().write("<user><uid>1</uid><name>张三</name><price>11.2</price></user>");
			
	}
}
