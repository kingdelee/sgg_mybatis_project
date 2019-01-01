package com.zhang.dao;

import com.zhang.domain.User;
public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;

	//更新用户
	public void updateUser(User user)throws Exception;

}
