package yp.cqc.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextServlet2 extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����ServletContext����
			ServletContext sc=this.getServletContext();
		//��ȡ����
			System.out.println("ServletContextServlet2()"+sc.getAttribute("str"));
		
	}
}