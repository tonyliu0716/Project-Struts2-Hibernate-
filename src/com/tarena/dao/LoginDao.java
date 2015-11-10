package com.tarena.dao;

import com.tarena.entity.Admin;

public interface LoginDao {

	/**
	 * 根据账号查询管理员
	 * @param adminCode
	 * @return
	 */
	Admin findByCode(String adminCode);
	
}
