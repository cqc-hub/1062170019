<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import ="java.io.*" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="upload" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'acceptFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body color = "pink">
	<upload:UpFile subdir="JSP_upload/image" />   <%--JSP_upload是当前的web服务目录 --%>
    <%=message%>                           <%--message是Tag文件返回的对象 --%>
    <br><%=fileName %>上传的效果:         <%--fileName是Tag文件返回的对象 --%>
    <br><image src="image/<%=fileName %>" width=360 height=250>
       </image>
</html>
