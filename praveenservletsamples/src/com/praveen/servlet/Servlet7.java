package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {

	private static final long serialVersionUID = -1783928465376659763L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("--------Console : Servlet7 Begin--------");
		out.println("--------Browser : Servlet7 Begin --------<br>");
		//Reading Form data by using same request object
		String s2 = request.getParameter("param1");
		System.out.println("Console : Servlet7 : Parameter = " + s2);
		out.println("Browser : Servlet7 : Parameter = " + s2 + "<br>");
		// By Using Relative way
		RequestDispatcher rd = request.getRequestDispatcher("Servlet8");
		//Sending the request & response object to Servlet7
		rd.include(request, response);
		System.out.println("--------Console : Servlet7 End--------");
		out.println("--------Browser : Servlet7 End --------<br>");
	}

}
