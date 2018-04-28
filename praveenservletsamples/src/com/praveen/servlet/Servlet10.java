package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet10")
public class Servlet10 extends HttpServlet {
	private static final long serialVersionUID = 3172754681436448835L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("--------Console : Servlet10 Begin--------");
		out.println("--------Browser : Servlet10 Begin --------<br>");
		//Reading form data
		String s2 = request.getParameter("param1");
		System.out.println("Console : Servlet10 : Parameter = " + s2);
		out.println("Browser : Servlet10 : Parameter = " + s2 + "<br>");
		response.sendRedirect("Servlet11");
		System.out.println("--------Console : Servlet10 End--------");
		out.println("--------Browser : Servlet10 End --------<br>");
	}

}
