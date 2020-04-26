<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import ="java.io.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '9-10.jsp' starting page</title>
    
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
    <P>选择要上传的文件：<br>
 	<form action="acceptFile.jsp" method="post" enctype="multipart/form-data">
     	<input type=File name="boy" size="50"> 
     	<br> <input type="submit" name ="boy" value="提交">
 	</form >
  </body>
</html>
