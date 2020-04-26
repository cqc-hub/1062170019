package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.util.MD5Utils;

public class LoginServlet extends HttpServlet {
	
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取用户名、密码、自动登录标志
		String username = request.getParameter("name");
		String pass = request.getParameter("pass");    //MD5Utils.md5(request.getParameter("pass"));
		String regpwd = request.getParameter("regpwd");
		String autologin = request.getParameter("autologin");
		//2.调用UserDao中根据用户名密码查找用户的方法
		UserDao ud = new UserDao();
		User user = ud.getUser(username, pass);
		if(user.getUsername()==null){
			request.setAttribute("msg", "用户名密码不正确!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//3.保存用户登录信息
		request.getSession().setAttribute("user", user);
		
		//--处理记住密码
        if(regpwd!=null){
			Cookie passC = new Cookie("pass",URLEncoder.encode(user.getPass(),"utf-8"));
			passC.setPath("/");
			passC.setMaxAge(60*5);        //(3600*24*30);
			response.addCookie(passC);
		}else{
			Cookie passC = new Cookie("pass","");
			passC.setPath("/");
			passC.setMaxAge(0);
			response.addCookie(passC);
			request.setAttribute("msg", "用户没有选择记住密码!");
		}
		
		//--处理30天内自动登陆
		if(autologin!=null&&regpwd!=null){
			Cookie autologinC = new Cookie("autologin",URLEncoder.encode(user.getUsername()+":"+user.getPass(),"utf-8"));
			autologinC.setPath("/");
			autologinC.setMaxAge(60*5);         //(3600*24*30);
			response.addCookie(autologinC);
			JOptionPane.showMessageDialog(null, "程序正常2-信息已经写入Cookie中！", "标题【调试】", JOptionPane.ERROR_MESSAGE);
		}else{
			//删除cookie的方法，就建立一个同名cookie，然后设置cookie的setmaxage=0； 			
			Cookie autologinC=new Cookie("autologin", "");
			autologinC.setMaxAge(0); 
			autologinC.setPath("/");
			response.addCookie(autologinC); 
		}
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");   //转向主页
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
}

