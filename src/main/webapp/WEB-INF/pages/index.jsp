<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World...!!</h1>
	
	<form method="post" action="login">
		<input type = "text" name="user_id" placeholder="enter user id"   /><br><br>
		<input type = "password" name="pass" placeholder="enter password" /><br><br>
		
		<button type="submit">LOGIN</button>
	</form>
</body>
</html>