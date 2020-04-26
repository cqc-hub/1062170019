package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yp.cqc.Service.MyService;
import yp.cqc.Service.impl.ServiceImpl;
import yp.cqc.pojo.User;

public class MyServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println(uname+"------"+pwd);
		
		
		MyService ms=new ServiceImpl();
		User u=ms.checkLoginService(uname, pwd);
		System.out.println(u);
		
		if(u!=null){
			resp.sendRedirect("index.jsp");
		}
	}
}
