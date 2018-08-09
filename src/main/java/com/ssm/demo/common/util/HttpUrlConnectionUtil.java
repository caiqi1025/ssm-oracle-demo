/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2016.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2016��8��11��    Cai Qi         Create the class
*/

package com.ssm.demo.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @FileName HttpUrlConnectionUtil.java
 * @Description: HttpUrlConnection工具类
 *
 * @Date 2016年8月11日
 * @author Cai Qi
 * @version 1.0
 * 
 */
public class HttpUrlConnectionUtil {
	
	private static Log logger = LogFactory.getLog(HttpUrlConnectionUtil.class);
	
	// 字符编码
	public final static String CHARSET_UTF8 = "UTF-8";
	public final static String CHARSET_GBK = "GBK";
	// 设置连接超时
	private static final int CONNECT_TIMEOUT = 30000;
	// 设置读取数据超时
    private static final int READ_TIMEOUT = 30000;
	
	/**
	 * @Title: postRequest 
	 * @Description: POST请求方法
	 * @param requestUrl
	 * @param paramsStr
	 * @param charset
	 * @return 
	 * @author Cai Qi
	 * @date 2016年8月11日
	 */
	public static String postRequest(String requestUrl, Map<String,Object> paramsMap, String charset) {
		String paramsStr = paramsMapToString(paramsMap);
		// 返回结果
		String result = null;
		HttpURLConnection connection = null;
		OutputStreamWriter out = null;
		BufferedReader br = null;
		try {
			// 创建url对象
			URL url = new URL(requestUrl);
			//打开连接
			connection = (HttpURLConnection) url.openConnection();
			//设置连接参数
			connection.setConnectTimeout(CONNECT_TIMEOUT);
			connection.setReadTimeout(READ_TIMEOUT);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");

			// 输出请求参数
			out = new OutputStreamWriter(connection.getOutputStream(), charset);
			out.write(paramsStr);
			out.flush();
			// 服务器返回数据
			StringBuffer sb = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\r\n");
			}
			result = sb.toString();
		} catch(Exception e) {
			logger.error("【远程访问<HttpUrlConnection>】异常：" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (br != null) {
					br.close();
				}
				if (connection != null) {  
					connection.disconnect();  
	            }  
			} catch (IOException e) {
				logger.error("【远程访问<HttpUrlConnection>】异常：" + e.getMessage());
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * @Title: getRequest 
	 * @Description: GET请求方法
	 * @param requestUrl
	 * @param paramsMap
	 * @param charset
	 * @return 
	 * @author Cai Qi
	 * @date 2016年12月2日
	 */
	public static String getRequest(String requestUrl, Map<String,Object> paramsMap) {
		String paramsStr = paramsMapToString(paramsMap);
		if (StringUtil.isNotEmpty(paramsStr)) {
			requestUrl = requestUrl + "?" + paramsStr;
		}
		// 返回结果
		String result = null;
		HttpURLConnection connection = null;
		BufferedReader br = null;
		try {
			// 创建url对象
			URL url = new URL(requestUrl);
			//打开连接
			connection = (HttpURLConnection) url.openConnection();
			//设置连接参数
			connection.setConnectTimeout(CONNECT_TIMEOUT);
			connection.setReadTimeout(READ_TIMEOUT);
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8"); 
			// 服务器返回数据
			StringBuffer sb = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\r\n");
			}
			result = sb.toString();
		} catch(Exception e) {
			logger.error("【远程访问<HttpUrlConnection>】异常：" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (connection != null) {  
					connection.disconnect();  
	            }  
			} catch (IOException e) {
				logger.error("【远程访问<HttpUrlConnection>】异常：" + e.getMessage());
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * @Title: paramsMapToString 
	 * @Description: 将Map转String
	 * @param paramsMap
	 * @return 
	 * @author Cai Qi
	 * @date 2016年12月2日
	 */
	private static String paramsMapToString(Map<String, Object> paramsMap) {
		if (paramsMap == null || paramsMap.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (String key : paramsMap.keySet()) {
			String value = (String) paramsMap.get(key);
			if (sb.length() < 1) {
				sb.append(key).append("=").append(value);
			} else {
				sb.append("&").append(key).append("=").append(value);
			}
		}
		return sb.toString();
	}
	
	public static void main(String args[]) {
		/*String url = "http://gw.ose.aliyun.com/event/ecoLog";
		String result = HttpUrlConnectionUtil.postRequest(url, "", CHARSET_UTF8);
		JSONObject jsonObject = JSONObject.parseObject(result);
		System.out.println(jsonObject.get("result"));*/
	}
}
