<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@include file="header.jsp" %>
 
 <jsp:include page="include.jsp" /> 
 
 
 <!-- for displaying username at the top of the page -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add JSP file</title>
</head>
<body>

<!-- another syntax for including the file in JSP, can be used interchangeably
 with first one. -->

<h1>This is add file</h1>

<!-- request.getContextPath() gives the project name Web1 in this case. ie root directory  -->

<form action="<%=request.getContextPath()%>/saveEmpUrl" method="post"> <!-- saveEmpUrl is the url pattern that
has to be matched in Web.xml file -->

<input type="text" name="firstName"> FirstName
<br>
<input type="text" name="lastName"> LastName
<br>
<input type="text" name="salary">Salary
<br>
<input type="text" name="age">Age 
<br>
<input type="text" name="email">Email
<br>

<input type="submit" value="Add">

</form>
</body>
</html>