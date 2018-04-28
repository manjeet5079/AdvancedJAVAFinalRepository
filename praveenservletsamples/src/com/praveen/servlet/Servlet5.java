package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {

	private static final long serialVersionUID = 7952584502820518909L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("--------Console : Servlet5 Begin--------");
		out.println("--------Browser : Servlet5 Begin --------<br>");
		// Reading Form data by using same request object
		String s2 = request.getParameter("param1");
		System.out.println("Console : Servlet5 : Parameter = " + s2);
		out.println("Browser : Servlet5 : Parameter = " + s2 + "<br>");
		// Reading the revParam from Servlet4 request object
		String revParam2 = (String) request.getAttribute("result");
		System.out.println("Console : Servlet5 : revParam = " + revParam2);
		out.println("Browser : Servlet4 : revParam = " + revParam2 + "<br>");
		System.out.println("--------Console : Servlet5 End--------");
		out.println("--------Browser : Servlet5 End --------<br>");
	}

}
