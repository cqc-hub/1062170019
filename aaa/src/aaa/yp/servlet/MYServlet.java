package aaa.yp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aaa.yp.pojo.User;
import aaa.yp.service.LoginService;
import aaa.yp.service.impl.LoginServiceimpl;







public class MYServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		String[] hobits=req.getParameterValues("hobit");
		for(String hobit:hobits){
			System.out.print(hobit+" ");
	}
		System.out.println();
		
		//��ȡҵ������
		LoginService ls=new LoginServiceimpl();
		User u=ls.checkLoginService(uname, pwd);
		System.out.println(u);
		//��Ӧ������
		if(u!=null){
			resp.getWriter().write("��½�ɹ�");
		}else{
			resp.getWriter().write("��½ʧ��");
		}
		
	}
	
}
