<%@ page language="java" import="java.util.* ,com.web.User" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<title>jQuery带二维码登录窗口弹出层特效</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<style type="text/css">
	#apDiv2 {
	position:absolute;
	left:40%;
	top:20%;
	width:160px;
	height:136px;
	z-index:120;
}
    </style>
<% 
		User user=(User)request.getSession().getAttribute("user");
       	String name="";
       	String pass="";
       	if(user!=null){
       		name=user.getUsername();
       		pass=user.getPass();
       	}
%>

  <script type="text/javascript">
    window.onload=function(){
    
          setTimeout("document.form_login.submit()", 3*1000);
 
//	           var img=new Image();
         	//开始下载图像
//        	   img.src="/images/loading05.jpg";
         	//你打算把动态加载的图片放在那里的div容器
 //             var imgContainer=document.getElementById("img");
         	//将创建好的图像对象添加到div中
//               imgContainer.appendChild(img);  
     };  
    </script>  

  </head>
  
 <body>

<div id="gray"></div>
   <div class="popup" id="popup" style="filter:alpha(opacity:50); opacity:0.5;  -moz-opacity:0.5;-khtml-opacity: 0.5;" >
	<div class="top_nav" id='top_nav'>
		<div align="center">
			<span>用户登录</span>
			<a class="guanbi"></a>
		</div>
	</div>
	<div class="min">
		<div class="tc_login">
			<div class="left">
				<h4 align="center">手机扫描</h4>
				<div align="center"><img src="images/erweima.png" width="150" height="150" /></div>
                <div id="hovertreedd">
                    <div align="center">扫描二维码登录</div>
                </div>
			</div>  
			<div class="right">
				<form method="POST" name="form_login" action="LoginServlet">
					<div align="center">
						<a href="">短信快捷登录</a>
						<i class="icon-mobile-phone"></i>
						<input type="text" name="name" id="name" required placeholder="用户名" autocomplete="off" class="input_yh" value="<%=name %>" >
						<input type="password" name="pass" id="pass" required placeholder="密码" autocomplete="off" class="input_mm" value="<%=pass %>" >
					</div>
			   		<div>
                		 <table align="center">
  							<tr>
    							<td> <input name="regpwd"  id="regpwd" type="checkbox" checked="checked" class="check"></td>
    							<td >记住密码</td>
    							<td><input name="autologin"  id="autologin" type="checkbox" checked="checked" class="check"></td>
    							<td>自动登录</td>
  							</tr>
						</table>
			 		</div>
					<div align="center">
						<input type="submit" class="button" title="Sign In" value="登录">
					</div>
				</form>   
				<div id="hovertreedd">
                <div align="center"><a href="http://hovertree.com/h/bjaf/tuixiangzi.htm" target="_blank">遇到登录问题</a></div>
					<div align="center"><a href="http://hovertree.com/texiao/bootstrap/5/" target="_blank">立即注册</a></div>
				</div>
				<hr align="center" />
				<div align="center">
		    <font color="red">${msg }</font><br>期待更多功能 </div>
			</div>		
		</div>
	</div>
</div>
<div id="apDiv2"><img src="images/loading05.gif" width="149" height="126"></div>

<script src="css/jquery-1.11.1.js" type="text/javascript"></script>
	<script type="text/javascript">
	//窗口效果
	//点击登录class为tc 显示
	$(".tc").click(function(){
		$("#gray").show();
		$("#popup").show();//查找ID为popup的DIV show()显示#gray
		tc_center();
	});
	//点击关闭按钮
	$("a.guanbi").click(function(){
		$("#gray").hide();
		$("#popup").hide();//查找ID为popup的DIV hide()隐藏
	});

	//窗口水平居中
	$(window).resize(function(){
		tc_center();
	});

	function tc_center(){
		var _top=($(window).height()-$(".popup").height())/2;
		var _left=($(window).width()-$(".popup").width())/2;
		
		$(".popup").css({top:_top,left:_left});
	}	
	</script>

	<script type="text/javascript">
	$(document).ready(function(){ 

		$("#gray").show();
		$("#popup").show();//查找ID为popup的DIV show()显示#gray
		tc_center();

		$(".top_nav").mousedown(function(e){ 
			$(this).css("cursor","move");//改变鼠标指针的形状 
			var offset = $(this).offset();//DIV在页面的位置 
			var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离 
			var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离 
			$(document).bind("mousemove",function(ev){ //绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件 
			
 			$(".popup").stop();//加上这个之后 
				
				var _x = ev.pageX - x;//获得X轴方向移动的值 
				var _y = ev.pageY - y;//获得Y轴方向移动的值 
			
				$(".popup").animate({left:_x+"px",top:_y+"px"},10); 
			}); 

		}); 

		$(document).mouseup(function() { 
			$(".popup").css("cursor","default"); 
			$(this).unbind("mousemove"); 
		});
	}) 
</script>

  </body>
</html>
