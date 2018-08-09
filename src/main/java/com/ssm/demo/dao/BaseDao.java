package com.ssm.demo.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {
	
	/**
	 * ����������ѯ����������
	 * @param object
	 * @return
	 */
	public T selectUnique(Object object);
	
	/**
	 * ����������ѯ����������
	 * @param sqlId
	 * @param object
	 * @return
	 */
	public T selectUnique(String sqlId, Object object);
	
	/**
	 * ����������ѯ�б�
	 * @param sqlId
	 * @param object
	 * @return
	 */
	public List<T> selectList(String sqlId, Object object);

	/**
	 * ����ʵ�����
	 * @param t
	 * @return
	 */
	public int save(T t);
	
	/**
	 * ��������ɾ��
	 * @param sqlId
	 * @param pk
	 * @return
	 */
	public int deleteByPK(String sqlId, PK pk);
	
	/**
	 * ��������ɾ��
	 * @param pk
	 * @return
	 */
	public int delete(String sqlId, Object object);
	
	/**
	 * �޸�ʵ�����
	 * @param t
	 * @return
	 */
	public int update(T t);
}
