package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceImpl.UserUpImpl;
import com.entity.User;

public class register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public register() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
        //获取传过来的表单数据,根据表单中的name获取所填写的值
		User u = new User();
		String username1,username2,password,xz,email,tel;
		int age;
		Date birthday;
	  //String[] favorites;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			username1 = request.getParameter("real_name");
			username2 = request.getParameter("user_name");
			password = request.getParameter("password");
			xz = request.getParameter("xz");
			email = request.getParameter("email");
			age =Integer.parseInt(request.getParameter("real_lage").trim());
			tel =request.getParameter("telphone");
			birthday =sdf.parse(request.getParameter("birthday"));
			
			java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());
			
			//用来获取多个复选按钮的值
     	  //favorites = request.getParameterValues("favorite");
			
			u.setReal_name(username1);
			u.setUser_name(username2);
			u.setPassword(password);
			u.setXz(xz);
			u.setEmail(email);
			u.setBirthday(birthday);
			u.setReal_lage(age);
			u.setTelphone(tel);
		  //u.setFavorites(favorites);
			
			/*
			 * 开始调用service层的方法，并通过返回值进行判断是否注册成功
			 */
			UserUpImpl service = new UserUpImpl();
			String sql = "INSERT INTO User2(real_name,user_name,password,xz,real_lage,birthday,email,telphone) VALUES('"+username1+"','"+username2+"','"+password+"','"+xz+"',"+age+",'"+sqlDate+"','"+email+"','"+tel+"')";
			String isSuccess = service.UserUp(sql);
			request.setAttribute("msg", isSuccess);
			//跳转到userinfo页面
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
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
