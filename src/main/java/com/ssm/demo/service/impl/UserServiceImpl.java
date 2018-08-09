package com.ssm.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.demo.dao.UserDao;
import com.ssm.demo.entity.User;
import com.ssm.demo.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User queryByUserName(String userName) {
		return this.userDao.selectUnique("queryByUserName", userName);
	}

	@Override
	public int deleteByUserId(Integer userId) {
		return this.userDao.deleteByPK("deleteByUserId", userId);
	}

}
