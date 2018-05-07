package com.praveen.crud.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.praveen.crud.model.Department;
import com.praveen.crud.model.Employee;
import com.praveen.crud.service.DepartmentService;
import com.praveen.crud.service.DepartmentServiceImpl;
import com.praveen.crud.service.EmployeeService;
import com.praveen.crud.service.EmployeeServiceImpl;

public class EmployeeAction extends ActionSupport implements Preparable {
   	private static final long serialVersionUID = 6124566403608016983L;
	private EmployeeService empService = new EmployeeServiceImpl();
    private DepartmentService deptService = new DepartmentServiceImpl();
    
    private Employee employee;
    private List<Employee> employees;
    private List<Department> departments;

    /**
     * Loads employee data in case of editing, and loads departments in any case,
     * to be displayed even in case validation fails.
     * 
     * @throws Exception 
     */
    @Override
    public void prepare() throws Exception {
        //deparments list will be always displayed, even if validation fails
        departments = deptService.getAllDepartments();
        if (employee != null && employee.getEmployeeId() != null) {
            //retrieves the employee from data source in case of editing and 
            //employee id. exists
            employee = empService.getEmployee(employee.getEmployeeId());
        }
    }
    
    /**
     * Adds or updates the employee given by getEmployee().
     */
    public String save() {
        if (employee.getEmployeeId() == null) {
            empService.insertEmployee(employee);
        } else {
            empService.updateEmployee(employee);
        }
        return SUCCESS;
    }

    /**
     * Delete employee which ID is getEmployee().getEmployeeId()
     */
    public String delete() {
        empService.deleteEmployee(employee.getEmployeeId());
        return SUCCESS;
    }

    /**
     * Returns all employees
     */
    public String list() {
        employees = empService.getAllEmployees();
        return SUCCESS;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

}
