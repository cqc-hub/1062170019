package yp.cqc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import yp.cqc.pojo.SwUser;
import yp.cqc.service.SwService;
import yp.cqc.service.impl.SwServiceImpl;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	String uname=req.getParameter("uname");
    	String pwd=req.getParameter("pwd");
    	//System.out.println(uname+":"+pwd);
    	SwService ss=new SwServiceImpl();
    	SwUser u=ss.LoginService(uname,pwd);
    	System.out.println(u);
    	if(u!=null){
    		HttpSession hs=req.getSession();
    		hs.setAttribute("user",u);
    	}
    	
    }

}
