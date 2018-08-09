package com.ssm.demo.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.demo.common.constant.Const;
import com.ssm.demo.common.result.ResultJson;
import com.ssm.demo.common.util.StringUtil;
import com.ssm.demo.entity.User;
import com.ssm.demo.service.UserService;

/** 
 * @FileName: UserController.java
 * @Description: 用户管理
 *
 * @author caiqi
 * @date 2018年3月19日
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static Log logger = LogFactory.getLog(UserController.class);
	private @Resource UserService userService;
	
	/**
	 * @Title: index 
	 * @Description: 进入首页
	 * @return 
	 * @author Cai Qi
	 * @date 2018年6月29日
	 */
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		try {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			mv.addObject("message", "你好，欢迎！");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login")
	public ResultJson login(@RequestParam String userName, @RequestParam String password) {
		logger.info("【用户登录】请求参数: userName=" + userName + ",password=" + password);
		try {
			/**
			 * 参数校验
			 */
			if (StringUtil.isEmpty(userName)) {
				return ResultJson.fail(Const.FAILURE_CODE, "请输入用户名!");
			} 
			if (StringUtil.isEmpty(password)) {
				return ResultJson.fail(Const.FAILURE_CODE, "请输入密码!");
			}
			/**
			 * 根据用户名查询
			 */
			User user = this.userService.queryByUserName(userName);
			if (user == null) {
				return ResultJson.fail(Const.FAILURE_CODE, "用户不存在!");
			}
			/**
			 * 验证密码是否正确
			 */
			if (password.equals(user.getPassword())) {
				return ResultJson.success(Const.SUCCESS_CODE, "用户登录成功!");
			} else {
				return ResultJson.fail(Const.FAILURE_CODE, "用户密码错误!");
			}
		} catch (Exception e) {
			logger.error("【用户登录】系统错误: " + e.getMessage());
			return ResultJson.fail(Const.FAILURE_CODE, "系统错误：" + e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete")
	public ResultJson delete(@RequestParam String userId) {
		logger.info("【用户删除】请求参数: userId=" + userId);
		try {
			if (StringUtil.isEmpty(userId)) {
				return ResultJson.fail(Const.FAILURE_CODE, "请输入删除用户ID!");
			} 
			/**
			 * 根据用户ID删除
			 */
			int result = this.userService.deleteByUserId(Integer.parseInt(userId));
			if (result > 0) {
				return ResultJson.success(Const.SUCCESS_CODE, "用户删除成功!");
			} else {
				return ResultJson.fail(Const.FAILURE_CODE, "用户删除失败!");
			}
		} catch (Exception e) {
			logger.error("【用户删除】系统错误: " + e.getMessage());
			return ResultJson.fail(Const.FAILURE_CODE, "系统错误：" + e.getMessage());
		}
	}
}
