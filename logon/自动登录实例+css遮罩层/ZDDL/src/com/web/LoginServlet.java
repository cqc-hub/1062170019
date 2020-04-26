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
		//1.��ȡ�û��������롢�Զ���¼��־
		String username = request.getParameter("name");
		String pass = request.getParameter("pass");    //MD5Utils.md5(request.getParameter("pass"));
		String regpwd = request.getParameter("regpwd");
		String autologin = request.getParameter("autologin");
		//2.����UserDao�и����û�����������û��ķ���
		UserDao ud = new UserDao();
		User user = ud.getUser(username, pass);
		if(user.getUsername()==null){
			request.setAttribute("msg", "�û������벻��ȷ!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//3.�����û���¼��Ϣ
		request.getSession().setAttribute("user", user);
		
		//--�����ס����
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
			request.setAttribute("msg", "�û�û��ѡ���ס����!");
		}
		
		//--����30�����Զ���½
		if(autologin!=null&&regpwd!=null){
			Cookie autologinC = new Cookie("autologin",URLEncoder.encode(user.getUsername()+":"+user.getPass(),"utf-8"));
			autologinC.setPath("/");
			autologinC.setMaxAge(60*5);         //(3600*24*30);
			response.addCookie(autologinC);
			JOptionPane.showMessageDialog(null, "��������2-��Ϣ�Ѿ�д��Cookie�У�", "���⡾���ԡ�", JOptionPane.ERROR_MESSAGE);
		}else{
			//ɾ��cookie�ķ������ͽ���һ��ͬ��cookie��Ȼ������cookie��setmaxage=0�� 			
			Cookie autologinC=new Cookie("autologin", "");
			autologinC.setMaxAge(0); 
			autologinC.setPath("/");
			response.addCookie(autologinC); 
		}
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");   //ת����ҳ
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

