<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'my.jsp' starting page</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<script>
		function getDate(){
			//获取元素对象
			var showdiv=document.querySelector("#showdiv");
			var d=new Date();
			
			showdiv.innerHTML=d.toLocaleTimeString();
		}
	
	</script>
	<style type="text/css">
		#showdiv{
			border:solid 1px;
			width:200px;
			height:100px;
		}
	
	</style>
  </head>
  
  <body>
  	<h3>欢迎登陆403峡谷</h3>
  	<hr>
  	<input type="button" value="测试" onclick="getDate()"/>
  	<div id="showdiv"> </div>
  </body>
</html>
