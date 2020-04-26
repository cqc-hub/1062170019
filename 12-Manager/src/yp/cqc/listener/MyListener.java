package yp.cqc.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener,ServletContextListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//��ȡapplication����
		ServletContext sc=se.getSession().getServletContext();
		//��ȡ����ͳ�������ı���
		int count=(int) sc.getAttribute("count");
		//����
		count++;
		sc.setAttribute("count", count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//��ȡapplication����
		ServletContext sc=se.getSession().getServletContext();
		//��ȡ����ͳ�������ı���
				int count=(int) sc.getAttribute("count");
				//�Լ�
				count--;
				sc.setAttribute("count", count);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//��ȡapplication����
		ServletContext sc=sce.getServletContext();
		 sc=sce.getServletContext();
		//��application����洢��������ͳ������
		sc.setAttribute("count", 0);
		
	}

}
