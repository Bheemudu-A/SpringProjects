package com.example.demo.Servlets;


import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("Inservice");
		
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<h2><b>Hello World</b><h2>");
		
	}

}
