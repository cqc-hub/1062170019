package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import yp.cqc.service.UserService;
import yp.cqc.serviceimpl.UserServiceImpl;
import yp.cqc.vo.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������/��Ӧ�����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//resp.setContentType("text/xml;charset=utf-8");
		//��ȡ������Ϣ
		String name=req.getParameter("name");
		System.out.println("�û�������Ϣ��"+name);
		//����������Ϣ
			//��ȡҵ������
			UserService us=new UserServiceImpl();
			User u=us.getUserInfoService(name);
			System.out.println("��ѯ���Ϊ��"+u);
		//��Ӧ������
			resp.getWriter().write(new Gson().toJson(u));
			//Gson��Դ���Լ����� toJson���ܣ��Ѷ������ַ���(json��ʽ)
			
			
			//XML����
			//resp.getWriter().write("<user><uid>1</uid><name>����</name><price>11.2</price></user>");
			
	}
}
