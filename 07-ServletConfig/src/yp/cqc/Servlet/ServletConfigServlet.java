package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*ServletConfig:��web.xml�и�ÿ��servlet������������
 *   ʹ��:
 *   	��ȡservletconfig����
 *   	��ȡweb.xml�е��������ݣ���Ҫ����web.xml�и�ÿ��servlet������������  д��<init-param>�
 *   	
 * 
 * 
*/
public class ServletConfigServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//��ȡservletfonfig����
		ServletConfig sc=this.getServletConfig();
		//��ȡweb.xml�е���������
		String code=sc.getInitParameter("config");
		System.out.println(code);
	}
}
