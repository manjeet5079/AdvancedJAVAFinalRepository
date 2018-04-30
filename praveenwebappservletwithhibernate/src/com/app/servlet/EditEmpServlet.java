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

@WebServlet("/EditEmpServlet")
public class EditEmpServlet extends HttpServlet {

	

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// capture empId from Edit hyperlink
		String empId = request.getParameter("empId");

		EmpDao dao = new EmpDaoImpl();
		Employee emp = dao.getEmpById(Integer.parseInt(empId));

		request.setAttribute("emp", emp);

		RequestDispatcher rd = request.getRequestDispatcher("editEmp.jsp");
		rd.forward(request, response);

	}

}
