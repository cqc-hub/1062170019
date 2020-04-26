<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div align="center">
   <form action="bt" method="get">
      用户：<input type="text" name="uname" value="" /><br/>
      密码：<input type="password" name="pwd" value=""/><br/>
      爱好：<input type="checkbox" name="hobit" value="唱"/>唱 &nbsp;&nbsp;
      	<input type="checkbox" name="hobit" value="跳"/>跳&nbsp;&nbsp;
      	<input type="checkbox" name="hobit" value="rap"/>rap&nbsp;&nbsp;<br/>
    <input type="submit" name="submit" value="登陆"><br/>
   
   </form>
   </div>
   
  </body>
</html>
