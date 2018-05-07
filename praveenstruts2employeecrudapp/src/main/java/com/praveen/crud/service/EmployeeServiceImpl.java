package com.praveen.crud.service;

import java.util.List;

import com.praveen.crud.dao.EmployeeDao;
import com.praveen.crud.dao.EmployeeDaoImpl;
import com.praveen.crud.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao dao;

    public EmployeeServiceImpl() {
        this.dao = new EmployeeDaoImpl();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    @Override
    public void updateEmployee(Employee emp) {
        dao.update(emp);
    }

    @Override
    public Integer deleteEmployee(Integer id) {
        return dao.delete(id);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return dao.getEmployee(id);
    }

    @Override
    public void insertEmployee(Employee emp) {
        dao.insert(emp);
    }
}
