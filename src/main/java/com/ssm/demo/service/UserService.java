package com.ssm.demo.service;

import com.ssm.demo.entity.User;

public interface UserService {

	/**
	 * �����û�����ѯ
	 * @param userName
	 * @return
	 */
	public User queryByUserName(String userName);
	
	/**
	 * �����û�IDɾ��
	 * @param userId
	 * @return
	 */
	public int deleteByUserId(Integer userId);
}
