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
	ServletContext���������ҳ������
		���û���¼У���д�����������������Ȼ��洢��ServletContext������
		����ҳ��ȥ����������ʾ���û�


*/
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//������Ӧ�����ʽ
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
			String uname=req.getParameter("uname");
			//uname=new String(uname.getBytes("iso8859-1"),"utf-8");//ת�����ʽ,��tomat�汾��9Ĭ��utf-8
			String pwd=req.getParameter("pwd");
			System.out.println(uname+":"+pwd);
		//����������Ϣ
			//��ȡҵ������
			LoginService ls=new LoginServiceImpl();
			User u=ls.checkLoginService(uname, pwd);
			System.out.println(u);
		//��Ӧ������
			if(u!=null){
				//����cookie��Ϣʵ���������¼
				Cookie c=new Cookie("uid",u.getUid()+"");
				//����cookie��Ч��
				c.setMaxAge(3*24*60*60);
				c.setPath("/04-login/ck");
				resp.addCookie(c);
				//����session
				HttpSession hs=req.getSession();
				//�洢���ݵ�session
				hs.setAttribute("user", u);
				
				//������ҳ������
					//��ȡ��������
					ServletContext sc=this.getServletConfig().getServletContext();
					if(sc.getAttribute("nums")!=null){
					int nums=Integer.parseInt((String) sc.getAttribute("nums"));
					nums+=1;
					//���´洢��ServletContext��
					sc.setAttribute("nums", nums);
					}else{
						sc.setAttribute("nums", 1);
					}
				//�ض���
				resp.sendRedirect("main");
				return;
			}else{
				//resp.getWriter().write("��½ʧ��");
	
				//ʹ��request����ʵ�ֲ�ͬservlet��������ת
				req.setAttribute("str", "�û������������");
				//ʹ������ת��
				req.getRequestDispatcher("page").forward(req, resp);
				return;
				
			}
	}
}
