<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<script src="validateForm.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

	<h1>JSP Login Page</h1>

	<form action="loginUrl" method="POST" onSubmit = "return validate()">

<!-- ${msg} will show the message showed in else block of the LoginServlet.java if error occurred. -->

     <h3 style="color:red;background-color:brown; height:60px;width:400px;">${errorMessage}</h3> 

		UserName : <input type="text" name="uname" value="Badri" id = "un">
		<br> 
		<div id="unameErr"  style="visibility:hidden;"></div>
		
		Password : <input type="password" name="upass" value="Badri" id="pass"> 
		<br> 
		<div id="passErr"  style="visibility:hidden;"></div>
		         
	  <input type="submit" value="submit">
   
   </form>
   
</body>
</html>