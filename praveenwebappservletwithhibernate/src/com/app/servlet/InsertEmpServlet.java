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

@WebServlet("/insertEmp")
public class InsertEmpServlet extends HttpServlet {	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// capture form data
			String ename = request.getParameter("ename");
			String email = request.getParameter("email");
			String esal = request.getParameter("esal");

			Employee emp = new Employee();
			
			//setting form data to employee object
			emp.setEname(ename);
			emp.setEmail(email);
			if (esal != null) {
				emp.setSalary(Double.parseDouble(esal));
			}

			// store into database
			EmpDao dao = new EmpDaoImpl();
			Integer generatedEid = dao.registerEmp(emp);

			// display success msg to user
			request.setAttribute("succMsg", AppConstants.sucessMsg+generatedEid);
			
		} catch (Exception e) {
			e.printStackTrace();
			// display error msg to user
			request.setAttribute("errMsg", AppConstants.errMsg);
		}

		// redirecting the user to same page with success/error msg
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

}
