package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
			//��ȡcookie��Ϣ
				Cookie[] cks=req.getCookies();
				if(cks!=null){
				for(Cookie c:cks){
					String name=c.getName();
					String value=c.getValue();
					System.out.println(name+":"+value);
				}
				}
			//��ȡ�û���Ϣ
		//����������Ϣ
		//��Ӧ�������
			//ֱ����Ӧ
			//����ת��
			//�ض���
		
	}
}