package yp.cqc.Service.impl;

import yp.cqc.Dao.Dao;
import yp.cqc.Dao.impl.DaoImpl;
import yp.cqc.Service.MyService;
import yp.cqc.pojo.User;

public class ServiceImpl implements MyService{
	Dao da=new DaoImpl();
	@Override
	public User checkLoginService(String uname, String pwd) {
		// TODO Auto-generated method stub
		
		return da.checkLoginDao(uname, pwd);
	}

	
}
