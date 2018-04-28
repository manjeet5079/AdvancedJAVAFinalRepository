package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 8289810785062487086L;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("This is doGet() method");
		out.println("User Name : " + req.getParameter("username"));
		out.println("Password : " + req.getParameter("password"));
		out.println("Query String : " + req.getQueryString());
		out.println("URL :" + req.getRequestURL() + req.getQueryString());
	}
}
