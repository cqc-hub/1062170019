package yp.cqc.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yp.cqc.pojo.Address;
import yp.cqc.pojo.User;
@WebServlet("/es")
/*
 *   ��ȡjsp�����������
*/
public class ELServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����������Ӧ�����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		
		//����������Ϣ
		System.out.println(uname+":"+pwd);
		//��Ӧ������
			//ֱ����Ӧ
			//ʹ��request���������������ת
				//��ͨ�ַ���
				req.setAttribute("str", "�����������");
				//��������
				User u=new User(1,"����","�ĵ�Ӱ",new Address("����","����", "�ݳ���"));
				req.setAttribute("user", u);
				//��������
					//list����
						//�洢��ͨ�ַ�
						List<String> list=new ArrayList<String>();
						list.add("�żһ�");
						list.add("����ͮ");
						list.add("��ʫʫ");
						req.setAttribute("list", list);
						
						//�洢����
						List<User> list2=new ArrayList<User>();
						User u2=new User(2, "��������","�ĵ�Ӱ", new Address("�½�","��³ľ��","��³ľ��"));
						list2.add(u2);
						req.setAttribute("list2", list2);
					//map����
						//�洢��ͨ�ַ�
						Map<String,String> map=new HashMap<String,String>();
						map.put("a", "����");
						map.put("b", "shanghai");
						map.put("c", "�󶼻�");
						req.setAttribute("map", map);
						
						//�洢����
						Map<String,User> map2=new HashMap<String,User>();
						map2.put("a", u2);
						req.setAttribute("map2", map2);
			//����ת��
			req.getRequestDispatcher("/el.jsp").forward(req, resp);
			return;
			 
			

			//�ض���
		
	}
}
