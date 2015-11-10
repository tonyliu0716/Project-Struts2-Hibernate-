package com.tarena.action;

import com.tarena.dao.CostDao;
import com.tarena.dao.DaoFactory;
import com.tarena.entity.Cost;

/**
 *	打开修改页面
 */
public class ToUpdateCostAction {

	//input
	private int id;
	//output
	private Cost cost;
	
	public String execute() {
		CostDao dao = DaoFactory.getCostDao();
		cost = dao.findById(id);
		return "success";
	}
	
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
