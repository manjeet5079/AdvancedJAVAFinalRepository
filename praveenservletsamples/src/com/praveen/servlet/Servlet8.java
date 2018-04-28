package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet8")
public class Servlet8 extends HttpServlet {

	private static final long serialVersionUID = 1551434992707998590L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("--------Console : Servlet8 Begin--------");
		out.println("--------Browser : Servlet8 Begin --------<br>");
		//Reading Form data by using same request object
		String s3 = request.getParameter("param1");
		System.out.println("Console : Servlet8 : Parameter = " + s3);
		out.println("Browser : Servlet8 : Parameter = " + s3 + "<br>");
		// Reading the revParam from  request object
		String revParam3 = (String) request.getAttribute("result");
		System.out.println("Console : Servlet8 : revParam3 = " + revParam3);
		out.println("Browser : Servlet6 : revParam3 = " + revParam3 + "<br>");
		System.out.println("--------Console : Servlet8 End--------");
		out.println("--------Browser : Servlet8 End --------<br>");
	}

}
