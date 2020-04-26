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
	������----------------------
		���ã�
			�������ö���request session application�Ĵ��������ٺ����ݵĸı�

		ʹ�ã�
			1������һ��ʵ����ָ���ӿڵ�java�࣬��д����
				����request����Ĵ���������(�ӿ�)--->ServletRequestListener
	
					requestInitialized(ServletRequestEvent sre)
						sre.getServletRequest()   //����������󴴽���request����
					
					requestDestroyed(ServletRequestEvent sre)
						sre.getServletRequest()   //���ر����ٵ�request����
						
				����request���������ݵı��--->ServletRequestAttributeListener
					attributeAdded(ServletRequestAttributeEvent srae)
					
					attributeRemoved(ServletRequestAttributeEvent srae)
					
					attributeReplaced(ServletRequestAttributeEvent srae)
					
				����session����Ĵ���������--->HttpSessionListener
					sessionCreated(HttpSessionEvent se)
						se.getSession();//��ȡ��������session����
					
					sessionDestroyed(HttpSessionEvent se)
					
				����session���������--->HttpSessionAttributeListener
					attributeAdded(HttpSessionBindingEvent se)
					
					attributeRemoved(HttpSessionBindingEvent se)
					
					attributeReplaced(HttpSessionBindingEvent se)
					
			2����web.xml�����ü�������
				 <!-- ���ü����� -->
				  <listener>
				  	<listener-class>yp.cqc.listener.MyListener</listener-class>
				  
				  </listener>
				
			
			
			
			
	

*/
public class MyListener implements ServletRequestListener,ServletRequestAttributeListener,HttpSessionListener,HttpSessionAttributeListener,ServletContextListener,ServletContextAttributeListener{

	@Override
	//request��������
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
		System.out.println("�ұ�������");
	}

	@Override
	//request���󴴽�
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
		System.out.println("�ұ�������");
	}

	@Override
	//����request���������ݵ����
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
		System.out.println("request��������һ������-"+srae.getName()+":"+srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request��ɾ����һ������-"+srae.getName()+":"+srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		System.out.println("request��һ�����ݸı���-"+srae.getName()+":"+srae.getValue());
		
	}
	/*-------------------------------------------------------------------------
	*/
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
		System.out.println("session��������-");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session��������-");
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session��������һ������-"+se.getName()+":"+se.getValue());
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
		System.out.println("MyListener.attributeAdded(�ұ������)-----"+scab.getName()+":"+scab.getValue());
		
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
