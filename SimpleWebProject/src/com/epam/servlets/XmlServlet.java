package com.epam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		writer.append("<h3>Hello xml servlet  from get method</h3>");
		
		String userName = request.getParameter("userName");
		writer.println("Hello current user name is "+userName);
		
		
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		
		if(userName!="" && userName!=null) {
			session.setAttribute("savedUserName",userName);
			context.setAttribute("savedUserName",userName);
		}	
		writer.println("Session parameter has username as "+session.getAttribute("savedUserName"));
		writer.println("Context parameter has username as "+context.getAttribute("savedUserName"));
		
		
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		writer.append("<h3>Hello xml servlet form post method</h3>");
		
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String profession = request.getParameter("prof");
		writer.println("Hello "+userName+"We know your full name is :"+fullName);
		writer.println("You are a "+profession);
		
		
		String[] location = request.getParameterValues("location");
		writer.println("You are at "+location.length+" places");
		for(String locations : location)
			writer.println(locations);
	}

}
