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

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = -5712507621447542783L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("param1");
		System.out.println("--------Console : Servlet4 Begin--------");
		out.println("--------Browser : Servlet4 Begin --------<br>");
		System.out.println("Console : Servlet4 : Parameter = " + s1);
		out.println("Browser : Servlet4 : Parameter = " + s1 + "<br>");
		String revParam1 = new StringBuffer(s1).reverse().toString();
		// Setting the revParam1 in response object
		request.setAttribute("result", revParam1);
		// We can follow any one of the way
		// 1. Using Relative way
		// RequestDispatcher rd = request.getRequestDispatcher("Servlet2");
		// Sending the request & response object to Servlet2
		// rd.forward(request, response);
		// 2. Using Absolute way
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/Servlet5");
		rd.forward(request, response);
		System.out.println("--------Console : Servlet4 End--------");
		out.println("--------Browser : Servlet4 End --------<br>");
	}

}
