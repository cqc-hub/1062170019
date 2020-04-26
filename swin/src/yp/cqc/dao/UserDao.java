package yp.cqc.dao;

import javax.xml.registry.infomodel.User;

import yp.cqc.pojo.SwUser;

public interface UserDao {

	SwUser LoginDao(String uname, String pwd);

}
