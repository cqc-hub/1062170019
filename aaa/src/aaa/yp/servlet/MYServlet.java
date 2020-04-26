package aaa.yp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aaa.yp.pojo.User;
import aaa.yp.service.LoginService;
import aaa.yp.service.impl.LoginServiceimpl;







public class MYServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		String[] hobits=req.getParameterValues("hobit");
		for(String hobit:hobits){
			System.out.print(hobit+" ");
	}
		System.out.println();
		
		//获取业务层对象
		LoginService ls=new LoginServiceimpl();
		User u=ls.checkLoginService(uname, pwd);
		System.out.println(u);
		//响应处理结果
		if(u!=null){
			resp.getWriter().write("登陆成功");
		}else{
			resp.getWriter().write("登陆失败");
		}
		
	}
	
}
