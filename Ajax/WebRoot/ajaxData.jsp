<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxData.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 使用ajax在当前页面显示查询结果 -->
	<!-- ps: 
			eval:将字符串转为对象
	 -->
	 <script type="text/javascript" src="js/ajaxUntil.js">
<!--

//-->
</script>
	<script type="text/javascript">
		//获取数据
	
		function getData(){
			
			//获取用户请求信息
			var name=document.querySelector("#uname").value;
			//创建ajax引擎对象
			var ajax;
			if(window.XMLHttpRequest){
				ajax=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				ajax=new ActiveXObject("Msxml2.XMLHTTP");
			}
			//覆写onreadystatechange对象
			ajax.onreadystatechange=function(){
				//判断ajax状态码
				if(ajax.readyState==4){
					//判断响应状态码
					if(ajax.status==200){
						//获取响应数据
						var ruselt=ajax.responseText;
						//alert(ruselt);
						eval("var u="+ruselt);//转字符串为对象
						//alert(obj.uid+obj.uname);
						//处理响应数据
							 //获取table对象
							var ta=document.querySelector("#ta");
							//插入新行
							var tr=ta.insertRow(1);
							var cell0=tr.insertCell(0);
							cell0.innerHTML=u.uid;
							
							var cell1=tr.insertCell(1);
							cell1.innerHTML=u.uname;
							
							var cell2=tr.insertCell(2);
							cell2.innerHTML=u.price;
							
							var cell3=tr.insertCell(3);
							cell3.innerHTML=u.loc;
							
							var cell4=tr.insertCell(4);
							cell4.innerHTML=u.desc; 
							
							
							
							
							
					}else if(ajax.status==404){}else if(ajax.status==500){}
				}else{}
			
			}
			//发送请求
			ajax.open("get", "user?name="+name);
			ajax.send(null);
		}
		
		function getData2(){
		
			var name=document.querySelector("#uname").value;
			var data="name="+name;
			myAjax("get", "user", data, function(ajax) {
				//获取请求数据
				var rs=ajax.responseText;
				//处理结果
				alert(rs);
			});
		}
		
		
		
		setTimeout("document.querySelector('#btb').addEventListener('click',getData);",200);
	</script>
  </head>
  	<h3>欢迎访问英雄商店</h3>
  	<hr>
  	英雄名称：<input type="text" placeholder="输入英雄名称" name="uname" id="uname" value="" />
  	<input type="button" value="搜索" id="btb">
  	<hr>
  	<table border="1px" id="ta" width="1000px" >
  		<tr >
  			<td>编号</td>
  			<td>名称</td>
  			<td>价格</td>
  			<td>位置</td>
  			<td>描述</td>
  		</tr>
  	</table>
  <body>
    
  </body>
</html>
