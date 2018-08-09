import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ssm.demo.common.util.HttpUrlConnectionUtil;

public class UserControllerTest {

	/**
	 * 用户登录测试用例
	 */
	@Test
	public void testLogin() {
		String url = "http://127.0.0.1:8080/ssm-oracle-demo/user/login.do";
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("userName", "888888");
		paramsMap.put("password", "888888");
		System.out.println("【用户登录测试用例】请求参数:" + paramsMap.toString());
		String result = HttpUrlConnectionUtil.postRequest(url, paramsMap, "utf-8");
		System.out.println("【用户登录测试用例】返回结果:" +result);
	}
	
	/**
	 * 用户删除测试用例
	 */
	@Test
	public void testDelete() {
		String url = "http://127.0.0.1:8080/ssm-oracle-demo/user/delete.do";
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("userId", "5");
		System.out.println("【用户删除测试用例】请求参数:" + paramsMap.toString());
		String result = HttpUrlConnectionUtil.postRequest(url, paramsMap, "utf-8");
		System.out.println("【用户删除测试用例】返回结果:" + result);
	}
}
