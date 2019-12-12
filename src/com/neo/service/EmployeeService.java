package com.neo.service;

import java.util.List;

import com.neo.model.Employee;

//write what has to be done on the data(raw data) of the
//class (Employee class in this case).

public interface EmployeeService {

	public void saveEmployee(Employee emp);
	public List<Employee> allEmployees();
	public void deleteEmployee(Integer id);
	public Employee employeeById(Integer id);
	public void updateEmployee(Employee emp);
	
}
