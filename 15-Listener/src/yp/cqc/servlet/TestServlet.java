package yp.cqc.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ������Ϣ
		//����������Ϣ
			req.setAttribute("str", "������ѧϰ");
			HttpSession hs=req.getSession();
			hs.setAttribute("str1", "session/����������");
			hs.invalidate();//����
			ServletContext sc= req.getSession().getServletContext();
			sc.setAttribute("str2", "��ʼ���ʼ��ʼ��ʷɻ�");
		//��Ӧ������
			resp.getWriter().write("this is listener study");
		
	}
}
