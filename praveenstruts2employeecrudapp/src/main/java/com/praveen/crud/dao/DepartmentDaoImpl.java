package com.praveen.crud.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.praveen.crud.model.Department;
import com.praveen.crud.util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {
    public List<Department> getAllDepartments() {
    	Session hsession = HibernateUtil.getSessionFactory().openSession();
		String hql = "From Department";
		Query query = hsession.createQuery(hql);
		List<Department> deptList = query.getResultList();
		hsession.close();
		return deptList;
    }
}
