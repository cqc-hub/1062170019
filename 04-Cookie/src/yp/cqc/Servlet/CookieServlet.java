package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*Cookie
 * 	���ã�����˷��͵Ĳ�ͬ��������ݹ�������
 * 	ʹ�ã�
 * 	 //cookie�Ĵ����ʹ洢
 * 		//����cookie����
		Cookie c=new Cookie(String name,String value);
		//����cookie����ѡ��
		 * 	//������Ч��
		 * 	c.setMaxAge(3*24*60*60);//��Ϊ��λ��intֵ
		 * 	//������Ч·��
		 * 	c.setPath("/cookie/gc");
		//��Ӧcookie��Ϣ
		resp.addCookie(c);
		
	//cookie�Ļ�ȡ	
		//��ȡcookie����
		 * 	Cookie[] cks=req.getCookies();
		//���������ȡcookie��Ϣ
		 * if(cks!=null){
		 * 	for(Cookie c:cks){
		 * 		String name=c.getName();
		 * 		String value=c.getValue();
		 * 		System.out.println(name+":"+value);
		 * 		}
		 *	 }
	ע�⣺һ��cookie�洢һ�����ݣ��������ݿ��Զഴ������cookie
 * 	�ص㣺
 * 		������˵����ݴ洢����
 * 		�洢�����������ڷ�������
 * 		��ʱ�洢������������������ڴ���ر������ʧЧ
 * 		��ʱ�洢��������cookie����Ч�ڣ��洢�ڿͻ��˵�Ӳ���У�����Ч���ڷ���·��Ҫ������󶼻ḽ������Ϣ
 * 		Ĭ��cookie��Ϣ�洢��֮����Ŀÿ�����󶼻ḽ��������������Ч·��
 * 
 * 
*/
public class CookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
			
		//����������Ϣ
		//��Ӧ������Ϣ
			//ʹ��cookie����������˵����ݴ洢
				//����cookie����
				Cookie c=new Cookie("mouse","thinkpad");
				Cookie c2=new Cookie("yp","1160202");
			
				//����cookie
					//����cookie��Ч��
					c2.setMaxAge(3*24*60*60);//��Ϊ��λ��intֵ
					//������Ч·��
					c2.setPath("/cookie/gc");
				//��Ӧcookie��Ϣ
				resp.addCookie(c);
				resp.addCookie(c2);
			//ֱ����Ӧ
			resp.getWriter().write("Cookie~~~~");
			//����ת��
			//�ض���
	}
}
