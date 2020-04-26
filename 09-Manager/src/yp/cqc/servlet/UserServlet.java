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
 * 重定向路径总结
 * 		可以相对路径（不建议）
 * 		绝对路径
 * 			/项目虚拟名/资源路径
 * 注意：在请求转发/表示项目根目录
 * 		req.getRequestDispatcher("/资源路径").forward(req, resp);
*/
public class UserServlet extends HttpServlet {
	//声明日志对象
	Logger logger=Logger.getLogger(UserServlet.class);
	//获取service层对象
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setContentType("text/html;charset=utf-8");
		//获取操作符
			String oper=req.getParameter("oper");
			if("login".equals(oper)){
				//调用登陆处理方法
				checkUserLogin(req,resp);
			}else if("out".equals(oper)){
				//调用退出功能
				userOut(req,resp);
				
			}else if("pwd".equals(oper)){
				//调用修改密码功能
				userChangePwd(req,resp);
				
			}else if("show".equals(oper)){
				//调用查看所有用户数据功能
				userShow(req,resp);
				
			}else if("reg".equals(oper)){
				//调用注册
				userReg(req,resp);
				
			}else{
				logger.debug("没有找到对应的操作符:"+oper);
			}
		
		
		
	}
	//注册
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//获取请求
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
		//处理请求
			//调用业务层
				int index=us.userRegService(u);
				System.out.println(index);
		//响应
				if(index>0){
					//获取session对象
					HttpSession hs=req.getSession();
					hs.setAttribute("reg", "true");
					//重定向登陆页面
					resp.sendRedirect("/mg/login.jsp");
				}
	}
	//显示所有用户信息
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理请求
			//调用service
			List<User> lu=us.checkUserShowService();
			if(lu!=null){
				//将查询的数据对象存储到request
				req.setAttribute("lu", lu);
				//请求转发
				req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
				return;
			}
	}
	//用户修改密码
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//获取数据
			String newPwd=req.getParameter("newPwd");
			//获取用户信息
			User u=(User) req.getSession().getAttribute("user");
			int uid=u.getUid();
		//处理请求
			//调用service处理
			int index=us.userChangePwdServlce(newPwd,uid);
			System.out.println(index);
			if(index>0){
				//获取session对象
				HttpSession hs=req.getSession();
				hs.setAttribute("pwd", "true");
				//重定向登陆页面
				resp.sendRedirect("/mg/login.jsp");
			}
	}

	//用户退出
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		//获取session对象
		HttpSession hs=req.getSession();
		//强制销毁session
		hs.invalidate();
		//重定向到登陆界面
		resp.sendRedirect("/mg/login.jsp");
	}

	//处理登陆
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//获取请求信息
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		//处理请求信息
			
			//校验
			User u=us.checkUserLoginService(uname, pwd);
		//响应处理结果
			//直接响应
			//请求转发
			//重定向
			if(u!=null){
				//获取session对象
				HttpSession hs=req.getSession();
				//把用户数据存到session中
				hs.setAttribute("user", u);
				//重定向
				resp.sendRedirect("/mg/main/main.jsp");
				return;
			}else{
				//添加标识符到request中
				req.setAttribute("flag", 0);
				//请求转发
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}
	}
}
