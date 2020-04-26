package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.pojo.User;
import com.edu.service.LoginService;
import com.edu.service.impl.LoginServiceImpl;

public class CookieServlet extends HttpServlet {
	/*Cookie ��ϢУ��
	 * 		�ж�������Ϣ���Ƿ�Я����ȷ��cookie��Ϣ
	 * 		�������У��cookie��Ϣ�Ƿ���ȷ
	 * 			���У����ȷ��ֱ����Ӧ��ҳ����û�
	 * 			�������ȷ����Ӧ��½ҳ����û�
	 * 		û��������ת������½ҳ��
	 * 
	 * 
	 * 
	 */
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
		//����������Ϣ
		if(cks!=null){
			//����cookie��Ϣ
			String uid="";
			for(Cookie c:cks){
				if("uid".equals(c.getName())){
					uid=c.getValue();
				}
			}
			//У��uid�Ƿ����
			if("".equals(uid)){
				req.getRequestDispatcher("page").forward(req, resp);
				return;
			}else{
				//У��uid�û���Ϣ
				//��ȡҵ������
				LoginService ls=new LoginServiceImpl();
				User u=ls.checkUidService(uid);
				if(u!=null){
					//���û����ݴ洢��session������
					req.getSession().setAttribute("user", u);
					//��ҳ����������
						int nums=(int) this.getServletContext().getAttribute("nums");
						nums+=1;
						this.getServletContext().setAttribute("nums", nums);
					//�ض���
					resp.sendRedirect("main");
					return;
				}else{
					req.getRequestDispatcher("page").forward(req, resp);
					return;
				}

			}
		}else{
			//��Ӧ������
			//����ת��
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}


	}
}
