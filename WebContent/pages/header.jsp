<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="">
<tr>
<td>Project : </td>
<td><b>Welcome to  &nbsp; Employee &nbsp; Management</b></td>
<td>Logged In user :<b>

<%
out.print(session.getAttribute("sessionValue").toString().toUpperCase());//gives BADRI which was stored as session value.
%>
</b> </td>


</tr>

</table>

</body>
</html>