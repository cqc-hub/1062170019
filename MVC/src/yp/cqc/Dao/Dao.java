package yp.cqc.Dao;

import yp.cqc.pojo.User;

public interface Dao {

	User checkLoginDao(String uname,String pwd);
}
