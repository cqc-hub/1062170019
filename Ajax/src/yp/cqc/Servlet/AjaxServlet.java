package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ajax")

public class AjaxServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������Ӧ����������ʽ  //����û���������Բ�������
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		/*try {
			Thread.sleep(1000);
			//��ȡ������Ϣ
			//����������Ϣ
			//��Ӧ���
			resp.getWriter().write("���������������ʣ�999");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//��ȡ������Ϣ
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		System.out.println(name+":"+pwd+":"+req.getMethod());
		//����������Ϣ
		//��Ӧ���
		resp.getWriter().write("���������������ʣ�999");
	
	}
}
