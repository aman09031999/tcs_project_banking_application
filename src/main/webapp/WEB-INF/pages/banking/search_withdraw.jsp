<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>SASH - WITHDRAW SERVICE</title>
  </head>
<body>

	<div class="container-fluid">
		
		<%@ include file = "header.jsp" %>
		
		<div class="jumbotron alert alert-danger">
			<div class="row">
				<!-- Search By Account ID -->
				<div class="col">
					<form method="POST" action="/sash/banking/account/withdraw/search/id">
						<!-- Enter Account ID -->
						<label><b>Enter Account ID :</b></label><br>
	    				<input type="text" name="id" class="form-control"><br>
	  						
	  					<div class="col-sm-10">
	      					<button type="submit" class="btn btn-primary">SEARCH</button>
	    				</div>	
	  				</form>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col">
					${alert }
				</div>
			</div>
		</div>
		
		<%@ include file = "footer.jsp" %>
		
	</div>