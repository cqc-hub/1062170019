<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxXML.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function getXML(){
			//创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest){
				ajax=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				ajax=new ActiveXObject("Msxml2.XMLHTTP");
			}
			//复写onreadychange
			ajax.onreadystatechange=function(){
				if(ajax.readyState==4){
					if(ajax.status==200){
						//获取请求
						var doc=ajax.responseXML;
						//处理请求
						alert(doc.getElementsByTagName("name")[0].innerHTML);
						console.log(doc);
						
					
					}
				
				}
			
			}
			//发送请求
			ajax.open("get", "xml");
			ajax.send(null);
		
		}
	
	
	</script>
  </head>
  
  <body>
  	 <h3>XML数据格式学习</h3>
  	 <hr>
  	 <input type="button" value="测试xml" onclick="getXML()">
  </body>
</html>
