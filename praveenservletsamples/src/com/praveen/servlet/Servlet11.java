package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet11")
public class Servlet11 extends HttpServlet {
	private static final long serialVersionUID = 8977321376741680997L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("--------Console : Servlet11 Begin--------");
		out.println("--------Browser : Servlet11 Begin --------<br>");
		//Reading Form data by using same request object
		String s3 = request.getParameter("param1");
		System.out.println("Console : Servlet11 : Parameter = " + s3);
		out.println("Browser : Servlet11 : Parameter = " + s3 + "<br>");
		// Reading the revParam from  request object
		String revParam3 = (String) request.getAttribute("result");
		System.out.println("Console : Servlet11 : revParam3 = " + revParam3);
		out.println("Browser : Servlet11 : revParam3 = " + revParam3 + "<br>");
		System.out.println("--------Console : Servlet11 End--------");
		out.println("--------Browser : Servlet11 End --------<br>");
	}

}
