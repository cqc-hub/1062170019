package com.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  /* Response����ѧϰ
   * 
   * ���ã�  
   *     ������Ӧ�������һ������
   * 
   * ʹ�ã�
   * 	
				
   * 	������Ӧͷ
   * 		resp.setHeader(String name, String value); //����Ӧͷ�������Ӧ��Ϣ������ͬ���Ḳ��
			resp.addHeader(String name, String value); //����Ӧͷ�������Ӧ��Ϣ��ͬ�����Ḳ��
			
		������Ӧ״̬��	
			resp.sendError(int num,String msg);			//�Զ�����Ӧ״̬��
			
		������Ӧ�����ʽ
   * 		resp.setContentType("text/html;charset=utf-8");		//html
   * 
   * 	������Ӧ��
   * 		resp.getWriter().write(String str);			//��Ӧ��������ݸ������
   * 
   * 	
   * �ܽ᣺
   * 	service������������̣�
   * 		������Ӧ��ʽ��
   * 		��ȡ�������ݣ�  	 //request
   * 		�����������ݣ�	//java ���� �߼�����
   * 			���ݿ������mvc˼�룩��
   * 		��Ӧ��������	//response
   * 
   * */
public class ResponseServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//��ȡ������Ϣ
			//��ȡ����ͷ
			//��ȡ������
			//��ȡ�û�����
		//��������
			
		//��Ӧ������
			//������Ӧͷ
		
			resp.setHeader("mouse", "two fly birds");//����Ӧͷ�������Ӧ��Ϣ������ͬ���Ḳ��
			resp.addHeader("key", "thinkpad");		//����Ӧͷ�������Ӧ��Ϣ��ͬ�����Ḳ��
			
			resp.setHeader("mouse", "bjsxt");
			resp.addHeader("key", "wollo");
			
			//������Ӧ�����ʽ
				//resp.setHeader("content-type", "text/html;charset=utf-8");
				resp.setContentType("text/html;charset=utf-8");		//html
				//resp.setContentType("text/plain;charset=utf-8");  //plain(��ͨ�ı�)
				//resp.setContentType("text/xml;charset=utf-8");	//xml(xml�ı�)
			
			
			
			//������Ӧ״̬��
			//resp.sendError(405,"this method is not supported");
			//������Ӧʵ��
			resp.getWriter().write("<b><h1>this is response study</h1></b>");
			resp.getWriter().write("<b>����������ã�����ѧϰ</b>");    ////������Ӧ״̬�� ��Ȼ����
			
			
	}
}
