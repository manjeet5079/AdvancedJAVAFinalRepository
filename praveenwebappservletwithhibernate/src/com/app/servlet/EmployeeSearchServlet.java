package com.app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/EmployeeSearchServlet")
public class EmployeeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = -4568760801816742133L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("empid");
		EmpDao dao = new EmpDaoImpl();
		List<Employee> empList = null;
		Employee emp = null;
		try {
			if (eid != null && !eid.equals("")) {
				int id = Integer.parseInt(eid);
				emp = dao.getEmpById(id);
				empList = new ArrayList<Employee>();
				if(emp!=null) {
				   empList.add(emp);
				}
			} else {
				empList = dao.getAllEmpRecords();
			}
			
			System.out.println(empList);

			if (empList.size() > 0) {
				request.setAttribute("searchSuccMsg", AppConstants.searchSuccMsg + eid);
				// set the data in request scope to display in jsp
				request.setAttribute("empList", empList);
				request.setAttribute("totalPages", empList.size());
			}else {
				request.setAttribute("searchFailMsg", AppConstants.searchFailMsg + eid);
			}

		} catch (Exception e) {
			request.setAttribute("searchFailMsg", AppConstants.searchFailMsg + eid);
		}
		

		// dispatch the request to jsp page
		RequestDispatcher rd = request.getRequestDispatcher("viewEmpData.jsp");
		rd.forward(request, response);

	}
}
