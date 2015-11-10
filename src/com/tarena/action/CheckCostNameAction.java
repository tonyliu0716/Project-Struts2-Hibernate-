package com.tarena.action;

import java.util.HashMap;
import java.util.Map;

import com.tarena.dao.CostDao;
import com.tarena.dao.DaoFactory;
import com.tarena.entity.Cost;

/**
 *	校验资费名是否重复
 */
public class CheckCostNameAction {

	//input
	private String name;
	//output
	private Map<String,Object> info = 
		new HashMap<String,Object>();
	
	public String execute() {
		//根据名称查询资费数据
		CostDao dao = DaoFactory.getCostDao();
		Cost cost = dao.findByName(name);
		//判断是否重复
		if(cost == null) {
			//没有重复，给予正确提示
			info.put("repeat", false);
			info.put("message", "资费名有效.");
		} else {
			//重复了，给予错误提示
			info.put("repeat", true);
			info.put("message", "资费名已存在.");
		}
		return "success";
	}
	
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
