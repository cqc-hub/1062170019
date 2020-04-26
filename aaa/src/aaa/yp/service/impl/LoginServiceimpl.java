package aaa.yp.service.impl;

import aaa.yp.dao.LoginDao;
import aaa.yp.dao.impl.LoginDaoimpl;
import aaa.yp.pojo.User;
import aaa.yp.service.LoginService;

public class LoginServiceimpl implements LoginService{
	//创建dao层对象
	LoginDao ld=new LoginDaoimpl();

	@Override
	public User checkLoginService(String uname,String pwd){
		//可以在这里进行数据提交的格式校验
		
		return ld.checkLoginDao(uname, pwd);
	}

	
	
	
}
