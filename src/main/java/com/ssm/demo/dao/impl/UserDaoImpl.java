package com.ssm.demo.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ssm.demo.dao.UserDao;
import com.ssm.demo.entity.User;

@Repository("UserDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	/*@Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }*/
	
	@Override
	public User queryByUserName(Map<String,Object> paramsMap) {
		//return this.getSqlSession().selectOne("com.ssm.demo.entity.UserDao.queryByUserName", userName);
		return this.selectUnique(paramsMap);
	}
	

}
