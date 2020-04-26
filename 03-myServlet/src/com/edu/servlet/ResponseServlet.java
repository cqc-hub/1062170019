package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  /* Response对象学习
   * 
   * 作用：  
   *     用来响应浏览器的一个对象
   * 
   * 使用：
   * 	
				
   * 	设置响应头
   * 		resp.setHeader(String name, String value); //在响应头中添加响应信息，但是同键会覆盖
			resp.addHeader(String name, String value); //在响应头中添加响应信息，同键不会覆盖
			
		设置响应状态码	
			resp.sendError(int num,String msg);			//自定义响应状态码
			
		设置响应编码格式
   * 		resp.setContentType("text/html;charset=utf-8");		//html
   * 
   * 	设置响应体
   * 		resp.getWriter().write(String str);			//响应具体的数据给浏览器
   * 
   * 	
   * 总结：
   * 	service请求处理代码流程：
   * 		设置响应格式；
   * 		获取请求数据；  	 //request
   * 		处理请求数据；	//java 代码 逻辑代码
   * 			数据库操作（mvc思想）；
   * 		响应处理结果；	//response
   * 
   * */
public class ResponseServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取请求信息
			//获取请求头
			//获取请求行
			//获取用户数据
		//处理请求
			
		//响应处理结果
			//设置响应头
		
			resp.setHeader("mouse", "two fly birds");//在响应头中添加响应信息，但是同键会覆盖
			resp.addHeader("key", "thinkpad");		//在响应头中添加响应信息，同键不会覆盖
			
			resp.setHeader("mouse", "bjsxt");
			resp.addHeader("key", "wollo");
			
			//设置响应编码格式
				//resp.setHeader("content-type", "text/html;charset=utf-8");
				resp.setContentType("text/html;charset=utf-8");		//html
				//resp.setContentType("text/plain;charset=utf-8");  //plain(普通文本)
				//resp.setContentType("text/xml;charset=utf-8");	//xml(xml文本)
			
			
			
			//设置响应状态码
			//resp.sendError(405,"this method is not supported");
			//设置响应实体
			resp.getWriter().write("<b><h1>this is response study</h1></b>");
			resp.getWriter().write("<b>今天天气真好，我想学习</b>");    ////设置响应状态码 不然乱码
			
			
	}
}
