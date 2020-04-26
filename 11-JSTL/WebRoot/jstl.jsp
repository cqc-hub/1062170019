<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	教程地址：www.runoob.com/jsp/jsp-jstl.html
	JSTL:
		作用：提高在jsp中的逻辑代码编写效率
		
		使用：
			jstl的核心标签库（重点）
			jstl的格式化标签库
			jstl的sql标签库
			jstl的函数标签库
			jstl的xml标签库
		
		
		
		
		jstl的核心标签库（重点）：
						1、导入jar包
						2、声明jstl标签库的引入（核心标签库）
							<%@taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
						3、完成内容
								基本标签：---------------
									<c:out value="数据" default="默认值"></c:out>   
									//将数据输出给客户端，数据可以是常量值也可以是el表达式
									
									<c:set var="键名" value="数据" scope="放在哪个作用域"></c:set>
									//存储数据到作用域对象中(page request session application)
									
									<c:remove var="键名" scope="指定作用域" />
									//删除某个作用域内的键的数据         scope可选不写（不写则在四个作用域内符合要求的数据全部删除）
								
								逻辑标签:--------------------
									<c:if test="${表达式}">
										前端代码
									</c:if>
									//单分支判断（没有else if）,(依赖el表达式,涉及到的数据必须从作用域中获取)
									
									
									<c:choose>
										<c:when test="${表达式}"></c:when>
										<c:when test="${表达式}"></c:when>
										<c:otherwise></c:otherwise>
									</c:choose>
									//多分支判断   (<c:otherwise></c:otherwise>)相当于else
									
									

--%>
<%
	request.setAttribute("str", "今天天气真好，适合学习");
	//request.setAttribute("hello", "hello request");
 %>
 <h3>基本标签：---------------</h3>
<c:out value="哈哈"></c:out>-----哈哈--${str }
<hr>
<c:out value="${str2 }" default="嘿嘿"></c:out>



<c:set  var="hello" value="hello pagecontext" scope="page"></c:set>
<c:set  var="hello" value="hello request" scope="request"></c:set>
<c:set  var="hello" value="hello session" scope="session"></c:set>
<c:set  var="hello" value="hello application" scope="application"></c:set>

<p><c:out value="${applicationScope.hello} "></c:out>




<hr>

<c:remove var="hello" scope="page"/>
<p><c:out value="${hello} "  ></c:out>------

 <h3>逻辑标签：---------------</h3>
<!--传统方式  -->
<%
	int a=4;
	if(a>3){
%>
<b>今天天气有点热</b>

<%
	}
 %>--------------------
 <!-- jstl方式 -->
 <c:set var="a" value="4"></c:set>
 <c:if test="${a>3 }">
 	<b>今天天气有点冷</b>(依赖el表达式)
 </c:if>

<hr>
<c:set var="score" value="98"></c:set>
<c:choose>
	<c:when test="${score>90 }"><i>奖励吃鸡装备一套 </i></c:when>
	<c:when test="${score>80&&score<=90}"><i>奖励空投箱</i></c:when>
	<c:otherwise><i>男女混合双打</i></c:otherwise>
</c:choose>




<h3>jstl循环标签</h3>
<!-- 传统方式表格 -->

table>tr*3>td*4

<table border="1px">
  <tr>
    <td>课程名称</td>
    <td>教师</td>
    <td>价格</td>
    <td>重要性</td>
  </tr>
  <% for(int i=0;i<3;i++){ 
  		if(i==2){
  %>
  	
    <tr>
   	<td>java</td>
    <td>詹老师</td>
    <td>不要钱</td>
    <td>非常重要</td>
  </tr>
  <%}} %>
    <tr>
    <td>python</td>
    <td>詹老师</td>
    <td>不要钱</td>
    <td>很重要</td>
  </tr>
</table>
		
		
<hr>
<h3>使用jstl循环</h3>	<br>
<%
	ArrayList<String> list=new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	
	HashMap<String,String> map=new HashMap<String,String>();
	map.put("a1", "哈哈哈");
	map.put("a2", "嘿嘿嘿");
	map.put("a3", "呵呵呵");
	map.put("a4", "哒哒哒");
	
	request.setAttribute("list", list);
	request.setAttribute("map", map);
 %>

<!-- 常量循环 -->
<c:forEach begin="0" end="4" step="1" varStatus="vs">
	1111--${vs.index }--${vs.count }--${vs.first }--${vs.last }</br>

</c:forEach>																												
<hr>
<!--  -->
<!-- 动态循环 -->
<c:forEach items="${list }" var="str" >
${str }<br>

</c:forEach>	

<br>
<table border="1px">
  <tr>
    <td>课程名称</td>
    <td>教师</td>
    <td>价格</td>
    <td>重要性</td>
  </tr>

<c:forEach items="${list }" var="ss">
	 <tr>
    <td>${ss }</td>
    <td>${ss }</td>
    <td>${ss }</td>
    <td>${ss }</td>
  </tr>
</c:forEach>

   
</table>

<!-- 遍历map集合 -->

<c:forEach items="${map }" var="m">

${m.key}-------${m.value }<br>

</c:forEach>

<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
           
<c:set var="d" value="<%=new Date() %>"></c:set>  
<br>
<p> 格式化日期：<fmt:formatDate value="${d }" type="time"/>
<p> 格式化日期：<fmt:formatDate value="${d }" pattern="yyyy年MM月dd日HH：mm：ss"/>

<p><fmt:formatNumber value="120000.2309" type="currency"></fmt:formatNumber>

    
     
