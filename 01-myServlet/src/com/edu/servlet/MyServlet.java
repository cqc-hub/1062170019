package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	@Override //��дservice����(�ִ�service alt+"/")
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 resp.getWriter().write("this is my first servlet"); //�������string�����ӡ�����������ϣ����԰�html����һ���д��ȥ��
	 System.out.println("This is my first servlet");
		
	}
	
	public void Demo(HttpServlet hs){
		
		
	}

}
