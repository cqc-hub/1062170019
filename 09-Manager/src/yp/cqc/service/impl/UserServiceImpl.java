package yp.cqc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import yp.cqc.dao.UserDao;
import yp.cqc.dao.impl.UserDaoImpl;
import yp.cqc.pojo.User;
import yp.cqc.service.UserService;

public class UserServiceImpl implements UserService{
	//������־����
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	//����dao�����
	UserDao ud=new UserDaoImpl();
	//�û���¼
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		// TODO Auto-generated method stub
		//��ӡ��־
		logger.debug(uname+"�����½����");
		User u=ud.checkUserLoginDao(uname, pwd);
		//�ж�
		if(u!=null){
			logger.debug(uname+"��½�ɹ�");
		}else{
			logger.debug(uname+"��½ʧ��");
		}
		return u;
	}
	//�޸�����
	@Override
	public int userChangePwdServlce(String newPwd, int uid) {
		// TODO Auto-generated method stub
		logger.debug(uid+":���������޸�����");
		int index=ud.userChangePwdDao(newPwd, uid);
		if(index>0){
			logger.debug(uid+":�����޸ĳɹ�");
		}else{
			logger.debug(uid+":�����޸�ʧ��");
		}
		return index;
	}
	//��ȡ�����û���Ϣ
	@Override
	public List<User> checkUserShowService() {
		// TODO Auto-generated method stub
		List<User> lu=ud.checkUserShowDao();
		logger.debug("��ʾ�����û���Ϣ��"+lu);
		return lu;
	}
	
	//zhuce
	@Override
	public int userRegService(User u) {
		// TODO Auto-generated method stub
		int index=ud.checkUserRegnDao(u);
		return index;
	}

}
