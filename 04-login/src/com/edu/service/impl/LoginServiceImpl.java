package com.edu.service.impl;

import com.edu.dao.LoginDao;
import com.edu.dao.impl.LoginDaoImpl;
import com.edu.pojo.User;
import com.edu.service.LoginService;

public class LoginServiceImpl implements LoginService {
	//����Dao�������
	LoginDao ld=new LoginDaoImpl();
	
	//У���û���¼��Ϣ
	@Override
	public User checkLoginService(String uname, String pwd) {
		// TODO Auto-generated method stub
		//����������Ϊ�˱�֤������Ч�� ����2��У��
		
		return ld.checkLoginDao(uname, pwd);
	}
	//У���û�cookie��Ϣ
	@Override
	public User checkUidService(String uid) {
		// TODO Auto-generated method stub
		return ld.checkUidDao(uid);
	}

}
