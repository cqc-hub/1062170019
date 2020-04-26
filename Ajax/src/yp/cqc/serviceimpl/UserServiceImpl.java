package yp.cqc.serviceimpl;

import yp.cqc.dao.UserDao;
import yp.cqc.daoimpl.UserDaoImpl;
import yp.cqc.service.UserService;
import yp.cqc.vo.User;

public class UserServiceImpl implements UserService{
	//获取dao层对象
	UserDao ud=new UserDaoImpl();
	@Override
	public User getUserInfoService(String name) {
		// TODO Auto-generated method stub
		return ud.getUserInfo(name);
	}

}
