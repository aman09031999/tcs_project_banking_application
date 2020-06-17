<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>SASH - HOME</title>
  </head>
<body>

	<div class="container-fluid">
		
		<%@ include file = "header.jsp" %>
		
		<div class="row">
			<div class="col">
				<h1><center>Home Page</center></h1><br>
				<h1><center>WELCOME To TCS Project</center></h1><br>
			</div>
		</div>
		
		<div class="row">
			${alert }
		</div>

	</div>	
	<%@ include file = "footer.jsp" %>
