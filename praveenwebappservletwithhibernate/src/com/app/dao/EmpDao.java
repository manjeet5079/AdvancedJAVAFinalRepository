package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface EmpDao {

	public Integer registerEmp(Employee emp);

	public List<Employee> getAllEmpRecords(int pageNumber, int pageSize);

	public Integer getTotalEmpRecordsCount();

	public Integer deleteEmpById(Integer eid);

	public Employee getEmpById(Integer eid);
	
	public void updateEmp(Employee emp);
	
	public List<Employee> getAllEmpRecords();

}
