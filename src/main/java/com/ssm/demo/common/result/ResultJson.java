package com.ssm.demo.common.result;

public class ResultJson {

	private boolean success; // 请求状态
	private String code;     // 返回码
	private String message;  // 返回消息
	private Object data;     // 返回数据
	
	public static ResultJson success(String code, String message) {
		ResultJson resultJson = new ResultJson();
		resultJson.setSuccess(true);
		resultJson.setCode(code);
		resultJson.setMessage(message);
		return resultJson;
	}
	
	public static ResultJson success(String code, String message, Object data) {
		ResultJson resultJson = new ResultJson();
		resultJson.setSuccess(true);
		resultJson.setCode(code);
		resultJson.setMessage(message);
		resultJson.setData(data);
		return resultJson;
	}
	
	public static ResultJson fail(String code, String message) {
		ResultJson resultJson = new ResultJson();
		resultJson.setSuccess(false);
		resultJson.setCode(code);
		resultJson.setMessage(message);
		return resultJson;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
