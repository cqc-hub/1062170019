function chkUsername() {
 var username = $.trim($("#username").val());
 if(username=="") {
  return 0;
 }
 else if( /^\d.*$/.test( username ) ){
  //用户名不能以数字开头
  return -1;
 }
 else if(username.length<4 || username.length>18 ){
  //合法长度为4-18个字符
  return -2;
 }
  else if(! /^[\u4E00-\u9FA5\uf900-\ufa2d\w]{4,18}$/.test( username ) ){
  //用户名只能包含中文、英文、数字、下划线、4-18个字符。
   return -3;
 }
 else if(! /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]*$/.test( username ) ){
  //用户名只能英文字母和中文开头
  return -4;
 }
 else if(!(/[0-9a-zA-Z]+$/.test( username ))){
  //用户名只能英文字母或数字结尾
  return -5;
 }
  return 1;
}
 
$(document).ready(function(){
  /** ----------- 用户名输入框事件 ----------- */
  //当文本框成为焦点时
  $("#username").bind("focus", function(){
  var ret=chkUsername();
  if(ret==0){
  //用户名输入框为空,显示规则
   $("#div_uname_err_info").hide();
   $("#div_uname_rule").show();  
   document.form1.user_name.focus();
  }
  return false;
  }); 
  
  //当文本框失去焦点时
  $("#username").bind("blur", function(){
   var ret=chkUsername();
   $("#div_uname_rule").hide();
   $("#div_uname_err_info").show();
   
   var name = $.trim($("#username").val());
   if (ret>0){

	   $.ajax({
		    url : "UserVerify", //后台查询验证的方法
		    data : { "username" : name },    //携带的参数
		    type : "post",
		    success : function(data) {   //根据后台返回前台的msg给提示信息加HTML
		    	if(data=="true")  
	   		    {
		    		$("#div_uname_err_info").html("你输入的用户名已经存在，请重新输入！");
		    	    document.form1.user_name.focus();
	   		    }
	   		  	else
	   		  		$("#div_uname_err_info").hide();
		    }
	   });
   }
   else if(ret==0){
   //用户名输入框为空,显示规则
    $("#div_uname_err_info").html("用户名不能为空");  
    document.form1.user_name.focus();
   } 
   else {
    if(ret == -1){
     //显示具体的错误内容
     $("#div_uname_err_info").html("用户名不能以数字开头");
    }
    else if(ret == -2){
     $("#div_uname_err_info").html("合法长度为4-18个字符");
    }
    else if(ret == -3){
     $("#div_uname_err_info").html("用户名只能包含中文、英文、数字、下划线这4-18个字符。 ");
    }
    else if(ret == -4){
     $("#div_uname_err_info").html("用户名只能英文字母和中文开头");
    }
    else if(ret == -5){
     $("#div_uname_err_info").html("用户名只能英文字母或数字结尾");
    }
    document.form1.user_name.focus();
   }
   return false;
  }); 
  
  /** ----------- 确认密码输入框事件 ----------- */
  //当文本框失去焦点时
  $("#password2").bind("blur", function(){
	  if ($("#password2").val()!=$("#password").val())
      {
         window.confirm("对不起，确认密码与密码不一致！");
         document.form1.password.focus();
      }
  });
   
});
