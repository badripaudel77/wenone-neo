<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.*" %>
 <<jsp:include page="intn.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>intn2 jsp file</title>
</head>
<body>

<%
ResourceBundle rb=(ResourceBundle) request.getAttribute("resource");
%>

<%=rb.getString("welcome.message") %>
</body>
</html>