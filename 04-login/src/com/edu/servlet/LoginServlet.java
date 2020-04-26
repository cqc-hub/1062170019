package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.pojo.User;
import com.edu.service.LoginService;
import com.edu.service.impl.LoginServiceImpl;
/*
	ServletContext对象完成网页计数器
		在用户登录校验中创建计数器并自增，然后存储到ServletContext对象中
		在主页面去除计数器显示给用户


*/
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//设置相应编码格式
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			String uname=req.getParameter("uname");
			//uname=new String(uname.getBytes("iso8859-1"),"utf-8");//转编码格式,看tomat版本，9默认utf-8
			String pwd=req.getParameter("pwd");
			System.out.println(uname+":"+pwd);
		//处理请求信息
			//获取业务层对象
			LoginService ls=new LoginServiceImpl();
			User u=ls.checkLoginService(uname, pwd);
			System.out.println(u);
		//响应处理结果
			if(u!=null){
				//创建cookie信息实现三天免登录
				Cookie c=new Cookie("uid",u.getUid()+"");
				//设置cookie有效期
				c.setMaxAge(3*24*60*60);
				c.setPath("/04-login/ck");
				resp.addCookie(c);
				//创建session
				HttpSession hs=req.getSession();
				//存储数据到session
				hs.setAttribute("user", u);
				
				//创建网页计数器
					//获取计数数据
					ServletContext sc=this.getServletConfig().getServletContext();
					if(sc.getAttribute("nums")!=null){
					int nums=Integer.parseInt((String) sc.getAttribute("nums"));
					nums+=1;
					//重新存储到ServletContext中
					sc.setAttribute("nums", nums);
					}else{
						sc.setAttribute("nums", 1);
					}
				//重定向
				resp.sendRedirect("main");
				return;
			}else{
				//resp.getWriter().write("登陆失败");
	
				//使用request对象实现不同servlet的数据流转
				req.setAttribute("str", "用户名或密码出错");
				//使用请求转发
				req.getRequestDispatcher("page").forward(req, resp);
				return;
				
			}
	}
}
