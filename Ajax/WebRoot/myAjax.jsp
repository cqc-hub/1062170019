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
			//创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest){//基本上的新版本浏览器都支持这个
				ajax=new XMLHttpRequest();
			}else if(window.activeXObject){//早期版本浏览器
				ajax=new activeXObject("Msxml2.XMLHTTP");
			}
			//覆写onredaystatement函数
			ajax.onreadystatechange=function(){
				//判断ajax状态码
				if(ajax.readyState==4)
				{
					//判断响应状态码
					if(ajax.status==200){
						//获取响应内容
						var result=ajax.responseText;
						//alert(ajax.readyState);
						//获取元素对象
						var showdiv=document.querySelector("#showdiv");
		
						showdiv.innerHTML=result;
					}else if(ajax.status==404){
						var showdiv=document.querySelector("#showdiv");
						showdiv.innerHTML="请求资源不存在";
					}else if(ajax.status==500){
						var showdiv=document.querySelector("#showdiv");
						showdiv.innerHTML="服务器繁忙";
					}
					
				
				}else{
						var showdiv=document.querySelector("#showdiv");
						showdiv.innerHTML="<img src='img/2.gif' width='50px' height='50px'>";
				}
			}
			//发送请求
			ajax.open("get", "ajax",true);
			/*ajax.open(method, uri,async);
				async:设置ajax是同步还是异步
					默认true异步：一个线程，遇到一个事件会创建一个子线程进行等待，主线程继续下走
					false同步:一个线程，遇到一个事件会等待这个事件执行完毕才向下走
					
			 */
			ajax.send(null);
			alert("hhh...");
			
			
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
