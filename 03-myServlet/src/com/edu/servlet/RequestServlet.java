package com.edu.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

/*	request����ѧϰ
	
	���ã�request�����з���˵�ǰ�����������������
	ʹ�ã� 
		��ȡ����ͷ����
			req.getMethod();  		//��ȡ����ʽ
			req.getRequestURL();	//��ȡ����url��Ϣ
			req.getRequestURI();	//��ȡ����uri��Ϣ
			req.getScheme();		//��ȡЭ��
		��ȡ����������
			req.getHeader("����");//����ָ������ͷ��Ϣ
			req.getHeaderNames();	//��������ͷ�ļ�����ö��
		��ȡ�û�����
			req.getParameter("����");	//����ָ�����û�����
			req.getParameterValues("����");//����ͬ����ֵͬ���������ݣ���ѡ������������
			req.getParameterNames()��		//���������û��������ݵ�ö�ټ���
			ע�⣺���Ҫ��ȡ���������ݲ����ڣ����ᱨ������null
	ע�⣺request������tomcat����������������Ϊʵ�δ��ݸ������servlet��service������
	
	*
	*
	*/
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ����ͷ����
				//��ȡ����ʽ
					String method=req.getMethod();   //method=get/post   ���������ж���post����get
					System.out.println(method);    	//��� GET
				//��ȡ����url	
					StringBuffer url=req.getRequestURL();
					System.out.println(url);		//	��� http://localhost:8080/03-myServlet/req
					//��ȡuri  (web.xml���url-pattern)
					String uri=req.getRequestURI();
					System.out.println(uri);		//��� /03-myServlet/req
				//��ȡЭ��
					String h=req.getScheme();
					System.out.println(h);			//��� http
					
					//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//��ȡ����������
					//��ȡָ������������Ϣ
					String value=req.getHeader("Host");//����ͷ���С�Host�������ԣ����ء�Host�����Ե������� �����û�С�Host�����ԣ�����null
					System.out.println(value);  	//localhost:8080
					
					//��ȡ���е������еļ���ö��
					Enumeration headnames =req.getHeaderNames();
					while(headnames.hasMoreElements()){
						String name=(String)headnames.nextElement();
						String value2=req.getHeader(name);
						System.out.println(name+":"+value2);
						
					}
		//��ȡ�û�����
					String name=req.getParameter("uname");//"uname"��Method.jsp���Լ�form�����õ��û���,��ͬ
					String pwd=req.getParameter("pwd");
					System.out.println(name+":"+pwd+"\n");
					//String fav=req.getParameter("fav");  //��ѡ�Ļ���©��
					
					
				String[]favs=req.getParameterValues("fav");
				if(favs!=null){
					for(String fav:favs){
						System.out.println(fav);
					}
				}
				//��ȡ���е��û��������ݵļ���ö�ټ��� req.getParameterNames()
				
	}
}
