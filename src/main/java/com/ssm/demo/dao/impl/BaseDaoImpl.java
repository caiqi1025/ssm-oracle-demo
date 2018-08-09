package com.ssm.demo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssm.demo.common.util.ReflectGenericUtil;
import com.ssm.demo.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

	public static final String SEPARATOR = ".";
	public static final String SQL_SELECTONE = "selectUnique";
	public static final String SQL_SAVE = "save";   
	public static final String SQL_UPDATE = "update";   
	public static final String SQL_DELETEBYPK = "deleteByPK";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@SuppressWarnings("unchecked")
	public String getNamespace() {
		Class<T> clazz = ReflectGenericUtil.getClassGenricType(this.getClass());
		String nameSpace = clazz.getName();
		return nameSpace;
	}
	
	/**
	 * ����������ѯ����������
	 */
	@Override
	public T selectUnique(Object object) {
		return this.sqlSessionTemplate.selectOne(this.getNamespace() + SEPARATOR + SQL_SELECTONE, object);
	}
	
	/**
	 * ����������ѯ����������
	 */
	@Override
	public T selectUnique(String sqlId, Object object) {
		return this.sqlSessionTemplate.selectOne(this.getNamespace() + SEPARATOR + sqlId, object);
	}
	
	/**
	 * ����������ѯ�б�
	 */
	@Override
	public List<T> selectList(String sqlId, Object object) {
		return this.sqlSessionTemplate.selectList(this.getNamespace() + SEPARATOR + sqlId, object);
	}
	
	@Override
	public int save(T t) {
		return this.sqlSessionTemplate.insert(this.getNamespace() + SEPARATOR + SQL_SAVE, t);
	}
	
	/**
	 * ��������ɾ��
	 */
	@Override
	public int deleteByPK(String sqlId, PK pk) {
		return this.sqlSessionTemplate.delete(this.getNamespace() + SEPARATOR + sqlId, pk);
	}
	
	/**
	 * ��������ɾ��
	 */
	@Override
	public int delete(String sqlId, Object object) {
		return this.sqlSessionTemplate.delete(this.getNamespace() + SEPARATOR + sqlId, object);
	}

	/**
	 * �޸�
	 */
	@Override
	public int update(T t) {
		return this.sqlSessionTemplate.update(this.getNamespace() + SEPARATOR + SQL_UPDATE, t);
	}

}
