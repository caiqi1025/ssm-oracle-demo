package com.ssm.demo.service;

import com.ssm.demo.entity.User;

public interface UserService {

	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public User queryByUserName(String userName);
	
	/**
	 * 根据用户ID删除
	 * @param userId
	 * @return
	 */
	public int deleteByUserId(Integer userId);
}
