package com.edu.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

/*	request对象学习
	
	作用：request对象中封存了当前请求的所有请求数据
	使用： 
		获取请求头数据
			req.getMethod();  		//获取请求方式
			req.getRequestURL();	//获取请求url信息
			req.getRequestURI();	//获取请求uri信息
			req.getScheme();		//获取协议
		获取请求行数据
			req.getHeader("键名");//返回指定请求头信息
			req.getHeaderNames();	//返回请求头的键名的枚举
		获取用户数据
			req.getParameter("键名");	//返回指定的用户数据
			req.getParameterValues("键名");//返回同键不同值的请求数据（多选），返回数组
			req.getParameterNames()；		//返回所有用户请求数据的枚举集合
			注意：如果要获取的请求数据不存在，不会报错，返回null
	注意：request对象由tomcat服务器创建，并作为实参传递给请求的servlet的service方法。
	
	*
	*
	*/
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取请求头数据
				//获取请求方式
					String method=req.getMethod();   //method=get/post   可以用来判断是post还是get
					System.out.println(method);    	//输出 GET
				//获取请求url	
					StringBuffer url=req.getRequestURL();
					System.out.println(url);		//	输出 http://localhost:8080/03-myServlet/req
					//获取uri  (web.xml里的url-pattern)
					String uri=req.getRequestURI();
					System.out.println(uri);		//输出 /03-myServlet/req
				//获取协议
					String h=req.getScheme();
					System.out.println(h);			//输出 http
					
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//获取请求行数据
					//获取指定的请求行信息
					String value=req.getHeader("Host");//请求头里有”Host“的属性，返回”Host“属性的行数据 ，如果没有”Host“属性，返回null
					System.out.println(value);  	//localhost:8080
					
					//获取所有的请求行的键的枚举
					Enumeration headnames =req.getHeaderNames();
					while(headnames.hasMoreElements()){
						String name=(String)headnames.nextElement();
						String value2=req.getHeader(name);
						System.out.println(name+":"+value2);
						
					}
		//获取用户数据
					String name=req.getParameter("uname");//"uname"是Method.jsp里自己form里设置的用户名,下同
					String pwd=req.getParameter("pwd");
					System.out.println(name+":"+pwd+"\n");
					//String fav=req.getParameter("fav");  //多选的话会漏掉
					
					
				String[]favs=req.getParameterValues("fav");
				if(favs!=null){
					for(String fav:favs){
						System.out.println(fav);
					}
				}
				//获取所有的用户请求数据的键的枚举集合 req.getParameterNames()
				
	}
}
