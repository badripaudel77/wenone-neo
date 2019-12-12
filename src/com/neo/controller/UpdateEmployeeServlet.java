package com.neo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.model.Employee;
import com.neo.service.EmployeeService;
import com.neo.service.EmployeeServiceImpl;


@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	EmployeeService empService = new EmployeeServiceImpl();
 
    public UpdateEmployeeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		Integer id = Integer.parseInt(request.getParameter("eId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Double salary = Double.parseDouble(request.getParameter("salary"));
		
		Integer age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		
		Employee e = new Employee();
		
		e.setId(id);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		e.setAge(age);
		e.setEmail(email);
		
		empService.updateEmployee(e);

		RequestDispatcher rd = request.getRequestDispatcher("/pages/list.jsp");
		
		rd.forward(request, response);
		
		
	}

}
