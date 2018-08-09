package com.ssm.demo.entity;

import java.io.Serializable;

/**
 * 用户实体
 * @author caiqi
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;    // 用户编号
	private String userName;  // 用户名称
	private String password;  // 用户密码
	private String nickname;  // 用户昵称

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", nickname=" + nickname + "]";
	}

}
