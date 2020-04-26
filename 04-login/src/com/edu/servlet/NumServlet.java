package com.edu.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class NumServlet extends HttpServlet {
/*  web.xml
 * 
 *   <servlet>
    <description>This is the description of my J2EE component</description>
    <display-name>This is the display name of my J2EE component</display-name>
    <servlet-name>NumServlet</servlet-name>
    <servlet-class>com.edu.servlet.NumServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
 * 
 * ����Ҫ��web.xml�����
 * <load-on-startup>���������</load-on-startup>
 * 
	*/
	//��дinit��ʼ�������������ݶ�ȡ��ServletContext��
	@Override
	public void init() throws ServletException {
		//��ȡ�ļ��еļ���������
			//����������
				FileReader fr=null;
				BufferedReader br=null;
			//��ȡ�ļ�·��
				String path=this.getServletContext().getRealPath("/nums/nums.txt");
				
			try {
				fr=new FileReader(path);
				br=new BufferedReader(fr);
				String nums=br.readLine();
				System.out.println(nums);
				this.getServletContext().setAttribute("nums", nums);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	//��д���ٷ������洢���������ļ���
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		//��ȡ��ҳ������
		int  nums=(int) this.getServletContext().getAttribute("nums");
		//��ȡ�ļ�·��
		String path=this.getServletContext().getRealPath("/nums/nums.txt");
		//����������
		BufferedWriter bw=null;
		FileWriter fw=null;
		
		try {
			fw=new FileWriter(path);
			bw=new BufferedWriter(fw);
			bw.write(nums+"");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
