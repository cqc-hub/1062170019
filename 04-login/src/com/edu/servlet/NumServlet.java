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
 * 还需要在web.xml里添加
 * <load-on-startup>这里随便填</load-on-startup>
 * 
	*/
	//覆写init初始化方法，将数据读取到ServletContext中
	@Override
	public void init() throws ServletException {
		//获取文件中的计数器数据
			//声明流对象
				FileReader fr=null;
				BufferedReader br=null;
			//获取文件路径
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
	//覆写销毁方法，存储计数器到文件中
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		//获取网页计数器
		int  nums=(int) this.getServletContext().getAttribute("nums");
		//获取文件路径
		String path=this.getServletContext().getRealPath("/nums/nums.txt");
		//声明流对象
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
