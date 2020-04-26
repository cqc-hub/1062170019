package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	@Override //复写service方法(手打service alt+"/")
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 resp.getWriter().write("this is my first servlet"); //把里面的string对象打印到浏览器面板上（可以把html代码一句句写进去）
	 System.out.println("This is my first servlet");
		
	}
	
	public void Demo(HttpServlet hs){
		
		
	}

}
