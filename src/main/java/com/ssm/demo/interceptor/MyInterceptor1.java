/*
 * COPYRIGHT. ShenZhen MinSiDa Technology Co., Ltd. 2018.
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
 * 2018年6月29日    Cai Qi         Create the class
*/

package com.ssm.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @FileName MyInterceptor1.java
 * @Description: 拦截器1：实现HandlerInterceptor接口
 *
 * @Date 2018年6月29日 
 * @author Cai Qi
 * @version 1.0
 * 
 */
public class MyInterceptor1 implements HandlerInterceptor {

	private static Log logger = LogFactory.getLog(MyInterceptor1.class);
	
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		logger.info("【拦截器1】................preHandle................");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("【拦截器1】................postHandle................");	
	}

	@Override
	public void afterCompletion(HttpServletRequest requst, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("【拦截器1】................afterCompletion................");
	}
}
