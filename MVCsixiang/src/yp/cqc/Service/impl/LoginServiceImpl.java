package yp.cqc.Service.impl;

import yp.cqc.Dao.LoginDao;
import yp.cqc.Dao.impl.LoginDaoImpl;
import yp.cqc.Service.LoginService;
import yp.cqc.pojo.User;

public class LoginServiceImpl implements LoginService {
	//����dao�����
	LoginDao ld=new LoginDaoImpl();
	@Override
	public User checkLoginService(String uname, String pwd) {
		// TODO Auto-generated method stub
		
		
		return ld.checkLoginDao(uname, pwd);
	}

	
}
