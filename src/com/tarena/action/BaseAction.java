package com.tarena.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 *	Action的父类，可以将一些通用的逻辑
 *	封装在这个类中。
 */
public class BaseAction 
	implements SessionAware {
	
	protected Map<String,Object> session;

	/* 
	 * 在Struts2实例化Action之后，它会自动判断
	 * 此Action是否是SessionAware接口类型，如果
	 * 是的话则将创建好的session对象通过该方法
	 * 注入给Action。
	 */
	public void setSession(
		Map<String, Object> session) {
		this.session = session;
	}

}
