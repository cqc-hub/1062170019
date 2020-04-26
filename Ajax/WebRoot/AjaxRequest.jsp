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
		function ajaxReq(){
			//获取用户请求数据
			var uname=document.getElementById("uname").value;
			var pwd=document.getElementById("pwd").value;
			var data="name="+uname;
			var pd="pwd="+pwd;
			//创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest){
				ajax=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				ajax=new ActiveXObject("Msxml2.XMLHTTP");
			}
			
			
			//覆写onreadystatement函数
			ajax.onreadystatechange=function(){
				//判断ajax状态码
				if(ajax.readyState==4){
					//判断响应状态码
					if(ajax.status==200){
						//获取响应内容
						var result=ajax.responseText;
						//处理响应内容
						alert(result);
					}
					
				
				}
					
			
			}
				
			//发送请求
				//"get"方式：请求实体拼接在url后面
				/* ajax.open("get", "ajax?"+data+"&"+pd);
				ajax.send(null); */
				
				
				//post方式:请求实体需要单独发送
				ajax.open("post", "ajax");
				ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				ajax.send("name=张三&pwd=123");
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
  	<input type="text" name="uname" id="uname" value="" placeholder="请输入姓名"/>
  		<input type="password" name="pwd" id="pwd" value="" placeholder="请输入密码"/>
  	<input type="button" value="测试" onclick="ajaxReq()"/>
  	<div id="showdiv"> </div>
  </body>
</html>
