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
 *   获取jsp作用域的数据
*/
public class ELServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求、响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		
		//处理请求信息
		System.out.println(uname+":"+pwd);
		//响应处理结果
			//直接响应
			//使用request作用域进行数据流转
				//普通字符串
				req.setAttribute("str", "今天天气真好");
				//对象类型
				User u=new User(1,"柳岩","拍电影",new Address("河南","商丘", "虞城县"));
				req.setAttribute("user", u);
				//集合类型
					//list集合
						//存储普通字符
						List<String> list=new ArrayList<String>();
						list.add("张家辉");
						list.add("关晓彤");
						list.add("刘诗诗");
						req.setAttribute("list", list);
						
						//存储对象
						List<User> list2=new ArrayList<User>();
						User u2=new User(2, "古力娜扎","拍电影", new Address("新疆","乌鲁木齐","乌鲁木齐"));
						list2.add(u2);
						req.setAttribute("list2", list2);
					//map集合
						//存储普通字符
						Map<String,String> map=new HashMap<String,String>();
						map.put("a", "北京");
						map.put("b", "shanghai");
						map.put("c", "大都会");
						req.setAttribute("map", map);
						
						//存储对象
						Map<String,User> map2=new HashMap<String,User>();
						map2.put("a", u2);
						req.setAttribute("map2", map2);
			//请求转发
			req.getRequestDispatcher("/el.jsp").forward(req, resp);
			return;
			 
			

			//重定向
		
	}
}
