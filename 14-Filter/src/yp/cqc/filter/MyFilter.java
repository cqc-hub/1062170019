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
 * 过滤器的使用
 * 		1、创建一个实现了Filter接口的普通java类
 * 		2、覆写方法
 * 			init()   	:服务器启动时执行。资源初始化
 * 			doFilter()	：拦截请求的方法，在此方法中实现对资源管理
 * 				注意：
 * 					需要手动对资源放行。chain.doFilter(request, response);
 * 		
 * 							
 * 			destroy()	：服务器关闭时执行
 * 		3、在web.xml中配置过滤器
 * 			<!-- 配置过滤器 -->
			  <filter>
				  	<filter-name>myFilter</filter-name>
				  	<filter-class>yp.cqc.filter.MyFilter</filter-class>
			  </filter>
			  <filter-mapping>
				  	<filter-name>myFilter</filter-name>
				  	<url-pattern>/*</url-pattern>
			  </filter-mapping>
			  
			  注意：url-pattern：/*   ,表示拦截所有请求
			  	url-pattern：*.do   ,表示拦截所有以.do结尾的请求，一般用来进行模块拦截处理
			  	url-pattern：/ts.do   ,表示拦截指定url的请求。针对某个servlet的请求拦截，保护servlet
		过滤器生命周期：服务器启动到服务器关闭.
			  		
 * 
 * */
public class MyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("MyFilter.destroy(我被销毁了)");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter.doFilter(我被执行了)");
		
		///设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//判断session
		HttpSession hs=((HttpServletRequest)req).getSession();
		if(hs.getAttribute("user")==null){
			((HttpServletResponse)resp).sendRedirect("/a/login.jsp");
			
		}else{
			chain.doFilter(req, resp);
		}
		
		//放行
			chain.doFilter(req, resp);
			System.out.println("MyFilter.doFilter(我被执行了2)");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter.init(我被初始化了)");
		
	}

}
