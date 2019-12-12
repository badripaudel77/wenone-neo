 package com.neo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neo.model.Employee;
import com.neo.util.DbConnection;

public class EmployeeServiceImpl implements EmployeeService {

	Connection con = null;
	PreparedStatement ps = null;

	@Override
	public void saveEmployee(Employee emp) {
		
	try {

	 con = DbConnection.getDbConnection(); //just accessing the static class's method, that returns connection (con).
	 
	 String sql = "INSERT INTO employee (firstName,lastName,salary,age,email) VALUES (?,?,?,?,?)";
	 
	ps= con.prepareStatement(sql);
	 
    ps.setString(1, emp.getFirstName());
    ps.setString(2, emp.getLastName());
    ps.setDouble(3, emp.getSalary());
    ps.setInt(4, emp.getAge());
    ps.setString(5, emp.getEmail());
    
    int i = ps.executeUpdate();
    
    System.out.println("Data Inserted successfully with ID " + i);
    	
	}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	catch(SQLException e) {
		
			e.printStackTrace();
		}
		}

	@Override
	public List<Employee> allEmployees() {

		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			con = DbConnection.getDbConnection();
			
			String sql = "SELECT * FROM employee";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

		   Employee e = new Employee();
			
		    e.setId(rs.getInt("id"));
			e.setFirstName(rs.getString("firstName"));
			e.setLastName(rs.getString("lastName"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			e.setEmail(rs.getString("email"));
			empList.add(e);

			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return empList;
		 
	}

	@Override
	public void deleteEmployee(Integer id) {

		try {
			
			con = DbConnection.getDbConnection();
			 String sql = "DELETE FROM employee WHERE id =?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, id);
			 ps.executeUpdate();
			 System.out.println("Data deleted successfully of ID " + id);
			
		}
		catch(ClassNotFoundException e) {
			e.getMessage();
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}
	
		finally {
			try {
				ps.close();
				con.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}

	@Override
	public Employee employeeById(Integer id) {
		
		Employee e = null;
		
		try {
			
			con = DbConnection.getDbConnection();
			String sql = "SELECT * FROM employee WHERE id =?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();//selecting data 
			
			while(rs.next()) {
				
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstName"));
				e.setLastName(rs.getString("lastName"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				
			}
		}
		
		catch(Exception msg) {
				msg.getMessage();
			}
		
		return e;
	}

	@Override
	public void updateEmployee(Employee emp) {

		try {
			con = DbConnection.getDbConnection();
			
			String sql = "UPDATE employee SET firstName = ?, lastName = ?,salary = ?,age = ?,email = ? WHERE id =?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getEmail());
			ps.setInt(6, emp.getId());

			 ps.executeUpdate();
			
			System.out.println("Data updated with id " + emp.getId());
			
		}
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
