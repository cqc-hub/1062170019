package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import yp.cqc.Service.LoginService;
import yp.cqc.Service.impl.LoginServiceImpl;
import yp.cqc.pojo.User;

public class MyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println(uname+"~~~~`"+pwd);
		//获取业务层对象
		LoginService ls=new LoginServiceImpl();
		User u=ls.checkLoginService(uname, pwd);
		System.out.println(u);
		
		if(u!=null){
			resp.sendRedirect("index.jsp");
			
		}else{
			resp.getWriter().write("登陆失败");
		}
			
	}
}
