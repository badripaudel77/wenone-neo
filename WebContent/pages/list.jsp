<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<%@include file="header.jsp"%>
<%@include file="include.jsp"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page import="com.neo.service.EmployeeService" %>
<%@ page import="com.neo.service.EmployeeServiceImpl" %>
<%@ page import="com.neo.model.Employee" %>

<%

EmployeeService es = new EmployeeServiceImpl();

List<Employee> employeeList = es.allEmployees();
//set same name
request.setAttribute("employeeList",employeeList); // using employeeList already created in other page. 

%>

<!--   -->
<head>
<meta charset="ISO-8859-1">
</head>

<!-- This is the JSTL (core ) Tag , to use this a jar jstl.jar is 
required to paste in lib folder. -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>

	<h3>This is list file in jsp.</h3>

	<table border="1" style="border-style: solid; border-width: 5px;">
		<tr>
			<th>SNo The length of the numLIst : <br></th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Salary</th>
			<th>Age</th>
			<th>Email</th>
			<th colspan="2">Action</th>
		</tr>

        <b>count : </b>
        <c:forEach items="${employeeList}" var="emp"> <!--  forEach loop each time
		id increases as the loop completes -->
		<!-- employeeList has been 
		set as an attribute in the EmployeeServlet.java file. -->
		
			<tr>

               <!-- it is data that has to be displayed inside of the td tag in table -->
				
				<!-- id is the database id. -->
				
				<td>S.No <c:out value="${emp.id}" /></td> 
				<td>${emp.firstName}</td>
				<td><c:out value="${emp.lastName}" /></td>
				<td><c:out value="${emp.salary}" /></td>
				<td><c:out value="${emp.age}" /></td>
				<td><c:out value="${emp.email}" /></td>

                <td> <a href="<%=request.getContextPath()%>/empUrl?action=edit&eId=<c:out value="${emp.id}"/>"> Update</a></td>
			    
			    <td> <a href="<%=request.getContextPath()%>/empUrl?action=delete&eId=<c:out value="${emp.id}"/>"> Delete</a></td>
			
			<!--  This pattern is to be followed exactly. 
			action is just a variable name to distinguish can put any like variables.
			 -->
			<!-- & if multiple parameters   -->
			</tr>	
		</c:forEach>
	</table>
</body>
</html>