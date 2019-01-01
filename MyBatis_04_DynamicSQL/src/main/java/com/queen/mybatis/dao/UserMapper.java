package com.queen.mybatis.dao;

import com.queen.mybatis.bean.User;
/**
 * @since 2017-08-08
 * @author queen 
 * 定义一个UserMapper接口
 *
 */
public interface UserMapper {
	
	/**
	 * 根据ID查询User信息，返回一条记录User
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	
}