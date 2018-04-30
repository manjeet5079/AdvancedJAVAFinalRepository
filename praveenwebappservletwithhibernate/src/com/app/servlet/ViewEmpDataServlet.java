package com.app.servlet;

import java.io.IOException;
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

@WebServlet("/viewEmpData")
public class ViewEmpDataServlet extends HttpServlet {
	private static Integer PAGE_SIZE = 0;
	private static Integer pageNumber = 1;
	private static Integer totalPages = 1;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		EmpDao dao = new EmpDaoImpl();

		String str = request.getParameter("pageNumber");
		if (str != null) {
			pageNumber = Integer.parseInt(str);
		}

		Integer totalRecords = dao.getTotalEmpRecordsCount();

		PAGE_SIZE = AppConstants.PAGE_SIZE;

		totalPages = totalRecords / PAGE_SIZE
				+ (totalRecords % PAGE_SIZE > 0 ? 1 : 0);
		System.out.println("total pages :" + totalPages);

		request.setAttribute("totalPages", totalPages);

		List<Employee> empList = dao.getAllEmpRecords(pageNumber, PAGE_SIZE);

		request.setAttribute("empList", empList);

		RequestDispatcher rd = request.getRequestDispatcher("empData.jsp");
		rd.forward(request, response);

	}

}
