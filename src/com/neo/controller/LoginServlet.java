package com.neo.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")

// Servlet implementation class LoginServlet
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    	
    	super(); //calling the super class constructor ( of HttpServlet ) which does nothing becoz it is an abstract class.
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//PrintWriter out = response.getWriter();
	    //out.println("doGet method running here.");
	
	}

	//we are using post method but default method is get .
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out = response.getWriter();

	//getting the parameters value and storing it in variables.
	String userName = request.getParameter("uname");
	String password = request.getParameter("upass");
	
	if(userName.equals("Badri") && password.equals("Badri")) {
		
	out.print("Hello " + userName);
	
	//creating session  

	HttpSession session = request.getSession();
	
	session.setAttribute("sessionValue",userName); //setting userName as session variable for the future use.
	
	//redirect to the next page
	
	
	//response.sendRedirect("pages/menu.jsp"); used in jsp generally for navigating to the external source also
	
	//dispatch means send so it redirect to the specified page.
    //it is an interface that defines an object to send to any sources HTML,Servlet, JSP
	//reference javatpoint.
	RequestDispatcher rd = request.getRequestDispatcher("pages/menu.jsp");
	
	rd.forward(request, response); // use it
	//rd.include(request, response);
	}
	
	else {
		
		request.setAttribute("errorMessage"," *** Username/Password not valid ***");//set an error message
		
		RequestDispatcher rd = request.getRequestDispatcher("/");// else goto root file which calls index file.
		
		rd.forward(request, response); // forward to root file i.e. index file.
	}

	//out.println("doPost method running here.");
	
	}

}
