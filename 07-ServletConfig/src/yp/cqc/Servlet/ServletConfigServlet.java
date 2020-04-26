package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*ServletConfig:在web.xml中给每个servlet单独配置数据
 *   使用:
 *   	获取servletconfig对象
 *   	获取web.xml中的配置数据（需要先在web.xml中给每个servlet单独配置数据  写在<init-param>里）
 *   	
 * 
 * 
*/
public class ServletConfigServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取servletfonfig对象
		ServletConfig sc=this.getServletConfig();
		//获取web.xml中的配置数据
		String code=sc.getInitParameter("config");
		System.out.println(code);
	}
}
