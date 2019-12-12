package com.neo.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neo.model.Employee;
import com.neo.service.EmployeeService;
import com.neo.service.EmployeeServiceImpl;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	private EmployeeService empService = new EmployeeServiceImpl();
	 
	List<Employee> empList = empService.allEmployees();
	
    public EmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		//out.print("From Get " );
		
		String action = "";
		Integer id= 0;
		
		if(request.getParameter("eId")!=null) {
			
			id = Integer.parseInt(request.getParameter("eId"));
		}
	
		if(request.getParameter("action")!=null) {
			
			action = request.getParameter("action");
			
			if(action.equals("delete")) {
				
				empService.deleteEmployee(id);
				request.setAttribute("deletedMsg", "Data deleted Successfully");
				
				RequestDispatcher rd =request.getRequestDispatcher("/pages/list.jsp");
				rd.forward(request, response);
				
			}
			else if(action.equals("edit")) {
				
				out.print("edit action ....." + id);
				
				Employee emp =  empService.employeeById(id);
				 
				request.setAttribute("empDetail",emp);
				
				RequestDispatcher rd =request.getRequestDispatcher("/pages/edit.jsp");
				rd.forward(request, response);
				
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    doGet(request,response);
    
	PrintWriter out = response.getWriter();
	out.print("From Post in EmployeeServlet" );
	out.println();	
	
	String firstName;
	String lastName;
	Double salary;
	Integer age;
	String email;
	
	firstName = request.getParameter("firstName");
	lastName = request.getParameter("lastName");
	salary = Double.parseDouble(request.getParameter("salary"));
	age = Integer.parseInt(request.getParameter("age"));
	email = request.getParameter("email");
	
	Employee e = new Employee();
	
	e.setFirstName(firstName);
	e.setLastName(lastName);
    e.setAge(age);
    e.setSalary(salary);
    e.setEmail(email);
    
    empService.saveEmployee(e); // saving the data.
    
	//out.println("Data Saved successfuly with" + e.getId());
	
	empList = empService.allEmployees(); //storing the data into list.
	
	request.setAttribute("employeeList", empList);//store so that u can use it letter using getAttribute
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/list.jsp");
	
	dispatcher.forward(request, response);
	
	}
}
