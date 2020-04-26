package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.pojo.User;

public class MainServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setContentType("text/html;charset=utf-8");
		//��ȡsession����
			User u=(User) req.getSession().getAttribute("user");
		//��ȡ��ҳ�������
			int nums=(int) this.getServletContext().getAttribute("nums");
		//��ȡ������Ϣ
		//����������Ϣ
		//��Ӧ������
			resp.getWriter().write("<html>");
			resp.getWriter().write("<head>");
			resp.getWriter().write("<title>");
			resp.getWriter().write("</title>");
			resp.getWriter().write("</head>");
			resp.getWriter().write("<body>");
			//��ȡֵ
			resp.getWriter().write("<h3>��ӭ"+u.getUname()+"����xxx����ϵͳ</h3>");
			resp.getWriter().write("��ǰ��ҳ�������Ϊ"+nums);
			resp.getWriter().write("<hr>");
			resp.getWriter().write("<form action='show' method='get'>");
			resp.getWriter().write("<input type='submit' value='�鿴������Ϣ'>");
			resp.getWriter().write("</form>");
			resp.getWriter().write("</body>");
			resp.getWriter().write("</html>");
	}
}
