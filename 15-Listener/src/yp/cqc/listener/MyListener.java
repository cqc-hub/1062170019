package yp.cqc.listener;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sound.sampled.LineEvent;
/*
	监听器----------------------
		作用：
			监听作用对象request session application的创建、销毁和内容的改变

		使用：
			1、创建一个实现了指定接口的java类，覆写方法
				监听request对象的创建和销毁(接口)--->ServletRequestListener
	
					requestInitialized(ServletRequestEvent sre)
						sre.getServletRequest()   //返回这次请求创建的request对象
					
					requestDestroyed(ServletRequestEvent sre)
						sre.getServletRequest()   //返回被销毁的request对象
						
				监听request作用域数据的变更--->ServletRequestAttributeListener
					attributeAdded(ServletRequestAttributeEvent srae)
					
					attributeRemoved(ServletRequestAttributeEvent srae)
					
					attributeReplaced(ServletRequestAttributeEvent srae)
					
				监听session对象的创建和销毁--->HttpSessionListener
					sessionCreated(HttpSessionEvent se)
						se.getSession();//获取被监听的session对象
					
					sessionDestroyed(HttpSessionEvent se)
					
				监听session对象的数据--->HttpSessionAttributeListener
					attributeAdded(HttpSessionBindingEvent se)
					
					attributeRemoved(HttpSessionBindingEvent se)
					
					attributeReplaced(HttpSessionBindingEvent se)
					
			2、在web.xml中配置监听器类
				 <!-- 配置监听器 -->
				  <listener>
				  	<listener-class>yp.cqc.listener.MyListener</listener-class>
				  
				  </listener>
				
			
			
			
			
	

*/
public class MyListener implements ServletRequestListener,ServletRequestAttributeListener,HttpSessionListener,HttpSessionAttributeListener,ServletContextListener,ServletContextAttributeListener{

	@Override
	//request对象销毁
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
		System.out.println("我被销毁了");
	}

	@Override
	//request对象创建
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
		System.out.println("我被创建了");
	}

	@Override
	//创建request作用域数据的添加
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
		System.out.println("request中增加了一条数据-"+srae.getName()+":"+srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request中删除了一条数据-"+srae.getName()+":"+srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request中一条数据改变了-"+srae.getName()+":"+srae.getValue());
		
	}
	/*-------------------------------------------------------------------------
	*/
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
		System.out.println("session被创建了-");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session被销毁了-");
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session中增加了一条数据-"+se.getName()+":"+se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}
//--------------------------------------------------------------------------------
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println("MyListener.attributeAdded(我被添加了)-----"+scab.getName()+":"+scab.getValue());
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		
	}



}
