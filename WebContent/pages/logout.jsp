<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<h3> This is logout file. </h3>

<%
//destroy the session.
session.invalidate();//making session invalid / deleting session

response.sendRedirect("../index.jsp");//.. one step outside  if two folder outside ../../index.jsp

%>

</body>
</html>