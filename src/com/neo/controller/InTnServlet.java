package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InTnServlet")

public class InTnServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
   
    public InTnServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	PrintWriter out = response.getWriter();
	
	String cc= request.getParameter("country");
	String In = request.getParameter("language");
	
	Locale locale = null;

	if(cc==null) 
	
		locale =new Locale(In);
		
else 

	locale = new Locale(In,cc);
	out.println("intnVal... " + locale);
	
	ResourceBundle rb = ResourceBundle.getBundle("ApplicationResource",locale);
	request.setAttribute("resource", rb);
	
	RequestDispatcher rd = request.getRequestDispatcher("/pages/intn2.jsp");
	rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
