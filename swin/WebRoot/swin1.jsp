<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/jquery-3.4.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" href="css/app.css">
		<script>
			$(function(){
				
				
				$("#ulogin").click(function(){
					$("#login").modal("toggle");
				});
				$("#resp-navbar").on("show.bs.collapse",function(){
					consele.log("111");
				});
				$("#mycarousel").carousel({
				    interval:3000,
				
				});
				
				
			});
		</script>
	</head>
	<body>
		<%HttpSession hs=request.getSession(); %>
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<a href="#" class="navbar-brand">logo</a>
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#resp-navbar" >
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							
						</button>
					</div>
					
					<div class="collapse navbar-collapse" id="resp-navbar" >
						<ul class="nav navbar-nav " id="mytab">
							<li class="active"><a href="#home" data-toggle="tab">home</a></li>
							<li><a href="#tab2" data-toggle="tab">tab2</a></li>
							<li><a href="#tab3" data-toggle="tab">3</a></li>
							
						</ul>
						<div class="navbar-right ">
							<p class="navbar-text hidden-xs">您好,<a href="#" class="navbar-link">cqc</a></p>
							<ul class="nav navbar-nav ">
								<li><a href="#"  id="ulogin">登陆</a></li>
								<li><a href="#">注册</a></li>
							</ul>
						</div>
						
						
						
						<form action="" class="navbar-form navbar-right">
							<input type="text" class="form-control" placeholder="搜索">
							<button type="submit" class=""><span class="glyphicon glyphicon-search"></span></button>
						</form>
						
					</div>
					
					
					
				</div>
			</nav>
			<div class="modal fade " id="login" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span>&times;</span>
							</button>
							<h4 class="modal-title">用户登录</h4>
						</div>
						<div class="modal-body">
							 <form role="form" class="form-horizontal" method="get" action="login">
							<!--            form-horizontal 水平表单-->
										<div class="form-group">
										    <label class="col-sm-2 control-label">身份</label>
										    <div class="col-sm-8">
												<div class="col-sm-4">
													<label>
													 <input type="radio" class="" name="leixin" value="" checked="checked">运动员
													 </label>
												</div>
										       <div class="col-sm-4">
										       	<label>
										       	 <input type="radio" class="" name="leixin" value="">教练
										       	 </label>
										       </div>
											   <div class="col-sm-4">
											   	<label>
											   	 <input type="radio" class="" name="leixin" value="">管理员
											   	 </label>
											   </div>
										    </div>
										</div>
							            <div class="form-group">
							                <label class="col-sm-2 control-label">用户名</label>
							                <div class="col-sm-8">
							                    <input type="text" class="form-control" placeholder="enter user name" name="uname">
							                </div>
							
							
							            </div>
							            <div class="form-group">
							                <label class="col-sm-2 control-label">密码</label>
							                <div class="col-sm-8">
							                    <input type="password" class="form-control" placeholder="enter password" name="pwd">
							                </div>
							            </div>
										
							            <div class="form-group">
							                <div class="col-sm-10 col-sm-offset-2">
							                    <div class="checkbox">
							                        <label>
							                            <input type="checkbox">记住密码
							                        </label>
							                    </div>
							                </div>
							            </div>
							
							            <div class="form-group">
							                <div class="col-sm-10 col-sm-offset-2">
							                    <label>
							                        <input type="submit" class="btn btn-default" value="登陆">
							                    </label>
							                </div>
							            </div>
										
							        </form>
						</div>
						<!-- <div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
						</div> -->
					</div>
				</div>
			</div>
			
		
			
			
			<div class="container">
			<div class="starter">
				
				
					<div class="tab-content">
						<div class="tab-pane fade in active" id="home">
							
							<div class="lbt   "  style:"border:1px solid #eee">
								<div class="carousel slide" id="mycarousel">
									<div class="carousel-inner">
										<!-- .carousel-inner 带有一种响应式的结构 -->
										<div class="item active">
											<img src="img/a1.jpg" >
										</div>
										
										<div class="item">
											<img src="img/a2.png"  >
										</div>
										
										<div class="item">
											<img src="img/a3.png"  style="">
										</div>
									</div>
									<a href="#mycarousel" class="left carousel-control" data-slide="prev">
										<span class="glyphicon glyphicon-chevron-left"></span>
									</a>
									
									
									<a href="#mycarousel" class="right carousel-control" data-slide="next">
										<span class="glyphicon glyphicon-chevron-right">
											
										</span></a>
										
									<ul class="carousel-indicators">
										<li data-target="#mycarousel" data-slide-to="0" class="active"></li>
										<li data-target="#mycarousel" data-slide-to="1"></li>
										<li data-target="#mycarousel" data-slide-to="2"></li>
									</ul>
									
								</div>
							</div>
								
							
							
							
							   
						</div>
						<div class="fade tab-pane" id="tab2">
							<button type="button" data-toggle="collapse" data-target="#cc">111</button>
							
							fdslkl
							
								<p class="collapse" id="cc">fdslkfnbkdjhgjkl</p>
							
							
							
							
						</div>
				
							
						</div>
					</div>
					</div>
					    
				
			</div>
			
		
	</body>
</html>
