package com.tarena.action;

import java.util.List;
import com.tarena.dao.CostDao;
import com.tarena.dao.DaoFactory;
import com.tarena.entity.Cost;

/**
 *	查询资费数据
 */
public class FindCostAction {
	
	//output
	private List<Cost> costs;
	
	/**
	 * 业务方法，处理查询资费数据的请求
	 */
	public String execute() {
		CostDao dao = DaoFactory.getCostDao();
		costs = dao.findAll();
		return "success";
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

}
