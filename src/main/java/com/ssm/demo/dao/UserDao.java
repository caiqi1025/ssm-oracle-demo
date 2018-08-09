package com.ssm.demo.dao;

import java.util.Map;

import com.ssm.demo.entity.User;

public interface UserDao extends BaseDao<User, Integer> {

	/**
	 * �����û�����ѯ
	 * @param paramsMap
	 * @return
	 */
	public User queryByUserName(Map<String,Object> paramsMap);
	
}
