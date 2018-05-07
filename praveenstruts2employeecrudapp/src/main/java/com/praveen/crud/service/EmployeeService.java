package com.praveen.crud.service;

import java.util.List;

import com.praveen.crud.model.Employee;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void updateEmployee(Employee emp);

    public Integer deleteEmployee(Integer id);

    public Employee getEmployee(Integer id);

    public void insertEmployee(Employee emp);

}
