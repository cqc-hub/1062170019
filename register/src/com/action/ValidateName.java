package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serviceImpl.UserServiceImpl;

public class ValidateName extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ValidateName() {
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

		response.setContentType("text/html");
		UserServiceImpl dao = new UserServiceImpl();  
		String loginName=request.getParameter("username").toString();  
		String str = dao.checkUserName(loginName);  
		if(str.equals("用户名已存在！"))  
		{  
			response.getWriter().write("true");//此值jquery可以接收到    
		}  
	}  
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  
		this.doGet(request, response);   
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
