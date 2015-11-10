package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Cost;

public interface CostDao {

	List<Cost> findAll();
	
	void delete(int id);
	
	Cost findByName(String name);
	
	Cost findById(int id);
	
}
