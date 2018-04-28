package com.praveen.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/FirstServlet")
public class FirstServlet implements Servlet {
	ServletConfig config;

	public void init(ServletConfig config) {
		this.config = config;
		System.out.println("we are in init method");
	}

	public void service(ServletRequest request, ServletResponse response) {
		System.out.println("we are in service method");
	}

	public void destroy() {
		System.out.println("we are in destroy method");
	}

	public ServletConfig getServletConfig() {
		return config;
	}

	public String getServletInfo() {
		return "This is my First Servlet";
	}
}
