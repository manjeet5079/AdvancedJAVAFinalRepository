package com.praveen.crud.service;

import java.util.List;

import com.praveen.crud.dao.DepartmentDao;
import com.praveen.crud.dao.DepartmentDaoImpl;
import com.praveen.crud.model.Department;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao dao;

    public DepartmentServiceImpl() {
        this.dao = new DepartmentDaoImpl();
    }

    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }

}
