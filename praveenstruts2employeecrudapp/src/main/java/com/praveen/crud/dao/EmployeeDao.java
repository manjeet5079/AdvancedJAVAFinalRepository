package com.praveen.crud.dao;

import java.util.List;

import com.praveen.crud.model.Employee;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();

    public Employee getEmployee(Integer id);

    public void update(Employee emp);

    public Integer insert(Employee emp);

    public Integer delete(Integer id);

}
