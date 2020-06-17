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
					<form method="POST" action="id">
						<!-- Enter Account ID -->
						<label><b>Enter Customer ID :</b></label><br>
	    				<input type="text" name="customer_id" class="form-control"><br>
	  						
	  					<div class="col-sm-10">
	      					<button type="submit" class="btn btn-primary">SEARCH</button>
	    				</div>	
	  				</form>
				</div>
			</div>
		</div>
		
		<div class="jumbotron alert alert-primary">
			<div class="table-responsive">
 				<table class="table table-striped table-hover">
 					<thead>
					    <tr>
					      <th scope="col">Customer ID</th>
					      <th scope="col">Customer Name</th>
					      <th scope="col">Age</th>
					      <th scope="col">Date of Birth</th>
					      <th scope="col">Address</th>
					      <th scope="col">Email</th>
					      <th scope="col">Contact 1</th>
					      <th scope="col">Contact 2</th>
					      <th scope="col">Last Operation</th>
					      <th scope="col">Last Updated On</th>
					      <th scope="col">Message</th>
					    </tr>
					  </thead>
					  <tbody>
						    <tr>
						      <td>${customer.customer_id }		</td>
						      <td>${customer.customer_name }	</td>
						      <td>${customer.age }				</td>
						      <td>${customer.dob }				</td>
						      <td>${customer.address }			</td>
						      <td>${customer.customer_email }	</td>
						      <td>${customer.customer_contact1 }</td>
						      <td>${customer.customer_contact2 }</td>
						      <td>${customer.last_operation }	</td>
						      <td>${customer.last_updated }		</td>
						      <td>${customer.message }			</td>
						    </tr>
					  </tbody>
  				</table>
			</div>
			<hr>
			<div class="col-sm-10">
				<a href="/sash/customer/update" class="btn btn-success" tabindex="-1" role="button" aria-disabled="true">UPDATE</a>
				<a href="/sash/customer/delete" class="btn btn-danger" tabindex="-1" role="button" aria-disabled="true">DELETE</a>
				<a href="/sash/banking/account/create" class="btn btn-primary" tabindex="-1" role="button" aria-disabled="true">CREATE ACCOUNT</a>
	    	</div>
		</div>
		
	</div>
		<%@ include file = "footer.jsp" %>
