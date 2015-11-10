package com.tarena.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tarena.util.HibernateUtil;

//保证在视图层Session开启，视图层执行结束后，再关闭session
public class OpenSessionInViewInterceptor implements Interceptor{

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {

	}
	
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//调用action及result，相当于执行了视图层
		ai.invoke();
		
		//在此关闭session，就是在视图层执行之后关闭
		HibernateUtil.close();
		return null;
	}
	
}
