package yp.cqc.service;

import java.util.List;

import yp.cqc.pojo.User;

public interface UserService {
	/*�û���½У��
	 * uname
	 * 
	 * pwd
	 * 
	 * return ��ѯ�����û���Ϣ
	*/
	User checkUserLoginService(String uname,String pwd);

	

	int userChangePwdServlce(String newPwd, int uid);


	//��ȡ�����û���Ϣ
	List<User> checkUserShowService();


	//ע��
	int userRegService(User u);
	
	
}
