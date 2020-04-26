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
		//获取application对象
		ServletContext sc=se.getSession().getServletContext();
		//获取在线统计人数的变量
		int count=(int) sc.getAttribute("count");
		//自增
		count++;
		sc.setAttribute("count", count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		//获取application对象
		ServletContext sc=se.getSession().getServletContext();
		//获取在线统计人数的变量
				int count=(int) sc.getAttribute("count");
				//自减
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
		//获取application对象
		ServletContext sc=sce.getServletContext();
		 sc=sce.getServletContext();
		//在application对象存储变量进行统计人数
		sc.setAttribute("count", 0);
		
	}

}
