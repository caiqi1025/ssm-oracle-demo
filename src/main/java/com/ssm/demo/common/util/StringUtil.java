package com.ssm.demo.common.util;

public class StringUtil {

	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.equals("")) ? true : false;
	}
	
	/**
	 * �ж��ַ����Ƿ�ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return (str == null || str.equals("")) ? false : true;
	}
}
