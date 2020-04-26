package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMethod extends HttpServlet {
/*	service方法和 doGet和doPost的区别
	service方法：可以处理get/post方式的请求 ，如果servlet中有service方法，会优先调用service方法对请求进行处理
	doGet方法：  处理get方式的请求
	doPost方法：处理post方式的请求  
	
	
	
	注意：  如果在覆写的service方法中调用了父类的service方法   super.service(req, resp);
		  那么service方法处理完后，会再次根据请求方式响应的doGet/doPost方法执行。所以一般情况下
		  我们是不在覆写的service中调用父类的service方法，避免出现405错误
		  
		  
  	servlet的常见错误：  
  	     404错误：资源未找到、
  	            	原因1：请求地址中的servlet的别名书写错误。
  	            	原因2：虚拟项目名称拼写错误。
  	     500错误：
  	     			原因1：服务器没有加载到类
  	            		解决：在web.xml中校验servlet类的权限路径是否拼写错误
  	            	原因2：service方法里的代码执行错误	
  	            		解决：根据错误提示对service方法中的代码进行错误更改
  	      405错误：请求方式不支持
  	            	原因：请求方式和servlet中的方法不匹配
  	            		解决：尽量使用service方法进行请求处理，并且不要在覆写的service中调用父类service
  	            		
  	            		
	*/
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("我是service方法");
		//super.service(req, resp);
	}

/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("我是doGet方法");
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
		System.out.println("我是doPost方法");
		}*/
}
