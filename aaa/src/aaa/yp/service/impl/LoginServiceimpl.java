package aaa.yp.service.impl;

import aaa.yp.dao.LoginDao;
import aaa.yp.dao.impl.LoginDaoimpl;
import aaa.yp.pojo.User;
import aaa.yp.service.LoginService;

public class LoginServiceimpl implements LoginService{
	//����dao�����
	LoginDao ld=new LoginDaoimpl();

	@Override
	public User checkLoginService(String uname,String pwd){
		//������������������ύ�ĸ�ʽУ��
		
		return ld.checkLoginDao(uname, pwd);
	}

	
	
	
}
