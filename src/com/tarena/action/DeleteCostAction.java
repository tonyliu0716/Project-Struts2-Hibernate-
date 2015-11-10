package com.tarena.action;

import com.tarena.dao.CostDao;
import com.tarena.dao.DaoFactory;

public class DeleteCostAction {

	//input
	private int id;
	
	public String delete() {
		CostDao dao = DaoFactory.getCostDao();
		dao.delete(id);
		return "success";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
