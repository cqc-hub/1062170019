package com.edu.service.impl;

import com.edu.dao.LoginDao;
import com.edu.dao.impl.LoginDaoImpl;
import com.edu.pojo.User;
import com.edu.service.LoginService;

public class LoginServiceImpl implements LoginService {
	//创建Dao层过度向
	LoginDao ld=new LoginDaoImpl();
	
	//校验用户登录信息
	@Override
	public User checkLoginService(String uname, String pwd) {
		// TODO Auto-generated method stub
		//可以在这里为了保证数据有效性 进行2次校验
		
		return ld.checkLoginDao(uname, pwd);
	}
	//校验用户cookie信息
	@Override
	public User checkUidService(String uid) {
		// TODO Auto-generated method stub
		return ld.checkUidDao(uid);
	}

}
