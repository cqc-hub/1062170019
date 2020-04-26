package yp.cqc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * ��������ʹ��
 * 		1������һ��ʵ����Filter�ӿڵ���ͨjava��
 * 		2����д����
 * 			init()   	:����������ʱִ�С���Դ��ʼ��
 * 			doFilter()	����������ķ������ڴ˷�����ʵ�ֶ���Դ����
 * 				ע�⣺
 * 					��Ҫ�ֶ�����Դ���С�chain.doFilter(request, response);
 * 		
 * 							
 * 			destroy()	���������ر�ʱִ��
 * 		3����web.xml�����ù�����
 * 			<!-- ���ù����� -->
			  <filter>
				  	<filter-name>myFilter</filter-name>
				  	<filter-class>yp.cqc.filter.MyFilter</filter-class>
			  </filter>
			  <filter-mapping>
				  	<filter-name>myFilter</filter-name>
				  	<url-pattern>/*</url-pattern>
			  </filter-mapping>
			  
			  ע�⣺url-pattern��/*   ,��ʾ������������
			  	url-pattern��*.do   ,��ʾ����������.do��β������һ����������ģ�����ش���
			  	url-pattern��/ts.do   ,��ʾ����ָ��url���������ĳ��servlet���������أ�����servlet
		�������������ڣ��������������������ر�.
			  		
 * 
 * */
public class MyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("MyFilter.destroy(�ұ�������)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter.doFilter(�ұ�ִ����)");
		
		///���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//�ж�session
		HttpSession hs=((HttpServletRequest)req).getSession();
		if(hs.getAttribute("user")==null){
			((HttpServletResponse)resp).sendRedirect("/a/login.jsp");
			
		}else{
			chain.doFilter(req, resp);
		}
		
		//����
			chain.doFilter(req, resp);
			System.out.println("MyFilter.doFilter(�ұ�ִ����2)");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter.init(�ұ���ʼ����)");
		
	}

}
