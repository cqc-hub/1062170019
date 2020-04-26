package yp.cqc.dao;

import java.util.List;

import yp.cqc.pojo.User;

public interface UserDao {
	/*
	 * 根据用户名，密码查询用户信息
	 * 
	 * return 查询到的用户信息
	 */
	
	User checkUserLoginDao(String uname,String pwd);

	//修改密码

	int userChangePwdDao(String newPwd, int uid);

	//获取所有用户信息
	List<User> checkUserShowDao();
	//注册
	int checkUserRegnDao(User u);
}
