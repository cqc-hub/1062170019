<%@ page language="java" import="java.util.*,yp.cqc.pojo.*" pageEncoding="utf-8"%>
<!-- 使用传统方式获取作用域数据 -->
<h3>EL表达式学习：使用传统方式获取作用域数据</h3>
<b><%=request.getParameter("uname") %></b>
<hr>
<b><%=request.getAttribute("str") %></b>
<br>
<b><%=((User)request.getAttribute("user")).getAddr().getTown() %></b>
<br>
<!-- ArrayList -->
<b><%=((ArrayList)request.getAttribute("list")).get(2) %></b>

<br>
<b><%=((User)((ArrayList)request.getAttribute("list2")).get(0)).getAddr().getPre() %></b>
<p>还可以这么写(个人感觉这个好点) <br>
<b><%=((ArrayList<User>)request.getAttribute("list2")).get(0).getAddr().getPre() %></b>


<br>
<b><%=((HashMap<String,String>)request.getAttribute("map")).get("c") %></b>

<br>
<b><%=((HashMap<String,User>)request.getAttribute("map2")).get("a").getUname() %></b>




<%--传统方式缺点
	1：需要导包
	2：需要强转
	3：获取数据代码麻烦

	解决：
		使用el表达式：简化获取数据代码
		
		使用方法：
			${expression};
	
 --%>
 
 <!-- 使用EL表达式获取作用域对象数据 -->
 
 
 <h3>EL表达式学习：使用EL表达式获取作用域数据</h3>
<br>
<b>${param.uname}</b>

 <br>
<b>${str}</b>
 
 <br>
<b>${user.addr.town}</b>
 
 
 <br>
<b>${list[2]}</b>
 
 <br>
<b>${list2[0].addr.pre}</b>


 <br>
<b>${map.c }</b>
<hr>
<h3>-- EL作用域查找顺序 </h3>

<%
	pageContext.setAttribute("hello","hello pagecontext");
	request.setAttribute("hello","hello request");
	session.setAttribute("hello","hello session");
	application.setAttribute("hello","hello application");
	
 %>

${hello }

 
<hr>
指定作用域查找
<br>
${pageScope.hello}--${requestScope.hello }--${sessionScope.hello }--${applicationScope.hello}


<hr>
<h3>EL逻辑运算</h3>

<% 

	request.setAttribute("a", 3);
	request.setAttribute("b", 6);
%>

${a+b }--${1+2 }--${4/2 }--${6-2 }--${a%b }

<hr>
<!-- EL空值判断 -->
<h3>EL空值判断</h3>
<% 

	request.setAttribute("s", "");
	request.setAttribute("s1", new User());
	request.setAttribute("s2", new ArrayList());
	request.setAttribute("s3", new HashMap());
	
%>

${empty s }-----${empty s1 }-----${empty s2 }---${empty s3 }


<!-- 请求头数据 -->
<hr>
${header}
<p>--------------------
<br>
${header["host"]}




<!-- 获取cookie数据 -->

<hr>
${cookie}
<p>--------------------
${cookie.JSESSIONID}

