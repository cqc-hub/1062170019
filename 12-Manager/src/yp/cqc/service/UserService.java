package yp.cqc.service;

import java.util.List;

import yp.cqc.pojo.User;

public interface UserService {
	/*用户登陆校验
	 * uname
	 * 
	 * pwd
	 * 
	 * return 查询到的用户信息
	*/
	User checkUserLoginService(String uname,String pwd);

	

	int userChangePwdServlce(String newPwd, int uid);


	//获取所有用户信息
	List<User> checkUserShowService();


	//注册
	int userRegService(User u);
	
	
}
