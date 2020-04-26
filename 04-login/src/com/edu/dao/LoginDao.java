package com.edu.dao;

import com.edu.pojo.User;

public interface LoginDao {
	//工具用户密码获取用户信息
	User checkLoginDao(String uname,String pwd);
	/*把用户名、密码流转到dao层 ，dao层根据用户密码去数据库里看、查有没这个人
	 * 
	 * 查到数据封装成User对象返回给业务层（service层）
	 * 
	 * service拿到后再次把User对象返回到servlet层
	 * 
	 * servlet判断用户对象到底有还是没有，然后告诉你成功还是失败
	 * 
	 * */
	//根据uid获取用户信息
	User checkUidDao(String uid);
	
}
