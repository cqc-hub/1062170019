package yp.cqc.Dao;

import yp.cqc.pojo.User;

public interface LoginDao {
	
	User checkLoginDao(String uname,String pwd);

}
