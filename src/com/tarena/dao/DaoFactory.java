package com.tarena.dao;

/**
 *	DAO工厂，用于创建DAO接口的实例。
 *	目的是让业务组件通过这里方法直接获取接口实例，
 *	不需要自己new实现类，可以将业务组件与DAO
 *	实现类解耦，方便将来置换掉DAO的实现类。
 */
public class DaoFactory {
	
	private static CostDao costDao = 
		new CostDaoImpl();
	
	private static LoginDao loginDao = 
		new LoginDaoImpl();
	
	/**
	 * 创建资费DAO接口实例
	 */
	public static CostDao getCostDao() {
		return costDao;
	}
	
	/**
	 * 创建登录DAO接口实例
	 */
	public static LoginDao getLoginDao() {
		return loginDao;
	}

}
