package yp.cqc.dao;

import java.util.List;

import yp.cqc.pojo.User;

public interface UserDao {
	/*
	 * �����û����������ѯ�û���Ϣ
	 * 
	 * return ��ѯ�����û���Ϣ
	 */
	
	User checkUserLoginDao(String uname,String pwd);

	//�޸�����

	int userChangePwdDao(String newPwd, int uid);

	//��ȡ�����û���Ϣ
	List<User> checkUserShowDao();
	//ע��
	int checkUserRegnDao(User u);
}
