<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>SASH - Search Service</title>
  </head>
<body>

	<div class="container-fluid">
	
		<%@ include file = "header.jsp" %>
	
		<div class="jumbotron alert alert-danger">
			<div class="row">
				<!-- Search By Account ID -->
				<div class="col">
					<form method="POST" action="/sash/customer/search/id">
						<!-- Enter Account ID -->
						<label><b>Enter Customer ID :</b></label><br>
	    				<input type="text" name="id" class="form-control"><br>
	  						
	  					<div class="col-sm-10">
	      					<button type="submit" class="btn btn-primary">SEARCH</button>
	    				</div>	
	  				</form>
				</div>
			</div>
			<hr>
			<div class="row">
				${alert }
			</div>
		</div>
	</div>
		
		<%@ include file = "footer.jsp" %>
		