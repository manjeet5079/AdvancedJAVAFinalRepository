package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet9")
public class Servlet9 extends HttpServlet {

	private static final long serialVersionUID = -2188680777005533048L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("param1");
		System.out.println("--------Console : Servlet9 Begin--------");
		out.println("--------Browser : Servlet9 Begin --------<br>");
		System.out.println("Console : Servlet9 : Parameter = " + s1);
		out.println("Browser : Servlet9 : Parameter = " + s1 + "<br>");
		String revParam = new StringBuffer(s1).reverse().toString();
		request.setAttribute("result", revParam);
		response.sendRedirect("Servlet10");
		System.out.println("--------Console : Servlet9 End--------");
		out.println("--------Browser : Servlet9 End --------<br>");
	}

}
