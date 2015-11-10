package com.tarena.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tarena.entity.Cost;
import com.tarena.util.HibernateUtil;


public class CostDaoImpl implements CostDao {
	//findAll
	public List<Cost> findAll() {
		List<Cost> list = new ArrayList<Cost>();
		String hql = "from Cost";
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		list = query.list();
		session.close();
		return list;
	}
	//delete by id
	public void delete(int id) {
		Cost c = new Cost();
		c.setId(id);
		Session session = HibernateUtil.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.delete(c);
			ts.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			ts.rollback();
		}
		session.close();
	}

	//find by name
	public Cost findByName(String name) {
		if(name == null)
			return null;
		
		if(name.equals("aaa")) {
			Cost c1 = new Cost();
			c1.setId(1);
			c1.setName("aaa");
			c1.setBase_duration(20);
			c1.setBase_cost(2.00);
			c1.setUnit_cost(0.2);
			c1.setStatus("0");
			c1.setDescr("aaa");
			c1.setCreatime(
					new Date(System.currentTimeMillis()));
			c1.setCost_type("1");
			return c1;
		} else if (name.equals("bbb")) {
			Cost c2 = new Cost();
			c2.setId(2);
			c2.setName("bbb");
			c2.setBase_duration(30);
			c2.setBase_cost(3.00);
			c2.setUnit_cost(0.3);
			c2.setStatus("1");
			c2.setDescr("bbb");
			c2.setCreatime(
					new Date(System.currentTimeMillis()));
			c2.setCost_type("2");
			return c2;
		} else if (name.equals("ccc")) {
			Cost c3 = new Cost();
			c3.setId(3);
			c3.setName("ccc");
			c3.setBase_duration(40);
			c3.setBase_cost(4.00);
			c3.setUnit_cost(0.4);
			c3.setStatus("0");
			c3.setDescr("ccc");
			c3.setCreatime(
					new Date(System.currentTimeMillis()));
			c3.setCost_type("3");
			return c3;
		} else {
			return null;
		}
		
	}
	// find by id
	public Cost findById(int id) {
		Session session = HibernateUtil.getSession();
		Cost c = (Cost)session.get(Cost.class, id);
		session.close();
		return c;
	}

}
