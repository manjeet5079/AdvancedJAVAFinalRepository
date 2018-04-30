package com.app.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.dao.EmpDao;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class EmpDaoImpl implements EmpDao {

	/**
	 * 
	 */
	public List<Employee> getAllEmpRecords(int pageNumber, int pageSize) {
		Session hsession = HibernateUtil.getSessionFactory().openSession();
		String hql = "From Employee";
		Query query = hsession.createQuery(hql);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Employee> empList = query.getResultList();
		hsession.close();
		return empList;
	}

	/**
	 * 
	 */
	public Integer registerEmp(Employee emp) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Transaction tx = hsession.beginTransaction();
		Serializable ser = hsession.save(emp);
		Integer empId = Integer.parseInt(ser.toString());
		tx.commit();
		hsession.close();
		return empId;
	}

	/**
	 * 
	 */
	public Integer getTotalEmpRecordsCount() {
		Session hsession = HibernateUtil.getSessionFactory().openSession();
		String hql = "From Employee";
		Query query = hsession.createQuery(hql);
		List<Employee> empList = query.getResultList();
		hsession.close();
		return empList.size();
	}

	/**
	 * 
	 */
	public Integer deleteEmpById(Integer eid) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Transaction tx = hsession.beginTransaction();

		Employee emp = new Employee();
		emp.setEid(eid);
		hsession.delete(emp);

		tx.commit();
		hsession.close();
		return eid;
	}

	/**
	 * 
	 */
	public Employee getEmpById(Integer eid) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Employee emp = hsession.get(Employee.class, eid);
		hsession.close();
		return emp;
	}
	
	public void updateEmp(Employee emp) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Transaction tx = hsession.beginTransaction();		
		hsession.update(emp);		
		tx.commit();
		hsession.close();		
	}

}
