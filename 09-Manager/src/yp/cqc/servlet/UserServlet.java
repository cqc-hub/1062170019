package yp.cqc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import yp.cqc.pojo.User;
import yp.cqc.service.UserService;
import yp.cqc.service.impl.UserServiceImpl;
/*
 * �ض���·���ܽ�
 * 		�������·���������飩
 * 		����·��
 * 			/��Ŀ������/��Դ·��
 * ע�⣺������ת��/��ʾ��Ŀ��Ŀ¼
 * 		req.getRequestDispatcher("/��Դ·��").forward(req, resp);
*/
public class UserServlet extends HttpServlet {
	//������־����
	Logger logger=Logger.getLogger(UserServlet.class);
	//��ȡservice�����
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
			String oper=req.getParameter("oper");
			if("login".equals(oper)){
				//���õ�½������
				checkUserLogin(req,resp);
			}else if("out".equals(oper)){
				//�����˳�����
				userOut(req,resp);
				
			}else if("pwd".equals(oper)){
				//�����޸����빦��
				userChangePwd(req,resp);
				
			}else if("show".equals(oper)){
				//���ò鿴�����û����ݹ���
				userShow(req,resp);
				
			}else if("reg".equals(oper)){
				//����ע��
				userReg(req,resp);
				
			}else{
				logger.debug("û���ҵ���Ӧ�Ĳ�����:"+oper);
			}
		
		
		
	}
	//ע��
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//��ȡ����
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
			String birth=req.getParameter("birth");
			String[] bs=null;
			if(birth!=""){
				bs=birth.split("/");
				StringBuffer sb=new StringBuffer();
				sb.append(bs[2]+"-"+bs[0]+"-"+bs[1]);
				
				birth=sb.toString();
			}else{
				birth="1000-10-10";
			}
			
			System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
			User u=new User(0, uname, pwd, sex, age, birth);
		//��������
			//����ҵ���
				int index=us.userRegService(u);
				System.out.println(index);
		//��Ӧ
				if(index>0){
					//��ȡsession����
					HttpSession hs=req.getSession();
					hs.setAttribute("reg", "true");
					//�ض����½ҳ��
					resp.sendRedirect("/mg/login.jsp");
				}
	}
	//��ʾ�����û���Ϣ
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������
			//����service
			List<User> lu=us.checkUserShowService();
			if(lu!=null){
				//����ѯ�����ݶ���洢��request
				req.setAttribute("lu", lu);
				//����ת��
				req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
				return;
			}
	}
	//�û��޸�����
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//��ȡ����
			String newPwd=req.getParameter("newPwd");
			//��ȡ�û���Ϣ
			User u=(User) req.getSession().getAttribute("user");
			int uid=u.getUid();
		//��������
			//����service����
			int index=us.userChangePwdServlce(newPwd,uid);
			System.out.println(index);
			if(index>0){
				//��ȡsession����
				HttpSession hs=req.getSession();
				hs.setAttribute("pwd", "true");
				//�ض����½ҳ��
				resp.sendRedirect("/mg/login.jsp");
			}
	}

	//�û��˳�
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//��ȡsession����
		HttpSession hs=req.getSession();
		//ǿ������session
		hs.invalidate();
		//�ض��򵽵�½����
		resp.sendRedirect("/mg/login.jsp");
	}

	//�����½
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//��ȡ������Ϣ
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		//����������Ϣ
			
			//У��
			User u=us.checkUserLoginService(uname, pwd);
		//��Ӧ������
			//ֱ����Ӧ
			//����ת��
			//�ض���
			if(u!=null){
				//��ȡsession����
				HttpSession hs=req.getSession();
				//���û����ݴ浽session��
				hs.setAttribute("user", u);
				//�ض���
				resp.sendRedirect("/mg/main/main.jsp");
				return;
			}else{
				//��ӱ�ʶ����request��
				req.setAttribute("flag", 0);
				//����ת��
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}
	}
}
