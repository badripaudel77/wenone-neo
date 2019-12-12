<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This file is all about Internationalization</title>
</head>
<body>

	<h3>Hello from Internationalization file.
	Internationalization is all about reading properties file.
	
	</h3>
	<%@include file="header.jsp"%>
	<%@include file="include.jsp"%>

	<a href="../intnUrl?language=en">English</a><br>
	<a href="../intnUrl?language=en&country=US">English US user</a> <br>
	<a href="../intnUrl?language=it">Italian User</a><br>

</body>

</html>