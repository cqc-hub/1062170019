<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  page import = "java.io.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'accept.jsp' starting page</title>
    
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
  <%  try { InputStream in = request.getInputStream() ;  //该函数获取一个输入流，通过这个输入流读入用户上传的全部信息。
		File dir = new File("d:/1oad") ;
		dir. mkdir() ;
		File f = new File(dir, "B.txt") ;
		FileOutputStream o = new FileOutputStream(f) ;
		byte b[]=new byte[1000];
		int n;
		while((n = in.read(b))!=-1)
			o.write(b, 0 , n) ;
		in. close() ;
		o. close() ;
		out. print ("文件已上传");
	}  
	catch(IOException ee) {
		out. print("上传失败"+ee);
	}    
  %>
  </body>
</html>
