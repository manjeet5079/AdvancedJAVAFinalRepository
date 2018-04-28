package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet {
	
	private static final long serialVersionUID = 8111025774042288306L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("param1");
		System.out.println("--------Console : Servlet6 Begin--------");
		out.println("--------Browser : Servlet6 Begin --------<br>");
		System.out.println("Console : Servlet6 : Parameter = " + s1);
		out.println("Browser : Servlet6 : Parameter = " + s1 + "<br>");
		String revParam1 = new StringBuffer(s1).reverse().toString();
		// Setting the revParam1 in response object
		request.setAttribute("result", revParam1);
		// By Using Absolute way
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/Servlet7");
		rd.include(request, response);
		System.out.println("--------Console : Servlet6 End--------");
		out.println("--------Browser : Servlet6 End --------<br>");
	}

}
