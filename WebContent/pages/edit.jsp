<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file ="header.jsp" %>
    <%@include file ="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Edit Details.</h3>
    
 <form action="<%=request.getContextPath()%>/editEmpUrl" method="post"> <!-- editEmpUrl is the url pattern that
has to be matched in Web.xml file -->

Edit Employee ::<br> <input type="hidden" name="eId" value="${empDetail.getId()}" }>

<input type="text" name="firstName" value="${empDetail.getFirstName()}"> FirstName
<br>
<input type="text" name="lastName"  value="${empDetail.getLastName()}"> LastName
<br>
<input type="text" name="salary" value="${empDetail.getSalary()}">Salary
<br>
<input type="text" name="age"  value="${empDetail.getAge()}">Age 
<br>
<input type="text" name="email"  value="${empDetail.getEmail()}">Email
<br>

<input type="submit" value="Edit">

</form>
    
</body>
</html>