package com.ssm.demo.common.util;

public class StringUtil {

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.equals("")) ? true : false;
	}
	
	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ·Ç¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return (str == null || str.equals("")) ? false : true;
	}
}
