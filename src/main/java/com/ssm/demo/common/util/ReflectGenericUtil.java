package com.ssm.demo.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ���䷺�����͹�����
 * (���磺ObjectClass<String,Integer>��StringΪ����0��IntegerΪ����1)
 * @author Cai QI
 *
 */
public class ReflectGenericUtil {
	/**
	 * ��ò��������͵ķ������ͣ�ȡ��һ�������ķ������ͣ���Ĭ��ȥ�ĵ�һ����
	 * @param clazz ����������
	 * @return ��������
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClassGenricType(final Class clazz) {
		return getClassGenricType(clazz, 0);
	}
	
	/**
	 * ���ݲ���������ò��������͵ķ������ͣ���ͨ������ȡ�ã�
	 * @param clazz ����������
	 * @param index ��������
	 * @return ��������
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClassGenricType(final Class clazz, final int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
}
