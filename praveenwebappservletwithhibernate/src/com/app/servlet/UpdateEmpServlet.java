package com.app.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.EmpDao;
import com.app.dao.impl.EmpDaoImpl;
import com.app.model.Employee;
import com.app.util.AppConstants;

@WebServlet("/updateEmp")
public class UpdateEmpServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String empId=null;
		try {
			empId = request.getParameter("eid");
			System.out.println(request.getParameter("eid"));
			if (empId != null && !empId.equals("")) {
				
				// capture form data
				String ename = request.getParameter("ename");
				String email = request.getParameter("email");
				String esal = request.getParameter("esal");
				Employee emp = new Employee();
				//setting form data to employee object
				emp.setEid(Integer.valueOf(empId));				
				emp.setEname(ename);
				emp.setEmail(email);
				if (esal != null) {
					emp.setSalary(Double.parseDouble(esal));
				}
				
				// store into database
				EmpDao dao = new EmpDaoImpl();
				dao.updateEmp(emp);	
				
				request.setAttribute("updateSuccMsg",
						AppConstants.updateSuccMsg + empId);
				RequestDispatcher rd = request
						.getRequestDispatcher("/viewEmpData");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("updateFailMsg", AppConstants.updateFailMsg
					+ empId);
		}
	}

}
