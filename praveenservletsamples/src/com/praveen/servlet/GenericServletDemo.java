package com.praveen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/GenericServletDemo")
public class GenericServletDemo extends GenericServlet {
	private static final long serialVersionUID = -8783806487270072476L;
	public void service(ServletRequest req, ServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<b>Example of GenericServlet</b>");
		out.print("</body></html>");
	}
}
