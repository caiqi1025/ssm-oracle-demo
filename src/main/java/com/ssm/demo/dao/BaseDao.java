package com.ssm.demo.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {
	
	/**
	 * 根据条件查询单个对象结果
	 * @param object
	 * @return
	 */
	public T selectUnique(Object object);
	
	/**
	 * 根据条件查询单个对象结果
	 * @param sqlId
	 * @param object
	 * @return
	 */
	public T selectUnique(String sqlId, Object object);
	
	/**
	 * 根据条件查询列表
	 * @param sqlId
	 * @param object
	 * @return
	 */
	public List<T> selectList(String sqlId, Object object);

	/**
	 * 保存实体对象
	 * @param t
	 * @return
	 */
	public int save(T t);
	
	/**
	 * 根据主健删除
	 * @param sqlId
	 * @param pk
	 * @return
	 */
	public int deleteByPK(String sqlId, PK pk);
	
	/**
	 * 根据条件删除
	 * @param pk
	 * @return
	 */
	public int delete(String sqlId, Object object);
	
	/**
	 * 修改实体对象
	 * @param t
	 * @return
	 */
	public int update(T t);
}
