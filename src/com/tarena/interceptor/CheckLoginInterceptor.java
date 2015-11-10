package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.entity.Admin;

/**
 *	登录检查拦截器，用于校验用户是否登录
 */
public class CheckLoginInterceptor 
	implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation ai) 
		throws Exception {
		//从session中获取登录信息
		Map<String,Object> session = 
			ai.getInvocationContext().getSession();
		Admin admin = (Admin) session.get("admin");
		//判断是否登录过
		if(admin == null) {
			//没登录过，踢回到登录页面
			return "login";
		} else {
			//登录过，继续访问Action
			return ai.invoke();
		}
	}

}
