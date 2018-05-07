package com.praveen.crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.praveen.crud.model.Employee;
import com.praveen.crud.util.HibernateUtil;


public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployees() {
    	Session hsession = HibernateUtil.getSessionFactory().openSession();
		String hql = "From Employee";
		Query query = hsession.createQuery(hql);
		List<Employee> empList = query.getResultList();
		hsession.close();
		return empList;
		
    }

    @Override
    public Employee getEmployee(Integer eid) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Employee emp = hsession.get(Employee.class, eid);
		hsession.close();
		return emp;
    }

    @Override
    public void update(Employee emp) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Transaction tx = hsession.beginTransaction();		
		hsession.update(emp);		
		tx.commit();
		hsession.close();	
    }

    @Override
    public Integer insert(Employee emp) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Transaction tx = hsession.beginTransaction();
		Serializable ser = hsession.save(emp);
		Integer empId = Integer.parseInt(ser.toString());
		tx.commit();
		hsession.close();
		return empId;
    }

    @Override
    public Integer delete(Integer eid) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session hsession = sf.openSession();
		Transaction tx = hsession.beginTransaction();

		Employee emp = new Employee();
		emp.setEmployeeId(eid);
		hsession.delete(emp);

		tx.commit();
		hsession.close();
		return eid;
    }

}
