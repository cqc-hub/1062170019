package com.edu.dao;

import com.edu.pojo.User;

public interface LoginDao {
	//�����û������ȡ�û���Ϣ
	User checkLoginDao(String uname,String pwd);
	/*���û�����������ת��dao�� ��dao������û�����ȥ���ݿ��￴������û�����
	 * 
	 * �鵽���ݷ�װ��User���󷵻ظ�ҵ��㣨service�㣩
	 * 
	 * service�õ����ٴΰ�User���󷵻ص�servlet��
	 * 
	 * servlet�ж��û����󵽵��л���û�У�Ȼ�������ɹ�����ʧ��
	 * 
	 * */
	//����uid��ȡ�û���Ϣ
	User checkUidDao(String uid);
	
}
