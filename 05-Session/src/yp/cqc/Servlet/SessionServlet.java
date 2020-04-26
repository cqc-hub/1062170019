package yp.cqc.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * session:һ���û��Ĳ�ͬ����������ݹ���(session�洢�ڷ�������JSESSIONID�洢�������)
 * 		ʹ��ʱ����һ���û��ڵ�½web��Ŀʱ�Ὣ�û��ĸ������ݴ洢��session�У������û�����������ʹ��
 * 		ԭ��
 * 			�û���һ�η��ʷ��������������ᴴ��һ��session��������û���������session�����
 *          JSESESSIONIDʹ��Cookie�����洢��������У���֤�û������������ܹ���ȡ��ͬһ��
 *          session����Ҳ��֤�˲�ͬ�����ܻ�ȡ����������ݡ�
 *          
 * 		�ص㣺
 * 			�洢�ڷ�������
 * 			���������д���
 * 			����cookie����
 * 			һ�λỰ�������������
 * 			Ĭ�ϴ洢ʱ����30����
 * 		ʹ�ã�
 * 			����session����/��ȡsession����
	 * 				HttpSession hs=req.getSession();
	 * 				�����������session�ı�ʶ��Ҳ����JSESSIONID,�򷵻����Ӧ��session����
	 * 				���������û��session�ı�ʶ�����򴴽��µ�session���󲢽���JSESSIONID��Ϊ��cookie���ݴ洢���������
	 * 				���session����ʧЧ��Ҳ����ִ���session���󲢽���JSESSIONID��Ϊ��cookie���ݴ洢���������
		 * 			ע�⣺
		 * 				JSESSIONID�洢��cookie����ʱ�洢�ռ��ڣ�������ر�ʧЧ
 * 			//����session�洢ʱ��
 * 			hs.setMaxInactiveInterval(5);//Ĭ�ϴ洢ʱ����30���ӣ��ڴ����ڼ䱻ʹ�û����¼�ʱ
 * 
 * 			//����sessionǿ��ʧЧ
 * 				hs.invalidate();
 * 			
 * 			�洢/��ȡ���ݴ�session����
 * 				�洢��hs.setAttribute(String name,object value);
 * 				��ȡ��hs.getAttribute(String name) //����object����
 * 			
 * 		sessionʧЧ����
 * 				���û������е�JSESSIONID���̨��ȡ��	JSESSIONID���жԱȣ����һ����session��Ч��else ʧЧ (�ض��򵽵�¼ҳ�����µ�½)
 * 				
 * 
*/
public class SessionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ��������
			String name="����";
			
		//����������Ϣ
			//����session����
			HttpSession hs=req.getSession(); //���Ǵ�����Ҳ�ǻ�ȡ(����������û��sessionid)
			//����session�洢ʱ��
				//hs.setMaxInactiveInterval(50);
			System.out.println(hs.getId());
			//����sessionǿ��ʧЧ
				//hs.invalidate();
			//�洢����
				hs.setAttribute("name", name);
		//��Ӧ������
			//ֱ����Ӧ
			resp.getWriter().write("session learnning");
			//����ת��
			//�ض���
		
	}
	
}
