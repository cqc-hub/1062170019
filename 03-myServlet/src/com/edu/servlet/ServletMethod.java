package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMethod extends HttpServlet {
/*	service������ doGet��doPost������
	service���������Դ���get/post��ʽ������ �����servlet����service�����������ȵ���service������������д���
	doGet������  ����get��ʽ������
	doPost����������post��ʽ������  
	
	
	
	ע�⣺  ����ڸ�д��service�����е����˸����service����   super.service(req, resp);
		  ��ôservice����������󣬻��ٴθ�������ʽ��Ӧ��doGet/doPost����ִ�С�����һ�������
		  �����ǲ��ڸ�д��service�е��ø����service�������������405����
		  
		  
  	servlet�ĳ�������  
  	     404������Դδ�ҵ���
  	            	ԭ��1�������ַ�е�servlet�ı�����д����
  	            	ԭ��2��������Ŀ����ƴд����
  	     500����
  	     			ԭ��1��������û�м��ص���
  	            		�������web.xml��У��servlet���Ȩ��·���Ƿ�ƴд����
  	            	ԭ��2��service������Ĵ���ִ�д���	
  	            		��������ݴ�����ʾ��service�����еĴ�����д������
  	      405��������ʽ��֧��
  	            	ԭ������ʽ��servlet�еķ�����ƥ��
  	            		���������ʹ��service�����������������Ҳ�Ҫ�ڸ�д��service�е��ø���service
  	            		
  	            		
	*/
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("����service����");
		//super.service(req, resp);
	}

/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("����doGet����");
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
		System.out.println("����doPost����");
		}*/
}
