package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 3151094049108333813L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("This is doPost() method");
		out.println("User Name : " + req.getParameter("username"));
		out.println("Password : " + req.getParameter("password"));
		/*
		 * POST requests typically carry their parameters within the request body, which is why the request.getQueryString() method returns null.
		 */
		out.println("Query String : " + req.getQueryString());
		out.println("URL :" + req.getRequestURL() + req.getQueryString());
	}
}
