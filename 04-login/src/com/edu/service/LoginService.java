package com.edu.service;

import com.edu.pojo.User;

public interface LoginService {
	//У���û���¼��Ϣ
	User  checkLoginService(String uname,String pwd );
	//У���û�cookie��Ϣ
	User checkUidService(String uid);
	

}
