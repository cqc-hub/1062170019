<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true" %>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" %>
<%-- 
	jsp的三种注释
			前端语言注释
				会被转译、发送，但是不会被浏览器执行
			java语言注释
				会被转译，但是不会被servlet执行
			jsp注释
				不会被转译
				
	jsp配置指令
		<%@page 属性名="属性值" 属性名="属性值" ... %>
		
		属性作用
			language：声明jsp要被转译的语言（目前只支持java）                      language="java"
			import:声明转译的servlet文件要导入的包，不同包逗号隔开              import="java.util.*,java.lang.*"
			pageEncoding:当前jsp文件所保存的编码格式						pageEncoding="utf-8"
			contentType:jsp数据响应浏览器时，浏览器的解析和编码格式（一般低版本的jsp才q要写）
			session:设置转译的servlet中是否开启session支持，默认开启
			errorPage:设置jsp运行出错时跳转的页面  errorPage="error.jsp"
			extends:jsp跳转的java文件要继承的父类 全限定路径（包名+类名）
			
	jsp的局部代码块<% java代码 %>
			特点：
				局部代码块中声明的java代码会被原样转译到jsp对应的servlet文件中的_JspService方法中
				代码块中声明的变量都是局部变量
			缺点：
				使用局部代码块在jsp中进行逻辑判断，书写麻烦，阅读困难
			
			开发：使用servlet进行请求逻辑处理，jsp进行页面展示
	
	
	jsp的全局代码块<%! 全局代码 %>
			主要用来声明方法和全局变量,转译到对应的servlet类中
			
			全局代码块声明的代码，用局部代码块调用
			
			
	jsp的脚本段语句 <%=变量名or方法 %>   //不要在变量名or方法后面加分号
			特点：
				帮助我们快速获取变量或者方法返回值作为数据返回给浏览器
			位置：除了jsp语法要求以外的任意位子
			
	jsp的静态引入和动态引入
			静态引入（一般用于静态数据的网页）：<%@include file="相对路径" %>
					特点：会将引入的jsp文件和当前的jsp文件转译成一个java（servlet）文件使用，
					在网页中也就显示了合并后的显示效果
					
					注意：静态引入的jsp文件不会单独转译成java文件
						  当前文件和静态引入的文件中不能使用java代码块声明同名变量（与类型无关）
			
			动态引入：<jsp:include page="相对路径"></jsp:include>
					特点：会将引入的jsp文件单独转译，在当前文件转译好的java文件中调用引入的jsp文件的转译
					在网页中显示俩张网页合并后的效果
					
					注意：允许声明同名变量	
			
			优点：降低代码冗余，便于维护升级
	jsp的转发标签forward     jsp:forward page="相对路径"><jsp:param value="aaa" name="str"/></jsp:forward>
			特点：与servlet的request的转发一样，
			一次请求，
			地址栏信息不变
			
			注意：在转发标签的俩个标签中间除了写<jsp:param>子标签外的其他任意字符都会报错
			
	***jsp的九大内置对象:jsp转servlet自动生成的，直接使用即可
			
			pageContext:当前页面的数据共享
				获取其他内置对象
				作用域：当前jsp（除非请求转发）
				注意：一个jsp一个pageContext
			request:一次请求内的servlet的数据共享，范围一次请求
				通过请求转发，将数据流转到下一个servlet
			session：一个用户不同请求数据共享问题，范围一次会话
				将数据从一次请求流转给其他请求（一个用户）
			application：项目内不同用户的数据共享
				servletContext对象，一个项目只有一个，存储用户数据共享，范围项目内
				将数据从一个用户流转给其他用户
				
			response：响应请求处理结果给浏览器对象，设置响应头，重定向
			out：响应对象，jsp内部使用。带有缓冲区的响应对象，效率高于response
			page:代表当前jsp页面的对象，相当于java的this
			cxception:异常对象，存储了当前运行的异常信息
				注意：使用此对象需要在page指令中把 isErrorPage="true" 开启
			config:servletconfig,主要用来获取web.xml数据，完成一些初始化数据读取
			
			
			
	jsp文件路径
		可以用相对路径跳转，但是：
				问题1：资源位置不可更改
				问题2：需要使用。。/进行文件夹跳出，使用麻烦
		绝对路径：
			/虚拟项目名/项目资源路径
		使用jsp自带的全局路径声明
			作用：给资源前面添加项目路径    http://localhost:8080/虚拟项目名/
						
					
 --%>
 
 <html>
 	<head>
 		<title>jsp基本语法学习</title>
 		<meta charset="utf-8"/>
 	</head>
 	<body>
 		<h3>语法学习</h3>
 		<hr>
 		<!-- 局部代码块 -->
 		<%
 			//声明java代码--局部代码块
 			String str="jsp中使用逻辑判断真难受";
 			int a=2;
 			if(a>3){
 				out.write("<b>jsp learning simple</b>");
 			}else{
 			
	 			out.write("<i>"+str+"</i>");
	 			test();
 			}
 		
 		 %>
 		 <br>
 		<%=str %>
 		 <br>
 		<%=test() %>
 		<!-- 全局代码块 -->
 		
 		<%! 
 			int b=5;
 			public String test(){
 				String aa;
 				aa="我是全局代码块声明";
 				System.out.println("我是全局代码块声明");
 				return aa;
 				
 			} 
 		%>
 
 		
 	<!-- jsp的静态引入 -->
 	<%@include file="includeStatic.jsp" %>
 	
 	<!-- jsp的动态引入 -->
 	<jsp:include page="includeActive.jsp"></jsp:include>
 	
<%--  	
 	<!-- jsp的转发forward标签 -->
 	<jsp:forward page="forward.jsp">
 		<jsp:param value="aaa" name="str"/>
 		<jsp:param value="aaabb" name="str1"/>
 	</jsp:forward>
 	
 	 --%>
 	
 	<!-- jsp的九大内置对象 -->
 	<%
 		request.getAttribute("str");
 		String s=request.getParameter("aa");
 	
 	 %>
 	<%=s %>
	<%
 		//response.sendRedirect("forward.jsp");
 	 %>
 	 <br>
 	 <!-- jsp路径 -->
 	 <a href="a/a.jsp">访问a.jsp</a>
 	 <br>
 	  <a href="a/b/b.jsp">访问b.jsp</a>
 	</body>
 	</html>
