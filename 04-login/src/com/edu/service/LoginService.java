package com.edu.service;

import com.edu.pojo.User;

public interface LoginService {
	//校验用户登录信息
	User  checkLoginService(String uname,String pwd );
	//校验用户cookie信息
	User checkUidService(String uid);
	

}
