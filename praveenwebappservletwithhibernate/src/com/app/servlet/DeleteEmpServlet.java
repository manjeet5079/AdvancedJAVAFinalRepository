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
import com.app.util.AppConstants;

@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = -2174479927721976597L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer eid = 0;
		try {
			String empId = request.getParameter("empId");
			if (empId != null && !empId.equals("")) {
				EmpDao dao = new EmpDaoImpl();
				eid = dao.deleteEmpById(Integer.parseInt(empId));
				if (eid > 0) {
					request.setAttribute("deleteSuccMsg",
							AppConstants.deleteSuccMsg + eid);
				}

				RequestDispatcher rd = request
						.getRequestDispatcher("/viewEmpData");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("deleteFailMsg", AppConstants.deleteFailMsg
					+ eid);
		}
	}

}
