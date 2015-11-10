package com.tarena.dao;

import com.tarena.entity.Admin;

public class LoginDaoImpl implements LoginDao {

	/* 
	 * 模拟实现根据账号查询管理员。
	 * 假设当前管理员表只有一条数据
	 * admin_code=admin,password=123
	 */
	public Admin findByCode(String adminCode) {
		if(adminCode == null) 
			return null;
		
		//模拟查询
		if(adminCode.equals("admin")) {
			Admin a = new Admin();
			a.setId(1);
			a.setAdmin_code("admin");
			a.setPassword("123");
			a.setName("ADMIN");
			a.setTelephone("110");
			a.setEmail("admin@qq.com");
			return a;
		} else {
			return null;
		}
		
	}

}
