<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '9-11.jsp' starting page</title>
    
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
     <form action="load.jsp" method=post name=form >
                    选择要下载的文件：<br>
       <Select name="filePath" size=3>
           <Option Selected value="d:/2000/Hello.java">Hello.java
           <Option value="d:/2000/first.jsp">first.jsp
           <Option value="d:/2000/book.zip">book.zip
           <Option value="d:/2000/A.txt">A.txt
       </Select> 
       <br><input type="submit" value="提交你的选择" >
   </form > 
  </body>
</html>
