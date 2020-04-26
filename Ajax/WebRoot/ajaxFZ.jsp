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
		/*
			method:请求发送，值为"get"、"post"
					
			url:请求地址
					
			data:没有值需要传入null
					有请求数据则传入字符串数据，格式为"a=1&b=2"
					
			deal200:接受一个带有形参的js函数对象，接受的形参为ajax引擎对象
			dead404；接受一个sj函数对象	
			dead500；接受一个sj函数对象			
		
		*/
		
		
		function myAjax(method,url,data,deal200,deal404,deal500,async){
			
			
			var ajax=getAjax();
			
			
			
			//覆写onredaystatement函数
			ajax.onreadystatechange=function(){
				//判断ajax状态码
				if(ajax.readyState==4)
				{
					//判断响应状态码
					if(ajax.status==200){
						if(deal200){
							deal200(ajax);
						}
						
					}else if(ajax.status==404){
						if(deal404){
							deal404();
						}
						
					}else if(ajax.status==500){
						if(deal500){
							deal500();
						}
						
					}
					
				
				}
			}
			//发送请求
			if(method=="get"){
				ajax.open("get", url+(data==null?"":"?"+data),async);
				ajax.send(null);
			}else if(method=="post"){
				ajax.open("post", url,async);
				ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				ajax.send(data);
			}
			
			
		}
		
		
		myAjax("get","ajax",null,function(a){},async);
		
		/* ---------------------------------------------------------------------- */
		function getAjax(){
			//创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest){//基本上的新版本浏览器都支持这个
				ajax=new XMLHttpRequest();
			}else if(window.activeXObject){//早期版本浏览器
				ajax=new activeXObject("Msxml2.XMLHTTP");
			}
			return ajax;
		}
		function deal200(a){
		//获取响应内容
						var result=a.responseText;
						//alert(ajax.readyState);
						//获取元素对象
						var showdiv=document.querySelector("#showdiv");
		
						showdiv.innerHTML=result;
		
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
