package com.praveen.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.praveen.admin.dao.AdminDao;
import com.praveen.admin.dao.impl.AdminDaoImpl;
@WebServlet("/loginAdmin")
public class AdminLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3434646824633161751L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			processRequest(request, response);
	}

	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName=null;
			String password=null;
			String desinationLink=null;
			boolean isExist=false;
			HttpSession session=null;
			try {
				userName=request.getParameter("userName");
				password=request.getParameter("password");
				
				if (userName == null || password == null) {
					desinationLink="index.jsp?msg=Operation Not Allowed";
				}else if(request.getQueryString()!=null&& !"".equals(request.getQueryString())){
					desinationLink="index.jsp?msg=Operation Not Allowed as GET";
					
				}else if("".equals(userName) || "".equals(password)){
					desinationLink="index.jsp";
					
				}else{
					AdminDao dao=new AdminDaoImpl();
					isExist=dao.validateAdmin(userName, password);
					if (isExist) {
						desinationLink="Home.jsp";
						session=request.getSession();
						session.setAttribute("permission","true");
					}else{
						desinationLink="index.jsp?msg=Invalid Login Details";
					}
					
				}
				
				
				request.getRequestDispatcher(desinationLink).forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	

}