package com.tarena.action;

import com.tarena.dao.DaoFactory;
import com.tarena.dao.LoginDao;
import com.tarena.entity.Admin;

/**
 *	校验登录信息
 */
public class CheckLoginAction 
	extends BaseAction {
	
	//input
	private String adminCode;
	private String password;
	private String userCode;
	//output
	private String errorMsg;
	
	public String execute() {
		//校验验证码
		String imageCode = 
			(String) session.get("imageCode");
		if(userCode == null
				|| !userCode.equalsIgnoreCase(imageCode)) {
			errorMsg = "验证码有误.";
			return "fail";
		}
		
		//查询管理员
		LoginDao dao = DaoFactory.getLoginDao();
		Admin admin = dao.findByCode(adminCode);
		//判断查询结果
		if(admin == null) {
			//结果为空，说明账号不存在，校验失败
			errorMsg = "账号不存在.";
			return "fail";
		} else {
			//结果不为空，说明账号存在，再判断密码
			if(password != null
					&& password.equals(admin.getPassword())) {
				//密码正确，校验成功
				session.put("admin", admin);
				return "success";
			} else {
				//密码错误，校验失败
				errorMsg = "密码错误.";
				return "fail";
			}
		}
	}
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
