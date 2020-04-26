package yp.cqc.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
	ServletContext:��ͬ�û�ʹ����ͬ����
		�ص㣺�������������û�����
		������������Ŀ
		�������ڣ��������������ر�	
		
		ʹ�ã�
			��ȡServletContext����
				//��һ�ַ�ʽ
				ServletContext sc=this.getServletContext();
				//�ڶ��ַ�ʽ
				ServletContext sc2=this.getServletConfig().getServletContext();
				//�����ַ�ʽ
				ServletContext sc3=req.getSession().getServletContext();
			ʹ��ServletContext������ݹ���
				//���ݴ洢
				sc.setAttribute(String name, object value);
				//���ݴ洢�Ļ�ȡ
				sc.getAttribute(String name) //����object����
				
				ע�⣺
					��ͬ�û����Ը���ServletContext�������ݴ�ȡ
					��ȡ�����ݲ����ڷ���null.
			��ȡ��Ŀ��web.xml�ļ��е�ȫ����������
					sc.getInitParameter(String name); //���ݼ������ַ���web.xml��ȫ�����õ�ֵ��String��
				���÷�ʽ
					 <context-param>
					 <!-- һ��context-paramֻ����һ�����ݣ��ж������������context-param -->
					 <param-name>name</param-name>
					 <param-value>zhangsan</param-value>
					 </context-param>
				���ã�����̬���ݺͶ�̬������н��
			��ȡ��ĿWebRoot�µ���Դ�ľ���·��
				sc.getRealPath(String path); //��ȡ��·��Ϊ��Ŀ�ĸ�Ŀ¼,path����Ϊ��Ŀ��Ŀ¼�е�·��
			
			��ȡ��Ŀ��Ŀ¼�µ���Դ��������
				InputStream is=sc.getResourceAsStream("/doc/1.txt");
				ע�⣺���ַ�ʽֻ�ܻ�ȡ��Ŀ��Ŀ¼�µ���Դ������class�ļ�����������Ҫʹ�����������ȡ(������class�ļ�)
			
			
			
			
*/
public class ServletContextServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡServletContext����(1��3����)
			//��һ�ַ�ʽ
				ServletContext sc=this.getServletContext();
			//�ڶ��ַ�ʽ
				ServletContext sc2=this.getServletConfig().getServletContext();
			//�����ַ�ʽ
				ServletContext sc3=req.getSession().getServletContext();
				System.out.println(sc==sc2);
				System.out.println(sc==sc3);
			//ʹ��ServletContext������ݹ���
				//���ݴ洢
					sc.setAttribute("str", "ServletContext learnning");
			//��ȡweb.xml��ȫ����������
					String str=sc.getInitParameter("name");
					System.out.println("ȫ�����ò�����"+str);
				
			//��ȡ��Ŀ��Ŀ¼��Դ�µľ���·��
					//String path="D:\\Myeclipse\\Tomcat\\apache-tomcat-9.0.29\\webapps\\sc\\doc\\1.txt";
					String path=sc.getRealPath("/doc/1.txt");
					System.out.println(path);
			
			//��ȡ��Ŀ��Ŀ¼�µ���Դ��������
					InputStream is=sc.getResourceAsStream("/doc/1.txt");
					
	}
}
